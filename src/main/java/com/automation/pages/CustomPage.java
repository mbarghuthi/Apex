package com.automation.pages;

import com.automation.configuration.pageobjects.PageObject;
import com.automation.steps.CannedSteps;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@PageObject
public class CustomPage extends AbstractPage<CustomPage> {

    @Autowired
    private CannedPage cannedPage;
    // -------------------------
    // Common actions
    // -------------------------
    public CustomPage enterText(String elementName, String text) throws Exception {
        WebElement element = getElementWithWait(this, elementName);
        element.sendKeys(text);
        log.info("Filled '" + elementName + "' with value: " + text);
        return this;
    }

    public CustomPage click(String elementName) throws Exception {
        WebElement element = getElementWithWait(this, elementName);
        element.click();
        log.info("Clicked on '" + elementName + "'");
        return this;
    }

    public void checkRadioButton(String elementName, boolean shouldBeChecked) throws Exception {
        WebElement radioButton = getElementWithWait(this, elementName);
        if (shouldBeChecked && !radioButton.isSelected()) {
            radioButton.click();
        }
        Assert.assertEquals(
                "Radio button state does not match the expected state",
                shouldBeChecked,
                radioButton.isSelected()
        );
    }

    public void checkCheckboxButton(String elementName, boolean shouldNotBeChecked) throws Exception {
        WebElement checkbox = getElementWithWait(this, elementName);
        if (shouldNotBeChecked && checkbox.isSelected()) {
            checkbox.click();
        }
        Assert.assertEquals(
                "Checkbox state does not match the expected state",
                !shouldNotBeChecked,
                checkbox.isSelected()
        );
    }

    public void checkCheckboxState(String elementName, boolean expectedChecked) throws Exception {
        WebElement el = getElementWithWait(this, elementName);

        // If PageObject returned a wrapper, resolve the actual <input type="checkbox">
        WebElement checkbox = resolveCheckboxInput(el);

        // If your intention is "verify + fix", keep this. If you want pure assert, remove it.
        if (checkbox.isSelected() != expectedChecked) {
            if (!checkbox.isEnabled()) {
                throw new AssertionError("Checkbox '" + elementName + "' is disabled; cannot change its state.");
            }
            // For APEX, clicking the wrapper label sometimes is more reliable than clicking the input directly.
            clickCheckboxSafely(el, checkbox);
        }

        Assert.assertEquals(
                "Checkbox state does not match the expected state for '" + elementName + "'",
                expectedChecked,
                checkbox.isSelected()
        );
    }

    private WebElement resolveCheckboxInput(WebElement el) {
        String tag = el.getTagName().toLowerCase();

        // If already the input, return it
        if ("input".equals(tag)) return el;

        // Otherwise search within the wrapper
        List<WebElement> inputs = el.findElements(By.cssSelector("input[type='checkbox']"));
        if (!inputs.isEmpty()) return inputs.get(0);

        // Last attempt: if wrapper has an id like P21_STATUS_CONTAINER, try locating input by id pattern nearby
        // (keep it minimal; avoid guessing too much)
        throw new NoSuchElementException("Could not resolve checkbox <input> from element: " + tag);
    }

    private void clickCheckboxSafely(WebElement wrapperOrInput, WebElement input) {
        try {
            // Prefer clicking the wrapper if it's not the input (common in APEX styling)
            if (!"input".equalsIgnoreCase(wrapperOrInput.getTagName())) {
                wrapperOrInput.click();
            } else {
                input.click();
            }
        } catch (ElementClickInterceptedException e) {
            // fallback: JS click
            ((JavascriptExecutor) webDriverProvider.get()).executeScript("arguments[0].click();",
                    "input".equalsIgnoreCase(wrapperOrInput.getTagName()) ? input : wrapperOrInput);
        }
    }


    public CustomPage elementToHover(String elementName) throws Exception {
        WebDriver driver = webDriverProvider.get();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.rmRootGroup")));

        if ("User Name Header Button".equalsIgnoreCase(elementName)) {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("ul.rmRootGroup li.profile a.rmLink.rmRootLink")
                    ));

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    element
            );

            new Actions(driver)
                    .moveToElement(element)
                    .pause(Duration.ofMillis(150))
                    .perform();

            log.info("Hovered on 'User Name Header Button'");
            return this;
        }

        WebElement el = getElementWithWait(this, elementName);
        new Actions(driver).moveToElement(el).perform();
        log.info("Hovered on '" + elementName + "'");
        return this;
    }

    public int countRowsWithoutImage(int rowCount) throws Exception {
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            String imgXpath =
                    "//*[@id='ctl00_MainContent_RadGrid1_ctl00__" + i + "']/td[5]//img[@src='http://172.16.30.82:8888/Images/View.png']";
            List<WebElement> images = webDriverProvider.get().findElements(By.xpath(imgXpath));
            if (images.isEmpty()) {
                count++;
            }
        }
        System.out.println("Count of rows without the specified image: " + count);
        return count;
    }

    // =====================================================================
    // IG – Set single cell by row text + column header (click before fill)
    // =====================================================================
    public void setIGValue(String regionIdOrAnyId, String rowText, String columnHeader, String value) throws Exception {
        WebDriver driver = webDriverProvider.get();

        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridId = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);

        // Wait for IG container to exist and be visible
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(gridId)));

        // Wait for any APEX processing/refresh to finish before touching the grid
        waitForApexReady(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".u-Processing")));

        ensureIGEditMode(regionId);

        // Re-wait after edit mode in case IG refreshes/rebuilds
        waitForApexReady(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(gridId)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".u-Processing")));

        int colLeafIndex = resolveLeafHeaderIndex(regionId, columnHeader);
        if (colLeafIndex < 0) {
            throw new Exception("Header not found: " + columnHeader + "\nFound headers:\n" + dumpHeaders(regionId));
        }

        final String rowXpath =
                "//div[@id='" + gridId + "']//tr[@role='row' and .//td[normalize-space()=\"" + rowText + "\"]]";

        // Wait for the target row to be present and visible in a stable way
        WebElement row = wait.until(driver1 -> {
            List<WebElement> rows = driver1.findElements(By.xpath(rowXpath));
            if (rows.isEmpty()) {
                return null;
            }

            WebElement r = rows.get(0);
            if (!r.isDisplayed()) {
                return null;
            }

            List<WebElement> rowCells = r.findElements(By.cssSelector("td[role='gridcell']"));
            if (rowCells.isEmpty()) {
                return null;
            }

            return r;
        });

        // Re-locate cells fresh after row is stable
        List<WebElement> cells = row.findElements(By.cssSelector("td[role='gridcell']"));
        if (colLeafIndex >= cells.size()) {
            throw new Exception("Column index out of range. idx=" + colLeafIndex + ", cells=" + cells.size());
        }

        WebElement cell = cells.get(colLeafIndex);
        scrollTo(cell);

        wait.until(ExpectedConditions.visibilityOf(cell));
        wait.until(ExpectedConditions.elementToBeClickable(cell));

        String before = normalizeNumberString(safeText(cell));

        boolean uiOk = false;
        try {
            uiOk = trySetViaUi(cell, value, 5000);
        } catch (StaleElementReferenceException ex) {
            // Re-find row/cell once if IG rebuilt the DOM during editing
            row = wait.until(driver1 -> {
                List<WebElement> rows = driver1.findElements(By.xpath(rowXpath));
                if (rows.isEmpty()) {
                    return null;
                }
                WebElement r = rows.get(0);
                List<WebElement> rowCells = r.findElements(By.cssSelector("td[role='gridcell']"));
                return rowCells.isEmpty() ? null : r;
            });

            cells = row.findElements(By.cssSelector("td[role='gridcell']"));
            if (colLeafIndex >= cells.size()) {
                throw new Exception("Column index out of range after refresh. idx=" + colLeafIndex + ", cells=" + cells.size());
            }

            cell = cells.get(colLeafIndex);
            scrollTo(cell);
            wait.until(ExpectedConditions.visibilityOf(cell));
            wait.until(ExpectedConditions.elementToBeClickable(cell));

            uiOk = trySetViaUi(cell, value, 5000);
        }

        if (!uiOk) {
            boolean jsOk = setViaModel_ByForEach(regionId, rowText, columnHeader, value);
            if (!jsOk) {
                throw new Exception(
                        "Failed to set value (UI + JS). region=" + regionId +
                                ", row=" + rowText +
                                ", column=" + columnHeader
                );
            }
        }

        // Wait again for APEX/IG to settle after setting the value
        waitForApexReady(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".u-Processing")));

        waitUntilCellChangesToExpected(driver, regionId, rowText, colLeafIndex, before, value, 40);
    }

    private boolean trySetViaUi(WebElement cell, String value, long timeoutMs) {
        WebDriver driver = webDriverProvider.get();
        long end = System.currentTimeMillis() + timeoutMs;

        try {
            clickSafe(cell); // required

            try { cell.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
            try { cell.sendKeys(Keys.F2); } catch (Exception ignored) {}
            try { cell.sendKeys(Keys.SPACE); } catch (Exception ignored) {}

            By editorBy = By.cssSelector(
                    "div.a-GV-columnItem input, div.a-GV-columnItem textarea, div.a-GV-columnItem select," +
                            "td.is-active input, td.is-active textarea, td.is-active select," +
                            "td.a-GV-cell.is-active input, td.a-GV-cell.is-active textarea, td.a-GV-cell.is-active select"
            );

            while (System.currentTimeMillis() < end) {
                List<WebElement> eds = driver.findElements(editorBy);
                for (WebElement ed : eds) {
                    if (!ed.isDisplayed()) continue;

                    // do not edit DDL
                    String tag = safeAttr(ed, "tagName");
                    if (tag != null && tag.equalsIgnoreCase("select")) return false;

                    if (ed.isEnabled()) {
                        try { ed.sendKeys(Keys.chord(Keys.CONTROL, "a")); } catch (Exception ignored) {}
                        try { ed.sendKeys(Keys.DELETE); } catch (Exception ignored) {}
                        ed.sendKeys(value);
                        ed.sendKeys(Keys.TAB);
                        try { ed.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
                        return true;
                    }
                }
                Thread.sleep(150);
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    private void enableIgEditMode(String regionId) {
        ((JavascriptExecutor) webDriverProvider.get()).executeScript(
                "try{" +
                        "var r=apex.region(arguments[0]); if(!r||!r.widget) return;" +
                        "var ig$=r.widget(); if(!ig$||!ig$.length||typeof ig$.interactiveGrid!=='function') return;" +
                        "var a=ig$.interactiveGrid('getActions'); if(a && a.lookup('edit')) a.invoke('edit');" +
                        "}catch(e){}",
                regionId
        );
    }

    private boolean setViaModel_ByForEach(String regionId, String rowText, String columnHeader, String value) {
        Object res = ((JavascriptExecutor) webDriverProvider.get()).executeScript(
                "try {" +
                        " if(!(window.apex && apex.region)) return false;" +
                        " var region = apex.region(arguments[0]); if(!region) return false;" +
                        " var ig$ = region.widget(); if(!ig$) return false;" +
                        " var grid = ig$.interactiveGrid('getViews','grid');" +
                        " if(!grid || !grid.model) return false;" +
                        " var m = grid.model;" +
                        " if(typeof m.forEach !== 'function') return false;" +
                        " try { var act = ig$.interactiveGrid('getActions'); if(act && act.lookup('edit')) act.invoke('edit'); } catch(e){}" +
                        " var cols = null;" +
                        " try { if(grid.getColumns) cols = grid.getColumns(); } catch(e){}" +
                        " if(!cols || !cols.length) { try { if(grid.view$ && grid.view$.grid) cols = grid.view$.grid('getColumns'); } catch(e){} }" +
                        " if(!cols || !cols.length) return false;" +
                        " var key = (arguments[2]||'').trim().toLowerCase();" +
                        " function norm(s){return (s||'').replace(/\\u00a0/g,' ').replace(/[\\n\\r\\t]+/g,' ').trim().toLowerCase();}" +
                        " var prop = null;" +
                        " for(var i=0;i<cols.length;i++){" +
                        "   var c=cols[i];" +
                        "   var h=norm(c.heading||c.label||c.name||'');" +
                        "   if(h===key){ prop=(c.property||c.name||c.id); break; }" +
                        " }" +
                        " if(!prop) return false;" +
                        " var target = (arguments[1]||'').trim();" +
                        " var recFound = null;" +
                        " m.forEach(function(r){" +
                        "   if(recFound) return;" +
                        "   for(var k=0;k<cols.length;k++){" +
                        "     var p = cols[k].property||cols[k].name||cols[k].id;" +
                        "     if(!p) continue;" +
                        "     var v='';" +
                        "     try { v = (m.getValue(r,p) || '').toString().trim(); } catch(e){}" +
                        "     if(v===target){ recFound=r; return; }" +
                        "   }" +
                        " });" +
                        " if(!recFound) return false;" +
                        " m.setValue(recFound, prop, arguments[3]);" +
                        " try { if(m.setEdited) m.setEdited(recFound, true); } catch(e){}" +
                        " return true;" +
                        "} catch(e) { return false; }",
                regionId, rowText, columnHeader, value
        );
        return Boolean.TRUE.equals(res);
    }

    private int resolveLeafHeaderIndex(String regionId, String columnHeader) {
        // IMPORTANT: use grid VC root if headers are inside grid_vc
        String gridId = gridVcId(regionId);

        Object idx = ((JavascriptExecutor) webDriverProvider.get()).executeScript(
                "try {" +
                        " var root=document.getElementById(arguments[0]); if(!root) return -1;" +
                        " var key=(arguments[1]||'').trim().toLowerCase();" +
                        " function norm(s){return (s||'').replace(/\\u00a0/g,' ').replace(/[\\n\\r\\t]+/g,' ').trim().toLowerCase();}" +
                        " var ths=root.querySelectorAll('thead th');" +
                        " var leaf=[];" +
                        " for(var i=0;i<ths.length;i++){" +
                        "   var th=ths[i];" +
                        "   var txt=norm(th.textContent)||norm(th.innerText)||norm(th.getAttribute('aria-label'));" +
                        "   if(!txt) continue;" +
                        "   var colspan=parseInt(th.getAttribute('colspan')||'1',10);" +
                        "   if(colspan>1) continue;" +
                        "   leaf.push(th);" +
                        " }" +
                        " for(var j=0;j<leaf.length;j++){" +
                        "   var t=norm(leaf[j].textContent)||norm(leaf[j].innerText)||norm(leaf[j].getAttribute('aria-label'));" +
                        "   if(t===key) return j;" +
                        " }" +
                        " return -1;" +
                        "}catch(e){return -1;}",
                gridId, columnHeader
        );

        return idx == null ? -1 : ((Number) idx).intValue();
    }

    private String dumpHeaders(String regionId) {
        String gridId = gridVcId(regionId);

        Object res = ((JavascriptExecutor) webDriverProvider.get()).executeScript(
                "try{" +
                        " var root=document.getElementById(arguments[0]); if(!root) return 'Grid not found';" +
                        " function norm(s){return (s||'').replace(/\\u00a0/g,' ').replace(/[\\n\\r\\t]+/g,' ').trim();}" +
                        " var ths=root.querySelectorAll('thead th');" +
                        " var out=[];" +
                        " for(var i=0;i<ths.length;i++){" +
                        "   var th=ths[i];" +
                        "   var label=norm(th.textContent)||norm(th.innerText)||norm(th.getAttribute('aria-label'));" +
                        "   if(label) out.push(label);" +
                        " }" +
                        " return out.join('\\n');" +
                        "}catch(e){return 'ERR:'+e.message;}",
                gridId
        );

        return res == null ? "" : String.valueOf(res);
    }

    private void waitUntilCellChangesToExpected(
            WebDriver driver,
            String regionId,
            String rowText,
            int colLeafIndex,
            String beforeNorm,
            String expectedRaw,
            int timeoutSeconds
    ) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        String expectedNorm = normalizeNumberString(expectedRaw);

        Boolean ok = wait.until(d -> {
            try {
                WebElement row2 = d.findElement(By.xpath(
                        "//div[@id='" + gridVcId(regionId) + "']//tr[@role='row' and .//td[normalize-space()=\"" + rowText + "\"]]"
                ));
                List<WebElement> cells2 = row2.findElements(By.cssSelector("td[role='gridcell']"));
                if (colLeafIndex >= cells2.size()) return false;

                String now = normalizeNumberString(safeText(cells2.get(colLeafIndex)));
                return !now.equals(beforeNorm) && now.equals(expectedNorm);
            } catch (Exception e) {
                return false;
            }
        });

        if (!Boolean.TRUE.equals(ok)) {
            WebElement row2 = driver.findElement(By.xpath(
                    "//div[@id='" + gridVcId(regionId) + "']//tr[@role='row' and .//td[normalize-space()=\"" + rowText + "\"]]"
            ));
            List<WebElement> cells2 = row2.findElements(By.cssSelector("td[role='gridcell']"));
            String actual = normalizeNumberString(safeText(cells2.get(colLeafIndex)));
            throw new Exception("Value not applied. expected='" + expectedNorm + "', actual='" + actual + "'");
        }
    }

    private String normalizeNumberString(String s) {
        if (s == null) return "";
        String x = s.replace("\u00a0", " ").replace(",", "").trim();
        try {
            java.math.BigDecimal bd = new java.math.BigDecimal(x);
            if (x.contains(".")) {
                return bd.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString();
            }
            return bd.stripTrailingZeros().toPlainString();
        } catch (Exception ignored) {
            return x;
        }
    }

    // =====================================================================
// IG – Fill random numbers for ALL enabled cells (skip DDL),
// starting from firstRowText (in first data column)
// IMPORTANT FIXES:
// 1) Scope rows/cells to THIS IG grid VC only (prevents touching RisksQuery_ig)
// 2) Scope editor lookup to THIS IG only (prevents editing the other IG editor)
// =====================================================================
    public int setIGRandomNumbers_AllEnabledCells_SkipDDL_StartAfterSelector(
            String regionIdOrAnyId,
            String firstRowText,
            int minInclusive,
            int maxInclusive
    ) throws Exception {

        if (minInclusive > maxInclusive) {
            throw new Exception("minInclusive must be <= maxInclusive");
        }

        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Resolve IG root id (RiskCalculation_ig)
        String regionId = resolveIgRegionId(regionIdOrAnyId);

        // Use THIS IG root and THIS IG grid VC only
        WebElement igRoot = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(regionId)));
        String gridVc = gridVcId(regionId);
        WebElement grid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));

        // Ensure grid has rows
        wait.until(d -> !grid.findElements(By.cssSelector("tr.a-GV-row[role='row']")).isEmpty()
                || !grid.findElements(By.cssSelector("tr[role='row'].a-GV-row")).isEmpty());

        // Make IG editable (your cell-driven ensure is recommended)
        ensureIGEditMode(regionId);

        // Collect rows from THIS grid only
        List<WebElement> rows = grid.findElements(By.cssSelector("tr.a-GV-row[role='row']"));
        if (rows.isEmpty()) rows = grid.findElements(By.cssSelector("tr[role='row'].a-GV-row"));
        if (rows.isEmpty()) throw new Exception("No rows found in IG grid: " + gridVc);

        int startRowIndex = resolveStartRowIndexByFirstDataCellText(rows, firstRowText);
        int updated = 0;

        for (int r = startRowIndex; r < rows.size(); r++) {
            WebElement row = rows.get(r);
            scrollTo(row);

            String rowLabel = getRowLabel(row);

            // Cells from THIS row only
            List<WebElement> dataCells = row.findElements(By.cssSelector("td[role='gridcell']"));
            if (dataCells.isEmpty()) continue;

            for (int c = 0; c < dataCells.size(); c++) {
                WebElement cell = dataCells.get(c);

                if (!isCellEditableDom(cell)) continue;

                // Header text: scope to THIS grid (not whole page)
                String colHeader = getHeaderTextByLeafIndex(grid, c);

                int rnd = randomBetween(minInclusive, maxInclusive);

                // IMPORTANT: scoped editor lookup to THIS IG
                boolean ok = trySetCellValueViaUi(igRoot, cell, String.valueOf(rnd), 1800);

                if (ok) {
                    updated++;
                    log.info(String.format("[IG Fill] region=%s | row='%s' | col='%s' | value=%s",
                            regionId,
                            rowLabel,
                            (colHeader == null || colHeader.isEmpty()) ? ("#colIndex=" + c) : colHeader,
                            rnd
                    ));
                }
            }
        }

        return updated;
    }



    private int resolveStartRowIndexByFirstDataCellText(List<WebElement> rows, String firstRowText) {
        if (firstRowText == null || firstRowText.trim().isEmpty()) return 0;
        String target = firstRowText.trim();

        for (int i = 0; i < rows.size(); i++) {
            try {
                List<WebElement> tds = rows.get(i).findElements(By.cssSelector("td[role='gridcell']"));
                if (tds.isEmpty()) continue;
                String txt = safeText(tds.get(0)).trim();
                if (txt.equals(target)) return i;
            } catch (Exception ignored) {
            }
        }
        return 0;
    }

    private boolean isCellEditableDom(WebElement cell) {
        try {
            String ariaReadonly = safeAttr(cell, "aria-readonly");
            if ("true".equalsIgnoreCase(ariaReadonly)) return false;

            String cls = safeAttr(cell, "class");
            if (cls != null) {
                String l = cls.toLowerCase();
                if (l.contains("is-readonly")) return false;
                if (l.contains("is-disabled")) return false;
            }
            return cell.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean trySetCellRandomViaUi(WebElement cell, int minInclusive, int maxInclusive, long timeoutMs) {
        WebDriver driver = webDriverProvider.get();
        long end = System.currentTimeMillis() + timeoutMs;

        try {
            scrollTo(cell);
            clickSafe(cell); // required

            try { cell.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
            try { cell.sendKeys(Keys.F2); } catch (Exception ignored) {}

            By editorBy = By.cssSelector(
                    "div.a-GV-columnItem input, div.a-GV-columnItem textarea, div.a-GV-columnItem select," +
                            "td.is-active input, td.is-active textarea, td.is-active select," +
                            "td.a-GV-cell.is-active input, td.a-GV-cell.is-active textarea, td.a-GV-cell.is-active select"
            );

            while (System.currentTimeMillis() < end) {
                List<WebElement> eds = driver.findElements(editorBy);

                for (WebElement ed : eds) {
                    if (!ed.isDisplayed()) continue;

                    // skip DDL
                    String tag = safeAttr(ed, "tagName");
                    if (tag != null && tag.equalsIgnoreCase("select")) return false;

                    // skip known LOV/DDL widgets (best-effort)
                    String eCls = safeAttr(ed, "class");
                    if (eCls != null) {
                        String l = eCls.toLowerCase();
                        if (l.contains("select") || l.contains("lov") || l.contains("popup")) return false;
                    }

                    if (ed.isEnabled()) {
                        int rnd = randomBetween(minInclusive, maxInclusive);

                        try { ed.sendKeys(Keys.chord(Keys.CONTROL, "a")); } catch (Exception ignored) {}
                        try { ed.sendKeys(Keys.DELETE); } catch (Exception ignored) {}

                        ed.sendKeys(String.valueOf(rnd));
                        ed.sendKeys(Keys.TAB);
                        try { ed.sendKeys(Keys.ENTER); } catch (Exception ignored) {}

                        return true;
                    }
                }
                Thread.sleep(120);
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    private int randomBetween(int minInclusive, int maxInclusive) {
        double r = Math.random();
        return (int) Math.floor(r * (maxInclusive - minInclusive + 1)) + minInclusive;
    }

    private String resolveIgRegionId(String regionIdOrAnyId) throws Exception {
        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String raw = regionIdOrAnyId == null ? "" : regionIdOrAnyId.trim();
        if (raw.isEmpty()) throw new Exception("IG id is empty");

        // -----------------------------------------------------------------
        // NEW: if user passed a repository element name, convert to DOM id
        // -----------------------------------------------------------------
        raw = resolveDomIdFromRepositoryIfPossible(raw);

        // Fast path: if apex.region(raw) exists
        if (apexRegionExists(raw)) return raw;

        // Normalize common suffixes to a root guess
        String base = rootIgId(raw);

        // Try common candidates as region static id
        String[] candidates = new String[] {
                raw,
                base,
                raw.replace("_grid_vc", ""),
                base.replace("_grid_vc", ""),
                base.replace("_ig", ""),     // allows apex static id without _ig
                base + "_ig",
                base + "_grid_vc"
        };

        for (String c : candidates) {
            if (c == null || c.trim().isEmpty()) continue;
            if (apexRegionExists(c)) return c;
        }

        // If DOM element exists by id, climb to closest div.a-IG
        for (String c : candidates) {
            if (c == null || c.trim().isEmpty()) continue;
            List<WebElement> els = driver.findElements(By.id(c));
            if (els.isEmpty()) continue;
            try {
                WebElement ig = els.get(0).findElement(By.xpath("ancestor::div[contains(@class,'a-IG')][1]"));
                String igId = ig.getAttribute("id");
                if (igId != null && !igId.trim().isEmpty()) {
                    if (apexRegionExists(igId)) return igId;
                    return igId;
                }
            } catch (Exception ignored) {}
        }

        // Last resort: scan all IG roots and try to pick closest match
        Object scan = ((JavascriptExecutor) driver).executeScript(
                "try{" +
                        " var guess=(arguments[0]||'').toLowerCase();" +
                        " var list=Array.from(document.querySelectorAll('div.a-IG[id]')).map(x=>x.id);" +
                        " function pick(){ " +
                        "  if(!guess) return null;" +
                        "  for(var i=0;i<list.length;i++){ if(list[i].toLowerCase()===guess) return list[i]; }" +
                        "  for(var i=0;i<list.length;i++){ if(list[i].toLowerCase().startsWith(guess)) return list[i]; }" +
                        "  for(var i=0;i<list.length;i++){ if(list[i].toLowerCase().indexOf(guess)>-1) return list[i]; }" +
                        "  return null;" +
                        " }" +
                        " return {picked: pick(), all:list};" +
                        "}catch(e){return {picked:null, all:[]};}",
                base
        );

        if (scan instanceof Map) {
            Map<?, ?> m = (Map<?, ?>) scan;
            Object picked = m.get("picked");
            if (picked != null && !String.valueOf(picked).trim().isEmpty()) {
                return String.valueOf(picked);
            }
            throw new Exception(
                    "Unable to resolve IG root id from: '" + regionIdOrAnyId + "' (resolvedRaw='" + raw + "', base='" + base + "'). IGs found: " + m.get("all")
            );
        }

        throw new Exception("Unable to resolve IG root id from: " + regionIdOrAnyId);
    }

    private String resolveDomIdFromRepositoryIfPossible(String input) {
        try {
            if (cannedPage == null) return input;
            WebElement el = cannedPage.getElementWithWait(cannedPage, input);
            if (el == null) return input;

            String id = el.getAttribute("id");
            if (id != null && !id.trim().isEmpty()) {
                log.info("[IG DEBUG] Resolved repository name '" + input + "' to DOM id '" + id + "'");
                return id.trim();
            }
        } catch (Exception ignored) {
            // not a repository element name
        }
        return input;
    }


    private boolean apexRegionExists(String regionId) {
        Object ok = ((JavascriptExecutor) webDriverProvider.get()).executeScript(
                "try { return !!(window.apex && apex.region && apex.region(arguments[0])); } catch(e){ return false; }",
                regionId
        );
        return Boolean.TRUE.equals(ok);
    }

    /**
     * Ensure IG is in Edit mode (works for any id input).
     */
    private void ensureIGEditMode(String regionIdOrAnyId) throws Exception {
        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));

        // If we can open any cell editor, we're editable
        if (tryOpenAnyCellEditor(regionId, 2000)) {
            log.info("[IG DEBUG] IG is editable without invoking IG edit action. region=" + regionId);
            return;
        }

        // Try IG edit action if available
        try {
            clickIgAction(regionId, "edit");
            waitForApexAjaxToFinish(driver);
        } catch (Exception ignored) {}

        if (tryOpenAnyCellEditor(regionId, 3000)) {
            log.info("[IG DEBUG] IG became editable after invoking IG edit action. region=" + regionId);
            return;
        }

        throw new Exception(
                "Unable to enter IG edit mode (cannot open any cell editor). region=" + regionId +
                        "\nActions state:\n" + dumpIgActionsState(regionId)
        );
    }


    private boolean isIgSaveEnabled(String regionId) {
        try {
            Object enabled = ((JavascriptExecutor) webDriverProvider.get()).executeScript(
                    "try{" +
                            "var r=apex.region(arguments[0]); if(!r||!r.widget) return false;" +
                            "var ig$=r.widget(); if(!ig$||!ig$.length||typeof ig$.interactiveGrid!=='function') return false;" +
                            "var a=ig$.interactiveGrid('getActions'); if(!a) return false;" +
                            "var s=a.lookup('save'); if(!s) return false;" +
                            "return (s.disabled===false);" +
                            "}catch(e){return false;}",
                    regionId
            );
            return Boolean.TRUE.equals(enabled);
        } catch (Exception e) {
            return false;
        }
    }

    public void ensureIgEditModePublic(String regionIdOrAnyId) throws Exception {
        ensureIGEditMode(regionIdOrAnyId);
    }

    private WebElement findIGRowByText(String regionIdOrAnyId, String rowText) throws Exception {
        WebDriver driver = webDriverProvider.get();
        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc   = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));

        WebElement row = wait.until(ExpectedConditions.presenceOfElementLocated(
                igRowByText(gridVc, rowText)
        ));

        scrollTo(row);
        wait.until(ExpectedConditions.visibilityOf(row));
        return row;
    }

    public void fillEnabledIgCellsWithRandomNumbersAndCommit(String anyId, int min, int max) {
        if (min > max) throw new IllegalArgumentException("min must be <= max");

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String js =
                "var anyId=arguments[0], min=arguments[1], max=arguments[2];" +
                        "function randInt(a,b){return Math.floor(Math.random()*(b-a+1))+a;}" +

                        "function resolveRoot(id){" +
                        " if(!id) return null;" +
                        " var el=document.getElementById(id);" +
                        " if(!el && id.indexOf('_grid_vc')>-1) el=document.getElementById(id.replace('_grid_vc',''));" +
                        " if(!el) el=document.getElementById(id + '_grid_vc');" +
                        " if(el){ var ig=el.closest('div.a-IG'); if(ig && ig.id) return ig.id; }" +
                        " // if id itself is IG root" +
                        " var ig2=document.getElementById(id);" +
                        " if(ig2 && ig2.classList && ig2.classList.contains('a-IG')) return id;" +
                        " return id;" +
                        "}" +

                        "function getIg$(id){" +
                        " var rootId=resolveRoot(id);" +
                        " var ig$=null;" +
                        " try{ var r=apex.region(rootId); if(r && r.widget) ig$=r.widget(); }catch(e){}" +
                        " if(!ig$ || !ig$.length || typeof ig$.interactiveGrid!=='function'){ ig$=apex.jQuery('#'+rootId); }" +
                        " if(ig$ && ig$.length && typeof ig$.interactiveGrid==='function') return ig$;" +
                        " // last resort: climb from element" +
                        " var el=document.getElementById(id) || document.getElementById(rootId);" +
                        " if(el){ var igEl=el.closest('div.a-IG'); if(igEl && igEl.id){ ig$=apex.jQuery('#'+igEl.id); } }" +
                        " return ig$;" +
                        "}" +

                        "var ig$=getIg$(anyId);" +
                        "if(!ig$ || !ig$.length) throw 'IG root not found for: '+anyId;" +
                        "if(typeof ig$.interactiveGrid!=='function') throw 'Not an IG widget. root='+ig$[0].id;" +

                        "var actions=ig$.interactiveGrid('getActions');" +
                        "try{ if(actions && actions.lookup('edit')) actions.invoke('edit'); }catch(e){}" +

                        "var gridView=ig$.interactiveGrid('getViews','grid');" +
                        "if(!gridView || !gridView.model) throw 'Grid view/model not found. root='+ig$[0].id;" +
                        "var model=gridView.model;" +

                        // FIX: columns must be retrieved from gridView.view$.grid('getColumns') when available
                        "var cols=[];" +
                        "try{ if(gridView.view$ && gridView.view$.grid) cols = gridView.view$.grid('getColumns') || []; }catch(e){ cols=[]; }" +
                        "if(!cols.length){ try{ if(gridView.getColumns) cols = gridView.getColumns() || []; }catch(e){} }" +
                        "if(!cols.length) throw 'No columns metadata found.';" +

                        "function isSkipCol(c){" +
                        " var t=(c.type||c.itemType||'').toString().toLowerCase();" +
                        " var p=(c.property||c.name||c.id||'').toString().toLowerCase();" +
                        " if(!p) return true;" +
                        " if(t==='rowselect' || t==='actions') return true;" +
                        " if(p.indexOf('rowselector')>-1) return true;" +
                        " if(c.hidden===true) return true;" +
                        " return false;" +
                        "}" +
                        "function looksLikeLov(c){" +
                        " var t=(c.type||c.itemType||c.elementType||'').toString().toLowerCase();" +
                        " var it=(c.itemType||'').toString().toLowerCase();" +
                        " if(t.indexOf('select')>-1 || t.indexOf('lov')>-1 || t.indexOf('popup')>-1) return true;" +
                        " if(it.indexOf('select')>-1 || it.indexOf('lov')>-1) return true;" +
                        " return false;" +
                        "}" +

                        "var props=[];" +
                        "for(var i=0;i<cols.length;i++){" +
                        " var c=cols[i];" +
                        " if(!c || isSkipCol(c)) continue;" +
                        " if(looksLikeLov(c)) continue;" +
                        " var prop=c.property||c.name||c.id;" +
                        " if(prop) props.push(prop);" +
                        "}" +

                        "if(typeof model.forEach!=='function') throw 'Model.forEach not available';" +

                        "var updated=0, skipped=0;" +
                        "model.forEach(function(rec){" +
                        " var md=null;" +
                        " try{ if(typeof model.getRecordMetadata==='function') md=model.getRecordMetadata(rec); }catch(e){}" +
                        " for(var j=0;j<props.length;j++){" +
                        "  var p=props[j];" +
                        "  try{" +
                        "    if(md && md.fields && md.fields[p]){" +
                        "      var f=md.fields[p];" +
                        "      if(f.readonly===true || f.readOnly===true || f.disabled===true){ skipped++; continue; }" +
                        "    }" +
                        "    var cur=null;" +
                        "    try{ cur=model.getValue(rec,p); }catch(e){}" +
                        "    if(cur!==null && cur!==undefined && cur!==''){" +
                        "      var s=cur.toString().replace(/,/g,'').trim();" +
                        "      if(s!=='' && isNaN(Number(s))){ skipped++; continue; }" +
                        "    }" +
                        "    model.setValue(rec,p,randInt(min,max));" +
                        "    updated++;" +
                        "  }catch(e){ skipped++; }" +
                        " }" +
                        "});" +

                        "if(updated>0){" +
                        " try{ if(actions && actions.lookup('save')) actions.invoke('save'); }catch(e){}" +
                        "}" +
                        "return {root: ig$[0].id, props: props.length, updated: updated, skipped: skipped};";

        Object result = ((JavascriptExecutor) driver).executeScript(js, anyId, min, max);
        waitForApexAjaxToFinish(driver);

        if (result instanceof Map) {
            Map<?, ?> m = (Map<?, ?>) result;
            int props = m.get("props") == null ? 0 : ((Number) m.get("props")).intValue();
            int updated = m.get("updated") == null ? 0 : ((Number) m.get("updated")).intValue();

            if (props == 0) {
                throw new RuntimeException("IG found (" + m.get("root") + ") but no candidate columns found (props=0).");
            }
            if (updated == 0) {
                throw new RuntimeException("IG found (" + m.get("root") + ") but no cells updated (updated=0).");
            }
        }
    }

    public int fillCalcIgRandomAndSave(String regionIdOrAnyId, String firstRowText, int min, int max) throws Exception {
        String regionId = resolveIgRegionId(regionIdOrAnyId);

        clickIgEdit(regionId);
        int updated = setIGRandomNumbers_AllEnabledCells_SkipDDL_StartAfterSelector(regionId, firstRowText, min, max);
        clickIgSave(regionId);

        return updated;
    }

    private void clickIgAction(String regionIdOrAnyId, String actionName) throws Exception {
        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String resolved = resolveIgRegionId(regionIdOrAnyId);
        String regionId = apexRegionIdForActions(resolved);
        String actionKey = safeLower(actionName); // "edit" / "save"

        // 1) APEX actions (best)
        Object ok = ((JavascriptExecutor) driver).executeScript(
                "try{" +
                        "var id=arguments[0], actName=arguments[1];" +
                        "if(!window.apex || !apex.region) return false;" +
                        "var r=apex.region(id); if(!r || !r.widget) return false;" +
                        "var ig$=r.widget(); if(!ig$ || !ig$.length || typeof ig$.interactiveGrid!=='function') return false;" +
                        "var a=ig$.interactiveGrid('getActions'); if(!a) return false;" +
                        "var act=a.lookup(actName); if(!act) return false;" +
                        "a.invoke(actName);" +
                        "return true;" +
                        "}catch(e){return false;}",
                regionId, actionKey
        );

        if (Boolean.TRUE.equals(ok)) {
            waitForApexAjaxToFinish(driver);
            return;
        }

        // 2) Toolbar fallback: find button inside IG root (do NOT rely on *_ig_toolbar_container)
        WebElement igRoot = driver.findElement(By.id(regionId));

        // APEX toolbars vary; search broadly inside root
        List<WebElement> buttons = igRoot.findElements(By.cssSelector("button"));
        WebElement target = null;

        for (WebElement b : buttons) {
            String title = safeLower(b.getAttribute("title"));
            String txt = safeLower(b.getText());
            String aria = safeLower(b.getAttribute("aria-label"));

            if (actionKey.equals(title) || actionKey.equals(txt) || actionKey.equals(aria)) {
                target = b;
                break;
            }

            // some themes have "Save" in title but empty text
            if ("save".equals(actionKey) && (title.contains("save") || aria.contains("save"))) {
                target = b;
                break;
            }
            if ("edit".equals(actionKey) && (title.contains("edit") || aria.contains("edit"))) {
                target = b;
                break;
            }
        }

        if (target == null) {
            Object allIgs = ((JavascriptExecutor) driver).executeScript(
                    "try{return Array.from(document.querySelectorAll('div.a-IG[id]')).map(x=>x.id);}catch(e){return [];}"
            );
            throw new Exception(
                    "IG action failed. resolvedRegionId=" + regionId +
                            ", input=" + regionIdOrAnyId +
                            ", action=" + actionName +
                            ", IGsOnPage=" + String.valueOf(allIgs)
            );
        }

        clickSafe(target);
        waitForApexAjaxToFinish(driver);
    }

    public void clickIgEdit(String regionIdOrAnyId) throws Exception {
        clickIgAction(regionIdOrAnyId, "edit");
    }

    public void clickIgSave(String regionIdOrAnyId) throws Exception {
        clickIgAction(regionIdOrAnyId, "save");
    }

    private void waitForApexReady(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(d -> {
            try {
                Object ok = ((JavascriptExecutor) d).executeScript("return !!window.apex && !!apex.jQuery;");
                return Boolean.TRUE.equals(ok);
            } catch (Exception e) {
                return false;
            }
        });
    }

    private void waitForApexAjaxToFinish(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(35)).until(d -> {
            try {
                Object idle = ((JavascriptExecutor) d).executeScript(
                        "var $=apex.jQuery;" +
                                "var ajaxIdle=($.active===0);" +
                                "var spinners=$('.u-Processing, .u-Processing--fixed, .a-LoadingIndicator').length;" +
                                "return ajaxIdle && spinners===0;"
                );
                return Boolean.TRUE.equals(idle);
            } catch (Exception e) {
                return true;
            }
        });
    }

    private void clickSafe(WebElement el) {
        try {
            el.click();
        } catch (ElementClickInterceptedException e) {
            try {
                ((JavascriptExecutor) webDriverProvider.get()).executeScript("arguments[0].click();", el);
            } catch (Exception ignored) {}
        } catch (Exception ignored) {}
    }

    private void scrollTo(WebElement el) {
        ((JavascriptExecutor) webDriverProvider.get())
                .executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", el);
    }

    private String safeText(WebElement el) {
        try {
            String t = el.getText();
            return t == null ? "" : t.trim();
        } catch (StaleElementReferenceException e) {
            return "";
        }
    }

    private String safeAttr(WebElement el, String attr) {
        try {
            return el.getAttribute(attr);
        } catch (Exception e) {
            return null;
        }
    }

    private String safeLower(String s) {
        return s == null ? "" : s.trim().toLowerCase();
    }

    private String rootIgId(String anyId) {
        if (anyId == null) return "";
        String id = anyId.trim();

        if (id.endsWith("_grid_vc")) id = id.substring(0, id.length() - "_grid_vc".length());
        if (id.endsWith("_ig_toolbar_container")) id = id.substring(0, id.length() - "_ig_toolbar_container".length());

        // do NOT strip "_ig" here, because IG root id can legitimately end with _ig (e.g., calc_ig)
        return id;
    }

    private String gridVcId(String regionRootId) {
        WebDriver driver = webDriverProvider.get();

        String root = rootIgId(regionRootId);

        String c1 = root.endsWith("_grid_vc") ? root : root + "_grid_vc";
        if (!driver.findElements(By.id(c1)).isEmpty()) return c1;

        if (root.endsWith("_ig")) {
            String base = root.substring(0, root.length() - 3);
            String c2 = base + "_grid_vc";
            if (!driver.findElements(By.id(c2)).isEmpty()) return c2;
        }

        return c1;
    }

    private String getHeaderTextByLeafIndex(WebElement regionRoot, int leafIndex) {
        try {
            List<WebElement> ths = regionRoot.findElements(By.cssSelector("thead th"));
            // build leaf headers: colspan == 1 and has text
            java.util.ArrayList<WebElement> leaf = new java.util.ArrayList<>();
            for (WebElement th : ths) {
                String txt = safeText(th);
                if (txt == null) txt = "";
                String colspanStr = th.getAttribute("colspan");
                int colspan = 1;
                try { colspan = Integer.parseInt(colspanStr == null ? "1" : colspanStr); } catch (Exception ignored) {}
                if (colspan > 1) continue;
                if (txt.trim().isEmpty()) {
                    String aria = th.getAttribute("aria-label");
                    if (aria != null && !aria.trim().isEmpty()) txt = aria.trim();
                }
                if (!txt.trim().isEmpty()) leaf.add(th);
            }
            if (leafIndex >= 0 && leafIndex < leaf.size()) {
                String t = safeText(leaf.get(leafIndex));
                if (t == null || t.trim().isEmpty()) {
                    String aria = leaf.get(leafIndex).getAttribute("aria-label");
                    if (aria != null) return aria.trim();
                }
                return t == null ? "" : t.trim();
            }
        } catch (Exception ignored) {}
        return "";
    }

    private String getRowLabel(WebElement row) {
        try {
            List<WebElement> tds = row.findElements(By.cssSelector("td[role='gridcell']"));
            if (!tds.isEmpty()) return safeText(tds.get(0)).trim();
        } catch (Exception ignored) {}
        return "";
    }


    private boolean trySetCellValueViaUi(WebElement igRoot, WebElement cell, String value, long timeoutMs) {
        WebDriver driver = webDriverProvider.get();
        long end = System.currentTimeMillis() + timeoutMs;

        java.util.function.LongConsumer tinyWait = ms -> {
            try { Thread.sleep(ms); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
        };

        try {
            scrollTo(cell);
            clickSafe(cell);

            try { cell.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
            tinyWait.accept(120);

            try { cell.sendKeys(Keys.F2); } catch (Exception ignored) {}
            tinyWait.accept(120);

            By editorBy = By.cssSelector(
                    "div.a-GV-columnItem input, div.a-GV-columnItem textarea, div.a-GV-columnItem select," +
                            "td.is-active input, td.is-active textarea, td.is-active select," +
                            "td.a-GV-cell.is-active input, td.a-GV-cell.is-active textarea, td.a-GV-cell.is-active select"
            );

            while (System.currentTimeMillis() < end) {

                // IMPORTANT: only search editors inside THIS IG
                List<WebElement> eds = igRoot.findElements(editorBy);

                for (WebElement ed : eds) {
                    if (!ed.isDisplayed()) continue;

                    // Skip DDL
                    String tag = ed.getTagName();
                    if (tag != null && tag.equalsIgnoreCase("select")) return false;

                    // Skip known LOV/DDL widgets (best-effort)
                    String eCls = safeAttr(ed, "class");
                    if (eCls != null) {
                        String l = eCls.toLowerCase();
                        if (l.contains("select") || l.contains("lov") || l.contains("popup")) return false;
                    }

                    if (ed.isEnabled()) {
                        try { ed.sendKeys(Keys.chord(Keys.CONTROL, "a")); } catch (Exception ignored) {}
                        tinyWait.accept(120);

                        try { ed.sendKeys(Keys.DELETE); } catch (Exception ignored) {}
                        tinyWait.accept(150);

                        ed.sendKeys(value);
                        tinyWait.accept(150);

                        // Commit
                        ed.sendKeys(Keys.TAB);
                        tinyWait.accept(150);

                        try { ed.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
                        tinyWait.accept(120);

                        return true;
                    }
                }

                tinyWait.accept(120);
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    public String getIGCellText(
            String regionIdOrAnyId,
            String rowText,
            String columnHeader
    ) throws Exception {

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVcId(regionId))));

        // Resolve column index (leaf header)
        int colLeafIndex = resolveLeafHeaderIndex(regionId, columnHeader);
        if (colLeafIndex < 0) {
            throw new Exception(
                    "Header not found: '" + columnHeader + "'\nAvailable headers:\n" + dumpHeaders(regionId)
            );
        }

        // Find row by its first column text
        WebElement row = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(
                        "//div[@id='" + gridVcId(regionId) + "']" +
                                "//tr[@role='row' and .//td[normalize-space()=\"" + rowText + "\"]]"
                )
        ));

        List<WebElement> cells = row.findElements(By.cssSelector("td[role='gridcell']"));
        if (colLeafIndex >= cells.size()) {
            throw new Exception(
                    "Column index out of range. idx=" + colLeafIndex + ", cells=" + cells.size()
            );
        }

        WebElement cell = cells.get(colLeafIndex);
        scrollTo(cell);

        return normalizeNumberString(safeText(cell));
    }


    public int fillSecondIgRandomAndSaveOnly(
            String secondIgRegionIdOrAnyId,
            String secondIgFirstRowText,
            int min,
            int max
    ) throws Exception {

        if (min > max) throw new Exception("min must be <= max");

        String ig2 = resolveIgRegionId(secondIgRegionIdOrAnyId);

        // Use the fixed edit mode enabler
        ensureIGEditMode(ig2);

        int updated2 = setIGRandomNumbers_AllEnabledCells_SkipDDL_StartAfterSelector(
                ig2, secondIgFirstRowText, min, max
        );

        clickIgSave(ig2);

        if (updated2 <= 0) {
            throw new Exception("IG: No enabled non-DDL cells were updated. ig=" + ig2);
        }

        return updated2;
    }

    private String apexRegionIdForActions(String regionIdOrAnyId) {
        String id = regionIdOrAnyId == null ? "" : regionIdOrAnyId.trim();
        if (id.isEmpty()) return id;

        // If apex.region(id) works, keep it
        if (apexRegionExists(id)) return id;

        // If the DOM id ends with _ig, try static id without it
        if (id.endsWith("_ig")) {
            String base = id.substring(0, id.length() - 3);
            if (apexRegionExists(base)) return base;
        }

        return id;
    }

    private boolean tryOpenAnyCellEditor(String regionIdOrAnyId, long timeoutMs) {
        WebDriver driver = webDriverProvider.get();
        long end = System.currentTimeMillis() + timeoutMs;

        String regionId;
        try {
            regionId = resolveIgRegionId(regionIdOrAnyId);
        } catch (Exception e) {
            return false;
        }

        String gridVc = gridVcId(regionId);

        By cellsBy = By.cssSelector("#" + gridVc + " td[role='gridcell']");

        By editorBy = By.cssSelector(
                "div.a-GV-columnItem input, div.a-GV-columnItem textarea, div.a-GV-columnItem select," +
                        "td.is-active input, td.is-active textarea, td.is-active select," +
                        "td.a-GV-cell.is-active input, td.a-GV-cell.is-active textarea, td.a-GV-cell.is-active select"
        );

        while (System.currentTimeMillis() < end) {
            try {
                List<WebElement> cells = driver.findElements(cellsBy);
                for (WebElement cell : cells) {
                    if (!cell.isDisplayed()) continue;

                    String ro = safeAttr(cell, "aria-readonly");
                    if ("true".equalsIgnoreCase(ro)) continue;

                    scrollTo(cell);
                    clickSafe(cell);

                    try { cell.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
                    try { cell.sendKeys(Keys.F2); } catch (Exception ignored) {}

                    // NOTE: global is OK here because we just need detection, not editing.
                    // If you want fully scoped detection, pass igRoot similarly.
                    List<WebElement> editors = driver.findElements(editorBy);
                    for (WebElement ed : editors) {
                        if (ed.isDisplayed() && ed.isEnabled()) {
                            return true;
                        }
                    }
                }
            } catch (Exception ignored) {
            }

            try { Thread.sleep(150); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
        }

        return false;
    }


    private String dumpIgActionsState(String regionIdOrAnyId) {
        try {
            String regionId = resolveIgRegionId(regionIdOrAnyId);

            Object res = ((JavascriptExecutor) webDriverProvider.get()).executeScript(
                    "try{" +
                            "var id=arguments[0];" +
                            "var out=[];" +
                            "if(!window.apex||!apex.region) return 'No apex.region';" +
                            "var r=apex.region(id); if(!r||!r.widget) return 'apex.region not found for '+id;" +
                            "var ig$=r.widget(); if(!ig$||!ig$.length||typeof ig$.interactiveGrid!=='function') return 'Not an IG widget: '+id;" +
                            "var a=ig$.interactiveGrid('getActions'); if(!a) return 'No actions';" +
                            "function st(name){" +
                            " var act=a.lookup(name);" +
                            " if(!act) return name+':(missing)';" +
                            " return name+': disabled='+(act.disabled===true)+'; hide='+(act.hide===true);" +
                            "}" +
                            "out.push(st('edit'));" +
                            "out.push(st('save'));" +
                            "out.push(st('selection-edit'));" +
                            "out.push(st('row-add'));" +
                            "out.push(st('row-delete'));" +
                            "return out.join('\\n');" +
                            "}catch(e){return 'ERR:'+e.message;}",
                    regionId
            );

            return res == null ? "" : String.valueOf(res);
        } catch (Exception e) {
            return "ERR: " + e.getMessage();
        }
    }

    private String resolveIgRegionIdByIndex(int oneBasedIndex) throws Exception {
        if (oneBasedIndex < 1) throw new Exception("IG index must be >= 1");

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        Object id = ((JavascriptExecutor) driver).executeScript(
                "try{" +
                        "var n=parseInt(arguments[0],10);" +
                        "var list=Array.from(document.querySelectorAll('div.a-IG[id]'))" +
                        " .filter(function(x){" +
                        "   var r=x.getBoundingClientRect();" +
                        "   return r.width>0 && r.height>0;" + // visible
                        " })" +
                        " .map(function(x){return x.id;});" +
                        "return (n>=1 && n<=list.length) ? list[n-1] : null;" +
                        "}catch(e){return null;}",
                oneBasedIndex
        );

        if (id == null || String.valueOf(id).trim().isEmpty()) {
            Object all = ((JavascriptExecutor) driver).executeScript(
                    "try{return Array.from(document.querySelectorAll('div.a-IG[id]')).map(x=>x.id);}catch(e){return [];}"
            );
            throw new Exception("Cannot resolve IG by index=" + oneBasedIndex + ". IGs found: " + String.valueOf(all));
        }

        return String.valueOf(id);
    }

    public int fillIgByIndexRandomAndSave(
            int igIndexOneBased,
            String firstRowText,
            int min,
            int max
    ) throws Exception {

        if (min > max) throw new Exception("min must be <= max");

        // Resolve the correct IG root by position (2 = second IG)
        String igId = resolveIgRegionIdByIndex(igIndexOneBased);

        log.info("[IG DEBUG] Using IG index=" + igIndexOneBased + " resolvedId=" + igId);

        // Ensure editable (your new cell-driven ensure method)
        ensureIGEditMode(igId);

        int updated = setIGRandomNumbers_AllEnabledCells_SkipDDL_StartAfterSelector(
                igId, firstRowText, min, max
        );

        clickIgSave(igId);

        if (updated <= 0) {
            throw new Exception("No enabled non-DDL cells were updated. igIndex=" + igIndexOneBased + ", ig=" + igId);
        }

        return updated;
    }


//    public void assertIgLocalAmountFillable(String regionIdOrAnyId, String rowText) throws Exception {
//        String regionId = resolveIgRegionId(regionIdOrAnyId);
//
//        // Screen 1: "Local" under group "Amount"
//        // Screen 2: leaf header is "Amount"
//        String columnHeader = resolveFirstExistingLeafHeader(regionId, "Local", "Amount");
//
//        assertIgCellFillable_ByEditor(regionId, rowText, columnHeader);
//    }
public void assertIgLocalAmountFillable(String regionIdOrAnyId, String rowText) throws Exception {
    String regionId = resolveIgRegionId(regionIdOrAnyId);

    // Select the row FIRST (radio selector) to ensure we validate the selected row only
    selectIgRowByRowText(regionId, rowText);

    // In this IG the leaf header is usually "Local Amount" (not "Local" or "Amount")
    String columnHeader = resolveFirstExistingLeafHeader(
            regionId,
            "Local Amount",
            "Local",
            "Amount"
    );

    // Assert only LOCAL/AMOUNT is fillable (do not touch Prem No)
    assertIgCellFillable_ByEditor(regionId, rowText, columnHeader);
}
    private void selectIgRowByRowText(String regionIdOrAnyId, String rowText) throws Exception {
        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc   = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));

        WebElement row = wait.until(ExpectedConditions.presenceOfElementLocated(
                igRowByText(gridVc, rowText)
        ));
        scrollTo(row);

        List<WebElement> selectors = row.findElements(By.cssSelector(
                "td.a-GV-rowSelector input, td.a-GV-rowSelector button," +
                        "td[role='rowheader'] input, td[role='rowheader'] button"
        ));

        if (selectors.isEmpty()) {
            clickSafe(row);
        } else {
            WebElement sel = selectors.get(0);
            if ("input".equalsIgnoreCase(sel.getTagName())) {
                String type = safeLower(sel.getAttribute("type"));
                if (("radio".equals(type) || "checkbox".equals(type))) {
                    if (!sel.isSelected()) clickSafe(sel);
                } else {
                    clickSafe(sel);
                }
            } else {
                clickSafe(sel);
            }
        }

        wait.until(d -> {
            try {
                String cls = row.getAttribute("class");
                return cls != null && cls.toLowerCase().contains("is-selected");
            } catch (StaleElementReferenceException e) {
                return true;
            }
        });
    }
    private String xpathLiteral(String s) {
        if (s == null) return "''";
        if (!s.contains("'")) return "'" + s + "'";
        if (!s.contains("\"")) return "\"" + s + "\"";
        // Contains both quotes -> concat('a', "'", 'b', '"', 'c')
        StringBuilder sb = new StringBuilder("concat(");
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            String part;
            if (arr[i] == '\'') part = "\"'\"";
            else if (arr[i] == '\"') part = "'\"'";
            else part = "'" + arr[i] + "'";
            sb.append(part);
            if (i < arr.length - 1) sb.append(",");
        }
        sb.append(")");
        return sb.toString();
    }
    private By igRowByText(String gridVc, String rowText) {
        String t = xpathLiteral(rowText.trim());

        // Match text anywhere inside ANY gridcell (td or its children), not only td direct text.
        String xp =
                "//div[@id=" + xpathLiteral(gridVc) + "]" +
                        "//tr[@role='row' and contains(@class,'a-GV-row')]" +
                        "[" +
                        "  .//td[@role='gridcell']//*[normalize-space(.)=" + t + "]" +
                        "  or .//td[@role='gridcell'][normalize-space(.)=" + t + "]" +
                        "  or .//td[contains(@class,'a-GV-cell')]//*[normalize-space(.)=" + t + "]" +
                        "  or .//td[contains(@class,'a-GV-cell')][normalize-space(.)=" + t + "]" +
                        "]";

        return By.xpath(xp);
    }

    public void assertIgForeignAmountFillable(String regionIdOrAnyId, String rowText) throws Exception {
        String regionId = resolveIgRegionId(regionIdOrAnyId);

        // Screen 1: "Foreign" under group "Amount"
        // Screen 2: "Foreign Amount"
        String columnHeader = resolveFirstExistingLeafHeader(regionId, "Foreign", "Foreign Amount");

        assertIgCellFillable_ByEditor(regionId, rowText, columnHeader);
    }

    private void assertIgCellFillable_ByEditor(String regionIdOrAnyId, String rowText, String columnHeader) throws Exception {
        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc = gridVcId(regionId);

        // Ensure grid exists + edit mode
        new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));
        ensureIGEditMode(regionId);

        // Resolve column index
        int colLeafIndex = resolveLeafHeaderIndex(regionId, columnHeader);
        if (colLeafIndex < 0) {
            throw new Exception("Header not found: '" + columnHeader + "'\nFound headers:\n" + dumpHeaders(regionId));
        }

        // Find row (your existing helper)
        WebElement row = findIGRowByText(regionId, rowText);

        List<WebElement> cells = row.findElements(By.cssSelector("td[role='gridcell']"));
        if (colLeafIndex >= cells.size()) {
            throw new Exception("Column index out of range. idx=" + colLeafIndex + ", cells=" + cells.size());
        }

        WebElement cell = cells.get(colLeafIndex);
        scrollTo(cell);

        // Fast fail if DOM says readonly
        String ariaReadonly = safeAttr(cell, "aria-readonly");
        if ("true".equalsIgnoreCase(ariaReadonly)) {
            throw new Exception("Cell is read-only (aria-readonly=true). region=" + regionId +
                    ", row='" + rowText + "', col='" + columnHeader + "'");
        }
        String cls = safeAttr(cell, "class");
        if (cls != null && cls.toLowerCase().contains("is-readonly")) {
            throw new Exception("Cell is read-only (class contains is-readonly). region=" + regionId +
                    ", row='" + rowText + "', col='" + columnHeader + "'");
        }

        // Try to open editor (APEX IG)
        clickSafe(cell);
        try { cell.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
        try { cell.sendKeys(Keys.F2); } catch (Exception ignored) {}

        WebElement igRoot = driver.findElement(By.id(regionId));

        By editorBy = By.cssSelector(
                "div.a-GV-columnItem input, div.a-GV-columnItem textarea," +
                        "td.is-active input, td.is-active textarea," +
                        "td.a-GV-cell.is-active input, td.a-GV-cell.is-active textarea"
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement editor = wait.until(d -> {
            try {
                List<WebElement> eds = igRoot.findElements(editorBy);
                for (WebElement e : eds) {
                    if (e.isDisplayed()) return e;
                }
            } catch (Exception ignored) {}
            return null;
        });

        if (editor == null) {
            throw new Exception("No editor opened for cell. region=" + regionId +
                    ", row='" + rowText + "', col='" + columnHeader + "'");
        }

        if (!editor.isEnabled()) {
            throw new Exception("Editor opened but is disabled (not fillable). region=" + regionId +
                    ", row='" + rowText + "', col='" + columnHeader + "'");
        }

        // If you want, also verify it's not a LOV/select
        String tag = editor.getTagName();
        if (tag != null && tag.equalsIgnoreCase("select")) {
            throw new Exception("Editor is a SELECT/DDL (not a free text/numeric fill). region=" + regionId +
                    ", row='" + rowText + "', col='" + columnHeader + "'");
        }

        // Passed: editor exists + enabled
        Assert.assertTrue(true);
    }

    private String resolveFirstExistingLeafHeader(String regionId, String... candidates) throws Exception {
        for (String h : candidates) {
            int idx = resolveLeafHeaderIndex(regionId, h);
            if (idx >= 0) return h;
        }
        throw new Exception(
                "None of the expected headers exist in IG. candidates=" + java.util.Arrays.toString(candidates) +
                        "\nFound headers:\n" + dumpHeaders(regionId)
        );
    }


    public void assertProgramsTreeSearchResultsContain(String searchInputElementNameOrId, String expectedText) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String expected = expectedText == null ? "" : expectedText.trim();
        if (expected.isEmpty()) {
            throw new IllegalArgumentException("Expected text must not be empty.");
        }

        String anchor = searchInputElementNameOrId;
        if ("ProgramsTree".equalsIgnoreCase(anchor)) {
            anchor = "SearchTreeInput";
        }

        // Resolve search input
        WebElement searchInput = resolveElementSmart(anchor, wait);
        wait.until(ExpectedConditions.visibilityOf(searchInput));

        // Small debounce for client-side filtering (APEX Tree search)
        Thread.sleep(700);

        // Find the visible tree (no waiting on refresh)
        WebElement tree = driver.findElements(By.cssSelector(".a-TreeView"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("No visible APEX Tree found after searching for '" + expected + "'")
                );

        String expectedLower = expected.toLowerCase();

        // Prefer LEAF nodes only (ignore parents like Setup)
        List<WebElement> leafLabels = tree.findElements(
                By.cssSelector(".a-TreeView-node:not(.is-collapsible) .a-TreeView-label")
        );

        // If no leaf nodes, fallback to visible labels
        List<WebElement> labelsToCheck = leafLabels.isEmpty()
                ? tree.findElements(By.cssSelector(".a-TreeView-label"))
                : leafLabels;

        if (labelsToCheck.isEmpty()) {
            throw new AssertionError("Tree has no visible results after searching for '" + expected + "'");
        }

        List<String> offenders = new ArrayList<>();

        for (WebElement label : labelsToCheck) {
            String text;
            try {
                text = label.getText() == null ? "" : label.getText().trim();
            } catch (StaleElementReferenceException e) {
                continue;
            }

            if (text.isEmpty()) continue;

            if (!text.toLowerCase().contains(expectedLower)) {
                offenders.add(text);
            }
        }

        if (!offenders.isEmpty()) {
            throw new AssertionError(
                    "Some tree results do NOT contain '" + expected + "'. Offenders:\n- "
                            + String.join("\n- ", offenders)
            );
        }

        log.info("Asserted APEX tree results contain '" + expected + "'");
    }

    private WebElement resolveElementSmart(String elementNameOrLocator, WebDriverWait wait) throws Exception {
        WebDriver driver = webDriverProvider.get();
        String s = elementNameOrLocator == null ? "" : elementNameOrLocator.trim();
        if (s.isEmpty()) throw new IllegalArgumentException("Element identifier is empty.");

        // 1) Resolve using the SAME repository used by your Input steps (CannedPage)
        try {
            return cannedPage.getElementWithWait(cannedPage, s);
        } catch (Exception ignored) { }

        // 2) XPath
        if (s.startsWith("//") || s.startsWith("(//")) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s)));
        }

        // 3) css=...
        if (s.toLowerCase().startsWith("css=")) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(s.substring(4).trim())));
        }

        // 4) id=... / name=...
        if (s.toLowerCase().startsWith("id=")) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(s.substring(3).trim())));
        }
        if (s.toLowerCase().startsWith("name=")) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(s.substring(5).trim())));
        }

        // 5) fallback tries
        try { return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(s))); } catch (Exception ignored) {}
        try { return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(s))); } catch (Exception ignored) {}
        try { return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#" + s))); } catch (Exception ignored) {}

        throw new Exception("Unable to resolve element: '" + elementNameOrLocator + "'");
    }


    public int countTreeResultsContainingAndSave(String searchInputElementNameOrId, String expectedText) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String expected = expectedText == null ? "" : expectedText.trim();
        if (expected.isEmpty()) throw new IllegalArgumentException("Expected text must not be empty.");

        String anchor = searchInputElementNameOrId;
        if ("ProgramsTree".equalsIgnoreCase(anchor)) anchor = "SearchTreeInput";

        // Resolve search input (same repo as steps)
        WebElement searchInput = resolveElementSmart(anchor, wait);
        wait.until(ExpectedConditions.visibilityOf(searchInput));

        // Debounce for APEX client filtering
        Thread.sleep(700);

        // Find visible APEX tree
        WebElement tree = driver.findElements(By.cssSelector(".a-TreeView"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("No visible APEX Tree found after searching for '" + expected + "'")
                );

        String expectedLower = expected.toLowerCase();

        // Prefer LEAF nodes only
        List<WebElement> leafLabels = tree.findElements(
                By.cssSelector(".a-TreeView-node:not(.is-collapsible) .a-TreeView-label")
        );

        // Fallback to all labels
        List<WebElement> labelsToCheck = leafLabels.isEmpty()
                ? tree.findElements(By.cssSelector(".a-TreeView-label"))
                : leafLabels;

        if (labelsToCheck.isEmpty()) {
            log.info("Tree has no visible results after searching for '" + expected + "'. count=0");
            return 0;
        }

        int containsCount = 0;

        for (WebElement label : labelsToCheck) {
            String text;
            try {
                text = label.getText() == null ? "" : label.getText().trim();
            } catch (StaleElementReferenceException e) {
                continue;
            }

            if (text.isEmpty()) continue;

            if (text.toLowerCase().contains(expectedLower)) {
                containsCount++;
            }
        }

        log.info(String.format("Tree results containing '%s': %d / %d",
                expected, containsCount, labelsToCheck.size()));

        return containsCount;
    }


    public int recountTreeResultsContaining(String searchInputElementNameOrId, String expectedText) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String expected = expectedText == null ? "" : expectedText.trim();
        if (expected.isEmpty()) throw new IllegalArgumentException("Expected text must not be empty.");

        String anchor = searchInputElementNameOrId;
        if ("ProgramsTree".equalsIgnoreCase(anchor)) anchor = "SearchTreeInput";

        WebElement searchInput = resolveElementSmart(anchor, wait);
        wait.until(ExpectedConditions.visibilityOf(searchInput));

        // Client-side debounce (APEX Tree search)
        Thread.sleep(700);

        WebElement tree = driver.findElements(By.cssSelector(".a-TreeView"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("No visible APEX Tree found while re-counting for '" + expected + "'")
                );

        String expectedLower = expected.toLowerCase();

        // Prefer LEAF nodes
        List<WebElement> leafLabels = tree.findElements(
                By.cssSelector(".a-TreeView-node:not(.is-collapsible) .a-TreeView-label")
        );

        List<WebElement> labelsToCheck = leafLabels.isEmpty()
                ? tree.findElements(By.cssSelector(".a-TreeView-label"))
                : leafLabels;

        int count = 0;

        for (WebElement label : labelsToCheck) {
            try {
                String txt = label.getText();
                if (txt != null && txt.toLowerCase().contains(expectedLower)) {
                    count++;
                }
            } catch (StaleElementReferenceException ignored) {}
        }

        log.info("Re-counted tree results containing '" + expected + "': " + count);
        return count;
    }

    public void assertProgramsTreeIsExpandedOrCollapsed(String treeIdOrAnyId, String expectedState) throws Exception {

        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String expected = expectedState == null ? "" : expectedState.trim().toLowerCase();
        if (!"expanded".equals(expected) && !"collapsed".equals(expected)) {
            throw new IllegalArgumentException("expectedState must be 'expanded' or 'collapsed'");
        }

        // Wait button exists
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("EXPAND_COLLAPSE")));

        // Retry to avoid animation/race
        String actual = null;
        for (int i = 0; i < 5; i++) {
            actual = getApexTreeExpandCollapseState(driver);
            if (!"unknown".equals(actual)) break;
            Thread.sleep(200);
        }

        if (!expected.equals(actual)) {
            throw new AssertionError("APEX Tree state mismatch. Expected: " + expected + ", Actual: " + actual);
        }

        log.info("APEX Tree state verified: " + actual);
    }

    private String getApexTreeExpandCollapseState(WebDriver driver) {

        WebElement btn = driver.findElement(By.id("EXPAND_COLLAPSE"));

        // Find icon inside the button (APEX theme uses FontAwesome on span/i)
        WebElement icon = null;
        try {
            icon = btn.findElement(By.cssSelector("span, i"));
        } catch (Exception ignored) {}

        String cls = icon != null ? icon.getAttribute("class") : btn.getAttribute("class");
        cls = cls == null ? "" : cls.toLowerCase();

        // Common APEX/FA patterns
        boolean looksCollapsed = cls.contains("fa-plus") || cls.contains("plus");
        boolean looksExpanded  = cls.contains("fa-minus") || cls.contains("minus");

        if (looksExpanded && !looksCollapsed) return "expanded";
        if (looksCollapsed && !looksExpanded) return "collapsed";

        // Fallback (if theme doesn’t switch icons): use visible child groups
        return detectByVisibleGroups(driver);
    }

    private String detectByVisibleGroups(WebDriver driver) {

        WebElement tree = driver.findElements(By.cssSelector(".a-TreeView"))
                .stream().filter(WebElement::isDisplayed).findFirst().orElse(null);

        if (tree == null) return "unknown";

        // In collapsed state, child groups are typically not visible
        List<WebElement> groups = tree.findElements(By.cssSelector("ul[role='group']"));

        boolean anyVisibleGroup = false;
        for (WebElement g : groups) {
            try {
                if (g.isDisplayed() && g.getSize().getHeight() > 0) {
                    anyVisibleGroup = true;
                    break;
                }
            } catch (StaleElementReferenceException ignored) {}
        }

        return anyVisibleGroup ? "expanded" : "collapsed";
    }

    private WebElement resolveApexTreeRoot(String treeIdOrAnyId, WebDriverWait wait) {
        WebDriver driver = webDriverProvider.get();

        // If id provided and exists
        if (treeIdOrAnyId != null && !treeIdOrAnyId.trim().isEmpty()) {
            List<WebElement> byId = driver.findElements(By.id(treeIdOrAnyId));
            if (!byId.isEmpty() && byId.get(0).isDisplayed()) {
                return byId.get(0);
            }
        }

        // Fallback: first visible APEX tree
        return wait.until(d ->
                d.findElements(By.cssSelector(".a-TreeView"))
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElse(null)
        );
    }

    public void ensureNavBarOpen(String toggleElementNameOrId) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Resolve using your existing smart resolver (works with element repository OR raw locators)
        WebElement toggle = resolveElementSmart(toggleElementNameOrId, wait);
        wait.until(ExpectedConditions.visibilityOf(toggle));

        String expanded = toggle.getAttribute("aria-expanded");

        // If already open -> do nothing
        if ("true".equalsIgnoreCase(expanded)) {
            log.info("Navbar already open. aria-expanded=true | toggle=" + toggleElementNameOrId);
            return;
        }

        // If closed -> click then wait until open
        try {
            clickSafe(toggle);
        } catch (Exception e) {
            // fallback JS click (clickSafe already does JS fallback, but keep safe)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
        }

        wait.until(d -> {
            try {
                WebElement t = resolveElementSmart(toggleElementNameOrId, new WebDriverWait(d, Duration.ofSeconds(2)));
                String now = t.getAttribute("aria-expanded");
                return "true".equalsIgnoreCase(now);
            } catch (Exception ex) {
                return false;
            }
        });

        log.info("Navbar opened successfully. aria-expanded=true | toggle=" + toggleElementNameOrId);
    }

    public void assertIgHasEmptyInsertedRow(String regionIdOrAnyId) throws Exception {

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc   = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);

        WebElement grid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));
        waitForApexAjaxToFinish(driver);

        WebElement row = wait.until(d -> {
            WebElement g = d.findElement(By.id(gridVc));

            List<WebElement> insertedRows = g.findElements(By.cssSelector("tr.a-GV-row.is-inserted"));
            if (insertedRows.isEmpty()) {
                insertedRows = g.findElements(By.cssSelector("tr[role='row'].is-inserted"));
            }

            if (insertedRows.isEmpty()) return null;

            WebElement r = insertedRows.get(insertedRows.size() - 1);
            return r.isDisplayed() ? r : null;
        });

        scrollTo(row);

        List<WebElement> cells = row.findElements(By.cssSelector("td[role='gridcell']"));

        int emptyCount = 0;
        int total = 0;

        for (WebElement cell : cells) {
            total++;
            String txt = safeText(cell);
            if (txt == null || txt.trim().isEmpty()) {
                emptyCount++;
            }
        }

        if (emptyCount < 2) {
            throw new Exception(
                    "Inserted row exists but does NOT look empty. " +
                            "emptyCells=" + emptyCount + "/" + total +
                            " | IG=" + regionId +
                            " | RowText=[" + safeText(row) + "]"
            );
        }

        log.info("Inserted empty row verified. IG=" + regionId + " | emptyCells=" + emptyCount + "/" + total);
    }

    public void assertIgHasEmptyInsertedRowForTdIndexes(
            String regionIdOrAnyId,
            int... tdIndexes1Based
    ) throws Exception {

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc   = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement grid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));

        List<WebElement> insertedRows = grid.findElements(By.cssSelector("tr.a-GV-row.is-inserted"));
        if (insertedRows.isEmpty()) {
            throw new Exception("No inserted row found in IG. Expected: tr.a-GV-row.is-inserted | IG=" + regionId);
        }

        WebElement row = insertedRows.get(insertedRows.size() - 1);
        scrollTo(row);

        for (int tdIndex : tdIndexes1Based) {
            if (tdIndex < 1) throw new Exception("td index must be >= 1");

            WebElement td = row.findElement(By.cssSelector("td:nth-child(" + tdIndex + ")"));
            String txt = safeText(td);

            if (txt != null && !txt.trim().isEmpty()) {
                throw new Exception(
                        "Inserted row cell is NOT empty. " +
                                "tdIndex=" + tdIndex +
                                " | actual=[" + txt + "]" +
                                " | IG=" + regionId
                );
            }
        }

        log.info("Inserted row verified empty for td indexes: " + java.util.Arrays.toString(tdIndexes1Based) + " | IG=" + regionId);
    }

    public void deleteAnyInsertedRowInIg(String regionIdOrAnyId) throws Exception {

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc   = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);

        WebElement grid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));
        waitForApexAjaxToFinish(driver);

        List<WebElement> insertedRows = grid.findElements(By.cssSelector("tr.a-GV-row.is-inserted"));
        if (insertedRows.isEmpty()) {
            insertedRows = grid.findElements(By.cssSelector("tr[role='row'].is-inserted"));
        }

        if (insertedRows.isEmpty()) {
            throw new Exception("No inserted row found to delete in IG. IG=" + regionId);
        }

        int beforeCount = insertedRows.size();

        WebElement row = insertedRows.get(insertedRows.size() - 1);
        scrollTo(row);

        WebElement deleteBtn = wait.until(d -> {
            try {
                WebElement freshGrid = d.findElement(By.id(gridVc));

                List<WebElement> freshInsertedRows = freshGrid.findElements(By.cssSelector("tr.a-GV-row.is-inserted"));
                if (freshInsertedRows.isEmpty()) {
                    freshInsertedRows = freshGrid.findElements(By.cssSelector("tr[role='row'].is-inserted"));
                }

                if (freshInsertedRows.isEmpty()) {
                    return null;
                }

                WebElement freshRow = freshInsertedRows.get(freshInsertedRows.size() - 1);
                if (!freshRow.isDisplayed()) {
                    return null;
                }

                WebElement btn = freshRow.findElement(By.cssSelector("button[data-action='row-delete']"));
                return (btn.isDisplayed() && btn.isEnabled()) ? btn : null;

            } catch (Exception e) {
                return null;
            }
        });

        scrollTo(deleteBtn);
        waitForApexAjaxToFinish(driver);
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));

        boolean popupHandled = false;

        try {
            // normal click first
            deleteBtn.click();
        } catch (ElementClickInterceptedException e) {
            // If popup/overlay appeared as part of the delete action, treat it as expected
            popupHandled = handleUnsavedChangesPopupIfPresent(driver);
            if (!popupHandled) {
                throw e;
            }
        }

        waitForApexAjaxToFinish(driver);

        // If click did not throw, popup may still appear a moment later
        if (!popupHandled) {
            popupHandled = handleUnsavedChangesPopupIfPresent(driver);
        }

        // If popup was handled, treat delete as successful and stop here
        if (popupHandled) {
            log.info("Delete triggered unsaved changes popup and popup was accepted. IG=" + regionId);
            return;
        }

        // If no popup appeared, verify inserted row count decreased
        wait.until(d -> {
            try {
                WebElement g = d.findElement(By.id(gridVc));

                List<WebElement> remaining = g.findElements(By.cssSelector("tr.a-GV-row.is-inserted"));
                if (remaining.isEmpty()) {
                    remaining = g.findElements(By.cssSelector("tr[role='row'].is-inserted"));
                }

                return remaining.size() < beforeCount;
            } catch (Exception ex) {
                return false;
            }
        });

        log.info("Deleted inserted row in IG=" + regionId);
    }

    private boolean handleUnsavedChangesPopupIfPresent(WebDriver driver) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement okBtn = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space()='OK' or .//span[normalize-space()='OK']]")
            ));

            okBtn.click();
            waitForApexAjaxToFinish(driver);
            return true;

        } catch (TimeoutException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteInsertedRowFromAnyVisibleIg() throws Exception {

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        List<WebElement> igRoots = driver.findElements(By.cssSelector("div.a-IG[id]"));
        for (WebElement ig : igRoots) {
            if (!ig.isDisplayed()) continue;

            String igId = ig.getAttribute("id");
            if (igId == null || igId.trim().isEmpty()) continue;

            String gridVc = gridVcId(igId);
            List<WebElement> grids = driver.findElements(By.id(gridVc));
            if (grids.isEmpty()) continue;

            WebElement grid = grids.get(0);
            List<WebElement> insertedRows = grid.findElements(By.cssSelector("tr.a-GV-row.is-inserted"));
            if (insertedRows.isEmpty()) insertedRows = grid.findElements(By.cssSelector("tr[role='row'].is-inserted"));

            if (!insertedRows.isEmpty()) {
                WebElement row = insertedRows.get(insertedRows.size() - 1);
                scrollTo(row);

                WebElement deleteBtn = row.findElement(By.cssSelector("button[data-action='row-delete']"));
                clickSafe(deleteBtn);
                waitForApexAjaxToFinish(driver);

                // Verify removed
                wait.until(d -> {
                    WebElement g = d.findElement(By.id(gridVc));
                    return g.findElements(By.cssSelector("tr.a-GV-row.is-inserted")).isEmpty()
                            && g.findElements(By.cssSelector("tr[role='row'].is-inserted")).isEmpty();
                });

                log.info("Deleted inserted row from IG=" + igId);
                return;
            }
        }

        throw new Exception("No inserted row found in any visible IG on the page.");
    }

    public String getTextByLocator(String locatorType, String locatorValue) {
        WebDriver driver = webDriverProvider.get();
        WebElement el;

        if ("css".equalsIgnoreCase(locatorType)) {
            el = driver.findElement(By.cssSelector(locatorValue));
        } else if ("xpath".equalsIgnoreCase(locatorType)) {
            el = driver.findElement(By.xpath(locatorValue));
        } else {
            throw new IllegalArgumentException("Unsupported locatorType: use css or xpath");
        }

        return el.getText() == null ? "" : el.getText().trim();
    }

    public String waitUntilTextChanges(String locatorType, String locatorValue, String oldValue) {
        WebDriver driver = webDriverProvider.get();

        int timeoutSeconds = 30; // fixed default, no step parameter

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        wait.until(d -> {
            try {
                String now = getTextByLocator(locatorType, locatorValue);
                String old = oldValue == null ? "" : oldValue.trim();
                return !now.equals(old);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                return false;
            }
        });

        return getTextByLocator(locatorType, locatorValue);
    }

    public String getTextByElementNameOrLocator(String elementNameOrLocator) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement el = resolveElementSmart(elementNameOrLocator, wait);
        wait.until(ExpectedConditions.visibilityOf(el));

        String txt = el.getText();
        return txt == null ? "" : txt.trim();
    }

    public String waitUntilTextChangesByElementNameOrLocator(String elementNameOrLocator, String oldValue) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        final String oldNorm = normalizeText(oldValue);

        wait.until(d -> {
            try {
                String now = getTextByElementNameOrLocator(elementNameOrLocator);
                String nowNorm = normalizeText(now);

                if (nowNorm.isEmpty()) return false;                 // ignore transient empty
                if (nowNorm.equalsIgnoreCase("loading")) return false; // optional
                return !nowNorm.equals(oldNorm);
            } catch (Exception e) {
                return false;
            }
        });

        return getTextByElementNameOrLocator(elementNameOrLocator);
    }

    private String normalizeText(String s) {
        if (s == null) return "";
        return s
                .replace("\u00A0", " ")
                .replace("\r\n", "\n")
                .trim();
    }

    public String getNormalizedSnapshot(String elementName) throws Exception {
        String txt = getTextByElementNameOrLocator(elementName);
        if (txt == null) return "";
        return txt
                .replace("\u00A0", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }

    public void assertAllFieldsAreEmptyByElementName(String containerElementName) throws Exception {

        if (containerElementName == null || containerElementName.trim().isEmpty()) {
            throw new IllegalArgumentException("containerElementName is empty");
        }

        WebDriver driver = webDriverProvider.get();

        // IMPORTANT: resolve by repository from CannedPage (where your @FindBy usually lives)
        WebElement container = cannedPage.getElementWithWait(cannedPage, containerElementName);

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(container));

        List<WebElement> fields = container.findElements(By.cssSelector("input, textarea, select"));

        List<String> offenders = new ArrayList<>();

        for (WebElement el : fields) {
            if (el == null) continue;

            try {
                if (!el.isDisplayed()) continue;
            } catch (StaleElementReferenceException e) {
                continue;
            }

            String tag  = safeLower(el.getTagName());
            String type = safeLower(safeAttr(el, "type"));
            String id   = safeAttr(el, "id");
            String name = safeAttr(el, "name");

            if ("input".equals(tag) && "hidden".equals(type)) continue;

            if ("input".equals(tag) && (type.equals("button") || type.equals("submit") || type.equals("reset") || type.equals("image")))
                continue;

            String label = buildFieldLabel(tag, type, id, name);

            if ("input".equals(tag) && (type.equals("checkbox") || type.equals("radio"))) {
                boolean selected = false;
                try { selected = el.isSelected(); } catch (Exception ignored) {}
                if (selected) offenders.add(label + " is selected");
                continue;
            }

            if ("select".equals(tag)) {
                String v = normalizeValue(safeAttr(el, "value"));
                if (!v.isEmpty()) offenders.add(label + " has value='" + v + "'");
                continue;
            }

            String v = normalizeValue(safeAttr(el, "value"));
            if (!v.isEmpty()) offenders.add(label + " has value='" + v + "'");
        }

        if (!offenders.isEmpty()) {
            throw new AssertionError(
                    "Some fields are NOT empty inside container '" + containerElementName + "':\n- "
                            + String.join("\n- ", offenders)
            );
        }

        log.info("All fields are empty inside container: " + containerElementName);
    }

    private String buildFieldLabel(String tag, String type, String id, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(tag);
        if (type != null && !type.isEmpty()) sb.append("[type=").append(type).append("]");
        if (id != null && !id.trim().isEmpty()) sb.append("#").append(id.trim());
        else if (name != null && !name.trim().isEmpty()) sb.append("[name=").append(name.trim()).append("]");
        return sb.toString();
    }

    public void assertFieldIsFilled(String elementNameOrLocator) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement el = resolveElementSmart(elementNameOrLocator, wait);
        wait.until(ExpectedConditions.visibilityOf(el));

        String tag = safeLower(el.getTagName());
        String v = "";

        // input-like elements
        if ("input".equals(tag) || "textarea".equals(tag) || "select".equals(tag)) {
            v = normalizeValue(safeAttr(el, "value"));
        } else {
            // display-only (like your screenshot)
            v = normalizeValue(safeText(el));
        }

        if (v.isEmpty()) {
            throw new AssertionError("Field is NOT filled: '" + elementNameOrLocator + "'");
        }

        log.info("Field is filled: '" + elementNameOrLocator + "' value=[" + v + "]");
    }

    private String normalizeValue(String v) {
        if (v == null) return "";
        return v.replace("\u00A0", " ").trim();
    }

    public void assertFieldIsNotFilled(String elementNameOrLocator) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement el = resolveElementSmart(elementNameOrLocator, wait);
        wait.until(ExpectedConditions.visibilityOf(el));

        String tag = safeLower(el.getTagName());
        String v;

        // input-like elements
        if ("input".equals(tag) || "textarea".equals(tag) || "select".equals(tag)) {
            v = normalizeValue(safeAttr(el, "value"));
        } else {
            // display-only elements (labels, td, div, etc.)
            v = normalizeValue(safeText(el));
        }

        if (!v.isEmpty()) {
            throw new AssertionError("Field IS filled but expected NOT filled: '" + elementNameOrLocator + "' value=[" + v + "]");
        }

        log.info("Field is NOT filled: '" + elementNameOrLocator + "'");
    }

    public String resolveApexItemIdFromElementName(String elementName) {
        switch (elementName) {
            case "StatusCheckbox":
                return "P21_STATUS";

            case "DisplayOnMenuCheckbox":
                return "P21_DISPLAYED_ON_MENU";

            default:
                throw new IllegalArgumentException(
                        "Unknown checkbox element name: '" + elementName + "'. Add mapping in resolveApexItemIdFromElementName()."
                );
        }
    }


    public int fillIgRandomComboDateNumberAndSave(String regionIdOrAnyId) throws Exception {
        String regionId = resolveIgRegionId(regionIdOrAnyId);

        ensureIGEditMode(regionId);

        int updated = fillIgRandomComboDateNumber(regionId);

        // robust save (JS action -> toolbar click -> Ctrl+S) + wait until saved
        clickIgSaveSmart(regionId);

        return updated;
    }
    public int fillIgRandomComboDateNumber(String regionIdOrAnyId) throws Exception {
        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc   = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Region + grid must be visible (not only present)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(regionId)));
        WebElement region = driver.findElement(By.id(regionId));
        scrollToSafe(region);
        wait.until(ExpectedConditions.visibilityOf(region));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));
        WebElement grid = driver.findElement(By.id(gridVc));
        scrollToSafe(grid);
        wait.until(ExpectedConditions.visibilityOf(grid));

        By rowsBy = By.cssSelector("#" + cssEscape(gridVc) + " tr.a-GV-row[role='row'], #"
                + cssEscape(gridVc) + " tr[role='row'].a-GV-row");
        wait.until(d -> !d.findElements(rowsBy).isEmpty());

        // Try to give the grid focus (important when IG is inside tabs/DA refresh)
        try {
            WebElement firstRow = getRowByIndex(gridVc, 0);
            List<WebElement> cs = firstRow.findElements(By.cssSelector("td[role='gridcell']"));
            if (!cs.isEmpty()) {
                scrollToSafe(cs.get(0));
                clickSafe(cs.get(0));
                sleepSilently(120);
            }
        } catch (Exception ignored) {}

        int updated = 0;
        boolean anyEditorOpened = false;

        int rowCount = driver.findElements(rowsBy).size();
        for (int r = 0; r < rowCount; r++) {

            WebElement row = getRowByIndex(gridVc, r);
            scrollToSafe(row);

            List<WebElement> cells = row.findElements(By.cssSelector("td[role='gridcell']"));
            for (int c = 0; c < cells.size(); c++) {

                // Re-fetch stale-safe
                WebElement freshRow = getRowByIndex(gridVc, r);
                List<WebElement> freshCells = freshRow.findElements(By.cssSelector("td[role='gridcell']"));
                if (c >= freshCells.size()) continue;

                WebElement cell = freshCells.get(c);
                scrollToSafe(cell);

                String beforeCellText = safeText(cell);
                if (beforeCellText == null) beforeCellText = "";
                beforeCellText = beforeCellText.trim();

                // Open editor
                if (!openIgCellEditorSafeByIndex(gridVc, r, c, 1500)) {
                    continue;
                }

                WebElement editor = findVisibleEditorInGrid(gridVc, 1200);
                if (editor == null) {
                    pressEscapeSafe();
                    continue;
                }
                anyEditorOpened = true;

                String beforeEditorVal = safeAttr(editor, "value");
                if (beforeEditorVal == null) beforeEditorVal = "";
                beforeEditorVal = beforeEditorVal.trim();

                // Fill and capture what we intended to set
                String newValue = tryFillComboReturnValue(driver, cell, editor);
                if (newValue == null) newValue = tryFillDateReturnValue(editor);
                if (newValue == null) newValue = tryFillNumberReturnValue(editor, 1, 99);

                if (newValue == null || newValue.trim().isEmpty()) {
                    pressEscapeSafe();
                    continue;
                }

                commitEditorAndWait(gridVc, editor);

                // Re-read the cell text after commit
                WebElement rowNow = getRowByIndex(gridVc, r);
                List<WebElement> cellsNow = rowNow.findElements(By.cssSelector("td[role='gridcell']"));
                if (c >= cellsNow.size()) continue;

                String afterCellText = safeText(cellsNow.get(c));
                if (afterCellText == null) afterCellText = "";
                afterCellText = afterCellText.trim();

                boolean changed = !afterCellText.equals(beforeCellText)
                        || afterCellText.toLowerCase().contains(newValue.trim().toLowerCase());

                if (changed) {
                    updated++;
                }
            }
        }

        // If IG exists but we never managed to open any editor, it’s usually tab/readonly/overlay
        if (!anyEditorOpened) {
            throw new Exception("IG '" + regionIdOrAnyId + "' is visible but no cell editor could be opened. " +
                    "Likely causes: IG in inactive tab/collapsed region, read-only columns, or APEX overlay/DA refresh.");
        }

        return updated;
    }
    private boolean openIgCellEditor(WebElement cell, long timeoutMs) {
        long end = System.currentTimeMillis() + timeoutMs;
        try {
            scrollTo(cell);
            clickSafe(cell);

            try { cell.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
            try { cell.sendKeys(Keys.F2); } catch (Exception ignored) {}

            while (System.currentTimeMillis() < end) {
                String cls = safeAttr(cell, "class");
                if (cls != null && cls.toLowerCase().contains("is-active")) return true;
                Thread.sleep(80);
            }
        } catch (Exception ignored) { }
        return false; // IMPORTANT
    }
    private WebElement findVisibleEditorInsideIg(WebElement igRoot, long timeoutMs) {
        long end = System.currentTimeMillis() + timeoutMs;

        By editorBy = By.cssSelector(
                "div.a-GV-columnItem input, div.a-GV-columnItem textarea, div.a-GV-columnItem select," +
                        "td.is-active input, td.is-active textarea, td.is-active select," +
                        "td.a-GV-cell.is-active input, td.a-GV-cell.is-active textarea, td.a-GV-cell.is-active select"
        );

        while (System.currentTimeMillis() < end) {
            try {
                List<WebElement> eds = igRoot.findElements(editorBy);
                for (WebElement e : eds) {
                    if (e.isDisplayed()) return e;
                }
            } catch (Exception ignored) {}
            try { Thread.sleep(80); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
        }
        return null;
    }
    private boolean tryFillNumberIfPresent(WebElement editor, int minInclusive, int maxInclusive) {
        try {
            if (!editor.isEnabled()) return false;

            String tag = safeLower(editor.getTagName());
            if (!"input".equals(tag) && !"textarea".equals(tag)) return false;

            // Skip if looks like LOV/Combo
            if (looksLikeComboEditor(editor)) return false;

            int rnd = randomBetween(minInclusive, maxInclusive);
            clearAndType(editor, String.valueOf(rnd));
            return true;

        } catch (Exception ignored) {}
        return false;
    }
    private boolean tryFillDateIfPresent(WebElement editor) {
        return tryFillDateReturnValue(editor) != null;
    }
    private boolean tryFillComboIfPresent(WebDriver driver, WebElement cell, WebElement editor) {
        try {
            if (!editor.isEnabled()) return false;

            String tag = safeLower(editor.getTagName());

            // <select>
            if ("select".equals(tag)) {
                return pickRandomOptionFromSelect(editor);
            }

            // LOV/Combobox input
            if (!looksLikeComboEditor(editor)) return false;

            openComboDropdownGlobal(cell, editor);

            WebElement option = findRandomVisibleLovOptionGlobal(driver, 1800);
            if (option == null) {
                pressEscapeSafe();
                return false;
            }

            clickSafe(option);
            return true;

        } catch (Exception ignored) {}
        return false;
    }
    private boolean looksLikeComboEditor(WebElement editor) {
        String cls  = safeLower(safeAttr(editor, "class"));
        String role = safeLower(safeAttr(editor, "role"));
        String ariaHasPopup = safeLower(safeAttr(editor, "aria-haspopup"));
        String ariaAuto = safeLower(safeAttr(editor, "aria-autocomplete"));

        if (cls != null && (cls.contains("popup") || cls.contains("lov") || cls.contains("combobox") || cls.contains("select")))
            return true;
        if ("combobox".equals(role)) return true;
        if ("listbox".equals(ariaHasPopup) || "true".equals(ariaHasPopup)) return true;
        if (ariaAuto != null && !ariaAuto.isEmpty() && !"none".equals(ariaAuto)) return true;

        return false;
    }
    private boolean pickRandomOptionFromSelect(WebElement selectEl) {
        try {
            List<WebElement> opts = selectEl.findElements(By.cssSelector("option"));
            List<WebElement> valid = new ArrayList<>();

            for (WebElement o : opts) {
                String v = safeAttr(o, "value");
                String t = safeText(o);

                if ((v == null || v.trim().isEmpty()) && (t == null || t.trim().isEmpty())) continue;

                String low = (t == null ? "" : t.trim().toLowerCase());
                if (low.contains("select") || low.contains("choose")) continue;

                valid.add(o);
            }

            if (valid.isEmpty()) return false;

            WebElement pick = valid.get(randomBetween(0, valid.size() - 1));
            clickSafe(selectEl);
            pick.click();
            return true;

        } catch (Exception ignored) {}
        return false;
    }
    private void clearAndType(WebElement editor, String value) {
        try { editor.sendKeys(Keys.chord(Keys.CONTROL, "a")); } catch (Exception ignored) {}
        try { editor.sendKeys(Keys.DELETE); } catch (Exception ignored) {}
        editor.sendKeys(value);
    }
    private void pressEscapeSafe() {
        try { webDriverProvider.get().switchTo().activeElement().sendKeys(Keys.ESCAPE); }
        catch (Exception ignored) {}
    }
    private void clickIgSaveSmart(String regionId) throws Exception {
        WebDriver driver = webDriverProvider.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1) Try IG-level save inside the IG region
        try {
            WebElement region = driver.findElement(By.id(regionId));

            List<By> igSaveCandidates = Arrays.asList(
                    By.cssSelector("button[data-action='save'], a[data-action='save']"),
                    By.cssSelector("button[title='Save'], button[aria-label='Save'], a[title='Save'], a[aria-label='Save']"),
                    By.xpath(".//button[normalize-space()='Save' or normalize-space()='SAVE']")
            );

            for (By by : igSaveCandidates) {
                List<WebElement> els = region.findElements(by);
                for (WebElement el : els) {
                    if (el.isDisplayed() && el.isEnabled()) {
                        scrollToSafe(el);
                        clickSafe(el);
                        waitForApexReady(driver);
                        waitIgNoPendingChanges(gridVcId(regionId));
                        return;
                    }
                }
            }
        } catch (Exception ignored) {
            // fall through
        }

        // 2) Page-level Save
        List<By> pageSaveCandidates = Arrays.asList(
                By.xpath("//button[.//span[normalize-space()='Save'] or normalize-space()='Save']"),
                By.cssSelector("button[aria-label='Save'], button[title='Save']"),
                By.cssSelector("button mat-icon, button i")
        );

        for (By by : pageSaveCandidates) {
            List<WebElement> els = driver.findElements(by);
            for (WebElement el : els) {
                WebElement btn = el;

                if (!"button".equalsIgnoreCase(el.getTagName())) {
                    try { btn = el.findElement(By.xpath("./ancestor::button[1]")); }
                    catch (Exception ex) { continue; }
                }

                if (btn.isDisplayed() && btn.isEnabled()) {
                    scrollToSafe(btn);
                    clickSafe(btn);
                    waitForApexReady(driver);
                    waitIgNoPendingChanges(gridVcId(regionId));
                    return;
                }
            }
        }

        log.info("No IG Save or Page Save button found; continuing without clicking Save. regionId=" + regionId);
    }
    private boolean isInViewport(WebElement el) {
        WebDriver driver = webDriverProvider.get();
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "const r=arguments[0].getBoundingClientRect();" +
                        "return r.top>=0 && r.left>=0 && r.bottom<=(window.innerHeight||document.documentElement.clientHeight)" +
                        " && r.right<=(window.innerWidth||document.documentElement.clientWidth);",
                el
        );
    }
    private void scrollToSafe(WebElement el) {
        WebDriver driver = webDriverProvider.get();
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center', inline:'center'});", el
            );
        } catch (Exception ignored) {}
    }
    private void waitForApexIdle() {
        WebDriver driver = webDriverProvider.get();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(d -> {
            boolean hasSpinner =
                    !d.findElements(By.cssSelector(".u-Processing, .u-Processing-spinner, #apex_wait_overlay")).isEmpty();
            return !hasSpinner;
        });
    }
    private WebElement getRowByIndex(String gridVc, int rowIndex) {
        WebDriver driver = webDriverProvider.get();
        By rowsBy = By.cssSelector("#" + cssEscape(gridVc) + " tr.a-GV-row[role='row'], #" +
                cssEscape(gridVc) + " tr[role='row'].a-GV-row");
        List<WebElement> rows = driver.findElements(rowsBy);
        if (rowIndex < 0 || rowIndex >= rows.size()) {
            throw new RuntimeException("Row index out of range: " + rowIndex + " for grid " + gridVc + " (rows=" + rows.size() + ")");
        }
        return rows.get(rowIndex);
    }
    private String cssEscape(String id) {
        return id.replace("\\", "\\\\").replace(":", "\\:").replace(".", "\\.");
    }
    private void sleepSilently(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    private WebElement findVisibleEditorInGrid(String gridVc, long timeoutMs) {
        WebDriver driver = webDriverProvider.get();
        long end = System.currentTimeMillis() + timeoutMs;

        By editorBy = By.cssSelector(
                // editor inside active cell (best case)
                "#" + cssEscape(gridVc) + " td.a-GV-cell.is-active input, " +
                        "#" + cssEscape(gridVc) + " td.a-GV-cell.is-active textarea, " +
                        "#" + cssEscape(gridVc) + " td.a-GV-cell.is-active select, " +
                        "#" + cssEscape(gridVc) + " td[role='gridcell'].is-active input, " +
                        "#" + cssEscape(gridVc) + " td[role='gridcell'].is-active textarea, " +
                        "#" + cssEscape(gridVc) + " td[role='gridcell'].is-active select, " +
                        // columnItem editor (often outside the cell but inside the same grid region container)
                        "div.a-GV-columnItem input, div.a-GV-columnItem textarea, div.a-GV-columnItem select"
        );

        while (System.currentTimeMillis() < end) {
            try {
                List<WebElement> eds = driver.findElements(editorBy);
                for (WebElement e : eds) {
                    if (!e.isDisplayed()) continue;

                    // Ensure this editor belongs to THIS grid:
                    // walk up to the closest IG/grid container and confirm it contains gridVc
                    boolean sameGrid = (Boolean) ((JavascriptExecutor) driver).executeScript(
                            "const el = arguments[0];" +
                                    "const gridId = arguments[1];" +
                                    "const grid = document.getElementById(gridId);" +
                                    "if (!grid) return false;" +
                                    // in-cell editor
                                    "if (grid.contains(el)) return true;" +
                                    // columnItem editor: must belong to same .a-GV container as this grid
                                    "const gv = grid.closest('.a-GV');" +
                                    "if (!gv) return false;" +
                                    "return gv.contains(el);",
                            e, gridVc
                    );

                    if (sameGrid) return e;
                }
            } catch (Exception ignored) { }

            sleepSilently(80);
        }
        return null;
    }
    private void commitEditorAndWait(String gridVc, WebElement editor) {
        WebDriver driver = webDriverProvider.get();

        boolean isDateEditor = false;
        try {
            String type = safeLower(safeAttr(editor, "type"));
            String cls  = safeLower(safeAttr(editor, "class"));
            String ph   = safeLower(safeAttr(editor, "placeholder"));
            String aria = safeLower(safeAttr(editor, "aria-label"));

            isDateEditor =
                    "date".equals(type)
                            || (cls != null && (cls.contains("date") || cls.contains("datepicker")))
                            || (ph != null && (ph.contains("dd") && ph.contains("mm") && ph.contains("yyyy")))
                            || (aria != null && aria.contains("date"));
        } catch (Exception ignored) {}

        // For normal editors, TAB may be OK
        if (!isDateEditor) {
            try { editor.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
            sleepSilently(120);
        } else {
            // For date editor, avoid TAB because last column creates a new row
            try { editor.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
            sleepSilently(120);
        }

        if (isEditingInsideGrid(gridVc)) {
            try { driver.switchTo().activeElement().sendKeys(Keys.ESCAPE); } catch (Exception ignored) {}
            sleepSilently(80);
        }

        if (isEditingInsideGrid(gridVc)) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "document.activeElement && document.activeElement.blur();");
            } catch (Exception ignored) {}

            try {
                WebElement grid = driver.findElement(By.id(gridVc));
                WebElement gv = grid.findElement(By.xpath("./ancestor::*[contains(@class,'a-GV')][1]"));
                scrollToSafe(gv);
                clickSafe(gv);
            } catch (Exception ignored) {
                try {
                    ((JavascriptExecutor) driver).executeScript("document.body && document.body.click();");
                } catch (Exception ignored2) {}
            }

            sleepSilently(150);
        }

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(d -> !isEditingInsideGrid(gridVc));

        waitForApexIdle();
    }
    private void waitIgNoPendingChanges(String gridVc) {
        WebDriver driver = webDriverProvider.get();
        By changedRows = By.cssSelector("#" + cssEscape(gridVc) + " tr.is-changed, #" +
                cssEscape(gridVc) + " tr.a-GV-row.is-changed");

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(d -> d.findElements(changedRows).isEmpty());
        } catch (Exception ignored) {
            // Do not fail here; some pages keep is-changed until refresh
        }

        waitForApexIdle();
    }
    private boolean openIgCellEditorSafeByIndex(String gridVc, int rowIndex, int cellIndex, long timeoutMs) {
        WebDriver driver = webDriverProvider.get();
        long end = System.currentTimeMillis() + timeoutMs;

        while (System.currentTimeMillis() < end) {
            try {
                WebElement row = getRowByIndex(gridVc, rowIndex);
                List<WebElement> cells = row.findElements(By.cssSelector("td[role='gridcell']"));
                if (cellIndex < 0 || cellIndex >= cells.size()) return false;

                WebElement cell = cells.get(cellIndex);
                scrollToSafe(cell);
                clickSafe(cell);

                // attempt enter edit mode
                try { driver.switchTo().activeElement().sendKeys(Keys.F2); } catch (Exception ignored) {}
                try { driver.switchTo().activeElement().sendKeys(Keys.ENTER); } catch (Exception ignored) {}
                try { driver.switchTo().activeElement().sendKeys(Keys.F2); } catch (Exception ignored) {}

                // confirm editor exists in this grid
                WebElement ed = findVisibleEditorInGrid(gridVc, 350);
                if (ed != null && ed.isEnabled()) return true;

            } catch (StaleElementReferenceException sere) {
                // retry
            } catch (Exception ignored) {
                // retry
            }

            sleepSilently(80);
        }

        return false;
    }
    private void openComboDropdownGlobal(WebElement cell, WebElement editor) {
        try {
            // try LOV/search button inside cell
            List<WebElement> btns = cell.findElements(By.cssSelector("button, a"));
            for (WebElement b : btns) {
                String t = safeLower(b.getAttribute("title"));
                String a = safeLower(b.getAttribute("aria-label"));
                String c = safeLower(b.getAttribute("class"));

                if ((t != null && (t.contains("search") || t.contains("select") || t.contains("lov"))) ||
                        (a != null && (a.contains("search") || a.contains("select") || a.contains("lov"))) ||
                        (c != null && (c.contains("popup") || c.contains("lov")))) {
                    clickSafe(b);
                    return;
                }
            }

            // fallback keyboard
            try { editor.sendKeys(Keys.chord(Keys.ALT, Keys.ARROW_DOWN)); } catch (Exception ignored) {}
            try { editor.sendKeys(Keys.ARROW_DOWN); } catch (Exception ignored) {}

        } catch (Exception ignored) {}
    }
    private WebElement findRandomVisibleLovOptionGlobal(WebDriver driver, long timeoutMs) {
        long end = System.currentTimeMillis() + timeoutMs;

        By optionsBy = By.cssSelector(
                "[role='listbox'] [role='option'], " +
                        ".a-PopupLOV-results li, " +
                        ".a-IconList-item, " +
                        ".ui-menu-item, " +
                        ".a-ListView-item"
        );

        while (System.currentTimeMillis() < end) {
            try {
                List<WebElement> opts = driver.findElements(optionsBy);

                List<WebElement> visible = new ArrayList<>();
                for (WebElement o : opts) {
                    if (!o.isDisplayed()) continue;

                    String txt = safeText(o);
                    if (txt == null) txt = "";
                    String t = txt.trim().toLowerCase();

                    if (t.isEmpty()) continue;
                    if (t.contains("no data")) continue;
                    if (t.contains("لا يوجد")) continue;
                    if (t.contains("select")) continue;
                    if (t.contains("choose")) continue;

                    visible.add(o);
                }

                if (!visible.isEmpty()) {
                    return visible.get(randomBetween(0, visible.size() - 1));
                }
            } catch (Exception ignored) {}

            sleepSilently(100);
        }

        return null;
    }
    private boolean isEditingInsideGrid(String gridVc) {
        WebDriver driver = webDriverProvider.get();
        try {
            return (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "const grid = document.getElementById(arguments[0]);" +
                            "if (!grid) return false;" +
                            "const gv = grid.closest('.a-GV');" +
                            "if (!gv) return false;" +

                            // 1) If APEX columnItem editor is visible for THIS grid, we're editing
                            "const colItem = gv.querySelector('.a-GV-columnItem');" +
                            "if (colItem) {" +
                            "  const cs = window.getComputedStyle(colItem);" +
                            "  const r = colItem.getBoundingClientRect();" +
                            "  const vis = cs && cs.display !== 'none' && cs.visibility !== 'hidden' && (r.width || r.height);" +
                            "  if (vis) return true;" +
                            "}" +

                            // 2) If there is a visible input/select/textarea inside an active cell for THIS grid
                            "const activeCell = gv.querySelector('td.a-GV-cell.is-active, td[role=\"gridcell\"].is-active');" +
                            "if (activeCell) {" +
                            "  const ed = activeCell.querySelector('input,textarea,select');" +
                            "  if (ed) {" +
                            "    const cs2 = window.getComputedStyle(ed);" +
                            "    const r2 = ed.getBoundingClientRect();" +
                            "    const vis2 = cs2 && cs2.display !== 'none' && cs2.visibility !== 'hidden' && (r2.width || r2.height);" +
                            "    if (vis2) return true;" +
                            "  }" +
                            "}" +

                            // 3) Fallback: activeElement is an editor belonging to same .a-GV
                            "const ae = document.activeElement;" +
                            "if (!ae) return false;" +
                            "const tag = (ae.tagName || '').toUpperCase();" +
                            "if (tag !== 'INPUT' && tag !== 'TEXTAREA' && tag !== 'SELECT') return false;" +
                            "return gv.contains(ae);" ,
                    gridVc
            );
        } catch (Exception e) {
            return false;
        }
    }
    private String tryFillNumberReturnValue(WebElement editor, int minInclusive, int maxInclusive) {
        try {
            if (!editor.isEnabled()) return null;

            String tag = safeLower(editor.getTagName());
            if (!"input".equals(tag) && !"textarea".equals(tag)) return null;
            if (looksLikeComboEditor(editor)) return null;

            int rnd = randomBetween(minInclusive, maxInclusive);
            String v = String.valueOf(rnd);
            clearAndType(editor, v);
            return v;
        } catch (Exception ignored) {}
        return null;
    }
    private String tryFillDateReturnValue(WebElement editor) {
        try {
            WebDriver driver = webDriverProvider.get();

            if (!editor.isEnabled()) return null;

            String tag = safeLower(editor.getTagName());
            if (!"input".equals(tag) && !"textarea".equals(tag)) return null;

            String type = safeLower(safeAttr(editor, "type"));
            String cls  = safeLower(safeAttr(editor, "class"));
            String ph   = safeLower(safeAttr(editor, "placeholder"));
            String aria = safeLower(safeAttr(editor, "aria-label"));

            boolean looksDate =
                    "date".equals(type)
                            || (cls != null && (cls.contains("date") || cls.contains("datepicker")))
                            || (ph != null && (ph.contains("dd") && ph.contains("mm") && ph.contains("yyyy")))
                            || (aria != null && aria.contains("date"));

            boolean isComboLike = looksLikeComboEditor(editor);

            if (!looksDate && isComboLike) return null;
            if (!looksDate) return null;

            LocalDate today = LocalDate.now();
            String expectedValue = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            clickSafe(editor);
            sleepSilently(200);

            // Click Today button
            if (clickVisibleTodayButton()) {
                // IMPORTANT: do not TAB here
                try { editor.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
                sleepSilently(120);

                try {
                    ((JavascriptExecutor) driver).executeScript(
                            "document.activeElement && document.activeElement.blur();");
                } catch (Exception ignored) {}

                sleepSilently(120);
                waitForApexIdle();
                return expectedValue;
            }

            // fallback typing today's date
            clearAndType(editor, expectedValue);

            // IMPORTANT: do not TAB here either
            try { editor.sendKeys(Keys.ENTER); } catch (Exception ignored) {}
            sleepSilently(120);

            try {
                ((JavascriptExecutor) driver).executeScript(
                        "document.activeElement && document.activeElement.blur();");
            } catch (Exception ignored) {}

            sleepSilently(120);
            waitForApexIdle();

            String after = safeAttr(editor, "value");
            if (after != null && !after.trim().isEmpty()) {
                return expectedValue;
            }

        } catch (Exception ignored) {}

        return null;
    }
    private String tryFillComboReturnValue(WebDriver driver, WebElement cell, WebElement editor) {
        try {
            if (!editor.isEnabled()) return null;

            String tag = safeLower(editor.getTagName());

            if ("select".equals(tag)) {
                List<WebElement> opts = editor.findElements(By.cssSelector("option"));
                List<WebElement> valid = new ArrayList<>();
                for (WebElement o : opts) {
                    String t = safeText(o);
                    if (t == null) t = "";
                    String low = t.trim().toLowerCase();
                    if (low.isEmpty()) continue;
                    if (low.contains("select") || low.contains("choose")) continue;
                    valid.add(o);
                }
                if (valid.isEmpty()) return null;

                WebElement pick = valid.get(randomBetween(0, valid.size() - 1));
                String chosenText = safeText(pick);
                if (chosenText == null) chosenText = "";
                clickSafe(editor);
                pick.click();
                return chosenText.trim();
            }

            if (!looksLikeComboEditor(editor)) return null;

            openComboDropdownGlobal(cell, editor);

            WebElement option = findRandomVisibleLovOptionGlobal(driver, 1800);
            if (option == null) {
                pressEscapeSafe();
                return null;
            }

            String chosenText = safeText(option);
            if (chosenText == null) chosenText = "";
            clickSafe(option);
            return chosenText.trim();

        } catch (Exception ignored) {}
        return null;
    }
    private boolean clickVisibleTodayButton() {
        try {
            WebDriver driver = webDriverProvider.get();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            By todayBtnBy = By.xpath("//button[@type='button'][normalize-space()='Today']");

            WebElement todayBtn = wait.until(d -> {
                List<WebElement> buttons = d.findElements(todayBtnBy);
                for (WebElement b : buttons) {
                    try {
                        if (b.isDisplayed() && b.isEnabled()) return b;
                    } catch (Exception ignored) {}
                }
                return null;
            });

            if (todayBtn != null) {
                scrollToSafe(todayBtn);
                clickSafe(todayBtn);
                sleepSilently(250);
                waitForApexIdle();
                return true;
            }
        } catch (Exception ignored) {}

        return false;
    }

    public void assertIgCellFilledAndReadOnly(String regionIdOrAnyId, String rowText, String columnHeader, boolean rejectZero) throws Exception {

        WebDriver driver = webDriverProvider.get();
        waitForApexReady(driver);

        String regionId = resolveIgRegionId(regionIdOrAnyId);
        String gridVc   = gridVcId(regionId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(gridVc)));

        // Select row first (your existing method)
        selectIgRowByRowText(regionId, rowText);

        // Resolve column index (leaf header)
        int colLeafIndex = resolveLeafHeaderIndex(regionId, columnHeader);
        if (colLeafIndex < 0) {
            throw new Exception("Header not found: '" + columnHeader + "'\nFound headers:\n" + dumpHeaders(regionId));
        }

        // Find row + cell
        WebElement row = findIGRowByText(regionId, rowText);

        List<WebElement> cells = row.findElements(By.cssSelector("td[role='gridcell']"));
        if (colLeafIndex >= cells.size()) {
            throw new Exception("Column index out of range. idx=" + colLeafIndex + ", cells=" + cells.size());
        }

        WebElement cell = cells.get(colLeafIndex);
        scrollTo(cell);

        // --------------------------
        // 1) Assert FILLED
        // --------------------------
        String val = normalizeNumberString(safeText(cell));
        if (val == null) val = "";
        val = val.trim();

        if (val.isEmpty()) {
            throw new Exception("IG cell is empty. region=" + regionId + ", row='" + rowText + "', col='" + columnHeader + "'");
        }

        if (rejectZero) {
            String norm = val.replace(",", "").trim();
            if (norm.equals("0") || norm.equals("0.0") || norm.equals("0.00")) {
                throw new Exception("IG cell is zero. region=" + regionId + ", row='" + rowText + "', col='" + columnHeader + "', value='" + val + "'");
            }
        }

        // --------------------------
        // 2) Assert READ-ONLY
        // --------------------------
        // Fast pass: DOM readonly markers
        String ariaReadonly = safeAttr(cell, "aria-readonly");
        String cls = safeAttr(cell, "class");

        if ("true".equalsIgnoreCase(ariaReadonly)) return;
        if (cls != null && cls.toLowerCase().contains("is-readonly")) return;

        // Try to open editor WITHOUT forcing IG edit mode (because this cell must be read-only)
        WebElement igRoot = driver.findElement(By.id(regionId));

        clickSafe(cell);
        try { cell.sendKeys(Keys.F2); } catch (Exception ignored) {}
        try { cell.sendKeys(Keys.ENTER); } catch (Exception ignored) {}

        WebElement editor = findVisibleEditorInsideIg(igRoot, 800);

        // If an enabled editor appears -> cell is editable => FAIL
        if (editor != null && editor.isDisplayed() && editor.isEnabled()) {
            pressEscapeSafe();
            throw new Exception("IG cell is editable but expected read-only. region=" + regionId
                    + ", row='" + rowText + "', col='" + columnHeader + "', value='" + val + "'");
        }

        // If no editor appears, it is effectively read-only => PASS
        pressEscapeSafe();
    }

    private String extractFolderName(String storyPath) {
        if (storyPath == null || storyPath.trim().isEmpty()) {
            return "UnknownFolder";
        }

        String normalizedPath = storyPath.replace("\\", "/");
        String[] parts = normalizedPath.split("/");

        if (parts.length >= 2) {
            return parts[parts.length - 2];
        }

        return "UnknownFolder";
    }

    private String removeStoryExtension(String storyName) {
        if (storyName == null || storyName.trim().isEmpty()) {
            return "UnknownStory";
        }

        if (storyName.toLowerCase().endsWith(".story")) {
            return storyName.substring(0, storyName.length() - 6);
        }

        return storyName;
    }
}