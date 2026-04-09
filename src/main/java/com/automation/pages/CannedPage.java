package com.automation.pages;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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

	@FindBy(css = "div[role='alert']")
	public WebElement SuccessfullyAlert;

	@FindBy(css = "div[role='alert']")
	public WebElement ErrorAlert;

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

	@FindBy(xpath = "//button[normalize-space()='OK']")
	public WebElement OkButton;

	@FindBy(css = "div[class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog--apex t-Dialog-page--standard ui-draggable'] button[title='Close']")
	public WebElement CloseButtonFromPopup;

	@FindBy(xpath = "//span[normalize-space()='Add a Customer']")
	public WebElement AddACustomerButton;

	@FindBy(css = ".a-AlertMessage-body")
	public WebElement AlertMsgBody;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement CancelAlertButton;

	@FindBy(css = "div[role='alertdialog']")
	public WebElement AlertDialog;

// ************************************************************ Elements **********************************************************************************************

	@FindBy(css = "#t_Button_navControl")
	public WebElement navControlButton;

// **************************** Side Menu Main ****************************
	@FindBy(xpath = "//a[normalize-space()='Home']")
	public WebElement HomeSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Control and Monitering']")
	public WebElement ControlAndMoniteringSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Quotations']")
	public WebElement QuotationsSideMenu;

	@FindBy(xpath = "//span[normalize-space()='FGA']")
	public WebElement FGASideMenu;

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

	@FindBy(xpath = "//span[normalize-space()='Codes Definition Linking Setup']")
	public WebElement CodesDefinitionLinkingSetupSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Premium Tariffs Setup']")
	public WebElement PremiumTariffsSetupSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Malpractice Setup']")
	public WebElement MalpracticeSetupSideMenu;

	@FindBy(xpath = "//span[normalize-space()='Travel Setup']")
	public WebElement TravelSetupSideMenu;

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

	@FindBy(xpath = "//a[normalize-space()='FGA Address']")
	public WebElement FGAAddressSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Household Contents Definition']")
	public WebElement HouseholdContentsDefinitionSideMenu;

	@FindBy(xpath = "//a[normalize-space()='FGA Rates Tariff']")
	public WebElement FGARatesTariffSideMenu;

	@FindBy(xpath = "//a[normalize-space()='FGA Rates (Percentages&Permils)']")
	public WebElement FGARatesPercentagesPermilsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Short Period Tariff (FGA Endorsement)']")
	public WebElement ShortPeriodTariffFGAEndorsementSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Earthquake Rate']")
	public WebElement EarthquakeRateSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Categories-Professions Definition']")
	public WebElement CategoriesProfessionsDefinitionSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Coverage Limit AOO-AAA']")
	public WebElement CoverageLimitAOO_AAASideMenu;

	@FindBy(xpath = "//a[normalize-space()='Malpractice Tariff Definition']")
	public WebElement MalpracticeTariffDefinitionSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Malpractice Questions']")
	public WebElement MalpracticeQuestionsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='MMP Periods']")
	public WebElement MMPPeriodsSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Travel Calculation Prices']")
	public WebElement TravelCalculationPricesSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Travel Days']")
	public WebElement TravelDaysSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Key Benefits']")
	public WebElement KeyBenefitsSideMenu;

// **************************** Card Dashboard ****************************
	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	public WebElement DashboardButton;

	@FindBy(xpath = "//h3[normalize-space()='Quotations']")
	public WebElement QuotationCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='Control and Monitering']")
	public WebElement ControlAndMoniteringCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='System Code Ranks']")
	public WebElement SystemCodeRanksCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='General']")
	public WebElement GeneralCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='Motor']")
	public WebElement MotorCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='FGA']")
	public WebElement FGACardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='Accounting']")
	public WebElement AccountingCardDashboard;

	@FindBy(xpath = "//h3[normalize-space()='Re-insurance']")
	public WebElement ReInsuranceCardDashboard;

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

	@FindBy(xpath = "(//h2[normalize-space()='Customers Receivable'])[1]")
	public WebElement CustomersReceivableTariffTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Payable Parties'])[1]")
	public WebElement PayablePartiesTitle;

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

	@FindBy(xpath = "//h1[normalize-space()='FGA Address']")
	public WebElement FGAAddressTitle;

	@FindBy(xpath = "//h1[normalize-space()='FGA Rates Tariff']")
	public WebElement FGARatesTariffTitle;

	@FindBy(xpath = "//h1[normalize-space()='FGA Rates (Percentages & Permils)']")
	public WebElement FGARatesPercentagesPermilsTitle;

	@FindBy(xpath = "//h1[normalize-space()='Short Period Tariff(FGA Enorsement)']")
	public WebElement ShortPeriodTariffFGAEndorsementTitle;

	@FindBy(xpath = "//h1[normalize-space()='Earthquake Rate']")
	public WebElement EarthquakeRateTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Coverage Limit AOO-AAA'])[1]")
	public WebElement CoverageLimitAOO_AAATitle;

	@FindBy(xpath = "(//h2[normalize-space()='Malpractice Tariff Definition'])[1]")
	public WebElement MalpracticeTariffDefinitionTitle;

	@FindBy(xpath = "(//h2[normalize-space()='Malpractice Questions'])[1]")
	public WebElement MalpracticeQuestionsTitle;

	@FindBy(xpath = "(//h2[normalize-space()='MMP Periods'])[1]")
	public WebElement MMPPeriodsTitle;

	@FindBy(xpath = "//h1[normalize-space()='Travel Calculation Prices']")
	public WebElement TravelCalculationPricesTitle;

	@FindBy(xpath = "//h1[normalize-space()='Travel Days']")
	public WebElement TravelDaysTitle;

	@FindBy(xpath = "//h1[normalize-space()='Key Benefits']")
	public WebElement KeyBenefitsTitle;

	@FindBy(xpath = "(//h1[normalize-space()='Motor'])[1]")
	public WebElement MotorTitle;

	@FindBy(xpath = "(//h1[normalize-space()='FGA'])[1]")
	public WebElement FGATitle;

	@FindBy(xpath = "(//h1[normalize-space()='Accounting'])[1]")
	public WebElement AccountingTitle;

	@FindBy(xpath = "(//h1[normalize-space()='Re-Insurance'])[1]")
	public WebElement ReInsuranceTitle;

// **************************** General ****************************
	@FindBy(xpath = "//h3[normalize-space()='4-Jeddah Claim Center']")
	public WebElement JeddahClaimCenterCard;
	@FindBy(xpath = "//h3[normalize-space()='24-SP Waziriyah Mrorr']")
	public WebElement SPWaziriyahMrorrCard;

	@FindBy(css = "#OFF_QUT_IG_ig_toolbar_btn-add_off_qut")
	public WebElement NewQuotationButton;

	@FindBy(css = "#OFF_QUT_IG_ig_toolbar_search_field")
	public WebElement SearchQuotationInput;

	@FindBy(css = "#C156602956249693875_HDR")
	public WebElement QuotationNumberTable;

	@FindBy(css = "#OFF_QUT_IG_ig_column_header_search")
	public WebElement QuotationNumberSearch;

	@FindBy(xpath = "(//img[@class='apex-edit-pencil'])[1]")
	public WebElement EditQuotationImg;

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

	@FindBy(css = "#OFF_QUT_IG_ig_FD_TYPE")
	public WebElement TypeFilterDDL;

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

	@FindBy(xpath = "(//td[@role='gridcell'])[1]")
	public WebElement EditPinButtonMultiRows;


	@FindBy(css = "td[role='gridcell'] a[class='disabled']")
	public WebElement RevisionIconDisable;
	@FindBy(css = "tbody tr[role='row'] td:nth-child(2) a:nth-child(1)")
	public WebElement RevisionIconEnable;

	@FindBy(xpath = "//span[normalize-space()='Main Quotations']")
	public WebElement MainQuotationsButton;

	@FindBy(css = "button[title='Remove Filter']")
	public WebElement RemoveFilterButton;

	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
	public WebElement FirstClassOfBusInTable;

	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(8)")
	public WebElement FirstIssueDateInTable;

// ************************************************************ Quotation Details Elements **********************************************************************************************

	@FindBy(css = "#P101_QUT_CLASS_OF_BUSINESS_DISPLAY")
	public WebElement QutClassOfBusinessDisplay;

	@FindBy(css = "#P101_QUT_POLICY_TYPE_DISPLAY")
	public WebElement QutPolicyTypeDisplay;

	@FindBy(css = "#P101_QUT_QUOT_STATUS_DISPLAY")
	public WebElement QutStatusDisplay;

	@FindBy(css = "#P101_QUT_VALID_STATUS_DISPLAY")
	public WebElement QutValidityStatusDisplay;

	@FindBy(xpath = "//span[normalize-space()='Main']")
	public WebElement MainTab;

	@FindBy(xpath = "//span[normalize-space()='Motor Information']")
	public WebElement MotorInformationTab;

	@FindBy(xpath = "//span[normalize-space()='Calculations']")
	public WebElement CalculationsTab;

	@FindBy(css = "#P101_QUT_SOURCE")
	public WebElement QutSourceCombobox;

	@FindBy(css = "#P101_QUT_SOURCE_error")
	public WebElement QutSourceErrorMsg;

	@FindBy(css = "#P101_QUT_PAYMENT_TERM")
	public WebElement QutPaymentTermCombobox;

	@FindBy(css = "#P101_QUT_QUOT_DT")
	public WebElement QutQuotDate;

	@FindBy(css = "#P101_QUT_QUOT_VALIDITY_DT")
	public WebElement QutQuotValidityDate;

	@FindBy(css = "#P101_QUT_INS_ST_DT_input")
	public WebElement QutInsStDateInput;

	@FindBy(css = "#P101_QUT_INS_ST_DT_error")
	public WebElement QutInsStDateErrorMsg;

	@FindBy(css = "#P101_QUT_INS_ED_DT_input")
	public WebElement QutInsEdDateInput;

	@FindBy(css = "#P101_QUT_INS_ED_DT_error")
	public WebElement QutInsEdDateErrorMsg;

	@FindBy(css = "#P101_QUT_AWARDED_TO")
	public WebElement QutAwardedToInput;

	@FindBy(css = "#P101_QUT_AWARDED_TO_error")
	public WebElement QutAwardedToErrorMsg;

	@FindBy(css = "#P101_QUT_CALCULATION_BASIS")
	public WebElement QutCalculationBasisCombobox;

	@FindBy(css = "#P101_QUT_CALCULATION_BASIS_error")
	public WebElement QutCalculationBasisErrorMsg;

	@FindBy(css = "#P101_QUT_CR_CD")
	public WebElement QutCrCdCombobox;

	@FindBy(css = "#P101_QUT_CR_CD_error")
	public WebElement QutCrCdErrorMsg;

	@FindBy(css = "#P101_QUT_BUSINESS_TYPE")
	public WebElement QutBusinessTypeCombobox;

	@FindBy(css = "#P101_QUT_UNIT_PRICE")
	public WebElement QutUnitPriceVal;

	@FindBy(css = "#P101_QUT_QUOT_NO_DISPLAY")
	public WebElement QutQuotNoCreateText;


	// ************************************************************ Risk Details Elements **********************************************************************************************
	@FindBy(css = "#RisksQuery_ig")
	public WebElement RiskTable;

	@FindBy(xpath = "//span[normalize-space()='Risk']")
	public WebElement RiskButton;

	@FindBy(css = "iframe[title='Motor Risk']")
	public WebElement MotorRiskIframe;

	@FindBy(css = "#P102_QUR_VEHICLE_MAKE")
	public WebElement QurVehicleMakeCombobox;

	@FindBy(css = "#P102_QUR_VEHICLE_MAKE_error")
	public WebElement QurVehicleMakeErrorMsg;

	@FindBy(css = "#P102_QUR_VEHICLE_MODEL")
	public WebElement QurVehicleModelCombobox;

	@FindBy(css = "#P102_QUR_VEHICLE_MODEL_error")
	public WebElement QurVehicleModelErrorMsg;

	@FindBy(css = "div[id='PopupLov_102_P102_QUR_VEHICLE_MODEL_dlg'] input[aria-label='Search']")
	public WebElement QurVehicleModelPopupLOVSearchBar;

	@FindBy(css = "#P102_QUR_YEAR_OF_MAKE_PICKER")
	public WebElement QurYearOfMakeInput;

	@FindBy(css = "#P102_QUR_YEAR_OF_MAKE_PICKER_error")
	public WebElement QurYearOfMakeErrorMsg;

	@FindBy(css = ".datepicker--button")
	public WebElement QurYearOfMakeTodayButton;

	@FindBy(css = "#P102_QUR_CHASSIS_NO")
	public WebElement QurChassisNoInput;

	@FindBy(css = "#P102_QUR_CHASSIS_NO_error")
	public WebElement QurChassisNoErrorMsg;

	@FindBy(css = "#P102_QUR_REGISTRATION_NO")
	public WebElement QurRegistrationNoInput;

	@FindBy(css = "#P102_QUR_REGISTRATION_NO_error")
	public WebElement QurRegistrationNoErrorMsg;

	@FindBy(css = "#P102_QUR_TYPE_OF_BODY")
	public WebElement QurTypeOfBodyCombobox;

	@FindBy(css = "#P102_QUR_TYPE_OF_BODY_error")
	public WebElement QurTypeOfBodyErrorMsg;

	@FindBy(css = "div[id='PopupLov_102_P102_QUR_TYPE_OF_BODY_dlg'] input[aria-label='Search']")
	public WebElement QurTypeOfBodyPopupLOVSearchBar;

	@FindBy(css = "#P102_QUR_VEHICLE_COLOR")
	public WebElement QurVehicleColorCombobox;

	@FindBy(css = "#P102_QUR_VEHICLE_COLOR_error")
	public WebElement QurVehicleColorErrorMsg;

	@FindBy(css = "div[id='PopupLov_102_P102_QUR_VEHICLE_COLOR_dlg'] input[aria-label='Search']")
	public WebElement QurVehicleColorPopupLOVSearchBar;

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

	@FindBy(xpath = "//span[normalize-space()='Back']")
	public WebElement RiskDetailsBackButton;

	@FindBy(xpath = "(//span[@class='t-Button-label'][normalize-space()='Cancel'])[1]")
	public WebElement RiskDetailsCancelButton;

	@FindBy(css = "td[role='gridcell'] a[title='Covers']")
	public WebElement VehicleDetailsButton;

	@FindBy(css = "#P49_PREM_DET")
	public WebElement VehiclePremiumDetailsDDL;

	@FindBy(xpath = "//td[@role='gridcell']//span[@class='fa fa-user-man']")
	public WebElement DriverDetailsButton;

	@FindBy(xpath = "//span[normalize-space()='Show All']")
	public WebElement ShowAllTab;

	@FindBy(xpath = "//span[normalize-space()='Personal Information']")
	public WebElement PersonalInformationTab;

	@FindBy(xpath = "(//h2[normalize-space()='Personal Information'])[1]")
	public WebElement PersonalInformationHeader;

	@FindBy(xpath = "//span[normalize-space()='Contacting & Address Details']")
	public WebElement ContactingAndAddressDetailsTab;

	@FindBy(xpath = "(//h2[normalize-space()='Contacting & Address Details'])[1]")
	public WebElement ContactingAndAddressDetailsHeader;

	@FindBy(xpath = "//span[normalize-space()='license Information']")
	public WebElement licenseInformationTab;

	@FindBy(xpath = "(//h2[normalize-space()='license Information'])[1]")
	public WebElement licenseInformationHeader;

	@FindBy(xpath = "//span[normalize-space()='Other Information']")
	public WebElement OtherInformationTab;

	@FindBy(xpath = "(//span[normalize-space()='Other Information'])[1]")
	public WebElement OtherInformationHeader;

// ************************************************************ Risk Value Types Elements **********************************************************************************************

	@FindBy(css = "#RISK_CALC_REGION_ig")
	public WebElement RiskCalculationIg;

	@FindBy(css = "#RiskCalculation_ig_toolbar_m3")
	public WebElement EditButton;

	@FindBy(xpath = "(//button[@title='Close'])[2]")
	public WebElement RiskCalculationPopupCloseButton;

	@FindBy(css = "td[class='a-GV-cell u-tC a-GV-frozen a-GV-frozen--start5']")
	public WebElement SIAmountCell;

	@FindBy(css = "button[title='Ctrl+Alt+S']")
	public WebElement SaveButton;

	@FindBy(css = "button[title='Ctrl+Alt+S']")
	public WebElement ApplyButton;

	@FindBy(xpath= "(//span[@class='fa fa-calculator'])[1]")
	public WebElement RiskCalculationButton;

	@FindBy(xpath= "//div[@id='apex_dialog_1']//iframe")
	public WebElement RiskCalculationIframe;

	@FindBy(css= "#RISK_CALC_REGION_ig_toolbar_m1")
	public WebElement RiskCalculationEditButton;

	@FindBy(css= "button[title='Ctrl+Alt+S'] span[class='a-Button-label']")
	public WebElement RiskCalculationSaveButton;



	// ************************************************************ Quotation Value Types **********************************************************************************************
	@FindBy(css = "div[class='a-GV-w-scroll']")
	public WebElement CalculationsTable;

	@FindBy(css = "#calc_ig_toolbar_m1")
	public WebElement EditButtonQuotationValue;

	@FindBy(css = "#calc_ig")
	public WebElement CalculationsIGRegion;

	// ************************************************************ Quotation Client **********************************************************************************************
	@FindBy(xpath = "//button[normalize-space()='Customer Info']")
	public WebElement CustomerInfoButton;

	@FindBy(css = "#P107_QUT_CLIENT")
	public WebElement QurQutClientCombobox;

	@FindBy(css = "#P107_QUT_CUST_NO")
	public WebElement QurQutClientNoCombobox;

	@FindBy(css = "#P107_QUT_COVER_GROUP")
	public WebElement QutCoverGroupCombobox;

	@FindBy(css = "#P107_QUT_COLLECTION_TYPE")
	public WebElement QutCollectionTypeCombobox;

	@FindBy(xpath = "//span[normalize-space()='Risk Quotation']")
	public WebElement RiskQuotationButton;

	@FindBy(xpath = "//span[normalize-space()='Beneficiary']")
	public WebElement BeneficiaryButton;

	@FindBy(css = "iframe[title='Beneficiary']")
	public WebElement BeneficiaryIframe;

	@FindBy(css = "#BEN_IG_ig")
	public WebElement BeneficiaryTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement BeneficiaryAddRow;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement BeneficiarySaveButton;

	@FindBy(xpath = "(//button[@title='Close'])[4]")
	public WebElement BeneficiaryIframeCloseButton;

//	@FindBy(xpath = "(//td[@role='gridcell'])[2]")
//	public WebElement BeneficiarySerialRow;

	@FindBy(css = "#C172506164779732682")
	public WebElement BeneficiarySerialRow;

	@FindBy(xpath = "(//td[@role='gridcell'])[3]")
	public WebElement BeneficiaryRow;
	@FindBy(css = "#C172506035280732681")
	public WebElement BeneficiaryComboboxRow;

	@FindBy(xpath = "(//td[@role='gridcell'])[5]")
	public WebElement IdNumberRow;
	@FindBy(css = "#C172953920768030151")
	public WebElement BeneficiaryIdNumberRow;

	@FindBy(xpath = "(//td[@role='gridcell'])[6]")
	public WebElement NationalityRow;
	@FindBy(css = "#C172954022461030152")
	public WebElement BeneficiaryNationalityRow;
	@FindBy(css = "#PopupLov_31_C172954022461030152_dlg input[aria-label='Search']")
	public WebElement BeneficiaryNationalityPopupLOVSearchBar;

	@FindBy(xpath = "(//td[@role='gridcell'])[7]")
	public WebElement ClassificationRow;
	@FindBy(css = "#C172954130845030153")
	public WebElement BeneficiaryClassificationRow;

	@FindBy(xpath = "//span[normalize-space()='Covers']")
	public WebElement CoversButton;

	@FindBy(css = "iframe[title='Covers']")
	public WebElement CoversIframe;

	@FindBy(css = "#COVER_IG_ig")
	public WebElement CoversTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement CoversAddRow;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement CoversSaveButton;

	@FindBy(css = "#C189816328888441255")
	public WebElement CoversSerialRow;

	@FindBy(css = "td[role='gridcell'] span[class='fa fa-trash-o']")
	public WebElement CoverDeleteFirstRow;

	@FindBy(xpath = "(//td[@role='gridcell'])[4]")
	public WebElement CategoryRow;
	@FindBy(css = "#C189854306393441270")
	public WebElement CoversCategoryComboboxRow;

	@FindBy(xpath = "(//td[@role='gridcell'])[5]")
	public WebElement CoversRow;
	@FindBy(css = "#C189819317048441256")
	public WebElement CoversComboboxRow;
	@FindBy(css = "#PopupLov_73_C189819317048441256_dlg input[aria-label='Search']")
	public WebElement CoversPopupLOVSearchBar;

	@FindBy(xpath = "(//td[@role='gridcell'])[6]")
	public WebElement PremRow;
	@FindBy(css = "#C189825355209441259")
	public WebElement CoversPremRow;
	@FindBy(css = "#C189823349800441258")
	public WebElement CoversRateRow;

	@FindBy(xpath = "//span[normalize-space()='REI Plan']")
	public WebElement REIPlanButton;

	@FindBy(css = "iframe[title='ReInsurance Plans']")
	public WebElement ReInsurancePlansIframe;

	@FindBy(css = "#P13_INS_PLN")
	public WebElement ReinsurancePlanCombobox;

	@FindBy(css = "#P13_INS_PLN_error")
	public WebElement ReinsurancePlanErrorMsg;

	@FindBy(css = "#P13_REI_METHOD")
	public WebElement ReiMethodCombobox;

	@FindBy(css = "#P13_REI_METHOD_error")
	public WebElement ReiMethodErrorMsg;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement REIPlanSaveButton;

	@FindBy(css = "#P107_QUT_QUOT_STATUS_DISPLAY")
	public WebElement StatusAllQuotationDetails;

	@FindBy(css = "#P107_QUT_VALID_STATUS_DISPLAY")
	public WebElement ValidityStatusAllQuotationDetails;

	@FindBy(css = "#P107_QUT_QUOT_NO_DISPLAY")
	public WebElement QutQuotNoAllQuotationDetails;

	@FindBy(xpath = "//button[normalize-space()='Calculations']")
	public WebElement CalculationsButton;

	// ************************************************************ Items Details Elements **********************************************************************************************
	@FindBy(xpath = "//span[normalize-space()='Add New Item']")
	public WebElement AddNewItemButton;

	@FindBy(css = "iframe[title='Fire Risk Items']")
	public WebElement FireRiskItemsIframe;
	@FindBy(css = "#P90_RIQ_ITEM_CODE")
	public WebElement RiqItemCodeCombobox;
	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement RiqSaveButtonIframe;

	// ************************************************************ Item Value Types Elements **********************************************************************************************
	@FindBy(css = "#item_c_ig_toolbar_m1")
	public WebElement ItemCalculationEditButton;

	@FindBy(xpath= "//div[@id='apex_dialog_1']//iframe")
	public WebElement ItemCalculationIframe;

	@FindBy(xpath = "(//span[@class='fa fa-calculator'])[3]")
	public WebElement ItemCalculationButton;

	// ************************************************************ End of Quotation Elements **********************************************************************************************

	@FindBy(xpath = "//span[normalize-space()='Revision Quotation']")
	public WebElement RevisionQuotationButton;

	@FindBy(xpath = "//span[normalize-space()='Copy Quotation']")
	public WebElement CopyQuotationButton;

	@FindBy(xpath = "//button[contains(text(),'Copy Quotation')]")
	public WebElement CopyQuotationConfirmationButton;

	@FindBy(xpath = "//span[normalize-space()='Issue Quotation']")
	public WebElement IssueQuotationButton;

	@FindBy(xpath = "//button[contains(text(),'Issue Quotation')]")
	public WebElement IssueQuotationConfirmationButton;

	@FindBy(xpath = "//span[normalize-space()='Reject Quotation']")
	public WebElement RejectQuotationButton;

	@FindBy(xpath = "//button[contains(text(),'Reject Quotation')]")
	public WebElement RejectQuotationConfirmationButton;

	@FindBy(css = "#P107_QUT_REJECT_DESC")
	public WebElement RejectDescriptionQuotationInput;

	@FindBy(xpath = "//span[normalize-space()='Reject']")
	public WebElement RejectButton;

	@FindBy(xpath = "//span[normalize-space()='Convert to Policy']")
	public WebElement ConvertToPolicyButton;

	@FindBy(xpath = "//button[contains(text(),'Convert to Policy')]")
	public WebElement ConvertToPolicyConfirmationButton;

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

	@FindBy(xpath = "(//span[@role='treeitem'][normalize-space()='Quotations'])[3]")
	public WebElement QuotationsChild;

	@FindBy(css = "iframe[title='Program Details']")
	public WebElement ProgramDetailsIframe;

	@FindBy(css = "#P21_APP_ALIAS")
	public WebElement ApplicationCombobox;

	@FindBy(css = "#P21_STATUS")
	public WebElement StatusCheckbox;

	@FindBy(css = "#P21_DISPLAYED_ON_MENU")
	public WebElement DisplayOnMenuCheckbox;

	@FindBy(xpath = "(//button[@title='Close'])[2]")
	public WebElement ProgramIframeCloseButton;

	// ************************************************************ System Code Ranks Elements **********************************************************************************************
	@FindBy(css = "#SCRM_IG_ig")
	public WebElement SystemCodeRanksMajorTable;

	@FindBy(css = "#SCRD_IG_ig")
	public WebElement SystemCodeRanksMinorTable;

	@FindBy(xpath = "//div[@id='SCRM_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement SystemCodeRanksMajorAddButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement SystemCodeRanksMajorSaveButton;

	@FindBy(xpath = "//div[@id='SCRD_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement SystemCodeRanksMinorAddButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[2]")
	public WebElement SystemCodeRanksMinorSaveButton;


	// ************************************************************ Error Messages Elements **********************************************************************************************
	@FindBy(css = "#EMM_IG_ig")
	public WebElement ErrorMessagesTable;

	@FindBy(css = "#EMD_IG_ig")
	public WebElement ErrorMessagesDetailsTable;

	@FindBy(xpath = "//div[@id='EMM_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement ErrorMessagesAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement ErrorMessagesSaveButton;

	@FindBy(xpath = "//div[@id='EMD_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement ErrorMessagesDetailsAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[2]")
	public WebElement ErrorMessagesDetailsSaveButton;

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

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement DomicileLocationsSaveButton;

	// ************************************************************ System Owner Setup Elements **********************************************************************************************
	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='General Information']")
	public WebElement GeneralInformationTab;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Settings']")
	public WebElement SettingsTab;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Application Configuration']")
	public WebElement ApplicationConfigurationTab;

	@FindBy(css = "#myIG_ig")
	public WebElement ApplicationConfigurationTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement ApplicationConfigurationAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[2]")
	public WebElement ApplicationConfigurationSaveButton;

	// ************************************************************ Sum Insured Ranges Elements **********************************************************************************************
	@FindBy(css = "#P13_REPORT_TYPE")
	public WebElement ReportTypeCombobox;

	@FindBy(css = "#P13_REPORT_VALUE")
	public WebElement ReportValueCombobox;

	@FindBy(css = "#IVD_ID_ig")
	public WebElement SumInsuredRangesTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement SumInsuredRangesAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement SumInsuredRangesSaveButton;


	// ************************************************************ Short Period Tariff Elements **********************************************************************************************
	@FindBy(css = "#P17_CLASS")
	public WebElement ClassCombobox;

	@FindBy(css = "#P17_POLICY")
	public WebElement PolicyTypeCombobox;

	@FindBy(css = "#SPT_ID_ig")
	public WebElement ShortPeriodTariffTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement ShortPeriodTariffAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement ShortPeriodTariffSaveButton;

	// ************************************************************ Pro-Rata Period Tariff Elements **********************************************************************************************

	@FindBy(css = "#PRO_IG_ig")
	public WebElement ProRataPeriodTariffTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement ProRataPeriodTariffAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement ProRataPeriodTariffSaveButton;

	// ************************************************************ Locations and Branches Elements **********************************************************************************************

	@FindBy(css = "#P12_LOCATION")
	public WebElement LocationCombobox;

	@FindBy(css = "#LOCB_ig")
	public WebElement LocationsAndBranchesTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement LocationsAndBranchesAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement LocationsAndBranchesSaveButton;


	// ************************************************************ Customers Receivable Elements **********************************************************************************************

	@FindBy(css = "#REC_IG_ig")
	public WebElement CustomersReceivableTable;

	@FindBy(xpath = "(//span[@class='t-Button-label'][normalize-space()='Save'])[1]")
	public WebElement CustomersReceivableSaveButton;

	@FindBy(css = "#P5_LOCATION_error")
	public WebElement LocationErrorMsg;

	@FindBy(css = "#P5_BRANCH_error")
	public WebElement BranchCRErrorMsg;

	@FindBy(css = "#P5_CUST_TYPE_error")
	public WebElement CustTypeErrorMsg;

	@FindBy(css = "#P5_LNAME_error")
	public WebElement NameEnglishErrorMsg;

	@FindBy(css = "#P5_STATUS_error")
	public WebElement CustStatusErrorMsg;

	@FindBy(css = "#B157590256067599170")
	public WebElement CustomerNameOpenPop;

	@FindBy(css = "#P5_CUST_FLNAME")
	public WebElement FirstNameEnInput;

	@FindBy(css = "#P5_CUST_FLNAME_error")
	public WebElement FirstNameEnErrorMsg;

	@FindBy(css = "#P5_CUST_LLNAME")
	public WebElement LastNameEnInput;

	@FindBy(css = "#P5_CUST_LLNAME_error")
	public WebElement LastNameEnErrorMsg;

	@FindBy(css = "#P5_CUST_FANAME")
	public WebElement FirstNameArInput;

	@FindBy(css = "#P5_CUST_FANAME_error")
	public WebElement FirstNameArErrorMsg;

	@FindBy(css = "#P5_CUST_LANAME")
	public WebElement LastNameArInput;

	@FindBy(css = "#P5_CUST_LANAME_error")
	public WebElement LastNameArErrorMsg;

	@FindBy(css = "#P5_CUST_NO_OF_VISIT")
	public WebElement NoOfVisitInput;

	@FindBy(css = "#P5_CUST_NO_OF_VISIT_error")
	public WebElement NoOfVisitErrorMsg;

	@FindBy(css = "#P5_CUST_ANNUAL_INCOME")
	public WebElement AnnualIncomeInput;

	@FindBy(css = "#P5_CUST_ANNUAL_INCOME_error")
	public WebElement AnnualIncomeErrorMsg;

	@FindBy(xpath = "(//button[@title='Close'])[2]")
	public WebElement CustomerNameCloseButton;

	@FindBy(css = "#BRANCHES_ID_ig")
	public WebElement BranchesCRTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement BranchesCRAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement BranchesCRSaveButton;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement CROkButton;

	@FindBy(css = "#R155352297762300556_ig")
	public WebElement CompanySizeCRTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement CompanySizeCRAddRowButton;


	// ************************************************************ Payable Parties Elements **********************************************************************************************

	@FindBy(css = "#PAY_IG_ig")
	public WebElement PayablePartiesTable;

	@FindBy(xpath = "(//span[@class='t-Button-label'][normalize-space()='Save'])[1]")
	public WebElement PayablePartiesSaveButton;

	@FindBy(css = "#P4_ACCOUNT_NO")
	public WebElement AccountNoInput;

	@FindBy(css = "#P4_ACCOUNT_NO_error")
	public WebElement AccountNoErrorMsg;

	@FindBy(css = "#P4_LOCATION_error")
	public WebElement LocationPPErrorMsg;

	@FindBy(css = "#P4_BRANCH_error")
	public WebElement BranchPPErrorMsg;

	@FindBy(css = "#P4_CLASS_error")
	public WebElement ClassErrorMsg;

	@FindBy(css = "#P4_CUSTOMER_TYPE_error")
	public WebElement CustomerTypeErrorMsg;

	@FindBy(css = "#CUSTOMER_LNAME_error")
	public WebElement CustomerNameErrorMsg;

	@FindBy(css = "#P4_CUST_STATUS_error")
	public WebElement CustStatusPPErrorMsg;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Customer Details']")
	public WebElement CustomerDetailsTab;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Customer Details 2']")
	public WebElement CustomerDetails2Tab;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Address']")
	public WebElement AddressTab;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Branches']")
	public WebElement BranchesTab;

	@FindBy(css = "#R150268016748535085_ig")
	public WebElement BranchesTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement BranchesAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement BranchesSaveButton;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Periods']")
	public WebElement PeriodsTab;

	@FindBy(css = "#R154338093266095678_ig")
	public WebElement PeriodsTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement PeriodsAddRowButton;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Commission']")
	public WebElement CommissionTab;

	@FindBy(css = "#R155877906567342590_ig")
	public WebElement CommissionTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[3]")
	public WebElement CommissionAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[3]")
	public WebElement CommissionSaveButton;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Company Size']")
	public WebElement CompanySizeTab;

	@FindBy(css = "#R158009214115732960_ig")
	public WebElement CompanySizeTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[4]")
	public WebElement CompanySizeAddRowButton;

	@FindBy(xpath = "(//span[@class='t-Button-label'][normalize-space()='Cancel'])[1]")
	public WebElement PPCancelButton;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement PPOkButton;

	@FindBy(css = "#B156489195266333089")
	public WebElement CustomerNamePPOpenPop;

	@FindBy(css = "#P4_ENAEM1")
	public WebElement FirstNameEnPPInput;

	@FindBy(css = "#P4_ENAEM1_error")
	public WebElement FirstNameEnPPErrorMsg;

	@FindBy(css = "#P4_ENAEM4")
	public WebElement LastNameEnPPInput;

	@FindBy(css = "#P4_ENAEM4_error")
	public WebElement LastNameEnPPErrorMsg;

	@FindBy(css = "#P4_ANAEM1")
	public WebElement FirstNameArPPInput;

	@FindBy(css = "#P4_ANAEM1_error")
	public WebElement FirstNameArPPErrorMsg;

	@FindBy(css = "#P4_ANAEM4")
	public WebElement LastNameArPPInput;

	@FindBy(css = "#P4_ANAEM4_error")
	public WebElement LastNameArPPErrorMsg;

	@FindBy(css = "#P4_CUST_CREDIT_LIMIT")
	public WebElement CreditLimitInput;

	@FindBy(css = "#P4_CUST_CREDIT_LIMIT_error")
	public WebElement CreditLimitErrorMsg;

	@FindBy(css = "#P4_CUST_CREDIT_AMOUNT")
	public WebElement CreditAmountInput;

	@FindBy(css = "#P4_CUST_CREDIT_AMOUNT_error")
	public WebElement CreditAmountErrorMsg;


	// ************************************************************ Class-Subclass Linking Elements **********************************************************************************************

	@FindBy(css = "#RCLASS_ig")
	public WebElement ClassTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement ClassAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement ClassSaveButton;

	@FindBy(css = "#SC_IG_ig")
	public WebElement SubClassTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement SubClassAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[2]")
	public WebElement SubClassSaveButton;

	// ************************************************************ Customers Address Screen Elements **********************************************************************************************

	@FindBy(css = "#CAS_ID_ig")
	public WebElement CustomerAddressTable;

	@FindBy(xpath = "//span[normalize-space()='Add Address']")
	public WebElement CustomerAddressAddRowButton;

	@FindBy(css = "#R217780171403918608 .t-Region-body")
	public WebElement CustomerAddressRegionBody;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement CustomerAddressSaveButton;

	@FindBy(css = "#P25_GEN_POL_BRANCH_error")
	public WebElement LocationCAErrorMsg;

	@FindBy(css = "#P25_GEN_POL_OFFICE_error")
	public WebElement OfficeErrorMsg;

	@FindBy(css = "#P25_GEN_ENDT_NO_error")
	public WebElement EndtNoErrorMsg;

	@FindBy(css = "#P25_GEN_ENDT_YEAR_error")
	public WebElement EndtYearErrorMsg;

	@FindBy(css = "#P25_GEN_ENDT_TYPE_error")
	public WebElement EndtTypeErrorMsg;

	@FindBy(css = "#P25_GEN_DEPT_NO_error")
	public WebElement DepartmentCAErrorMsg;

	@FindBy(css = "#P25_GEN_CLASS_OF_BUSINESS_error")
	public WebElement COBErrorMsg;

	@FindBy(css = "#P25_GEN_SOURCE_error")
	public WebElement SourceErrorMsg;

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

	@FindBy(xpath = "//div[@id='USER_IG']//table[contains(@class,'a-GV-table')]//tbody//tr[1]//td[1]//a")
	public WebElement UserNo;

	// ************************************************************ Roles Definition Elements **********************************************************************************************

	@FindBy(css = "#ROLES_ig")
	public WebElement RolesTable;

	@FindBy(xpath = "//div[@id='ROLES_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Add Row']")
	public WebElement RolesAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement RolesSaveButton;

	@FindBy(css = "#roleDet_ig")
	public WebElement RolesDetTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement RolesDetAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[2]")
	public WebElement RolesDetSaveButton;

	// ************************************************************ Users' Privileges On Locations & Branches Elements **********************************************************************************************

	@FindBy(css = "#P32_USERS")
	public WebElement UsersDDL;

	@FindBy(css = ".a-RDS-link[href='#loc']")
	public WebElement LocationTab;

	@FindBy(css = "#loc_ig")
	public WebElement LocationTable;

	@FindBy(xpath = "(//span[contains(@class,'a-Button-label')][normalize-space()='Add Row'])[1]")
	public WebElement LocationAddRowButton;

	@FindBy(xpath = "(//span[contains(@class,'a-Button-label')][normalize-space()='Save'])[1]")
	public WebElement LocationSaveButton;

	@FindBy(css = "#UR_IG_ig")
	public WebElement UserRoleTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement UserRoleAddRowButton;

	@FindBy(xpath = "//div[@id='UR_IG_ig_toolbar']//span[@class='a-Button-label'][normalize-space()='Save']")
	public WebElement UserRoleSaveButton;


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
	public WebElement AuthorizedButtonsAddRowButton;

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

	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	public WebElement TransactionTypeSaveButton;


	// ************************************************************ User Privileges On Claim Payments  Elements **********************************************************************************************

	@FindBy(css = "#P54_USER")
	public WebElement UserCombobox;

	@FindBy(css = "#P54_AUTHORITY")
	public WebElement AuthorityCombobox;

	@FindBy(css = "#P54_USER_ID_DISPLAY")
	public WebElement UserIdText;

	@FindBy(css = "#UAP_ID_ig")
	public WebElement UAPTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement UAPAddRow;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement UAPSaveButton;


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

	@FindBy(css = "#P30_USER_NAME_DISPLAY")
	public WebElement UserNameText;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement UserQuotationPostingAddRow;

	@FindBy(css = "#UQP_ID_ig")
	public WebElement UserQuotationPostingTable;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement UserQuotationPostingSaveButton;


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

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement CommissionDefinitionSaveButton;


	// ************************************************************ Import From Excel Advanced Elements **********************************************************************************************

	@FindBy(xpath = "//span[normalize-space()='Start Import']")
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

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Columns']")
	public WebElement ColumnsTab;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement ColumnsAddRowButton;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Save'])[1]")
	public WebElement ColumnsSaveButton;

	@FindBy(xpath = "//a[contains(@class,'a-RDS-link') and @role='tab' and normalize-space()='Constraints']")
	public WebElement ConstraintsTab;

	@FindBy(css = "#R143514321170915059_ig")
	public WebElement ConstraintsTable;



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

	@FindBy(css = "#MAIL_IG_ig_toolbar_search_field")
	public WebElement MailSetupTableSearch;

	@FindBy(xpath = "//td[@role='gridcell']//a")
	public WebElement MailSetupTableEdit;


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



	// ************************************************************ FGA Address Elements **********************************************************************************************

	@FindBy(css = "#R18543027120721613_ig")
	public WebElement FGAAddressTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement FGAAddressAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement FGAAddressSaveButton;


	// ************************************************************ Household Contents Definition Elements **********************************************************************************************

	@FindBy(css = "#R37774520111007016_ig")
	public WebElement HouseholdContentsDefinitionTable;

	@FindBy(css = "#P40_SYS_MINOR")
	public WebElement SysMinorCombobox;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement HouseholdContentsDefinitionAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement HouseholdContentsDefinitionSaveButton;


	// ************************************************************ FGA Rates Tariff Elements **********************************************************************************************

	@FindBy(css = "#R17804292463202872_ig")
	public WebElement FGARatesTariffTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement FGARatesTariffAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement FGARatesTariffSaveButton;


	// ************************************************************ FGA Rates (Percentages&Permils) Elements **********************************************************************************************

	@FindBy(css = "#R17863871779784685_ig")
	public WebElement FGARatesPercentagesPermilsTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement FGARatesPercentagesPermilsAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement FGARatesPercentagesPermilsSaveButton;


	// ************************************************************ Short Period Tariff(FGA Enorsement) Elements **********************************************************************************************

	@FindBy(css = "#R17905022704003627_ig")
	public WebElement ShortPeriodTariffFGAEndorsementTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement ShortPeriodTariffFGAEndorsementAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement ShortPeriodTariffFGAEndorsementSaveButton;


	// ************************************************************ Earthquake Rate Elements **********************************************************************************************

	@FindBy(css = "#R17888510743906786_ig")
	public WebElement EarthquakeRateTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement EarthquakeRateAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement EarthquakeRateSaveButton;


	// ************************************************************ Earthquake Rate Elements **********************************************************************************************

	@FindBy(xpath = "//span[normalize-space()='Categories']")
	public WebElement CategoriesTab;

	@FindBy(css = "#AutoSr_3_ig")
	public WebElement CategoriesTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[1]")
	public WebElement CategoriesAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Professions']")
	public WebElement ProfessionsTab;

	@FindBy(css = "#AutoSr_14_ig")
	public WebElement ProfessionsTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[2]")
	public WebElement ProfessionsAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Linking']")
	public WebElement LinkingTab;

	@FindBy(css = "#AutoSr_23_ig")
	public WebElement LinkingTable;

	@FindBy(xpath = "(//span[@class='a-Button-label'][normalize-space()='Add Row'])[3]")
	public WebElement LinkingAddRowButton;


	// ************************************************************ Coverage Limit AOO-AAA Elements **********************************************************************************************

	@FindBy(css = "#R9967642300309719_ig")
	public WebElement CoverageLimitAOO_AAATable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement CoverageLimitAOO_AAAAddRowButton;


	// ************************************************************ Malpractice Tariff Definition Elements **********************************************************************************************

	@FindBy(css = "#R9978972625330558_ig")
	public WebElement MalpracticeTariffDefinitionTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement MalpracticeTariffDefinitionAddRowButton;


	// ************************************************************ Malpractice Questions Elements **********************************************************************************************

	@FindBy(css = "#R9995699698371782_ig")
	public WebElement MalpracticeQuestionsTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement MalpracticeQuestionsAddRowButton;


	// ************************************************************ MMP Periods Elements **********************************************************************************************

	@FindBy(css = "#MMP_IG_ig")
	public WebElement MMPPeriodsTable;

	@FindBy(xpath = "(//button[@data-action='selection-add-row'])[1]")
	public WebElement MMPPeriodsAddRowButton;

	@FindBy(css = "#P15_TYPE")
	public WebElement MMPPeriodsCombobox;


	// ************************************************************ Travel Calculation Prices Elements **********************************************************************************************

	@FindBy(css = "#R8157961904845469_ig")
	public WebElement TravelCalculationPricesTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement TravelCalculationPricesAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement TravelCalculationPricesSaveButton;


	// ************************************************************ Travel Days Elements **********************************************************************************************

	@FindBy(css = "#R13129382496504989_ig")
	public WebElement TravelDaysTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement TravelDaysAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement TravelDaysSaveButton;


	// ************************************************************ Key Benefits Elements **********************************************************************************************

	@FindBy(css = "#R14520613656192732_ig")
	public WebElement KeyBenefitsTable;

	@FindBy(xpath = "//span[normalize-space()='Add Row']")
	public WebElement KeyBenefitsAddRowButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement KeyBenefitsSaveButton;


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

	public void wait_Element_Appear(String elementName) throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), Duration.ofSeconds(30));

		// Option 1 (recommended): wait until element is visible (present + displayed)
		WebElement el = wait.until(ExpectedConditions.visibilityOf(getElement(this, elementName)));
		if (el == null) {
			throw new Exception("Element '" + elementName + "' did not appear (not visible) within timeout.");
		}
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

		// Always fix/normalize incoming value (p:ClientName etc.)
		optionValue = fixMojibakeIfNeeded(optionValue);

		// 1) Try plain <select>
		try {
			Select select = new Select(dropdown);
			select.selectByVisibleText(optionValue);
			log.info("Selected '" + optionValue + "' from <select> '" + dropDownListName + "'");
			return;
		} catch (UnexpectedTagNameException ignored) {
			// not a <select>, fall through
		}

		// 2) Input-based APEX LOV / combobox
		if (!"input".equalsIgnoreCase(dropdown.getTagName())) {
			throw new Exception("Element '" + dropDownListName + "' is neither a <select> nor an <input>.");
		}

		dropdown.click();
		try {
			dropdown.clear();
		} catch (InvalidElementStateException ex) {
			// read-only inputs – ignore
		}

		dropdown.sendKeys(optionValue);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// 2a) Click visible LOV Search button (if exists)
		List<WebElement> searchButtons = driver.findElements(By.cssSelector("button.a-PopupLOV-doSearch"));
		for (WebElement btn : searchButtons) {
			if (btn.isDisplayed() && btn.isEnabled()) {
				btn.click();
				break;
			}
		}

		// 2b) Wait until at least one visible option exists
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
					// refreshed; ignore and let wait retry
				}
			}
			return visible.isEmpty() ? null : visible;
		});

		// 2c) Match with normalization (handles Arabic/newlines/spaces)
		String expected = normalizeLovText(optionValue);

		// exact match
		for (WebElement opt : visibleOptions) {
			String actual = normalizeLovText(opt.getText());
			if (actual.equals(expected)) {
				opt.click();
				log.info("Selected '" + optionValue + "' from LOV '" + dropDownListName + "'");
				return;
			}
		}

		// fallback: contains match
		for (WebElement opt : visibleOptions) {
			String actual = normalizeLovText(opt.getText());
			if (actual.contains(expected) || expected.contains(actual)) {
				opt.click();
				log.info("Selected (contains) '" + optionValue + "' from LOV '" + dropDownListName + "'");
				return;
			}
		}

		throw new Exception("Option '" + optionValue + "' not found in LOV for '" + dropDownListName + "'.");
	}

	private static final Pattern WS = Pattern.compile("\\s+");
	private String normalizeLovText(String s) {
		if (s == null) return "";
		s = fixMojibakeIfNeeded(s);
		s = Normalizer.normalize(s, Normalizer.Form.NFC);
		s = WS.matcher(s).replaceAll(" ").trim(); // collapse spaces + remove newlines
		return s;
	}
	private String fixMojibakeIfNeeded(String s) {
		if (s == null) return null;

		// Typical Arabic mojibake markers when UTF-8 text is read as ISO-8859-1/Windows-1252
		boolean looksBroken = s.contains("Ø") || s.contains("Ù") || s.contains("Ã") || s.contains("Â");
		if (!looksBroken) return s;

		// Convert "wrongly-decoded" string back to bytes and decode properly as UTF-8
		return new String(s.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
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

	public String getSelectedDropdownValue(String elementName) throws Exception {
		WebElement el = getElementWithWait(this, elementName);

		// 1) If it's a real <select>
		try {
			Select select = new Select(el);
			return select.getFirstSelectedOption().getText().trim();
		} catch (UnexpectedTagNameException ignored) {
			// not a <select>
		}

		// 2) If it's an input-based LOV/combobox
		String tag = el.getTagName() == null ? "" : el.getTagName().toLowerCase();
		if ("input".equals(tag) || "textarea".equals(tag)) {
			String v = el.getAttribute("value");
			return v == null ? "" : v.trim();
		}

		// 3) Fallback for other types
		String t = el.getText();
		return t == null ? "" : t.trim();
	}

	public void assertSelectedDropdownValueEquals(String elementName, String expectedText) throws Exception {
		String actual = getSelectedDropdownValue(elementName);

		if (actual == null) actual = "";
		if (expectedText == null) expectedText = "";

		if (!actual.equalsIgnoreCase(expectedText.trim())) {
			throw new AssertionError("Dropdown '" + elementName + "' expected selected value '"
					+ expectedText + "' but found '" + actual + "'");
		}

		log.info("Assert dropdown '" + elementName + "' selected='" + actual + "'");
	}

	/**
	 * For APEX Popup LOVs: also assert the RETURN value stored in the hidden item.
	 * Example: P61_WAS_API_STATUS -> hidden is usually P61_WAS_API_STATUS_HIDDEN
	 */
	public String getApexLovReturnValue(String lovElementName) throws Exception {
		WebElement lov = getElementWithWait(this, lovElementName);

		String id = lov.getAttribute("id");
		if (id == null || id.trim().isEmpty()) {
			throw new Exception("LOV '" + lovElementName + "' has no id attribute to resolve *_HIDDEN item.");
		}

		String hiddenId = id + "_HIDDEN";
		WebElement hidden = webDriverProvider.get().findElement(By.id(hiddenId));

		String v = hidden.getAttribute("value");
		return v == null ? "" : v.trim();
	}

	public void assertApexLovReturnValueEquals(String lovElementName, String expectedReturnValue) throws Exception {
		String actual = getApexLovReturnValue(lovElementName);

		if (actual == null) actual = "";
		if (expectedReturnValue == null) expectedReturnValue = "";

		if (!actual.equals(expectedReturnValue.trim())) {
			throw new AssertionError("APEX LOV '" + lovElementName + "' expected RETURN value '"
					+ expectedReturnValue + "' but found '" + actual + "'");
		}

		log.info("Assert APEX LOV '" + lovElementName + "' returnValue='" + actual + "'");
	}

	public boolean clickUntilPopupAppears(String clickElementName, String popupElementName) throws Exception {
		WebDriver driver = webDriverProvider.get();
		WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));

		int maxAttempts = 2;

		for (int attempt = 1; attempt <= maxAttempts; attempt++) {

			// 1) If popup is already visible, stop immediately
			if (isElementDisplayedSafe(popupElementName)) {
				log.info("Popup '" + popupElementName + "' is already visible before clicking '" + clickElementName + "'");
				return true;
			}

			try {
				WebElement clickElement = getElementWithWait(this, clickElementName);

				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView({block:'center'});", clickElement);

				shortWait.until(ExpectedConditions.elementToBeClickable(clickElement)).click();
				log.info("Clicked on '" + clickElementName + "', attempt " + attempt);

				// 2) Wait briefly for popup after click
				if (waitForPopupVisible(popupElementName, 3)) {
					log.info("Popup '" + popupElementName + "' appeared after click on '" + clickElementName + "'");
					return true;
				}

				log.info("Popup '" + popupElementName + "' did not appear after attempt " + attempt);

			} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
				log.info("Retry click due to transient issue on '" + clickElementName + "': " + e.getMessage());

				// 3) If click was intercepted, popup may already be open
				if (isElementDisplayedSafe(popupElementName)) {
					log.info("Popup '" + popupElementName + "' is visible after intercepted click on '" + clickElementName + "'");
					return true;
				}
			}
		}

		// final check before fail
		if (isElementDisplayedSafe(popupElementName)) {
			log.info("Popup '" + popupElementName + "' became visible after retries");
			return true;
		}

		throw new Exception("Popup '" + popupElementName + "' did not appear after clicking '" + clickElementName + "'");
	}
	private boolean waitForPopupVisible(String popupElementName, int seconds) {
		try {
			WebDriver driver = webDriverProvider.get();
			new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(d -> isElementDisplayedSafe(popupElementName));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
	private boolean isElementDisplayedSafe(String elementName) {
		try {
			WebElement element = getElement(this, elementName);
			return element != null && element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickIfPresent(String elementName) {
		WebDriver driver = webDriverProvider.get();
		try {
			// Use your framework wait/resolver
			WebElement el = getElementWithWait(this, elementName);
			if (el == null) return false;
			// If element exists but not visible/enabled -> skip
			if (!el.isDisplayed() || !el.isEnabled()) return false;
			// Reuse your framework click (keeps your scrolling/JS/iframe logic if implemented there)
			click(elementName);
			return true;
		} catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
			return false;
			// not present -> skip }
		} catch (ElementClickInterceptedException e) {
				// optional fallback if your click() doesn't already handle it
				try { WebElement el = getElementWithWait(this, elementName);
					if (el == null) return false;
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
					return true;
				} catch (Exception ex) {
					return false;
				}
		} catch (Exception e) { return false; } }
}
