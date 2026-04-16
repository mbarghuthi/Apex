Scenario:  TC_005_Apex TC5S1 Apex Test Case Control and Monitoring - Aman Control - Effective Date Grace Period

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanControlSideMenu'
And [Input] I click on 'EffectiveDateGracePeriodSideMenu'
And [Assertion] Verify 'EffectiveDateGracePeriodTitle' equals 'p:EffectiveDateGracePeriod' text
And [Assertion] Verify 'EffectiveDateGraceTable' is visible
And [Input] I click on 'CreateButton'
And [Javascript] I switch to iframe 'EffectiveDateGracePeriodIframe'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'DeptNoErrorMsg' contains 'p:DepartmentNoEmptyErrorMsg' text
And [Assertion] Verify 'ClassNoEDGPErrorMsg' contains 'p:ClassNoEDGPEmptyErrorMsg' text
And [Assertion] Verify 'PolicyTypeEDGPErrorMsg' contains 'p:PolicyTypeEDGPEmptyErrorMsg' text
And [Assertion] Verify 'FutureNoOfDaysErrorMsg' contains 'p:FutureNoOfDaysEmptyErrorMsg' text
And [Input] Set 'FutureNoOfDaysInput' value to 'random'
And [Input] Set 'BackdatedNoOfDaysInput' value to 'random'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'FutureNoOfDaysErrorMsg' contains 'p:FutureNoOfDaysInvalidErrorMsg' text
And [Assertion] Verify 'BackdatedNoOfDaysErrorMsg' contains 'p:BackdatedNoOfDaysInvalidErrorMsg' text
And [Input] I click on 'CancelButton'
And [Progress] I wait for '3' sec
And [Input] I click on 'CreateButton'
And [Javascript] I switch to iframe 'EffectiveDateGracePeriodIframe'
And [Input] I click on 'DeptNoCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Motor' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'EffectiveDateGracePeriodIframe'
And [Input] I click on 'ClassNoEDGPCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:MotorPrivate' value from 'ClassNoEDGPPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'EffectiveDateGracePeriodIframe'
And [Input] I click on 'PolicyTypeEDGPCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Comprehensive' value from 'PolicyTypeEDGPPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'EffectiveDateGracePeriodIframe'
And [Input] I click on 'EndorsementTypeCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Refund' value from 'EndorsementTypePopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'EffectiveDateGracePeriodIframe'
And [Input] Set 'FutureNoOfDaysInput' value to 'random2'
And [Input] Set 'BackdatedNoOfDaysInput' value to 'random2'
And [Input] I click on 'CancelButton'
And [Javascript] I switch back to main content
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_005_Apex TC5S2 Apex Test Case Control and Monitoring - Aman Control - Control Dates

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanControlSideMenu'
And [Input] I click on 'ControlDatesSideMenu'
And [Assertion] Verify 'ControlDatesTitle' equals 'p:ControlDates' text
And [Assertion] Verify 'ControlDatesTable' is visible
And [Progress] I wait for '5' sec
And [Input] I click on 'CreateButton'
And [Progress] I wait for '5' sec
And [Javascript] I switch to iframe 'ControlDatesIframe'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'LocationCDErrorMsg' contains 'p:LocationCDEmptyErrorMsg' text
And [Assertion] Verify 'BranchErrorMsg' contains 'p:BranchEmptyErrorMsg' text
And [Assertion] Verify 'ProgramCDErrorMsg' contains 'p:ProgramCDEmptyErrorMsg' text
And [Assertion] Verify 'MonthErrorMsg' contains 'p:MonthEmptyErrorMsg' text
And [Assertion] Verify 'YearErrorMsg' contains 'p:YearEmptyErrorMsg' text
And [Assertion] Verify 'StatusErrorMsg' contains 'p:StatusEmptyErrorMsg' text
And [Input] Set 'MonthInput' value to 'random'
And [Input] Set 'YearInput' value to 'random'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'MonthErrorMsg' contains 'p:MonthInvalidErrorMsg' text
And [Assertion] Verify 'YearErrorMsg' contains 'p:YearInvalidErrorMsg' text
And [Input] I click on 'CancelButton'
And [Progress] I wait for '3' sec
And [Input] I click on 'CreateButton'
And [Javascript] I switch to iframe 'ControlDatesIframe'
And [Input] I click on 'LocationCDCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:SaudiArabia' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'ControlDatesIframe'
And [Input] I click on 'BranchCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:KSAHeadOffice' value from 'BranchEDGPPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'ControlDatesIframe'
And [Input] I click on 'ProgramCDCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Home' value from 'ProgramCDPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'ControlDatesIframe'
And [Input] Set 'MonthInput' value to 'random2'
And [Input] Set 'YearInput' value to 'random2'
And [Input] I click on 'StatusCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Open' value from 'StatusPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'ControlDatesIframe'
And [Input] I click on 'CancelButton'
And [Javascript] I switch back to main content
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_005_Apex TC5S3 Apex Test Case Control and Monitoring - Aman Control - Control Dates (Groups)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanControlSideMenu'
And [Input] I click on 'ControlDatesGroupsSideMenu'
And [Assertion] Verify 'ControlDatesGroupsTitle' equals 'p:ControlDatesGroups' text
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_005_Apex TC5S4 Apex Test Case Control and Monitoring - Aman Control - Commision Definition

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanControlSideMenu'
And [Input] I click on 'CommisionDefinitionSideMenu'
And [Assertion] Verify 'CommissionDefinitionTitle' equals 'p:CommissionDefinition' text
And [Assertion] Verify 'CommissionDefinitionTable' is visible
And [Input] I click on 'CommissionDefinitionAddRowButton'
And [Assertion] Verify IG 'CommissionDefinitionTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'CommissionDefinitionSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'CommissionDefinitionTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_005_Apex TC5S5 Apex Test Case Control and Monitoring - Aman Control - Import From Excel Advanced

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanControlSideMenu'
And [Input] I click on 'ImportFromExcelAdvancedSideMenu'
And [Assertion] Verify 'ImportFromExcelAdvancedTitle' equals 'p:ImportFromExcelAdvanced' text
And [Progress] I wait for '3' sec
!-- And [Navigation] I scroll to 'StartImportButton'
!-- And [Input] I click on 'StartImportButton'
!-- And [Assertion] Verify 'DescriptionErrorMsg' contains 'p:DescriptionEmptyErrorMsg' text
!-- And [Assertion] Verify 'NoOfColumnsErrorMsg' contains 'p:NoOfColumnsEmptyErrorMsg' text
!-- Fill No Of Columns with invalid value and assert error message
And [Input] I click on 'DescriptionCombobox'
And [Input] Select 'p:ImportBatchesAndMedicalClaims' value from 'PopupLOVSearchBar' dropdown list
And [Input] I click on 'NoOfColumnsInput'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'OwnerInput' is filled
And [Assertion] Verify 'TableNameInput' is filled
And [Assertion] Verify 'NoOfColumnsInput' is filled
And [Progress] I wait for '5' sec
And [Input] I click on 'ClearButton'
And [Assertion] Verify 'OwnerInput' is not filled
And [Assertion] Verify 'TableNameInput' is not filled
And [Assertion] Verify 'NoOfColumnsInput' is not filled
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_005_Apex TC5S6 Apex Test Case Control and Monitoring - Aman Control - Excel Defintion

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanControlSideMenu'
And [Input] I click on 'ExcelDefintionSideMenu'
And [Assertion] Verify 'ExcelDefintionTitle' equals 'p:ExcelDefintion' text
And [Assertion] Verify 'ExcelDefintionTable' is visible
And [Input] I click on 'CreateButton'
And [Progress] I wait for '3' sec
And [Assertion] Verify 'ColumnsTable' is visible
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'DescriptionEDErrorMsg' contains 'p:DescriptionEDEmptyErrorMsg' text
And [Assertion] Verify 'TableOwnerErrorMsg' contains 'p:TableOwnerEmptyErrorMsg' text
And [Assertion] Verify 'TableNameErrorMsg' contains 'p:TableNameEmptyErrorMsg' text
And [Assertion] Verify 'NoOfColumnsEDErrorMsg' contains 'p:NoOfColumnsEDEmptyErrorMsg' text
And [Input] Set 'NoOfColumnsEDInput' value to 'random'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'NoOfColumnsEDErrorMsg' contains 'p:NoOfColumnsEDInvalidErrorMsg' text
And [Assertion] Verify tab 'ColumnsTab' is selected
And [Assertion] Verify 'ColumnsTable' is visible
And [Navigation] I scroll to 'ColumnsAddRowButton'
And [Input] I click on 'ColumnsAddRowButton'
And [Assertion] Verify IG 'ColumnsTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'ColumnsSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Navigation] I reload page
And [Assertion] Verify tab 'ColumnsTab' is selected
And [Input] I click on 'ConstraintsTab'
And [Assertion] Verify tab 'ConstraintsTab' is selected
And [Assertion] Verify 'ConstraintsTable' is visible
And [Input] I click on 'CancelButton'
And [Assertion] Verify 'ExcelDefintionTable' is visible
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present