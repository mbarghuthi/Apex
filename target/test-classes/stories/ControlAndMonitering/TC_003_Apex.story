Scenario:  TC_003_Apex TC3S1 Apex Test Case Control and Monitoring - Master Files - Locations & Branches

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'LocationsAndBranchesSideMenu'
And [Assertion] Verify 'LocationsAndBranchesTitle' equals 'p:LocationsAndBranches' text
And [Input] Select 'p:SaudiArabia' value from 'LocationCombobox' dropdown list
And [Assertion] Verify 'LocationsAndBranchesTable' is visible
And [Progress] I wait for '10' sec
And [Input] I click on 'LocationsAndBranchesAddRowButton'
And [Assertion] Verify IG 'LocationsAndBranchesTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'LocationsAndBranchesSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'LocationsAndBranchesTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex TC3S2 Apex Test Case Control and Monitoring - Master Files - Customers Receivable

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'CustomersReceivableSideMenu'
And [Assertion] Verify 'CustomersReceivableTariffTitle' equals 'p:CustomersReceivable' text
And [Assertion] Verify 'CustomersReceivableTable' is visible
And [Input] I click on 'AddACustomerButton'
And [Progress] I wait for '3' sec
And [Input] I click on 'CustomersReceivableSaveButton'
And [Input] I click on 'CloseIconButton'
And [Assertion] Verify 'LocationErrorMsg' contains 'p:LocationEmptyErrorMsg' text
And [Assertion] Verify 'BranchCRErrorMsg' contains 'p:BranchCREmptyErrorMsg' text
And [Assertion] Verify 'CustTypeErrorMsg' contains 'p:CustTypeEmptyErrorMsg' text
And [Assertion] Verify 'NameEnglishErrorMsg' contains 'p:NameEnglishEmptyErrorMsg' text
And [Assertion] Verify 'CustStatusErrorMsg' contains 'p:CustStatusEmptyErrorMsg' text
And [Input] I click on 'CustomerNameOpenPop'
And [Assertion] Verify 'FirstNameEnErrorMsg' contains 'p:FirstNameEnEmptyErrorMsg' text
And [Assertion] Verify 'LastNameEnErrorMsg' contains 'p:LastNameEnEmptyErrorMsg' text
And [Assertion] Verify 'FirstNameArErrorMsg' contains 'p:FirstNameArEmptyErrorMsg' text
And [Assertion] Verify 'LastNameArErrorMsg' contains 'p:LastNameArEmptyErrorMsg' text
And [Input] Set 'FirstNameEnInput' value to 'random2'
And [Assertion] Verify 'FirstNameEnInput' input is empty
And [Input] Set 'LastNameEnInput' value to 'random2'
And [Assertion] Verify 'LastNameEnInput' input is empty
And [Input] Set 'FirstNameArInput' value to 'random2'
And [Assertion] Verify 'FirstNameArInput' input is empty
And [Input] Set 'LastNameArInput' value to 'random2'
And [Assertion] Verify 'LastNameArInput' input is empty
And [Progress] I wait for '5' sec
And [Input] I click on 'CustomerNameCloseButton'
And [Assertion] Verify tab 'CustomerDetailsTab' is selected
And [Input] Set 'NoOfVisitInput' value to 'randomen'
And [Input] Set 'AnnualIncomeInput' value to 'randomen'
And [Navigation] I scroll to top of page
And [Input] I click on 'CustomersReceivableSaveButton'
And [Navigation] I scroll to 'NoOfVisitErrorMsg'
And [Assertion] Verify 'NoOfVisitErrorMsg' contains 'p:NoOfVisitInvalidErrorMsg' text
And [Assertion] Verify 'AnnualIncomeErrorMsg' contains 'p:AnnualIncomeInvalidErrorMsg' text
And [Navigation] I scroll to top of page
And [Input] I click on 'CustomerDetails2Tab'
And [Assertion] Verify tab 'CustomerDetails2Tab' is selected
And [Input] I click on 'AddressTab'
And [Assertion] Verify tab 'AddressTab' is selected
And [Input] I click on 'BranchesTab'
And [Assertion] Verify tab 'BranchesTab' is selected
And [Assertion] Verify 'BranchesCRTable' is visible
And [Navigation] I scroll to 'BranchesCRAddRowButton'
And [Input] I click on 'BranchesCRAddRowButton'
!-- And [Assertion] Verify IG 'BranchesCRTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'BranchesCRSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'CROkButton'
And [Action] I delete the inserted row in IG 'BranchesCRTable'
And [Input] I click on 'CompanySizeTab'
And [Assertion] Verify tab 'CompanySizeTab' is selected
And [Assertion] Verify 'CompanySizeCRTable' is visible
And [Navigation] I scroll to 'CompanySizeCRAddRowButton'
And [Input] I click on 'CompanySizeCRAddRowButton'
And [Assertion] Verify IG 'CompanySizeCRTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'CompanySizeCRTable'
And [Input] I click on 'CancelButton'
And [Assertion] Verify 'AddACustomerButton' is visible
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex TC3S3 Apex Test Case Control and Monitoring - Master Files - Payable Parties

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'PayablePartiesSideMenu'
And [Assertion] Verify 'PayablePartiesTitle' equals 'p:PayableParties' text
And [Assertion] Verify 'PayablePartiesTable' is visible
And [Input] I click on 'AddACustomerButton'
And [Progress] I wait for '3' sec
And [Input] I click on 'PayablePartiesSaveButton'
And [Assertion] Verify 'LocationPPErrorMsg' contains 'p:LocationEmptyErrorMsg' text
And [Assertion] Verify 'BranchPPErrorMsg' contains 'p:BranchEmptyErrorMsg' text
And [Assertion] Verify 'ClassErrorMsg' contains 'p:ClassEmptyErrorMsg' text
And [Assertion] Verify 'CustomerTypeErrorMsg' contains 'p:CustomerTypeEmptyErrorMsg' text
And [Assertion] Verify 'CustomerNameErrorMsg' contains 'p:CustomerNameEmptyErrorMsg' text
And [Assertion] Verify 'CustStatusPPErrorMsg' contains 'p:StatusEmptyErrorMsg' text
And [Input] I click on 'CustomerNamePPOpenPop'
And [Assertion] Verify 'FirstNameEnPPErrorMsg' contains 'p:FirstNameEnEmptyErrorMsg' text
And [Assertion] Verify 'LastNameEnPPErrorMsg' contains 'p:LastNameEnEmptyErrorMsg' text
And [Assertion] Verify 'FirstNameArPPErrorMsg' contains 'p:FirstNameArEmptyErrorMsg' text
And [Assertion] Verify 'LastNameArPPErrorMsg' contains 'p:LastNameArEmptyErrorMsg' text
And [Input] Set 'FirstNameEnPPInput' value to 'random2'
And [Assertion] Verify 'FirstNameEnPPInput' input is empty
And [Input] Set 'LastNameEnPPInput' value to 'random2'
And [Assertion] Verify 'LastNameEnPPInput' input is empty
And [Input] Set 'FirstNameArPPInput' value to 'random2'
And [Assertion] Verify 'FirstNameArPPInput' input is empty
And [Input] Set 'LastNameArPPInput' value to 'random2'
And [Assertion] Verify 'LastNameArPPInput' input is empty
And [Input] I click on 'CustomerNameCloseButton'
And [Input] Set 'AccountNoInput' value to 'randomen'
And [Input] I click on 'PayablePartiesSaveButton'
And [Assertion] Verify 'AccountNoErrorMsg' contains 'p:AccountNoInvalidErrorMsg' text
And [Assertion] Verify tab 'CustomerDetailsTab' is selected
And [Input] Set 'CreditLimitInput' value to 'randomen'
And [Input] Set 'CreditAmountInput' value to 'randomen'
And [Navigation] I scroll to top of page
And [Input] I click on 'PayablePartiesSaveButton'
And [Navigation] I scroll to 'CreditLimitErrorMsg'
And [Assertion] Verify 'CreditLimitErrorMsg' contains 'p:CreditLimitInvalidErrorMsg' text
And [Assertion] Verify 'CreditAmountErrorMsg' contains 'p:CreditAmountInvalidErrorMsg' text
And [Navigation] I scroll to top of page
And [Input] I click on 'CustomerDetails2Tab'
And [Assertion] Verify tab 'CustomerDetails2Tab' is selected
And [Input] I click on 'AddressTab'
And [Assertion] Verify tab 'AddressTab' is selected
And [Input] I click on 'BranchesTab'
And [Assertion] Verify tab 'BranchesTab' is selected
And [Assertion] Verify 'BranchesTable' is visible
And [Navigation] I scroll to 'BranchesAddRowButton'
And [Input] I click on 'BranchesAddRowButton'
And [Assertion] Verify IG 'BranchesTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'BranchesSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'PPOkButton'
And [Navigation] I reload page
And [Input] I click on 'PeriodsTab'
And [Assertion] Verify tab 'PeriodsTab' is selected
And [Assertion] Verify 'PeriodsTable' is visible
And [Navigation] I scroll to 'PeriodsAddRowButton'
And [Input] I click on 'PeriodsAddRowButton'
And [Progress] I wait for '5' sec
And [Assertion] Verify IG 'PeriodsTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'PeriodsTable'
And [Input] I click on 'CommissionTab'
And [Assertion] Verify tab 'CommissionTab' is selected
And [Assertion] Verify 'CommissionTable' is visible
And [Navigation] I scroll to 'CommissionAddRowButton'
And [Input] I click on 'CommissionAddRowButton'
And [Assertion] Verify IG 'CommissionTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'CommissionSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'PPOkButton'
And [Action] I delete the inserted row in IG 'CommissionTable'
And [Input] I click on 'CompanySizeTab'
And [Assertion] Verify tab 'CompanySizeTab' is selected
And [Assertion] Verify 'CompanySizeTable' is visible
And [Navigation] I scroll to 'CompanySizeAddRowButton'
And [Input] I click on 'CompanySizeAddRowButton'
And [Assertion] Verify IG 'CompanySizeTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'CompanySizeTable'
And [Input] I click on 'PPCancelButton'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex TC3S4 Apex Test Case Control and Monitoring - Master Files - Class-Subclass Linking

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'ClassSubclassLinkingSideMenu'
And [Assertion] Verify 'ClassTitle' equals 'p:Class' text
And [Assertion] Verify 'ClassTable' is visible
And [Input] I click on 'ClassAddRowButton'
And [Assertion] Verify IG 'ClassTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'ClassSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'ClassTable'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'SubClassTable' is visible
And [Input] I click on 'SubClassAddRowButton'
And [Assertion] Verify IG 'SubClassTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'SubClassSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'SubClassTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex TC3S5 Apex Test Case Control and Monitoring - Master Files - Customers Address Screen

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'CustomersAddressScreenSideMenu'
And [Assertion] Verify 'CustomerAddressTitle' equals 'p:CustomerAddress' text
And [Assertion] Verify 'CustomerAddressTable' is visible
And [Input] I click on 'CustomerAddressAddRowButton'
And [Progress] I wait for '5' sec
And [Assertion] Verify all fields in 'CustomerAddressRegionBody' are empty
And [Input] I click on 'CustomerAddressSaveButton'
And [Assertion] Verify 'LocationCAErrorMsg' contains 'p:LocationEmptyErrorMsg' text
And [Assertion] Verify 'OfficeErrorMsg' contains 'p:OfficeEmptyErrorMsg' text
And [Assertion] Verify 'EndtNoErrorMsg' contains 'p:EndtNoEmptyErrorMsg' text
And [Assertion] Verify 'EndtYearErrorMsg' contains 'p:EndtYearEmptyErrorMsg' text
And [Assertion] Verify 'EndtTypeErrorMsg' contains 'p:EndtTypeEmptyErrorMsg' text
And [Assertion] Verify 'DepartmentCAErrorMsg' contains 'p:DepartmentEmptyErrorMsg' text
And [Assertion] Verify 'COBErrorMsg' contains 'p:COBEmptyErrorMsg' text
And [Assertion] Verify 'SourceErrorMsg' contains 'p:SourceEmptyErrorMsg' text
And [Input] I click on 'CancelButton'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present