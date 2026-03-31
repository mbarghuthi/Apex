Scenario:  TC_002_Apex TC2S1 Apex Test Case Control and Monitoring - General Business Tariffs - Sum Insured Ranges

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'GeneralBusinessTariffsSideMenu'
And [Input] I click on 'SumInsuredRangesSideMenu'
And [Assertion] Verify 'SumInsuredRangesTitle' equals 'p:SumInsuredRanges' text
And [Input] Select 'p:DepartmentWise' value from 'ReportTypeCombobox' dropdown list
And [Progress] I wait for '3' sec
And [Input] Select 'p:Motor' value from 'ReportValueCombobox' dropdown list
And [Progress] I wait for '3' sec
And [Assertion] Verify 'SumInsuredRangesTable' is visible
And [Input] I click on 'SumInsuredRangesAddRowButton'
And [Assertion] Verify IG 'SumInsuredRangesTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'SumInsuredRangesSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'SumInsuredRangesTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_002_Apex TC2S2 Apex Test Case Control and Monitoring - General Business Tariffs - Short Period Tariff

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'GeneralBusinessTariffsSideMenu'
And [Input] I click on 'ShortPeriodTariffSideMenu'
And [Assertion] Verify 'ShortPeriodTariffTitle' equals 'p:ShortPeriodTariff' text
And [Input] Select 'p:MotorPrivate' value from 'ClassCombobox' dropdown list
And [Input] Select 'p:Comprehensive' value from 'PolicyTypeCombobox' dropdown list
And [Progress] I wait for '10' sec
And [Assertion] Verify 'ShortPeriodTariffTable' is visible
And [Input] I click on 'ShortPeriodTariffAddRowButton'
And [Assertion] Verify IG 'ShortPeriodTariffTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'ShortPeriodTariffSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'ShortPeriodTariffTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_002_Apex TC2S3 Apex Test Case Control and Monitoring - General Business Tariffs - Pro-Rata Period Tariff

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'GeneralBusinessTariffsSideMenu'
And [Input] I click on 'ProRataPeriodTariffSideMenu'
And [Assertion] Verify 'ProRataPeriodTariffTitle' equals 'p:ProRataPeriodTariff' text
And [Assertion] Verify 'ProRataPeriodTariffTable' is visible
And [Input] I click on 'ProRataPeriodTariffAddRowButton'
And [Assertion] Verify IG 'ProRataPeriodTariffTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'ProRataPeriodTariffSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
!-- And [Action] I delete the inserted row in IG 'ProRataPeriodTariffTable'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present

