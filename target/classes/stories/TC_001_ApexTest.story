Scenario:  TC_001_Apex 001 Apex Test Case Testing

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
And [Input] I click on 'BranchesSaveButton'
And [Input] I click on 'BranchesSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'PPOkButton'
And [Navigation] I reload page
And [Input] I click on 'PeriodsTab'
And [Assertion] Verify tab 'PeriodsTab' is selected
And [Assertion] Verify 'PeriodsTable' is visible
And [Navigation] I scroll to 'PeriodsAddRowButton'
And [Input] I click on 'PeriodsAddRowButton'
And [Assertion] Verify IG 'PeriodsTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'PeriodsTable'
And [Input] I click on 'CommissionTab'
And [Assertion] Verify tab 'CommissionTab' is selected
And [Assertion] Verify 'CommissionTable' is visible
And [Navigation] I scroll to 'CommissionAddRowButton'
And [Input] I click on 'CommissionAddRowButton'
And [Assertion] Verify IG 'CommissionTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'CommissionSaveButton'
And [Input] I click on 'CommissionSaveButton'
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
