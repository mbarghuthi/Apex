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

	@FindBy(xpath = "(//a[normalize-space()='Sign Out'])[1]")
	public WebElement LogoutButton;

	@FindBy(xpath = "//span[normalize-space()='Create']")
	public WebElement CreateButton;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	public WebElement CancelButton;

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

	@FindBy(xpath = "//span[@class='t-Icon icon-close']")
	public WebElement CloseIconButton;

// ************************************************************ Elements **********************************************************************************************

	@FindBy(css = "#t_Button_navControl")
	public WebElement navControlButton;

// **************************** Side Menu Main ****************************
	@FindBy(xpath = "//span[normalize-space()='Control and Monitering']")
	public WebElement ControlAndMoniteringSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Quotations']")
	public WebElement QuotationsSideMenu;

// **************************** Side Menu SubMain (1) ****************************
	@FindBy(xpath = "//span[normalize-space()='Quotation - Menu']")
	public WebElement QuotationMenuSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Aman Setup']")
	public WebElement AmanSetupSideMenu;

	@FindBy(xpath = "//span[normalize-space()='General Business Tariffs']")
	public WebElement GeneralBusinessTariffsSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Master Files']")
	public WebElement MasterFilesSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Users & Authorities']")
	public WebElement UsersAndAuthoritiesSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Aman Control']")
	public WebElement AmanControlSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Mail & SMS']")
	public WebElement MailAndSmsSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Workflow Integration']")
	public WebElement WorkflowIntegrationSideMenu;

// **************************** Side Menu SubMain (2) ****************************
	@FindBy(xpath = "//a[normalize-space()='Programs']")
	public WebElement ProgramsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='System Code Ranks']")
	public WebElement SystemCodeRanksSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Error Messages']")
	public WebElement ErrorMessagesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Departments']")
	public WebElement DepartmentsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Goverment Occupation']")
	public WebElement GovermentOccupationSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Address Ordering']")
	public WebElement AddressOrderingSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Black List']")
	public WebElement BlackListSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Domicile Locations']")
	public WebElement DomicileLocationsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='System Owner Setup']")
	public WebElement SystemOwnerSetupSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Sum Insured Ranges']")
	public WebElement SumInsuredRangesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Short Period Tariff']")
	public WebElement ShortPeriodTariffSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Pro-Rata Period Tariff']")
	public WebElement ProRataPeriodTariffSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Quotations']")
	public WebElement QuotationNavigationSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Locations & Branches']")
	public WebElement LocationsAndBranchesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Customers Receivable']")
	public WebElement CustomersReceivableSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Payable Parties']")
	public WebElement PayablePartiesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Class-Subclass Linking']")
	public WebElement ClassSubclassLinkingSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Customers Address Screen']")
	public WebElement CustomersAddressScreenSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Users Definition']")
	public WebElement UsersDefinitionSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Roles Definition']")
	public WebElement RolesDefinitionSideMenu;

	@FindBy(xpath = "(//a[normalize-space()=\"Users' Privileges On Locations & Branches\"])[1]")
	public WebElement UsersPrivilegesOnLocationsAndBranchesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	public WebElement ChangePasswordSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Authorized Buttons']")
	public WebElement AuthorizedButtonsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='User Privileges On Endt Transactions']")
	public WebElement UserPrivilegesOnEndtTransactionsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='User Privileges On Claim Payments']")
	public WebElement UserPrivilegesOnClaimPaymentsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Password Policy Rules']")
	public WebElement PasswordPolicyRulesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='User Access Violations']")
	public WebElement UserAccessViolationsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='User Privileges On Quotation Posting']")
	public WebElement UserPrivilegesOnQuotationPostingSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Link Region/City screen']")
	public WebElement LinkRegionCityScreenSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Effective Date Grace Period']")
	public WebElement EffectiveDateGracePeriodSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Control Dates']")
	public WebElement ControlDatesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Control Dates (Groups)']")
	public WebElement ControlDatesGroupsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Commision Definition']")
	public WebElement CommisionDefinitionSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Import From Excel Advanced']")
	public WebElement ImportFromExcelAdvancedSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Excel Defintion']")
	public WebElement ExcelDefintionSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Mail and SMS Notification Configuration']")
	public WebElement MailAndSmsNotificationConfigurationSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Mail Setup']")
	public WebElement MailSetupSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Mail and SMS Notifications']")
	public WebElement MailAndSmsNotificationsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='SMS Notifications']")
	public WebElement SmsNotificationsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='SMS GateWay Definition']")
	public WebElement SmsGateWayDefinitionSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Map AMAN Fields with WF Attributes']")
	public WebElement MapAmanFieldsWithWFAttributesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Workflow Build Queries']")
	public WebElement WorkflowBuildQueriesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Workflow Services Setup']")
	public WebElement WorkflowServicesSetupSideMenu;

// **************************** Card Dashboard ****************************
	@FindBy(xpath = "//h3[normalize-space()='Quotations']")
	public WebElement QuotationCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='Control and Monitering']")
	public WebElement ControlAndMoniteringCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='System Code Ranks']")
	public WebElement SystemCodeRanksCardDashboard;

// **************************** Module Title ****************************
	@FindBy(xpath = "//h2[normalize-space()='Quotations']")
	public WebElement QuotationsTitle;

	@FindBy(css = "#programs_heading")
	public WebElement ProgramsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='System Code Ranks Major'])[1]")
	public WebElement SystemCodeRanksMajorTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Error Messages'])[1]")
	public WebElement ErrorMessagesTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Departments'])[1]")
	public WebElement DepartmentsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Government Occupation'])[1]")
	public WebElement GovernmentOccupationTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Address Ordering'])[1]")
	public WebElement AddressOrderingTitle;

	@FindBy(xpath = "(//h2[normalize-space()='BlackList'])[1]")
	public WebElement BlackListTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Domicile Locations'])[1]")
	public WebElement DomicileLocationsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Sum Insured Ranges'])[1]")
	public WebElement SumInsuredRangesTitle;

	@FindBy(css = "#SP_ID_heading")
	public WebElement ShortPeriodTariffTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Pro-Rata Period Tariff'])[1]")
	public WebElement ProRataPeriodTariffTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Locations and Branches'])[1]")
	public WebElement LocationsAndBranchesTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Class'])[1]")
	public WebElement ClassTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Customer Address'])[1]")
	public WebElement CustomerAddressTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Users'])[1]")
	public WebElement UsersTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Change Password'])[1]")
	public WebElement ChangePasswordTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Authorized Buttons'])[1]")
	public WebElement AuthorizedButtonsTitle;

	@FindBy(css = "#UPET_ID_heading")
	public WebElement UserPrivilegesOnEndtTransactionsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='User Privileges On Claim Payments'])[1]")
	public WebElement UserPrivilegesOnClaimPaymentsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Password Policy Rules'])[1]")
	public WebElement PasswordPolicyRulesTitle;

	@FindBy(xpath = "(//h2[normalize-space()='User Access Violations'])[1]")
	public WebElement UserAccessViolationsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='User Privilege on Quotation Posting'])[1]")
	public WebElement UserPrivilegeOnQuotationPostingTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Link Region/City Screen'])[1]")
	public WebElement LinkRegionCityScreenTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Effective Date Grace Period'])[1]")
	public WebElement EffectiveDateGracePeriodTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Control Dates'])[1]")
	public WebElement ControlDatesTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Control Dates (Groups)'])[1]")
	public WebElement ControlDatesGroupsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Commission Definition'])[1]")
	public WebElement CommissionDefinitionTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Import From Excel Advanced'])[1]")
	public WebElement ImportFromExcelAdvancedTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Excel Defintion'])[1]")
	public WebElement ExcelDefintionTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Mail and SMS Notification Configuration'])[1]")
	public WebElement MailAndSmsNotificationConfigurationTitle;

	@FindBy(xpath = "(//h2[contains(text(),'Mail Setup')])[1]")
	public WebElement MailSetupTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Mail & SMS Notifications'])[1]")
	public WebElement MailAndSmsNotificationsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='SMS Notifications'])[1]")
	public WebElement SmsNotificationsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='SMS GateWay Definition'])[1]")
	public WebElement SmsGateWayDefinitionTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Map AMAN Fields with WF Attributes Master'])[1]")
	public WebElement MapAmanFieldsWithWFAttributesMasterTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Workflow Build Queries'])[1]")
	public WebElement WorkflowBuildQueriesTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Workflow Services Setup'])[1]")
	public WebElement WorkflowServicesSetupTitle;

// **************************** General ****************************
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

	@FindBy(css = "#OFF_QUT_IG_ig_toolbar_actions_button")
	public WebElement ActionButton;

	@FindBy(css = "#OFF_QUT_IG_ig_toolbar_2i")
	public WebElement FilterButton;

	@FindBy(css = "#OFF_QUT_IG_ig_FD_COLUMN")
	public WebElement ColumnFilterDDL;

	@FindBy(css = "#OFF_QUT_IG_ig_FD_VALUE")
	public WebElement ValueFilterInput;

	@FindBy(css = ".ui-button--hot.ui-button.ui-corner-all.ui-widget")
	public WebElement SaveFilterButton;

	@FindBy(css = "#OFF_QUT_IG_ig_toolbar_3i")
	public WebElement DataButton;

	@FindBy(css = "#OFF_QUT_IG_ig_toolbar_3_0i")
	public WebElement SortButton;

	@FindBy(css = "#OFF_QUT_IG_ig_SD_DIRECTION")
	public WebElement DirectionDDL;

	@FindBy(css = "#OFF_QUT_IG_ig_SD_COLUMN")
	public WebElement ColumnDDL;

	@FindBy(css = "td[role='gridcell'] img[class='apex-edit-pencil-alt']")
	public WebElement EditPinButton;

	@FindBy(css = "tr[class='a-GV-row is-readonly is-selected'] img[class='apex-edit-pencil-alt']")
	public WebElement EditPinButtonMultiRows;


	@FindBy(css = "td[role='gridcell'] a[class='disabled']")
	public WebElement RevisionIconDisable;
	@FindBy(css = "tbody tr[role='row'] td:nth-child(2) a:nth-child(1)")
	public WebElement RevisionIconEnable;

	@FindBy(xpath = "//span[normalize-space()='Main Quotations']")
	public WebElement MainQuotationsButton;

	@FindBy(css = "button[title='Remove Filter']")
	public WebElement RemoveFilterButton;

	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(3)")
	public WebElement FirstClassOfBusInTable;

	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(10)")
	public WebElement FirstIssueDateInTable;

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

	// ************************************************************ End of Quotation Elements **********************************************************************************************

	@FindBy(xpath = "//span[normalize-space()='Revision Quotation']")
	public WebElement RevisionQuotationButton;

	@FindBy(xpath = "//span[normalize-space()='Copy Quotation']")
	public WebElement CopyQuotationButton;

// ************************************************************ Quotation Revisions Elements **********************************************************************************************

	@FindBy(css = ".a-GV-row.is-readonly")
	public WebElement RevisionZeroRow;

	// ************************************************************ Programs Elements **********************************************************************************************
	@FindBy(css = "#P14_SEARCH_TREE")
	public WebElement SearchTreeInput;

	@FindBy(css = "#programs_tree")
	public WebElement ProgramsTree;

	@FindBy(css = "#EXPAND_COLLAPSE")
	public WebElement ExpandCollapseButton;

	// ************************************************************ System Code Ranks Elements **********************************************************************************************
	@FindBy(css = "#SCRM_IG_ig")
	public WebElement SystemCodeRanksMajorTable;

	@FindBy(css = "#SCRD_IG_ig")
	public WebElement SystemCodeRanksMinorTable;

	@FindBy(xpath = "//div[@id='SCRM_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement SystemCodeRanksMajorButton;

	@FindBy(xpath = "//div[@id='SCRD_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement SystemCodeRanksMinorButton;

	// ************************************************************ Error Messages Elements **********************************************************************************************
	@FindBy(css = "#EMM_IG_ig")
	public WebElement ErrorMessagesTable;

	@FindBy(css = "#EMD_IG_ig")
	public WebElement ErrorMessagesDetailsTable;

	@FindBy(xpath = "//div[@id='EMM_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement ErrorMessagesAddRowButton;

	@FindBy(xpath = "//div[@id='EMD_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement ErrorMessagesDetailsAddRowButton;

	// ************************************************************ Departments Elements **********************************************************************************************
	@FindBy(css = "#dept_ig")
	public WebElement DepartmentsTable;

	@FindBy(css = "#class_ig")
	public WebElement ClassesTable;

	@FindBy(css = "#policy_ig")
	public WebElement PoliciesTable;

	@FindBy(css = "#risk_ig")
	public WebElement RisksTable;

	// ************************************************************ Government Occupation Elements **********************************************************************************************
	@FindBy(css = "#OCCGOV_ig")
	public WebElement GovernmentOccupationTable;

	@FindBy(css = "div[class='a-GV-w-scroll'] table[role='presentation']")
	public WebElement GovernmentOccupationTableValue;

	@FindBy(xpath = "(//div[@class='apex-item-option'])[1]")
	public WebElement MaleRadioButtons;

	@FindBy(xpath = "//div[@class='t-Form-inputContainer col col-10']//div[2]")
	public WebElement FemaleRadioButtons;

	@FindBy(css = "button[data-action='selection-add-row']")
	public WebElement GovernmentOccupationAddRowButton;

	@FindBy(css = "button[title='Ctrl+Alt+S']")
	public WebElement GovernmentOccupationSaveButton;

	// ************************************************************ Black List Elements **********************************************************************************************
	@FindBy(css = "#blkLst_ig")
	public WebElement BlackListTable;

	@FindBy(css = "#blkDet_ig")
	public WebElement BlackListDetTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement BlackListAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement BlackListDetAddRowButton;

	// ************************************************************ Domicile Locations Elements **********************************************************************************************
	@FindBy(css = "#DL_IG_ig")
	public WebElement DomicileLocationsTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement DomicileLocationsAddRowButton;

	// ************************************************************ System Owner Setup Elements **********************************************************************************************
	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='General Information']")
	public WebElement GeneralInformationTab;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Settings']")
	public WebElement SettingsTab;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Application Configuration']")
	public WebElement ApplicationConfigurationTab;

	// ************************************************************ Sum Insured Ranges Elements **********************************************************************************************
	@FindBy(css = "#P13_REPORT_TYPE")
	public WebElement ReportTypeCombobox;

	@FindBy(css = "#P13_REPORT_VALUE")
	public WebElement ReportValueCombobox;

	@FindBy(css = "#IVD_ID_ig")
	public WebElement SumInsuredRangesTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement SumInsuredRangesAddRowButton;


	// ************************************************************ Short Period Tariff Elements **********************************************************************************************
	@FindBy(css = "#P17_CLASS")
	public WebElement ClassCombobox;

	@FindBy(css = "#P17_POLICY")
	public WebElement PolicyTypeCombobox;

	@FindBy(css = "#SPT_ID_ig")
	public WebElement ShortPeriodTariffTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement ShortPeriodTariffAddRowButton;

	// ************************************************************ Pro-Rata Period Tariff Elements **********************************************************************************************

	@FindBy(css = "#PRO_IG_ig")
	public WebElement ProRataPeriodTariffTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement ProRataPeriodTariffAddRowButton;

	// ************************************************************ Locations and Branches Elements **********************************************************************************************

	@FindBy(css = "#P12_LOCATION")
	public WebElement LocationCombobox;

	@FindBy(css = "#LOCB_ig")
	public WebElement LocationsAndBranchesTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement LocationsAndBranchesAddRowButton;

	// ************************************************************ Class-Subclass Linking Elements **********************************************************************************************

	@FindBy(css = "#RCLASS_ig")
	public WebElement ClassTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement ClassAddRowButton;

	@FindBy(css = "#SC_IG_ig")
	public WebElement SubClassTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement SubClassAddRowButton;

	// ************************************************************ Customers Address Screen Elements **********************************************************************************************

	@FindBy(css = "#CAS_ID_ig")
	public WebElement CustomerAddressTable;

	@FindBy(xpath = "//span[normalize-space()='Add Address']")
	public WebElement CustomerAddressAddRowButton;

	@FindBy(css = "#R217780171403918608 .t-Region-body")
	public WebElement CustomerAddressRegionBody;


	// ************************************************************ Users Definition Elements **********************************************************************************************

	@FindBy(xpath = "//span[normalize-space()='New User']")
	public WebElement UsersDefinitionNewUserButton;

	@FindBy(css = "#R131872538074084355 .t-Region-body")
	public WebElement UserDefinitionRegionBody;

	@FindBy(css = "#P22_USER_ENAME")
	public WebElement EnUserNameInput;

	@FindBy(css = "#P22_USER_ENAME_error")
	public WebElement EnUserNameErrorMsg;

	@FindBy(css = "#P22_USER_ID")
	public WebElement UserIdInput;

	@FindBy(css = "#P22_USER_ID_error")
	public WebElement UserIdErrorMsg;

	@FindBy(css = "#P22_USER_ANAME")
	public WebElement ArUserNameInput;

	@FindBy(css = "#P22_USER_ANAME_error")
	public WebElement ArUserNameErrorMsg;

	@FindBy(css = "#P22_USER_EMAIL")
	public WebElement UserEmailInput;

	@FindBy(css = "#P22_USER_EMAIL_error")
	public WebElement UserEmailErrorMsg;

	@FindBy(css = "#P22_USER_MOBILE")
	public WebElement UserMobileInput;

	@FindBy(css = "#P22_USER_MANAGER")
	public WebElement UserManagerInput;

	@FindBy(css = "#P22_USER_PASSWORD")
	public WebElement UserPasswordInput;

	@FindBy(css = "#P22_USER_PASSWORD_error")
	public WebElement UserPasswordErrorMsg;

	@FindBy(css = "#P22_CONFIRM_PASSWORD")
	public WebElement ConfirmPasswordInput;

	@FindBy(css = "#P22_CONFIRM_PASSWORD_error")
	public WebElement ConfirmPasswordErrorMsg;

	@FindBy(css = "#P22_USER_PASSWORD_EXP")
	public WebElement PasswordExpiryInput;

	@FindBy(css = "#P22_USER_DEFAULT_BRANCH")
	public WebElement UserDefaultBranchCombobox;

	@FindBy(css = "#P22_USER_DEFAULT_OFFICE")
	public WebElement UserDefaultOfficeCombobox;

	@FindBy(css = "#P22_USER_DEFAULT_REGION")
	public WebElement UserDefaultRegionCombobox;

	@FindBy(css = "#P22_USER_ACTUAL_OFFICE")
	public WebElement UserActualOfficeCombobox;

	@FindBy(css = "#P22_USER_DEPT_NO")
	public WebElement UserDeptNoCombobox;

	@FindBy(css = "#P22_USER_SUFLAG")
	public WebElement UserTypeCombobox;

	@FindBy(css = "#P22_USER_SUFLAG_error")
	public WebElement UserTypeErrorMsg;

	@FindBy(css = "#P22_USER_GROUP")
	public WebElement UserGroupCombobox;

	@FindBy(css = "#P22_USER_AUTHORIZED")
	public WebElement UserAuthorizedCombobox;

	@FindBy(css = "#P22_USER_LANGUAGE")
	public WebElement UserLanguageCombobox;

	@FindBy(css = "#P22_USER_ROLE_ID")
	public WebElement UserRoleIdCombobox;

	@FindBy(css = "#P22_USER_ROLE_ID_lov_btn")
	public WebElement UserRoleIdButton;

	@FindBy(css = "#PopupLov_22_P22_USER_ROLE_ID_dlg input[aria-label='Search']")
	public WebElement UserRoleIdPopupLOVSearchBar;

	@FindBy(css = "#P22_USER_WS_TYPE")
	public WebElement WorkshopTypesCombobox;

	@FindBy(css = "#PopupLov_22_P22_USER_WS_TYPE_dlg input[aria-label='Search']")
	public WebElement WorkshopTypesPopupLOVSearchBar;

	@FindBy(css = "#P22_USER_WF")
	public WebElement WorkFlowCombobox;

	@FindBy(css = "#P22_USER_USER_TYPE")
	public WebElement SellerTypeCombobox;

	@FindBy(css = "#P22_USR_MENAPAY_NO")
	public WebElement MenapayEmployeeNoInput;

	@FindBy(css = "#P22_USER_DMS_USER")
	public WebElement MappedDmsUserInput;

	@FindBy(css = "#P22_USER_APPLICATION_TYPE")
	public WebElement ApplicationTypeCombobox;

	@FindBy(css = "#P22_USER_REMARKS")
	public WebElement RemarksInput;

	@FindBy(css = "#P22_USER_TYPE_0")
	public WebElement UserTypeAgentRadio;

	@FindBy(xpath = "//label[normalize-space()='Agent/Broker']")
	public WebElement UserTypeAgentRadioLabel;

	@FindBy(css = "#P22_USER_TYPE_1")
	public WebElement UserTypeClientRadio;

	@FindBy(css = "#P22_USER_TYPE_error")
	public WebElement UserTypePortalErrorMsg;

	@FindBy(css = "#P22_USER_CREATED_DT")
	public WebElement UserCreatedDateInput;

	@FindBy(css = "#USER_IG_ig_toolbar_search_field")
	public WebElement SearchFieldUserTable;

	@FindBy(css = "#USER_IG")
	public WebElement UserTable;

	// ************************************************************ Roles Definition Elements **********************************************************************************************

	@FindBy(css = "#ROLES_ig")
	public WebElement RolesTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement RolesAddRowButton;

	@FindBy(css = "#roleDet_ig")
	public WebElement RolesDetTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement RolesDetAddRowButton;

	// ************************************************************ Users' Privileges On Locations & Branches Elements **********************************************************************************************

	@FindBy(css = "#P32_USERS")
	public WebElement UsersDDL;

	@FindBy(css = ".a-RDS-link[href='#loc']")
	public WebElement LocationTab;

	@FindBy(css = "#loc_ig")
	public WebElement LocationTable;

	@FindBy(xpath = "(//span[contains(@class,'a-Button-label')][normalize-space()='Add Row'])[1]")
	public WebElement LocationAddRowButton;

	@FindBy(css = "#loc_ig_grid_vc")
	public WebElement UserRoleTable;

	@FindBy(xpath = "(//span[contains(@class,'a-Button-label')][normalize-space()='Add Row'])[2]")
	public WebElement UserRoleAddRowButton;


	// ************************************************************ Change Password Elements **********************************************************************************************

	@FindBy(css = "#P27_USER_ID_DISPLAY")
	public WebElement UserIdValue;

	@FindBy(css = "#P27_USER_ENAME_DISPLAY")
	public WebElement UserENameValue;

	@FindBy(xpath = "//span[normalize-space()='Apply Changes']")
	public WebElement ChangePasswordApplyChangesButton;

	@FindBy(css = "#P27_USER_PASSWORD")
	public WebElement ChangePasswordUserPasswordInput;

	@FindBy(css = "#P27_USER_PASSWORD_error")
	public WebElement ChangePasswordUserPasswordErrorMsg;

	@FindBy(css = "#P27_CONFIRM_PASSWORD")
	public WebElement ChangePasswordConfirmPasswordInput;

	@FindBy(css = "#P27_CONFIRM_PASSWORD_error")
	public WebElement ChangePasswordConfirmPasswordErrorMsg;

	@FindBy(css = "#P27_CONFIRM_PASSWORD_error_placeholder")
	public WebElement ChangePasswordConfirmPasswordErrorMsgPlaceHolder;


	// ************************************************************  Elements **********************************************************************************************

	@FindBy(css = "#P31_PROGRAM")
	public WebElement ProgramCombobox;

	@FindBy(css = "#AB_ID_ig")
	public WebElement AuthorizedButtonsTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement AuthorizedButtonsApplyChangesButton;

	// ************************************************************ User Privileges On Endt Transactions Elements **********************************************************************************************

	@FindBy(css = "#P57_USER_NO")
	public WebElement UserNoCombobox;

	@FindBy(css = "#P57_CLASS_NO")
	public WebElement ClassNoCombobox;

	@FindBy(css = "#P57_TYPE_NO")
	public WebElement TypeNoCombobox;

	@FindBy(css = "#PopupLov_57_P57_TYPE_NO_dlg input[aria-label='Search']")
	public WebElement TypeNoPopupLOVSearchBar;

	@FindBy(css = "#P57_SOURCE")
	public WebElement SourceCombobox;

	@FindBy(css = "#TRANS_ID_ig")
	public WebElement TransactionTypeTable;

	@FindBy(xpath = "(//button[@data-action='selection-add-row'])[1]")
	public WebElement TransactionTypeAddRow;


	// ************************************************************ User Privileges On Claim Payments  Elements **********************************************************************************************

	@FindBy(css = "#P54_USER")
	public WebElement UserCombobox;

	@FindBy(css = "#P54_AUTHORITY")
	public WebElement AuthorityCombobox;

	@FindBy(css = "#UAP_ID_ig")
	public WebElement UAPTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement UAPAddRow;


	// ************************************************************ User Access Violations Elements **********************************************************************************************

	@FindBy(css = "#UAV_ID_ig")
	public WebElement UserAccessViolationsTable;

	@FindBy(xpath = "(//div[@class='apex-item-option'])[1]")
	public WebElement SuccessRadioButtons;

	@FindBy(xpath = "(//div[@class='apex-item-option'])[2]")
	public WebElement ViolationRadioButtons;


	// ************************************************************ User Privileges On Quotation Posting Elements **********************************************************************************************

	@FindBy(css = "#P30_USER_ID")
	public WebElement UserIdCombobox;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement UserQuotationPostingAddRow;

	@FindBy(css = "#UQP_ID_ig")
	public WebElement UserQuotationPostingTable;


	// ************************************************************ Link Region/City Screen Elements **********************************************************************************************

	@FindBy(css = "#P34_RANGES")
	public WebElement RangesCombobox;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement RangesAddRow;

	@FindBy(css = "#OFF_RANGE_ID_ig")
	public WebElement RangesTable;


	// ************************************************************ Effective Date Grace Period Elements **********************************************************************************************

	@FindBy(css = "#EDG_IG_ig")
	public WebElement EffectiveDateGraceTable;

	@FindBy(css = "iframe[title='Effective Date Grace Period']")
	public WebElement EffectiveDateGracePeriodIframe;

	@FindBy(css = "#P36_DEPT_NO")
	public WebElement DeptNoCombobox;

	@FindBy(css = "#P36_DEPT_NO_error")
	public WebElement DeptNoErrorMsg;

//	@FindBy(css = "#PopupLov_36_36_DEPT_NO_dlg input[aria-label='Search']")
//	public WebElement DeptNoPopupLOVSearchBar;

	@FindBy(css = "#P36_CLASS_NO")
	public WebElement ClassNoEDGPCombobox;

	@FindBy(css = "div[id='PopupLov_36_P36_CLASS_NO_dlg'] input[aria-label='Search']")
	public WebElement ClassNoEDGPPopupLOVSearchBar;

	@FindBy(css = "#P36_CLASS_NO_error")
	public WebElement ClassNoEDGPErrorMsg;

	@FindBy(css = "#P36_POLICY_TYPE")
	public WebElement PolicyTypeEDGPCombobox;

	@FindBy(css = "div[id='PopupLov_36_P36_POLICY_TYPE_dlg'] input[aria-label='Search']")
	public WebElement PolicyTypeEDGPPopupLOVSearchBar;

	@FindBy(css = "#P36_POLICY_TYPE_error")
	public WebElement PolicyTypeEDGPErrorMsg;

	@FindBy(css = "#P36_ENDT_TYPE")
	public WebElement EndorsementTypeCombobox;

	@FindBy(css = "div[id='PopupLov_36_P36_ENDT_TYPE_dlg'] input[aria-label='Search']")
	public WebElement EndorsementTypePopupLOVSearchBar;

	@FindBy(css = "#P36_NO_OF_DAYS")
	public WebElement FutureNoOfDaysInput;

	@FindBy(css = "#P36_NO_OF_DAYS_error")
	public WebElement FutureNoOfDaysErrorMsg;

	@FindBy(css = "#P36_BACKDATED_NO_OF_DAYS")
	public WebElement BackdatedNoOfDaysInput;

	@FindBy(css = "#P36_BACKDATED_NO_OF_DAYS_error")
	public WebElement BackdatedNoOfDaysErrorMsg;

	// ************************************************************ Control Dates Elements **********************************************************************************************

	@FindBy(css = "#CD_IG_ig")
	public WebElement ControlDatesTable;

	@FindBy(css = "iframe[title='Control Dates ']")
	public WebElement ControlDatesIframe;

	@FindBy(css = "#P56_CD_BRCH_NO")
	public WebElement LocationCDCombobox;

	@FindBy(css = "#P56_CD_BRCH_NO_error")
	public WebElement LocationCDErrorMsg;

	@FindBy(css = "#P56_CD_OFFC_NO")
	public WebElement BranchCombobox;

	@FindBy(css = "div[id='PopupLov_56_P56_CD_OFFC_NO_dlg'] input[aria-label='Search']")
	public WebElement BranchEDGPPopupLOVSearchBar;

	@FindBy(css = "#P56_CD_OFFC_NO_error")
	public WebElement BranchErrorMsg;

	@FindBy(css = "#P56_CD_PROG_NO")
	public WebElement ProgramCDCombobox;

	@FindBy(css = "div[id='PopupLov_56_P56_CD_PROG_NO_dlg'] input[aria-label='Search']")
	public WebElement ProgramCDPopupLOVSearchBar;

	@FindBy(css = "#P56_CD_PROG_NO_error")
	public WebElement ProgramCDErrorMsg;

	@FindBy(css = "#P56_CD_MONTH")
	public WebElement MonthInput;

	@FindBy(css = "#P56_CD_MONTH_error")
	public WebElement MonthErrorMsg;

	@FindBy(css = "#P56_CD_YEAR")
	public WebElement YearInput;

	@FindBy(css = "#P56_CD_YEAR_error")
	public WebElement YearErrorMsg;

	@FindBy(css = "#P56_CD_STATUS")
	public WebElement StatusCombobox;

	@FindBy(css = "div[id='PopupLov_56_P56_CD_STATUS_dlg'] input[aria-label='Search']")
	public WebElement StatusPopupLOVSearchBar;

	@FindBy(css = "#P56_CD_STATUS_error")
	public WebElement StatusErrorMsg;

	// ************************************************************ Commision Definition Elements **********************************************************************************************

	@FindBy(css = "#CD_IG_ig")
	public WebElement CommissionDefinitionTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement CommissionDefinitionAddRowButton;


	// ************************************************************ Import From Excel Advanced Elements **********************************************************************************************

	@FindBy(xpath = "//button[.//span[normalize-space()='Start Import']]")
	public WebElement StartImportButton;

	@FindBy(xpath = "//span[normalize-space()='Clear']")
	public WebElement ClearButton;

	@FindBy(css = "#P59_XMR_ID")
	public WebElement DescriptionCombobox;

	@FindBy(css = "#P59_XMR_ID_error")
	public WebElement DescriptionErrorMsg;

	@FindBy(css = "#P59_XMR_TABLE_OWNER")
	public WebElement OwnerInput;

	@FindBy(css = "#P59_XMR_TABLE_NAME")
	public WebElement TableNameInput;

	@FindBy(css = "#P59_XMR_NO_OF_COLUMNS")
	public WebElement NoOfColumnsInput;

	@FindBy(css = "#P59_XMR_NO_OF_COLUMNS_error")
	public WebElement NoOfColumnsErrorMsg;

	// ************************************************************ Excel Defintion Elements **********************************************************************************************

	@FindBy(css = "#ED_ID_ig")
	public WebElement ExcelDefintionTable;

	@FindBy(css = "#COL_ID_ig")
	public WebElement ColumnsTable;

	@FindBy(css = "#P49_XMR_DESCRIPTION")
	public WebElement DescriptionEDInput;

	@FindBy(css = "#P49_XMR_DESCRIPTION_error")
	public WebElement DescriptionEDErrorMsg;

	@FindBy(css = "#P49_XMR_TABLE_OWNER")
	public WebElement TableOwnerCombobox;

	@FindBy(css = "#P49_XMR_TABLE_OWNER_error")
	public WebElement TableOwnerErrorMsg;

	@FindBy(css = "#P49_XMR_TABLE_NAME")
	public WebElement TableNameCombobox;

	@FindBy(css = "#P49_XMR_TABLE_NAME_error")
	public WebElement TableNameErrorMsg;

	@FindBy(css = "#P49_XMR_NO_OF_COLUMNS")
	public WebElement NoOfColumnsEDInput;

	@FindBy(css = "#P49_XMR_NO_OF_COLUMNS_error")
	public WebElement NoOfColumnsEDErrorMsg;


	// ************************************************************ Mail And SMS Notification Configuration Elements **********************************************************************************************

	@FindBy(css = "#MSNC_ID_ig")
	public WebElement MailAndSmsNotificationConfigurationTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement MailAndSmsNotificationConfigurationAddRowButton;


	// ************************************************************ Mail Setup Elements **********************************************************************************************

	@FindBy(css = "#MAIL_IG_ig")
	public WebElement MailSetupTable;

	@FindBy(css = "iframe[title='Mail Setup']")
	public WebElement MailSetupIframe;

	@FindBy(css = "#P42_MAIL_SMTP")
	public WebElement EmailSmtpInput;

	@FindBy(css = "#P42_MAIL_SMTP_error")
	public WebElement EmailSmtpErrorMsg;

	@FindBy(css = "#P42_MAIL_PORT")
	public WebElement SmtpPortInput;

	@FindBy(css = "#P42_MAIL_PORT_error")
	public WebElement SmtpPortErrorMsg;


	// ************************************************************ Mail and SMS Notifications Elements **********************************************************************************************

	@FindBy(css = "#REPORT_ID")
	public WebElement MSNotificationReportTable;


	// ************************************************************ SMS Notifications Elements **********************************************************************************************

	@FindBy(css = "#REPORT_ID")
	public WebElement SmsNotificationTable;


	// ************************************************************ SMS GateWay Definition Elements **********************************************************************************************

	@FindBy(css = "#SGD_IG_ig")
	public WebElement SmsGateWayDefinitionTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement SmsGateWayDefinitionAddRowButton;


	// ************************************************************ Map AMAN Fields with WF Attributes Elements **********************************************************************************************

	@FindBy(css = "#MASTER_ID_ig")
	public WebElement MapAmanFieldsWithWFAttributesMasterTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement MapAmanFieldsWithWFAttributesMasterAddRowButton;

	@FindBy(css = "#DETAIL_ID_ig")
	public WebElement MapAmanFieldsWithWFAttributesDetailsTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement MapAmanFieldsWithWFAttributesDetailsAddRowButton;


	// ************************************************************ Workflow Build Queries Elements **********************************************************************************************

	@FindBy(css = "#TABLES_ig")
	public WebElement QueryTable;

	@FindBy(xpath = "//div[@id='TABLES_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement QueryAddRowButton;

	@FindBy(css = "#COLUMNS_ig")
	public WebElement QueryColumnsTable;

	@FindBy(xpath = "//div[@id='COLUMNS_ig_toolbar']//span[contains(@class,'a-Button-label')][normalize-space()='Add Row']")
	public WebElement QueryColumnsAddRowButton;

	@FindBy(css = "#QU_COND_ig")
	public WebElement QueryConditionsTable;

	@FindBy(xpath = "//div[@id='QU_COND_ig_toolbar']//span[contains(@class,'a-Button-label')][normalize-space()='Add Row']")
	public WebElement QueryConditionsAddRowButton;

	@FindBy(css = "#JOIN_ig")
	public WebElement QueryJoinTable;

	@FindBy(xpath = "//div[@id='JOIN_ig_toolbar']//span[contains(@class,'a-Button-label')][normalize-space()='Add Row']")
	public WebElement QueryJoinAddRowButton;


	// ************************************************************ Workflow Services Setup Elements **********************************************************************************************

	@FindBy(css = "#WF_IG_ig")
	public WebElement WorkflowServicesSetupTable;

	@FindBy(css = "#WF_IG_ig_toolbar_btn-add_wf")
	public WebElement AddServiceSetupButton;

	@FindBy(css = "iframe[title='Workflow Services Setup']")
	public WebElement WorkflowServicesSetupIframe;

	@FindBy(css = "#P61_WAS_API_ID")
	public WebElement ProcessCombobox;

	@FindBy(css = "#P61_WAS_API_ID_error")
	public WebElement ProcessErrorMsg;

	@FindBy(css = "#P61_WAS_API_STATUS")
	public WebElement ApiStatusCombobox;

	@FindBy(css = "#P61_WAS_API_STATUS_error")
	public WebElement ApiStatusErrorMsg;

	@FindBy(css = "div[id='PopupLov_61_P61_WAS_API_STATUS_dlg'] input[aria-label='Search']")
	public WebElement ApiStatusPopupLOVSearchBar;

	@FindBy(css = "#P61_WAS_DEPT_NO")
	public WebElement DepartmentCombobox;

	@FindBy(css = "#P61_WAS_DEPT_NO_error")
	public WebElement DepartmentErrorMsg;

	@FindBy(css = "div[id='PopupLov_61_P61_WAS_DEPT_NO_dlg'] input[aria-label='Search']")
	public WebElement DepartmentPopupLOVSearchBar;

	@FindBy(css = "#P61_WAS_API_URL")
	public WebElement UrlInput;

	@FindBy(css = "#P61_WAS_API_URL_error")
	public WebElement UrlErrorMsg;

	@FindBy(css = "#P61_WAS_USER_NAME")
	public WebElement UserNameInput;

	@FindBy(css = "#P61_WAS_USER_NAME_error")
	public WebElement UserNameErrorMsg;

	@FindBy(css = "#P61_WAS_PASSWORD")
	public WebElement PasswordWSSInput;

	@FindBy(css = "#P61_WAS_PASSWORD_error")
	public WebElement PasswordWSSErrorMsg;



	// ************************************************************************************************************************************************************************************
	// ************************************************************************************************************************************************************************************
	/**
	 *
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
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), Duration.ofSeconds(5));

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		if ("accept".equalsIgnoreCase(decision)) {
			alert.accept();   // clicks Reload
		} else {
			alert.dismiss();  // clicks Cancel
		}
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

	public boolean isElementVisibleSafe(String elementName) {
		try {
			WebElement el = getElement(this, elementName); // no long wait
			return el != null && el.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void assertApexTabSelected(String elementName, boolean shouldBeSelected) throws Exception {
		WebElement tab = getElementWithWait(this, elementName);

		// APEX RDS tabs usually mark selection here
		String ariaSelected = tab.getAttribute("aria-selected");
		boolean isSelected = "true".equalsIgnoreCase(ariaSelected);

		// Fallback: sometimes selection is on the parent <li>
		if (ariaSelected == null || ariaSelected.trim().isEmpty()) {
			try {
				WebElement li = tab.findElement(By.xpath("./ancestor::li[1]"));
				String liClass = li.getAttribute("class");
				isSelected = liClass != null && (
						liClass.contains("apex-rds-selected") ||
								liClass.contains("a-RDS-selected") ||
								liClass.contains("is-active")
				);
			} catch (Exception ignored) {
				// keep isSelected as-is
			}
		}

		if (shouldBeSelected && !isSelected) {
			throw new AssertionError("Expected tab '" + elementName + "' to be selected, but it is not.");
		}
		if (!shouldBeSelected && isSelected) {
			throw new AssertionError("Expected tab '" + elementName + "' to be NOT selected, but it is selected.");
		}

		log.info("Tab '" + elementName + "' selected=" + isSelected);
	}
}
