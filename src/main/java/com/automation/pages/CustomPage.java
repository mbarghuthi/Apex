package com.automation.pages;

import com.automation.configuration.pageobjects.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;


@PageObject
public class CustomPage extends AbstractPage<CustomPage> {
    @FindBy(xpath = "//input[@id='tbxUserName']")
    public WebElement adminUserName;
    @FindBy(xpath = "//input[@id='tbxPassword']")
    public WebElement adminPassword;
    @FindBy(css = "#btnLogin2")
    public WebElement loginAdminButton;



    @FindBy(css = "#ctl00_MainContent_rbOnSaveDraft")
    public WebElement SaveDraftOnRadioButton;



//    @FindBy(css = "#ctl00_MainContent_rdONMandatory")
    @FindBy(id = "ctl00_MainContent_rdONMandatory")
    public WebElement MandatoryCheckbox;

    @FindBy(css = "#ctl00_MainContent_GVViewData_ctl07_HyperLink3")
    public WebElement EditIncomingMailAttachment;


    @FindBy(xpath = "//span[contains(text(),'جميع المهام')]")
    public WebElement AllTaskHeaderButton;


    /**
     * Method to enter text into text field
     *
     * @param elementName : String : element Name
     * @param text        : String : Text value to enter in field
     * @throws Exception
     */
    public CustomPage enterText(String elementName, String text) throws Exception {
        WebElement element = getElementWithWait(this, elementName);
        // element.clear();
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
    public CustomPage click(String elementName) throws Exception {
        // wait element
        WebElement element = getElementWithWait(this, elementName);
        element.click();
//		Actions actions = new Actions(webDriverProvider.get());
//		actions.moveToElement(element).click().perform();
        log.info("Clicked on '" + elementName + "'");
        return this;
    }

    public void checkRadioButton(String elementName, boolean shouldBeChecked) throws Exception {
        WebElement radioButton = getElementWithWait(this, elementName);

        // Check if the radio button needs to be clicked or left as is
        if (shouldBeChecked && !radioButton.isSelected()) {
            radioButton.click();
        }

        // Verify if the radio button's state matches the expected state
        Assert.assertEquals("Radio button state does not match the expected state", shouldBeChecked, radioButton.isSelected());
    }

    public void checkCheckboxButton(String elementName, boolean shouldNotBeChecked) throws Exception {
        WebElement checkbox = getElementWithWait(this, elementName);

        // Check if the checkbox needs to be clicked or left as is
        if (shouldNotBeChecked && checkbox.isSelected()) {
            checkbox.click();
        }

        // Verify if the checkbox's state matches the expected state
        Assert.assertEquals("Checkbox state does not match the expected state", !shouldNotBeChecked, checkbox.isSelected());
    }

    public CustomPage elementToHover(String elementName) throws Exception {
        // wait element
        WebElement element = getElementWithWait(this, elementName);
		Actions actions = new Actions(webDriverProvider.get());
//        // Perform the mouse hover action
        actions.moveToElement(element).perform();
        log.info("Clicked on '" + elementName + "'");
        return this;
    }



}