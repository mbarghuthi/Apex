package com.automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.configuration.pageobjects.PageObject;

@PageObject
public class CannedPage extends AbstractPage<CannedPage> {


//	*********************************************************************************************************************************************************************
//********************************************************************** (For all clients)**************************************************************************
//	*********************************************************************************************************************************************************************

//************************************************************ Login Page elements ********************************************************************

	@FindBy(css = "#P9999_USERNAME")
	public WebElement userName;
	@FindBy(css = "#P9999_PASSWORD")
	public WebElement password;
	@FindBy(css = "#OK")
	public WebElement loginButton;

	@FindBy(css = "#userNavItem")
	public WebElement UserDDL;

	@FindBy(css = "#menu_L120831929885889141_1i")
	public WebElement LogoutButton;

	@FindBy(xpath = "//span[normalize-space()='Create']")
	public WebElement CreateButton;

	@FindBy(css = "h2[role='alert']")
	public WebElement SuccessfullyAlert;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement NextButton;

	@FindBy(css = "#PageUpdate")
	public WebElement ApplyChangesButton;

	@FindBy(css = "input[aria-label='Search']")
	public WebElement PopupLOVSearchBar;

	@FindBy(xpath = "//div[@class='t-Alert-body']")
	public WebElement loginAlert;

	@FindBy(xpath = "//span[normalize-space()='Delete']")
	public WebElement DeleteButton;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	public WebElement DeleteButtonPopup;

// ************************************************************ Elements **********************************************************************************************

	@FindBy(css = "#t_Button_navControl")
	public WebElement navControlButton;

	@FindBy(xpath = "//span[normalize-space()='Quotations']")
	public WebElement QuotationsSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Quotation - Menu']")
	public WebElement QuotationMenuSideMenu;

	@FindBy(xpath = "//h3[normalize-space()='Quotations']")
	public WebElement QuotationCardDashboard;

	@FindBy(xpath = "//a[normalize-space()='Quotations']")
	public WebElement QuotationNavigationSideMenu;

	@FindBy(xpath = "//h2[normalize-space()='Quotations']")
	public WebElement QuotationsTitle;

	@FindBy(xpath = "//h3[normalize-space()='4-Jeddah Claim Center']")
	public WebElement JeddahClaimCenterCard;

	@FindBy(css = "#OFF_QUT_IG_ig_toolbar_btn-add_off_qut")
	public WebElement NewQuotationButton;

	@FindBy(xpath = "//h3[normalize-space()='Motor']")
	public WebElement MotorCard;
	@FindBy(xpath = "//h3[normalize-space()='Motor Private']")
	public WebElement MotorPrivateCard;
	@FindBy(xpath = "//h3[normalize-space()='Motor Commercial']")
	public WebElement MotorCommercialCard;
	@FindBy(xpath = "//h3[normalize-space()='Comprehensive']")
	public WebElement ComprehensiveCard;
	@FindBy(xpath = "//h3[normalize-space()='Third Party']")
	public WebElement ThirdPartyCard;

	@FindBy(xpath = "//h3[normalize-space()='Marine']")
	public WebElement MarineCard;
	@FindBy(xpath = "//h3[normalize-space()='Marine Cargo']")
	public WebElement MarineCargoCard;
	@FindBy(xpath = "//h3[normalize-space()='Cargo Policy']")
	public WebElement CargoPolicyCard;
	@FindBy(xpath = "//h3[normalize-space()='Open Cover']")
	public WebElement OpenCoverCard;
	@FindBy(xpath = "//h3[normalize-space()='Certificate']")
	public WebElement CertificateCard;
	@FindBy(xpath = "//h3[normalize-space()='Marine Hull']")
	public WebElement MarineHullCard;
	@FindBy(xpath = "//h3[normalize-space()='Hull and Machinery']")
	public WebElement HullAndMachineryCard;
	@FindBy(xpath = "//h3[normalize-space()='Liability']")
	public WebElement LiabilityCard;

	@FindBy(xpath = "//h3[normalize-space()='FGA']")
	public WebElement FGACard;
	@FindBy(xpath = "//h3[normalize-space()='Fire']")
	public WebElement FireCard;
	@FindBy(xpath = "//h3[normalize-space()='Engineering']")
	public WebElement EngineeringCard;
//	@FindBy(xpath = "//h3[normalize-space()='Open Cover']")
//	public WebElement OpenCoverCard;




// ************************************************************ Quotation Details Elements **********************************************************************************************

	@FindBy(css = "#P101_QUT_CLASS_OF_BUSINESS_DISPLAY")
	public WebElement QutClassOfBusinessDisplay;

	@FindBy(css = "#P101_QUT_POLICY_TYPE_DISPLAY")
	public WebElement QutPolicyTypeDisplay;

	@FindBy(css = "#P101_QUT_SOURCE")
	public WebElement QutSourceCombobox;

	@FindBy(css = "#P101_QUT_PAYMENT_TERM")
	public WebElement QutPaymentTermCombobox;

	@FindBy(css = "#P101_QUT_QUOT_DT")
	public WebElement QutQuotDate;

	@FindBy(css = "#P101_QUT_QUOT_VALIDITY_DT")
	public WebElement QutQuotValidityDate;

	@FindBy(css = "#P101_QUT_INS_ST_DT_input")
	public WebElement QutInsStDateInput;

	@FindBy(css = "#P101_QUT_INS_ED_DT_input")
	public WebElement QutInsEdDateInput;

	@FindBy(css = "#P101_QUT_AWARDED_TO")
	public WebElement QutAwardedToInput;

	@FindBy(css = "#P101_QUT_CALCULATION_BASIS")
	public WebElement QutCalculationBasisCombobox;

	@FindBy(css = "#P101_QUT_CR_CD")
	public WebElement QutCrCdCombobox;

	@FindBy(css = "#P101_QUT_BUSINESS_TYPE")
	public WebElement QutBusinessTypeCombobox;

	@FindBy(css = "#P101_QUT_UNIT_PRICE")
	public WebElement QutUnitPriceVal;

	@FindBy(css = "#P101_QUT_QUOT_NO_DISPLAY")
	public WebElement QutQuotNoCreateText;


	// ************************************************************ Risk Details Elements **********************************************************************************************
	@FindBy(css = "#P43_QUR_VEHICLE_MAKE")
	public WebElement QurVehicleMakeCombobox;

	@FindBy(css = "#P43_QUR_VEHICLE_MODEL")
	public WebElement QurVehicleModelCombobox;

	@FindBy(css = "#P43_QUR_YEAR_OF_MAKE")
	public WebElement QurYearOfMakeCombobox;

	@FindBy(css = "#P43_QUR_CHASSIS_NO")
	public WebElement QurChassisNoCombobox;

	@FindBy(css = "#P43_QUR_REGISTRATION_NO")
	public WebElement QurRegistrationNoCombobox;

	@FindBy(css = "#P43_QUR_PLATE_COLOR")
	public WebElement QurPlateColorCombobox;

	@FindBy(css = "#P43_QUR_TYPE_OF_BODY")
	public WebElement QurTypeOfBodyCombobox;

	@FindBy(css = "#P43_QUR_VEHICLE_COLOR")
	public WebElement QurVehicleColorCombobox;

	@FindBy(xpath = "//span[normalize-space()='Add New Risk']")
	public WebElement AddNewRiskButton;
	@FindBy(css = "iframe[title='Add New Risk']")
	public WebElement AddNewRiskIframe;
	@FindBy(css = "#P92_QUR_RISK_TYPE")
	public WebElement RiskTypeLiabilityCombobox;
	@FindBy(css = "#P92_QUR_RATING_BASIS")
	public WebElement BreakdownCombobox;
	@FindBy(xpath = "//span[normalize-space()='Apply Changes']")
	public WebElement ApplyChangesButtonIframe;


// ************************************************************ Risk Value Types Elements **********************************************************************************************

	@FindBy(css = ".a-GV-cell.u-tC.a-GV-frozen.a-GV-frozen--start5.is-changed")
	public WebElement RiskCalculationIg;

	@FindBy(css = "#RiskCalculation_ig_toolbar_m3")
	public WebElement EditButton;

	@FindBy(css = "td[class='a-GV-cell u-tC a-GV-frozen a-GV-frozen--start5']")
	public WebElement SIAmountCell;

	@FindBy(css = "button[title='Ctrl+Alt+S']")
	public WebElement SaveButton;

	@FindBy(css = "button[title='Ctrl+Alt+S']")
	public WebElement ApplyButton;

	// ************************************************************ Quotation Value Types **********************************************************************************************
	@FindBy(css = "div[class='a-GV-w-scroll']")
	public WebElement CalculationsTable;

	@FindBy(css = "#calc_ig_toolbar_m1")
	public WebElement EditButtonQuotationValue;

	@FindBy(css = "#calc_ig")
	public WebElement CalculationsIGRegion;

	// ************************************************************ Quotation Client **********************************************************************************************
	@FindBy(css = "#P96_QUT_CLIENT")
	public WebElement QurQutClientCombobox;

	@FindBy(css = "#P96_QUT_CUST_NO")
	public WebElement QurQutClientNoCombobox;

	@FindBy(css = "#P107_QUT_COVER_GROUP")
	public WebElement QutCoverGroupCombobox;

	@FindBy(css = "#P107_QUT_COLLECTION_TYPE")
	public WebElement QutCollectionTypeCombobox;


	@FindBy(css = "#P107_QUT_QUOT_NO_DISPLAY")
	public WebElement QutQuotNoFinalPageText;

	// ************************************************************ Items Details Elements **********************************************************************************************
	@FindBy(xpath = "//span[normalize-space()='Add New Item']")
	public WebElement AddNewItemButton;

	@FindBy(css = "iframe[title='Fire Risk Items UpdatingApp']")
	public WebElement FireRiskItemsUpdatingAppIframe;
	@FindBy(css = "#P90_RIQ_ITEM_CODE")
	public WebElement RiqItemCodeCombobox;
	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement RiqSaveButtonIframe;

	// ************************************************************ Item Value Types Elements **********************************************************************************************
	@FindBy(css = "#item_c_ig_toolbar_m5")
	public WebElement ItemValueTypesEditButton;



	// ************************************************************************************************************************************************************************************
	// ************************************************************************************************************************************************************************************
	/**
	 *
	 * Method to open link
	 *
	 * @param url : String : URL for navigation
	 * @throws Exception
	 */

	public void navigateTo(String url) {

		webDriverProvider.get().manage().window().maximize();
//		Dimension dimension = new Dimension(1400, 2000);
//		webDriverProvider.get().manage().window().setSize(dimension);

		webDriverProvider.get().manage().deleteAllCookies();
		webDriverProvider.get().get(url);
		log.info("Navigating to the page: " + url);
	}

	/**
	 * Method to enter text into text field
	 *
	 * @param elementName : String : element Name
	 * @param text        : String : Text value to enter in field
	 * @throws Exception
	 */
	public CannedPage enterText(String elementName, String text) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		element.clear();
		element.sendKeys(text);
		log.info("Filled '" + elementName + "' with value: " + text);
		return this;

	}

	/**
	 * Method to click on an element
	 *
	 * @param elementName : String : element Name
	 * @throws Exception
	 */
	public CannedPage click(String elementName) throws Exception {
		// wait element
		WebElement element = getElementWithWait(this, elementName);
		element.click();
//		Actions actions = new Actions(webDriverProvider.get());
//		actions.moveToElement(element).click().perform();
		log.info("Clicked on '" + elementName + "'");
		return this;
	}

	public CannedPage doubleClick(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		Actions actions = new Actions(webDriverProvider.get());
		actions.moveToElement(element).doubleClick().perform();
		log.info("Double-clicked on '" + elementName + "'");
		return this;
	}

	/**
	 * method to check element presence
	 *
	 * @param elementName : String : element Name
	 * @param testCase    : Boolean : test case [true or false]
	 * @throws Exception
	 */
	public void checkElementPresence(String elementName, boolean testCase) throws Exception {
		if (testCase) {
			if (!isElementDisplayed(elementName))
				throw new Exception("Element Not Present");
		} else {
			try {
				if (isElementDisplayed(elementName))
					throw new Exception("Present"); // since it is negative test and we found element
			} catch (Exception e) {
				if (e.getMessage().equals("Present")) // only raise if it present
					throw new Exception("Element Present");
			}
		}
	}

	/**
	 * method to get element status - displayed?
	 *
	 * @param elementName : String : element Name
	 * @return Boolean
	 * @throws Exception
	 */
	public boolean isElementDisplayed(String elementName) throws Exception {

		return getElementWithWait(this, elementName).isDisplayed();
	}

	/**
	 * Method to check element text
	 *
	 * @param elementName : String : element Name
	 * @param expected    : String : Expected element text
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void checkElementText(String elementName, String expected, boolean testCase) throws Exception {
		String elementText = getElementWithWaitText(elementName);

		if (testCase) {
			if (!elementText.equalsIgnoreCase(expected))
				Assert.assertEquals(expected, elementText);
		} else {
			if (elementText.equalsIgnoreCase(expected))
				throw new Exception("Text Matched");
		}
	}

	/**
	 * Method to check element partial text
	 *
	 * @param elementName : String : element Name
	 * @param expected    : String : Expected element text
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void checkElementpartialText(String elementName, String expected, boolean testCase) throws Exception {
		String elementText = getElementWithWaitText(elementName);

		if (testCase) {
			if (!elementText.toLowerCase().contains(expected.toLowerCase())) {
				Assert.assertEquals(expected, elementText);
			}
			System.out.println("==========================================================");
			System.out.println("Actual: " + elementText);
			System.out.println("==========================================================");
		} else {
			if (elementText.toLowerCase().contains(expected.toLowerCase()))
				Assert.assertNotEquals(expected, elementText);
		}
	}

	/**
	 * Method to get element text
	 *
	 * @param elementName : String : element Name
	 * @return String
	 * @throws Exception
	 */
	public String getElementWithWaitText(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);

		String tagName = element.getTagName();
		String value;

		if ("input".equalsIgnoreCase(tagName) || "textarea".equalsIgnoreCase(tagName)) {
			// for inputs and textareas use "value"
			value = element.getAttribute("value");
		} else {
			// for labels/divs/spans use inner text
			value = element.getText();
		}

		return value != null ? value.trim() : "";
	}


	/**
	 * Method to wait element disappear
	 *
	 * @param elementName : String : element Name
	 * @throws Exception
	 */

	public void wait_Element_Disappear(String elementName) throws Exception {
		List<WebElement> elements = new ArrayList<WebElement>();
		elements.add(getElement(this, elementName));
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));

	}

	public void navigate(String direction) {
		if (direction.equals("back")) {
			webDriverProvider.get().navigate().back();
			log.info("I navigate back");
		} else {
			webDriverProvider.get().navigate().forward();
			log.info("I navigate forward");
		}
	}

	public void refresh_page() {
		webDriverProvider.get().navigate().refresh();
		log.info("I refresh page");
	}

	/**
	 * Method to resize browser
	 *
	 * @param width  : int : Width for browser resize
	 * @param height : int : Height for browser resize
	 */
	public void resizeBrowser(int width, int height) {
		webDriverProvider.get().manage().window().setSize(new Dimension(width, height));
		log.info("I resize browser window size to width '" + width + "' and height '" + height + "'");
	}

	/** Method to maximize browser */
	public void maximizeBrowser() {
		webDriverProvider.get().manage().window().maximize();
		log.info("I maximize browser window");
	}

	/**
	 * Method to scroll page to top or end
	 *
	 * @throws Exception
	 */
	public void scrollPage(String to) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) webDriverProvider.get();
		if (to.equals("end")) {
			executor.executeScript(
					"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
			log.info("I scroll to end of page");
		} else if (to.equals("top")) {
			executor.executeScript(
					"window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
			log.info("I scroll to top of page");
		} else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}

	/**
	 * Method to scroll page to particular element
	 *
	 * @param elementName : String : to get element
	 * @throws Exception
	 */
	public void scrollToElement(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		JavascriptExecutor executor = (JavascriptExecutor) webDriverProvider.get();
		executor.executeScript("arguments[0].scrollIntoView();", element);
		log.info("I scroll to '" + elementName + "'");
	}

	public void scrollToElementInCurrentFrame(String elementName) throws Exception {
		WebDriver driver = webDriverProvider.get();
		WebElement element = getElementWithWait(this, elementName);

		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	/**
	 * Method to hover on element
	 *
	 * @param elementName : String : to get element
	 * @throws Exception
	 */
	public void hoverOverElement(String elementName) throws Exception {
		Actions action = new Actions(webDriverProvider.get());
		WebElement element = getElementWithWait(this, elementName);
		action.moveToElement(element).perform();
	}

	/**
	 * Method to verify page title
	 *
	 * @param title    : String : expected title
	 * @param testCase : Boolean : test case [true or false]
	 * @throws Exception
	 */
	public void checkTitle(String title, boolean testCase) throws Exception {
		String pageTitle = webDriverProvider.get().getTitle();

		if (testCase) {
			Assert.assertEquals(title, pageTitle);
		} else {
			Assert.assertNotEquals(title, pageTitle);
		}
	}

	public void checkElementAttribute(String elementName, String attributeName, String attributeValue, boolean testCase)
			throws Exception {
		String attrVal = getElementAttribute(elementName, attributeName);
		if (testCase) {
			if (!attrVal.equals(attributeValue))
				Assert.assertEquals(attributeValue, attrVal);
		} else {
			if (attrVal.equals(attributeValue))
				Assert.assertNotEquals(attributeValue, attrVal);
		}
	}

	public String getElementAttribute(String elementName, String attributeName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		return element.getAttribute(attributeName);
	}
	public boolean isElementPresent(String xpath) {
		try {
			return webDriverProvider.get().findElements(By.xpath(xpath)).size() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public void checkElementEnable(String elementName, boolean testCase) throws Exception {
		boolean result = isElementEnabled(elementName);
		if (testCase) {
			if (!result)
				Assert.assertFalse("Element Not Enabled", result);

		} else {
			if (result)
				Assert.assertTrue("Element Enabled", result);
		}
	}

	public boolean isElementEnabled(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		return element.isEnabled();
	}

	public void isCheckboxChecked(String elementName, boolean shouldBeChecked) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if ((!checkbox.isSelected()) && shouldBeChecked)
			Assert.assertTrue("Checkbox is not checked", (!checkbox.isSelected()) && shouldBeChecked);
		else if (checkbox.isSelected() && !shouldBeChecked)
			Assert.assertTrue("Checkbox is checked", checkbox.isSelected() && !shouldBeChecked);
	}



	public void isRadioButtonSelected(String elementName, boolean shouldBeSelected) throws Exception {
		// Use getElement (no visibility wait)
		WebElement radio = getElement(this, elementName);

		if ((!radio.isSelected()) && shouldBeSelected) {
			Assert.assertTrue("Radio Button is not Selected",
					(!radio.isSelected()) && shouldBeSelected);
		} else if (radio.isSelected() && !shouldBeSelected) {
			Assert.assertTrue("Radio Button is Selected",
					radio.isSelected() && !shouldBeSelected);
		}
	}


	public void clearText(String elementName) throws Exception {
		WebElement el = getElementWithWait(this, elementName);
		String tag = el.getTagName().toLowerCase();

		if ("input".equals(tag) || "textarea".equals(tag)) {
			el.clear();
		}
		// else: do nothing (cell/div/span etc.)
	}

	public void selectOptionFromDropdown(String optionValue, String dropDownListName) throws Exception {
		WebElement dropdown = getElementWithWait(this, dropDownListName);
		WebDriver driver = webDriverProvider.get();

		// 1) Try plain <select>
		try {
			Select select = new Select(dropdown);
			select.selectByVisibleText(optionValue);
			log.info("Selected '" + optionValue + "' from <select> '" + dropDownListName + "'");
			return;
		} catch (UnexpectedTagNameException ignored) {
			// not a <select>, fall through
		}

		// 2) Generic LOV search <input>
		if (!"input".equalsIgnoreCase(dropdown.getTagName())) {
			throw new Exception("Element '" + dropDownListName + "' is neither a <select> nor an <input>.");
		}

		dropdown.click();
		try {
			dropdown.clear();
		} catch (InvalidElementStateException ex) {
			// read-only inputs – ignore
		}

		// type the visible text (already resolved from p:NationalResident, etc.)
		dropdown.sendKeys(optionValue);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// 2a) GENERIC: click any visible LOV Search button (if this LOV uses one)
		List<WebElement> searchButtons = driver.findElements(
				By.cssSelector("button.a-PopupLOV-doSearch"));
		for (WebElement btn : searchButtons) {
			if (btn.isDisplayed() && btn.isEnabled()) {
				btn.click();
				break;
			}
		}

		// 2b) GENERIC: wait until at least one visible <li> exists inside any ul.a-IconList
		By optionsLocator = By.cssSelector("ul.a-IconList li");

		List<WebElement> visibleOptions = wait.until(d -> {
			List<WebElement> all = d.findElements(optionsLocator);
			List<WebElement> visible = new ArrayList<>();
			for (WebElement e : all) {
				try {
					if (e.isDisplayed()) {
						visible.add(e);
					}
				} catch (StaleElementReferenceException ignored) {
					// element was refreshed; ignore and let the wait retry
				}
			}
			return visible.isEmpty() ? null : visible;
		});

		// 2c) Click the option whose text equals optionValue
		for (WebElement opt : visibleOptions) {
			String text = opt.getText().trim();
			if (text.equals(optionValue)) {
				opt.click();
				log.info("Selected '" + optionValue + "' from LOV '" + dropDownListName + "'");
				return;
			}
		}

		throw new Exception("Option '" + optionValue + "' not found in LOV for '" + dropDownListName + "'.");
	}

	public void selectFromDropdown(String elementName, String valueToSelect) throws Exception {
		WebElement dropdownElement = getElementWithWait(this, elementName);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(valueToSelect);
	}

	public void checkCheckbox(String elementName) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if (!checkbox.isSelected())
			checkbox.click();
	}

	public void uncheckCheckbox(String elementName) throws Exception {
		WebElement checkbox = getElementWithWait(this, elementName);
		if (checkbox.isSelected())
			checkbox.click();
	}

	public void selectRadioButton(String elementName) throws Exception {
		WebElement radioButton = getElementWithWait(this, elementName);
		if (!radioButton.isSelected())
			radioButton.click();
	}

	public CannedPage wait(String time) throws NumberFormatException, InterruptedException {
		// sleep method takes parameter in milliseconds
		Thread.sleep(Integer.parseInt(time) * 1000);
		return this;

	}

	public void handleAlert(String decision) {
		if (decision.equals("accept"))
			webDriverProvider.get().switchTo().alert().accept();
		else
			webDriverProvider.get().switchTo().alert().dismiss();
	}


	public List<String> getValuesFromXpaths(int rowCount) throws Exception {
		List<String> values = new ArrayList<>();

		for (int i = 0; i < rowCount; i++) {
			String xpath = "//*[@id='ctl00_MainContent_RadGrid1_ctl00__" + i + "']/td[2]";
			WebElement element = webDriverProvider.get().findElement(By.xpath(xpath));
			String text = element.getText().trim(); // Trim to remove any leading or trailing whitespace

			if (values.contains(text)) { // Check for duplicates
				throw new Exception("Duplicate value found: " + text);
			}

			values.add(text);
		}

		// Print the fetched values in the console
		System.out.println("Fetched values from xpaths:");
		for (String value : values) {
			System.out.println(value);
		}

		return values;
	}


	public void selectFromComboBox(String elementName, String value) throws Exception {
		WebElement comboBox = getElementWithWait(this, elementName);
		comboBox.click();
		comboBox.clear();
		comboBox.sendKeys(value);
		comboBox.sendKeys(Keys.DOWN);
		comboBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}


	public void switchToNewTab() {
		String originalWindow = webDriverProvider.get().getWindowHandle();
		// Get all window handles
		ArrayList<String> tabs = new ArrayList<>(webDriverProvider.get().getWindowHandles());
		// Switch to the new tab
		webDriverProvider.get().switchTo().window(tabs.get(1));
	}
	public void closeLatestTabAndReturnToFirstTab() {
		WebDriver driver = webDriverProvider.get();

		// Get all window handles
		Set<String> allTabs = driver.getWindowHandles();
		List<String> tabs = new ArrayList<>(allTabs);

		// Check if there are more than one tab
		if (tabs.size() > 1) {
			try {
				// Switch to the most recently opened tab
				String latestTab = tabs.get(tabs.size() - 1);

				// Ensure the latest tab handle is valid
				if (driver.getWindowHandles().contains(latestTab)) {
					driver.switchTo().window(latestTab);

					// Close the latest tab
					driver.close();

					// Refresh the list of window handles
					allTabs = driver.getWindowHandles();
					tabs = new ArrayList<>(allTabs);

					// If the original tab is still open, switch back to it
					if (!tabs.isEmpty()) {
						driver.switchTo().window(tabs.get(0));
					}
				} else {
					System.err.println("Error: The latest tab handle is no longer valid.");
					if (!tabs.isEmpty()) {
						driver.switchTo().window(tabs.get(0));
					}
				}
			} catch (NoSuchWindowException e) {
				System.err.println("Error: The target window is already closed.");
				// Switch back to the first available window in case of error
				allTabs = driver.getWindowHandles();
				tabs = new ArrayList<>(allTabs);
				if (!tabs.isEmpty()) {
					driver.switchTo().window(tabs.get(0));
				}
			}
		} else {
			System.out.println("No additional tabs to close.");
		}
	}

	public void switchToIframe(String iframeElementName) throws Exception {
		WebElement frame = getElementWithWait(this, iframeElementName);
		webDriverProvider.get().switchTo().frame(frame);
	}

	public void switchToDefaultContent() {
		webDriverProvider.get().switchTo().defaultContent();
	}

	public void reloadPage() {
		WebDriver driver = webDriverProvider.get();
		driver.navigate().refresh();
		log.info("I reload page");
		// wait until page fully loaded + loaders gone
		waitForLoad(driver);
	}

	public void pressEnter(String elementName) throws Exception {
		WebElement element = getElementWithWait(this, elementName);
		element.sendKeys(Keys.ENTER);
	}

	public void assertInputEmpty(String elementName, boolean shouldBeEmpty) throws Exception {
		WebElement el = getElementWithWait(this, elementName);

		String tag = el.getTagName() == null ? "" : el.getTagName().toLowerCase();
		String value;

		// For input/textarea, use "value". For other elements, fallback to text.
		if ("input".equals(tag) || "textarea".equals(tag)) {
			value = el.getAttribute("value");
		} else {
			value = el.getText();
		}

		String normalized = value == null ? "" : value.trim();

		if (shouldBeEmpty && !normalized.isEmpty()) {
			throw new AssertionError("Expected '" + elementName + "' to be empty but found: '" + value + "'");
		}

		if (!shouldBeEmpty && normalized.isEmpty()) {
			throw new AssertionError("Expected '" + elementName + "' to NOT be empty but it is empty");
		}

		log.info("Assert '" + elementName + "' empty=" + shouldBeEmpty + " (actual='" + value + "')");
	}

}
