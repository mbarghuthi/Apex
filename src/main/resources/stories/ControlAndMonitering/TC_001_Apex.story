Scenario:  TC_001_Apex 001 Apex Test Case Control and Monitoring - Aman Setup - Programs

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'ProgramsSideMenu'
And [Assertion] Verify 'ProgramsTitle' equals 'Programs' text
And [Input] Set 'SearchTreeInput' value to 'Quotation'
!-- And [Assertion] Verify all results in tree 'ProgramsTree' contain 'Quotation'
And [Action] I count results in tree 'ProgramsTree' that contain 'Quotation' and save it as 'QuotationCount'
And [Input] Clear 'SearchTreeInput' field
And [Input] I press Enter on 'SearchTreeInput'
And [Assertion] Verify tree 'ProgramsTree' count for 'Quotation' equals saved value 'QuotationCount'
And [Navigation] I reload page
And [Progress] I wait for '3' sec
And [Assertion] Verify tree 'ProgramsTree' is 'collapsed'
And [Input] I click on 'ExpandCollapseButton'
And [Progress] I wait for '3' sec
And [Assertion] Verify tree 'ProgramsTree' is 'expanded'
And [Input] I click on 'QuotationsChild'
And [Javascript] I switch to iframe 'ProgramDetailsIframe'
And [Assertion] Verify 'ApplicationCombobox' selected value equals 'Quotation'
And [Javascript] I switch back to main content
And [Javascript] I switch to iframe 'ProgramDetailsIframe'
And [Assertion] Verify APEX checkbox 'StatusCheckbox' is checked
And [Assertion] Verify APEX checkbox 'DisplayOnMenuCheckbox' is checked
And [Javascript] I switch back to main content
And [Input] I click on 'ProgramIframeCloseButton'
And [Javascript] I switch back to main content
And [Input] I click on 'ExpandCollapseButton'
And [Progress] I wait for '3' sec
And [Assertion] Verify tree 'ProgramsTree' is 'collapsed'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 002 Apex Test Case Control and Monitoring - Aman Setup - System Code Ranks

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'ControlAndMoniteringCardDashboard'
And [Input] I click on 'SystemCodeRanksCardDashboard'
And [Assertion] Verify 'SystemCodeRanksMajorTitle' equals 'p:SystemCodeRanksMajor' text
And [Assertion] Verify 'SystemCodeRanksMajorTable' is visible
And [Input] I click on 'SystemCodeRanksMajorAddButton'
And [Assertion] Verify IG 'SystemCodeRanksMajorTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'SystemCodeRanksMajorSaveButton'
And [Input] I click on 'SystemCodeRanksMajorSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'SystemCodeRanksMajorTable'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'SystemCodeRanksMinorTable' is visible
And [Input] I click on 'SystemCodeRanksMinorAddButton'
And [Assertion] Verify IG 'SystemCodeRanksMinorTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'SystemCodeRanksMinorSaveButton'
And [Input] I click on 'SystemCodeRanksMinorSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'SystemCodeRanksMinorTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 003 Apex Test Case Control and Monitoring - Aman Setup - Error Messages

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'ErrorMessagesSideMenu'
And [Assertion] Verify 'ErrorMessagesTitle' equals 'p:ErrorMessages' text
And [Assertion] Verify 'ErrorMessagesTable' is visible
And [Input] I click on 'ErrorMessagesAddRowButton'
And [Assertion] Verify IG 'ErrorMessagesTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'ErrorMessagesSaveButton'
And [Input] I click on 'ErrorMessagesSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'ErrorMessagesTable'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'ErrorMessagesDetailsTable' is visible
And [Input] I click on 'ErrorMessagesDetailsAddRowButton'
And [Assertion] Verify IG 'ErrorMessagesDetailsTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'ErrorMessagesDetailsSaveButton'
And [Input] I click on 'ErrorMessagesDetailsSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'ErrorMessagesDetailsTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 004 Apex Test Case Control and Monitoring - Aman Setup - Departments

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'DepartmentsSideMenu'
And [Assertion] Verify 'DepartmentsTitle' equals 'p:Departments' text
And [Assertion] Verify 'DepartmentsTable' is visible
!-- And [Input] I click on 'ErrorMessagesAddRowButton'
!-- And [Assertion] Verify IG 'ErrorMessagesTable' has an empty inserted row
!-- And [Action] I delete the inserted row in IG 'ErrorMessagesTable'
!-- And [Progress] I wait for '5' sec
And [Assertion] Verify 'ClassesTable' is visible
!-- And [Input] I click on 'ErrorMessagesDetailsAddRowButton'
!-- And [Assertion] Verify IG 'ErrorMessagesDetailsTable' has an empty inserted row
!-- And [Action] I delete the inserted row in IG 'ErrorMessagesDetailsTable'
And [Assertion] Verify 'PoliciesTable' is visible
And [Assertion] Verify 'RisksTable' is visible
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 005 Apex Test Case Control and Monitoring - Aman Setup - Government Occupation

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'GovermentOccupationSideMenu'
And [Assertion] Verify 'GovernmentOccupationTitle' equals 'p:GovernmentOccupation' text
And [Assertion] Verify 'GovernmentOccupationTable' is visible
And [Assertion] Verify 'MaleRadioButtons' is selected
And [Input] I click on 'GovernmentOccupationAddRowButton'
And [Assertion] Verify IG 'GovernmentOccupationTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'GovernmentOccupationTable'
And [Progress] I wait for '5' sec
And [Input] I click on 'GovernmentOccupationSaveButton'
And [Table] I save table snapshot from 'GovernmentOccupationTableValue' in variable 'MaleSnap'
And [Input] I click on 'FemaleRadioButtons'
And [Progress] I wait for '10' sec
And [Table] Verify table 'GovernmentOccupationTableValue' snapshot differs from 'MaleSnap'
And [Assertion] Verify 'FemaleRadioButtons' is selected
And [Input] I click on 'GovernmentOccupationAddRowButton'
And [Assertion] Verify IG 'GovernmentOccupationTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'GovernmentOccupationTable'
And [Progress] I wait for '5' sec
And [Input] I click on 'GovernmentOccupationSaveButton'
And [Table] I save table snapshot from 'GovernmentOccupationTableValue' in variable 'FemaleSnap'
And [Input] I click on 'MaleRadioButtons'
And [Progress] I wait for '10' sec
And [Table] Verify table 'GovernmentOccupationTableValue' snapshot differs from 'FemaleSnap'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 006 Apex Test Case Control and Monitoring - Aman Setup - Address Ordering

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'AddressOrderingSideMenu'
And [Assertion] Verify 'AddressOrderingTitle' equals 'p:AddressOrdering' text
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 007 Apex Test Case Control and Monitoring - Aman Setup - Black List

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'BlackListSideMenu'
And [Assertion] Verify 'BlackListTitle' equals 'p:BlackList' text
And [Assertion] Verify 'BlackListTable' is visible
And [Input] I click on 'BlackListAddRowButton'
And [Assertion] Verify IG 'BlackListTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'BlackListTable'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'BlackListDetTable' is visible
And [Input] I click on 'BlackListDetAddRowButton'
And [Assertion] Verify IG 'BlackListDetTable' has an empty inserted row
And [Navigation] I reload page
!-- And [Javascript] I accept alert
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 008 Apex Test Case Control and Monitoring - Aman Setup - Domicile Locations

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'DomicileLocationsSideMenu'
And [Assertion] Verify 'DomicileLocationsTitle' equals 'p:DomicileLocations' text
And [Assertion] Verify 'DomicileLocationsTable' is visible
And [Input] I click on 'DomicileLocationsAddRowButton'
And [Assertion] Verify IG 'DomicileLocationsTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'DomicileLocationsSaveButton'
And [Input] I click on 'DomicileLocationsSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'DomicileLocationsTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present

Scenario:  TC_001_Apex 009 Apex Test Case Control and Monitoring - Aman Setup - System Owner Setup

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'AmanSetupSideMenu'
And [Input] I click on 'SystemOwnerSetupSideMenu'
And [Assertion] Verify tab 'GeneralInformationTab' is selected
And [Input] I click on 'SettingsTab'
And [Assertion] Verify tab 'SettingsTab' is selected
And [Input] I click on 'ApplicationConfigurationTab'
And [Assertion] Verify tab 'ApplicationConfigurationTab' is selected
!-- table-add save delete
And [Assertion] Verify 'ApplicationConfigurationTable' is visible
And [Input] I click on 'ApplicationConfigurationAddRowButton'
And [Assertion] Verify IG 'ApplicationConfigurationTable' has an empty inserted row
!-- And [Progress] I wait for '5' sec
!-- And [Input] I click on 'ApplicationConfigurationSaveButton'
!-- And [Input] I click on 'ApplicationConfigurationSaveButton'
!-- And [Assertion] Verify 'AlertMsgBody' contains 'p:ThereAreUnsavedChangesDoYouWantToContinue' text
!-- And [Input] I click on 'OkButton'
And [Action] I delete the inserted row in IG 'ApplicationConfigurationTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present