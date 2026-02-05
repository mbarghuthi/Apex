package com.automation.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automation.pages.CustomPage;
import com.automation.pages.CannedPage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
@Component
public class CustomSteps extends AbstractSteps {

	@Autowired
	private CustomPage customPage;

	@Autowired
	private CannedPage cannedPage;

	// Step to get and save element text
	@Given("[Action] I get text from '$elementName' and save it as '$variableName'")
	@When("[Action] I get text from '$elementName' and save it as '$variableName'")
	@Then("[Action] I get text from '$elementName' and save it as '$variableName'")
	public void getElementTextAndSave(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String text = cannedPage.getElementWithWaitText(elementName);
		// Debug log
		System.out.println("Fetched text from " + elementName + ": " + text);
		stateManager.put(variableName, text);
		// Debug log
		System.out.println(variableName + " saved as: " + text);
	}

	// Step to get and save element value
	@Given("[Action] I get value from '$elementName' and save it as '$variableName'")
	@When("[Action] I get value from '$elementName' and save it as '$variableName'")
	@Then("[Action] I get value from '$elementName' and save it as '$variableName'")
	public void getElementValueAndSave(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String value = cannedPage.getElementAttribute(elementName, "value");
		// Debug log
		System.out.println("Fetched value from " + elementName + ": " + value);
		stateManager.put(variableName, value);
		// Debug log
		System.out.println(variableName + " saved as: " + value);
	}

	// Step to assert saved text value
	@Given("[Assertion] Verify text of '$elementName' equals saved value '$variableName'")
	@When("[Assertion] Verify text of '$elementName' equals saved value '$variableName'")
	@Then("[Assertion] Verify text of '$elementName' equals saved value '$variableName'")
	public void assertElementTextEqualsSavedValue(@Named("elementName") String elementName,
												  @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue   = cannedPage.getElementWithWaitText(elementName);

		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		if (expectedValue == null) {
			throw new Exception("Assertion failed: no value found in stateManager for key '" + variableName + "'");
		}

		expectedValue = expectedValue.trim();
		actualValue   = actualValue != null ? actualValue.trim() : "";

		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}

	@Given("[Assertion] Verify text of '$elementName' equals saved value or zero '$variableName'")
	@When("[Assertion] Verify text of '$elementName' equals saved value or zero '$variableName'")
	@Then("[Assertion] Verify text of '$elementName' equals saved value or zero '$variableName''")
	public void assertElementTextEqualsSavedValueOrZero(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementWithWaitText(elementName);

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		// Check if actual text is "0"
		if ("0".equals(expectedValue)) {
			// Locate the element with the text 'لا يوجد بيانات لإظهارها'
			boolean elementExists = cannedPage.isElementPresent("//div[contains(text(),'لا يوجد بيانات لإظهارها')]");

			if (elementExists) {
				System.out.println("Element indicating no data is present. Assertion passed.");
				return; // Exit the method as the assertion is true
			} else {
				throw new Exception("Assertion failed: expected '0', but no element indicating no data was found.");
			}
		}

		// Perform usual assertion if the text is not "0"
		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}




	@Given("[Assertion] Verify value of '$elementName' equals saved value '$variableName'")
	@When("[Assertion] Verify value of '$elementName' equals saved value '$variableName'")
	@Then("[Assertion] Verify value of '$elementName' equals saved value '$variableName'")
	public void assertElementValueEqualsSavedValue(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementAttribute(elementName, "value");

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}

	@Given("[Assertion] Verify value of '$elementName' equals saved value or zero '$variableName'")
	@When("[Assertion] Verify value of '$elementName' equals saved value or zero '$variableName'")
	@Then("[Assertion] Verify value of '$elementName' equals saved value or zero '$variableName")
	public void assertElementValueEqualsSavedValueOrZero(@Named("elementName") String elementName, @Named("variableName") String variableName) throws Exception {
		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementAttribute(elementName, "value");

		// Debug log
		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		// Check if actual value is zero
		if ("0".equals(expectedValue)) {
			// Locate the element with the text 'لا يوجد بيانات لإظهارها'
			boolean elementExists = cannedPage.isElementPresent("//div[contains(text(),'لا يوجد بيانات لإظهارها')]");

			if (elementExists) {
				System.out.println("Element indicating no data is present. Assertion passed.");
				return; // Exit the method as the assertion is true
			} else {
				throw new Exception("Assertion failed: expected '0', but no element indicating no data was found.");
			}
		}

		// Perform usual assertion if the value is not zero
		if (!expectedValue.equals(actualValue)) {
			throw new Exception("Assertion failed: expected '" + expectedValue + "', but was '" + actualValue + "'");
		}
	}

	// Step to verify uniqueness of values in column "رقم التعميم"
	@Given("[Assertion] Verify uniqueness of values in column 'رقم التعميم' to approaches '$variableName'")
	@When("[Assertion] Verify uniqueness of values in column 'رقم التعميم' to approaches '$variableName'")
	@Then("[Assertion] Verify uniqueness of values in column 'رقم التعميم' to approaches '$variableName'")
	public void verifyUniqueValuesInColumn(@Named("variableName") String variableName) throws Exception {
		Object rowCountObj = stateManager.get(variableName); // Fetch as Object

		if (rowCountObj == null) {
			throw new Exception("Value for '" + variableName + "' not found in stateManager.");
		}

		String rowCountStr = String.valueOf(rowCountObj); // Convert Object to String

		int rowCount = Integer.parseInt(rowCountStr); // Convert to integer if needed

		// Fetch the values from the xpaths
		List<String> values = cannedPage.getValuesFromXpaths(rowCount);

		// Verify the values are unique
		Set<String> uniqueValues = new HashSet<>(values);
		if (uniqueValues.size() != values.size()) {
			throw new Exception("Assertion failed: Values in column 'رقم التعميم' are not unique.");
		}
	}

	// to check the unwatched generalizations



	// Step to assert that GeneralizationYearValue equals CurrentYear
	@Given("[Assertion] Verify '$yearValue' equals current year")
	@When("[Assertion] Verify '$yearValue' equals current year")
	@Then("[Assertion] Verify '$yearValue' equals current year")
	public void assertGeneralizationYearEqualsCurrentYear(@Named("yearValue") String yearValue) throws Exception {
		String generalizationYear = (String) stateManager.get(yearValue);
		// Get the current year as a string
		String currentYear = String.valueOf(LocalDate.now().getYear());

		// Compare the generalization year with the current year
		if (!generalizationYear.equals(currentYear)) {
			throw new Exception("Assertion failed: GeneralizationYearValue (" + generalizationYear +
					") is not equal to current year (" + currentYear + ")");
		}
		System.out.println("Assertion passed: GeneralizationYearValue equals current year");
	}


	@Given("[Assertion] Verify text of '$elementName' contains saved value '$variableName'")
	@When("[Assertion] Verify text of '$elementName' contains saved value '$variableName'")
	@Then("[Assertion] Verify text of '$elementName' contains saved value '$variableName'")
	public void assertElementTextContainsSavedValue(@Named("elementName") String elementName,
													@Named("variableName") String variableName) throws Exception {

		String expectedValue = (String) stateManager.get(variableName);
		String actualValue = cannedPage.getElementWithWaitText(elementName);

		System.out.println("Expected value (from stateManager, key='" + variableName + "'): " + expectedValue);
		System.out.println("Actual value (from element '" + elementName + "'): " + actualValue);

		if (expectedValue == null) {
			throw new Exception("StateManager value is null for key: '" + variableName + "'");
		}

		// If expected value contains '|', take the part after it; otherwise use full value
		String relevantPart;
		if (expectedValue.contains("|")) {
			String[] parts = expectedValue.split("\\|", 2); // split into max 2 parts
			relevantPart = parts.length > 1 ? parts[1].trim() : expectedValue.trim();
		} else {
			relevantPart = expectedValue.trim();
		}

		if (actualValue == null) actualValue = "";

		if (!actualValue.contains(relevantPart)) {
			throw new Exception(
					"Assertion failed: element '" + elementName + "' text does not contain saved value '" + variableName + "'. "
							+ "Expected part '" + relevantPart + "', but actual was '" + actualValue + "'"
			);
		}
	}


	@Given("[Input] I login admin as '$userName' with password '$password'")
	@When("[Input] I login admin as '$userName' with password '$password'")
	@Then("[Input] I login admin as '$userName' with password '$password'")
	public void loginAdminAs(@Named("adminUserName") String userName, @Named("adminPassword") String password) throws Throwable {
		customPage.enterText("adminUserName", userName).enterText("adminPassword", password).click("loginAdminButton");
	}

	//step to assert checkbox is unchecked
	@Given("[Assertion] Verify Radio  '$elementName' is clicked on")
	@When("[Assertion] Verify Radio  '$elementName' is clicked on")
	@Then("[Assertion] Verify Radio  '$elementName' is clicked on")
	public void is_radio_button_unchecked(String elementName) throws Exception
	{
		customPage.checkRadioButton(elementName, true);
	}


	@Autowired
	private WebDriverProvider webDriverProvider;

	@Given("[Assertion] Verify Checkbox  '$elementName' is clicked on")
	@When("[Assertion] Verify Checkbox  '$elementName' is clicked on")
	@Then("[Assertion] Verify Checkbox  '$elementName' is clicked on")
	public void is_checkbox_checked(String elementName) throws Exception {
		customPage.checkCheckboxButton(elementName, true);

		// Access the WebDriver instance
//		WebDriver driver = webDriverProvider.get();
//		String originalWindow = driver.getWindowHandle();
//
//		// Wait for a new tab to open
//		Set<String> allWindows = driver.getWindowHandles();
//		if (allWindows.size() > 1) {
//			for (String windowHandle : allWindows) {
//				if (!windowHandle.equals(originalWindow)) {
//					driver.switchTo().window(windowHandle);
//					break;
//				}
//			}
//
//			// Continue with further actions on the new tab
//			WebElement newTabElement = driver.findElement(By.id("elementIdOnNewTab"));
//			newTabElement.click();
//
//			// Optionally, switch back to the original tab if needed
//			driver.switchTo().window(originalWindow);
//		}
	}

	@Given("[Input] I hover on '$elementName'")
	@When("[Input] I hover on '$elementName'")
	@Then("[Input] I hover on '$elementName'")
	public void elementToHoverStep(String elementName) throws Exception {
		customPage.elementToHover(elementName);
	}

	@Given("[Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches '$variableName'")
	@When("[Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches '$variableName'")
	@Then("[Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches '$variableName'")
	public void verifyRowsOfUnseenBooks(@Named("variableName") String variableName) throws Exception {
		// Fetch the row count from the state manager
		Object rowCountObj = stateManager.get(variableName); // Fetch as Object

		if (rowCountObj == null) {
			throw new Exception("Value for '" + variableName + "' not found in stateManager.");
		}

		// Convert the fetched row count to an integer
		int rowCount = Integer.parseInt(rowCountObj.toString().trim()); // Convert to integer

		// Fetch the count of rows without the specified image
		int countWithoutImage = customPage.countRowsWithoutImage(rowCount);

		// Fetch the expected value using the variable name provided in the steps
		Object expectedValueObj = stateManager.get(variableName); // Use the variable name dynamically

		if (expectedValueObj == null) {
			throw new Exception("Expected value not found in stateManager for variable: " + variableName);
		}

		// Convert the expected value to an integer
		int expectedValue = Integer.parseInt(expectedValueObj.toString().trim()); // Convert to integer

		// Assert that the actual count equals the expected value
		if (countWithoutImage != expectedValue) {
			throw new Exception("Assertion failed: Count of rows without the image (" + countWithoutImage + ") does not equal expected value (" + expectedValue + ").");
		} else {
			System.out.println("Assertion passed: Count of rows without the image matches the expected value: " + expectedValue);
		}
	}


	@Given("[Input] I set IG '$regionId' row '$rowText' column '$columnHeader' to '$value'")
	@When("[Input] I set IG '$regionId' row '$rowText' column '$columnHeader' to '$value'")
	@Then("[Input] I set IG '$regionId' row '$rowText' column '$columnHeader' to '$value'")
	public void set_ig_value(String regionId, String rowText, String columnHeader, String value) throws Exception {
		customPage.setIGValue(regionId, rowText, columnHeader, value);
	}


	@Given("[Input] I set IG '$regionId' from first row '$firstRowText' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	@When("[Input] I set IG '$regionId' from first row '$firstRowText' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	@Then("[Input] I set IG '$regionId' from first row '$firstRowText' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	public void set_ig_random_all_enabled_cells_excluding_ddl(String regionId, String firstRowText, int min, int max) throws Exception {
		int updated = customPage.fillCalcIgRandomAndSave(regionId, firstRowText, min, max);
		if (updated <= 0) throw new Exception("No enabled non-DDL cells were updated.");
	}


	@Given("[Input] I fill IG '$igId' with random numbers between '$min' and '$max' and save page")
	@When("[Input] I fill IG '$igId' with random numbers between '$min' and '$max' and save page")
	@Then("[Input] I fill IG '$igId' with random numbers between '$min' and '$max' and save page")
	public void fillIgRandomAndSavePage(String igId, int min, int max) throws Exception {

		int updated = customPage.fillCalcIgRandomAndSave(igId, "20 - LC invoice value", min, max);
		if (updated <= 0) throw new Exception("Nothing was filled in IG. updated=0");
	}


	@Given("[Action] I enable IG edit mode for '$regionId'")
	@When("[Action] I enable IG edit mode for '$regionId'")
	@Then("[Action] I enable IG edit mode for '$regionId'")
	public void enable_ig_edit_mode(String regionId) throws Exception {
		customPage.ensureIgEditModePublic(regionId);
	}

	@Given("[Assertion] Verify IG '$igId' row '$rowText' column '$columnHeader' is not zero")
	@When("[Assertion] Verify IG '$igId' row '$rowText' column '$columnHeader' is not zero")
	@Then("[Assertion] Verify IG '$igId' row '$rowText' column '$columnHeader' is not zero")
	public void verifyIgCellNotZero(String igId, String rowText, String columnHeader) throws Exception {

		WebDriver driver = webDriverProvider.get();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		Boolean ok = wait.until(d -> {
			try {
				String val = customPage.getIGCellText(igId, rowText, columnHeader);
				if (val == null) return false;
				String v = val.trim();
				return !v.isEmpty() && !"0".equals(v);
			} catch (Exception e) {
				return false;
			}
		});

		if (!Boolean.TRUE.equals(ok)) {
			String val = customPage.getIGCellText(igId, rowText, columnHeader);
			throw new Exception("IG cell is zero/empty. row=" + rowText + ", col=" + columnHeader + ", value=" + val);
		}
	}

	@Given("[Input] I set SECOND IG '$ig2' from first row '$firstRow2' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	@When("[Input] I set SECOND IG '$ig2' from first row '$firstRow2' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	@Then("[Input] I set SECOND IG '$ig2' from first row '$firstRow2' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	public void set_second_ig_random_all_enabled_cells_excluding_ddl(
			@Named("ig2") String ig2,
			@Named("firstRow2") String firstRow2,
			@Named("min") int min,
			@Named("max") int max
	) throws Exception {

		int updated = customPage.fillSecondIgRandomAndSaveOnly(ig2, firstRow2, min, max);
		if (updated <= 0) throw new Exception("No enabled non-DDL cells were updated in second IG.");
	}

	@Given("[Input] I set IG number '$igIndex' from first row '$firstRowText' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	@When("[Input] I set IG number '$igIndex' from first row '$firstRowText' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	@Then("[Input] I set IG number '$igIndex' from first row '$firstRowText' to random numbers between '$min' and '$max' for all enabled cells excluding DDL")
	public void set_ig_by_index_random_all_enabled_cells_excluding_ddl(
			@Named("igIndex") int igIndex,
			@Named("firstRowText") String firstRowText,
			@Named("min") int min,
			@Named("max") int max
	) throws Exception {
		int updated = customPage.fillIgByIndexRandomAndSave(igIndex, firstRowText, min, max);
		if (updated <= 0) throw new Exception("Nothing was filled in IG. updated=0");
	}

	@Given("[Assertion] Verify IG '$igId' row '$rowText' Local/Amount can be filled")
	@When("[Assertion] Verify IG '$igId' row '$rowText' Local/Amount can be filled")
	@Then("[Assertion] Verify IG '$igId' row '$rowText' Local/Amount can be filled")
	public void verify_ig_local_amount_fillable(
			@Named("igId") String igId,
			@Named("rowText") String rowText
	) throws Exception {
		customPage.assertIgLocalAmountFillable(igId, rowText);
	}

	@Given("[Assertion] Verify IG '$igId' row '$rowText' Foreign/Foreign Amount can be filled")
	@When("[Assertion] Verify IG '$igId' row '$rowText' Foreign/Foreign Amount can be filled")
	@Then("[Assertion] Verify IG '$igId' row '$rowText' Foreign/Foreign Amount can be filled")
	public void verify_ig_foreign_amount_fillable(
			@Named("igId") String igId,
			@Named("rowText") String rowText
	) throws Exception {
		customPage.assertIgForeignAmountFillable(igId, rowText);
	}


	@Given("[Assertion] Verify all results in tree '$treeId' contain '$text'")
	@When("[Assertion] Verify all results in tree '$treeId' contain '$text'")
	@Then("[Assertion] Verify all results in tree '$treeId' contain '$text'")
	public void verify_all_tree_results_contain(@Named("treeId") String treeId,
												@Named("text") String text) throws Exception {
		customPage.assertProgramsTreeSearchResultsContain(treeId, text);
	}

	// ======================= CustomSteps.java =======================
// Add this step (stores the count into stateManager)

	@Given("[Action] I count results in tree '$treeId' that contain '$text' and save it as '$variableName'")
	@When("[Action] I count results in tree '$treeId' that contain '$text' and save it as '$variableName'")
	@Then("[Action] I count results in tree '$treeId' that contain '$text' and save it as '$variableName'")
	public void count_tree_results_containing_and_save(
			@Named("treeId") String treeId,
			@Named("text") String text,
			@Named("variableName") String variableName
	) throws Exception {

		int count = customPage.countTreeResultsContainingAndSave(treeId, text);

		stateManager.put(variableName, String.valueOf(count));

		System.out.println("Saved tree match count for '" + text + "' as " + count + " into variable: " + variableName);
	}

	@Given("[Assertion] Verify tree '$treeId' count for '$text' equals saved value '$variableName'")
	@When("[Assertion] Verify tree '$treeId' count for '$text' equals saved value '$variableName'")
	@Then("[Assertion] Verify tree '$treeId' count for '$text' equals saved value '$variableName'")
	public void verify_tree_recount_equals_saved(
			@Named("treeId") String treeId,
			@Named("text") String text,
			@Named("variableName") String variableName
	) throws Exception {

		Object savedObj = stateManager.get(variableName);
		if (savedObj == null) {
			throw new Exception("No saved value found in stateManager for variable: " + variableName);
		}

		int expectedCount = Integer.parseInt(savedObj.toString().trim());
		int actualCount = customPage.recountTreeResultsContaining(treeId, text);

		if (expectedCount != actualCount) {
			throw new Exception(
					"Tree count mismatch for '" + text + "'. " +
							"Expected=" + expectedCount + ", Actual=" + actualCount
			);
		}

		System.out.println(
				"Tree count assertion passed for '" + text + "': " + actualCount
		);
	}


	@Given("[Assertion] Verify tree '$treeId' is '$state'")
	@When("[Assertion] Verify tree '$treeId' is '$state'")
	@Then("[Assertion] Verify tree '$treeId' is '$state'")
	public void verify_tree_expand_collapse_state(
			@Named("treeId") String treeId,
			@Named("state") String state
	) throws Exception {
		customPage.assertProgramsTreeIsExpandedOrCollapsed(treeId, state);
	}

	@Given("[Action] I ensure navbar is open using toggle '$toggle'")
	@When("[Action] I ensure navbar is open using toggle '$toggle'")
	@Then("[Action] I ensure navbar is open using toggle '$toggle'")
	public void ensure_navbar_open(@Named("toggle") String toggle) throws Exception {
		customPage.ensureNavBarOpen(toggle);
	}

	@Given("[Assertion] Verify IG '$igId' has an empty inserted row")
	@When("[Assertion] Verify IG '$igId' has an empty inserted row")
	@Then("[Assertion] Verify IG '$igId' has an empty inserted row")
	public void verify_ig_has_empty_inserted_row(@Named("igId") String igId) throws Exception {
		customPage.assertIgHasEmptyInsertedRow(igId);
	}

	@Given("[Assertion] Verify IG '$igId' has an empty inserted row at td indexes '$tdIndexes'")
	@When("[Assertion] Verify IG '$igId' has an empty inserted row at td indexes '$tdIndexes'")
	@Then("[Assertion] Verify IG '$igId' has an empty inserted row at td indexes '$tdIndexes'")
	public void verify_ig_has_empty_inserted_row_td_indexes(
			@Named("igId") String igId,
			@Named("tdIndexes") String tdIndexes
	) throws Exception {

		// Example in story: "3,4" (Code, Description)
		String[] parts = tdIndexes.split("\\s*,\\s*");
		int[] idx = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			idx[i] = Integer.parseInt(parts[i].trim());
		}

		customPage.assertIgHasEmptyInsertedRowForTdIndexes(igId, idx);
	}

	@Given("[Action] I delete the inserted row in IG '$igId'")
	@When("[Action] I delete the inserted row in IG '$igId'")
	@Then("[Action] I delete the inserted row in IG '$igId'")
	public void delete_inserted_row_in_ig(@Named("igId") String igId) throws Exception {
		customPage.deleteAnyInsertedRowInIg(igId);
	}

	@Given("[Action] I delete the inserted row from any visible IG")
	@When("[Action] I delete the inserted row from any visible IG")
	@Then("[Action] I delete the inserted row from any visible IG")
	public void delete_inserted_row_any_visible_ig() throws Exception {
		customPage.deleteInsertedRowFromAnyVisibleIg();
	}

	@Given("[Table] I save table snapshot from '$elementName' in variable '$variableName'")
	@When("[Table] I save table snapshot from '$elementName' in variable '$variableName'")
	@Then("[Table] I save table snapshot from '$elementName' in variable '$variableName'")
	public void saveTableSnapshot(
			@Named("elementName") String elementName,
			@Named("variableName") String variableName
	) throws Exception {
		String snapshot = customPage.getNormalizedSnapshot(elementName);
		stateManager.put(variableName, snapshot);
	}

	@Given("[Table] Verify table '$elementName' snapshot differs from '$variableName'")
	@When("[Table] Verify table '$elementName' snapshot differs from '$variableName'")
	@Then("[Table] Verify table '$elementName' snapshot differs from '$variableName'")
	public void verifyTableSnapshotChanged(
			@Named("elementName") String elementName,
			@Named("variableName") String variableName
	) throws Exception {

		String oldSnap = (String) stateManager.get(variableName);
		String newSnap = customPage.getNormalizedSnapshot(elementName);

		System.out.println("OLD SNAPSHOT=[" + oldSnap + "]");
		System.out.println("NEW SNAPSHOT=[" + newSnap + "]");

		Assert.assertNotEquals(
				"Table content did not change after filter action",
				oldSnap,
				newSnap
		);
	}

	@Given("[Assertion] Verify all fields in '$containerElementName' are empty")
	@When("[Assertion] Verify all fields in '$containerElementName' are empty")
	@Then("[Assertion] Verify all fields in '$containerElementName' are empty")
	public void verify_all_fields_empty_in_container(@Named("containerElementName") String containerElementName) throws Exception {
		customPage.assertAllFieldsAreEmptyByElementName(containerElementName);
	}

	@Given("[Assertion] Verify '$elementName' is filled")
	@When("[Assertion] Verify '$elementName' is filled")
	@Then("[Assertion] Verify '$elementName' is filled")
	public void verify_element_is_filled(@Named("elementName") String elementName) throws Exception {
		customPage.assertFieldIsFilled(elementName);
	}

	@Given("[Assertion] Verify '$elementName' is not filled")
	@When("[Assertion] Verify '$elementName' is not filled")
	@Then("[Assertion] Verify '$elementName' is not filled")
	public void verify_element_is_not_filled(@Named("elementName") String elementName) throws Exception {
		customPage.assertFieldIsNotFilled(elementName);
	}

	@Given("[Assertion] Verify APEX checkbox '$elementName' is checked")
	@When("[Assertion] Verify APEX checkbox '$elementName' is checked")
	@Then("[Assertion] Verify APEX checkbox '$elementName' is checked")
	public void assert_apex_checkbox_checked_by_element_name(String elementName) {
		elementName = elementName.trim();

		String itemId = customPage.resolveApexItemIdFromElementName(elementName); // e.g. StatusCheckbox -> P21_STATUS

		WebDriver driver = webDriverProvider.get();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		By checkedLocator = By.cssSelector(
				"#" + itemId + "_CONTAINER input[type='checkbox']:checked, " +
						"input#" + itemId + ":checked, " +
						"input[id^='" + itemId + "_']:checked"
		);

		WebElement checked = wait.until(ExpectedConditions.presenceOfElementLocated(checkedLocator));
		Assert.assertNotNull("Checkbox '" + elementName + "' (" + itemId + ") is not checked", checked);
	}

}