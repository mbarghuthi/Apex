Scenario:  TC_007_Apex 001 Apex Test Case Control and Monitoring - Workflow Integration - Map AMAN Fields with WF Attributes

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'WorkflowIntegrationSideMenu'
And [Input] I click on 'MapAmanFieldsWithWFAttributesSideMenu'
And [Assertion] Verify 'MapAmanFieldsWithWFAttributesMasterTitle' equals 'p:MapAmanFieldsWithWFAttributesMaster' text
And [Assertion] Verify 'MapAmanFieldsWithWFAttributesMasterTable' is visible
And [Input] I click on 'MapAmanFieldsWithWFAttributesMasterAddRowButton'
And [Assertion] Verify IG 'MapAmanFieldsWithWFAttributesMasterTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'MapAmanFieldsWithWFAttributesMasterTable'
And [Assertion] Verify 'MapAmanFieldsWithWFAttributesDetailsTable' is visible
And [Input] I click on 'MapAmanFieldsWithWFAttributesDetailsAddRowButton'
And [Assertion] Verify IG 'MapAmanFieldsWithWFAttributesDetailsTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'MapAmanFieldsWithWFAttributesDetailsTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_007_Apex 002 Apex Test Case Control and Monitoring - Workflow Integration - Workflow Build Queries

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'WorkflowIntegrationSideMenu'
And [Input] I click on 'WorkflowBuildQueriesSideMenu'
And [Assertion] Verify 'WorkflowBuildQueriesTitle' equals 'p:WorkflowBuildQueries' text
And [Assertion] Verify 'QueryTable' is visible
And [Assertion] Verify 'QueryColumnsTable' is visible
And [Assertion] Verify 'QueryConditionsTable' is visible
And [Assertion] Verify 'QueryJoinTable' is visible
And [Input] I click on 'QueryAddRowButton'
And [Assertion] Verify IG 'QueryTable' has an empty inserted row
And [Input] I click on 'QueryColumnsAddRowButton'
And [Assertion] Verify IG 'QueryColumnsTable' has an empty inserted row
And [Input] I click on 'QueryConditionsAddRowButton'
And [Assertion] Verify IG 'QueryConditionsTable' has an empty inserted row
And [Input] I click on 'QueryJoinAddRowButton'
And [Assertion] Verify IG 'QueryJoinTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'QueryJoinTable'
And [Action] I delete the inserted row in IG 'QueryConditionsTable'
And [Action] I delete the inserted row in IG 'QueryColumnsTable'
And [Action] I delete the inserted row in IG 'QueryTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_007_Apex 003 Apex Test Case Control and Monitoring - Workflow Integration - Workflow Services Setup

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'WorkflowIntegrationSideMenu'
And [Input] I click on 'WorkflowServicesSetupSideMenu'
And [Assertion] Verify 'WorkflowServicesSetupTitle' equals 'p:WorkflowServicesSetup' text
And [Assertion] Verify 'WorkflowServicesSetupTable' is visible
And [Input] I click on 'AddServiceSetupButton'
And [Javascript] I switch to iframe 'WorkflowServicesSetupIframe'
And [Input] I click on 'CreateButton'
And [Input] I click on 'CloseIconButton'
And [Assertion] Verify 'ProcessErrorMsg' contains 'p:ProcessEmptyErrorMsg' text
And [Assertion] Verify 'ApiStatusErrorMsg' contains 'p:ApiStatusEmptyErrorMsg' text
And [Assertion] Verify 'DepartmentErrorMsg' contains 'p:DepartmentEmptyErrorMsg' text
And [Assertion] Verify 'UrlErrorMsg' contains 'p:UrlEmptyErrorMsg' text
And [Assertion] Verify 'UserNameErrorMsg' contains 'p:UserNameEmptyErrorMsg' text
And [Assertion] Verify 'PasswordWSSErrorMsg' contains 'p:PasswordWSSEmptyErrorMsg' text
And [Input] I click on 'ProcessCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:AntifraudProcess' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'WorkflowServicesSetupIframe'
And [Input] I click on 'ApiStatusCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:NonActive' value from 'ApiStatusPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'WorkflowServicesSetupIframe'
And [Input] I click on 'DepartmentCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Motor' value from 'DepartmentPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'WorkflowServicesSetupIframe'
And [Input] Set 'UrlInput' value to 'random'
And [Input] Set 'UserNameInput' value to 'random'
And [Input] Set 'PasswordWSSInput' value to 'random'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'UrlErrorMsg' contains 'p:UrlInvalidErrorMsg' text
And [Input] I click on 'CancelButton'
And [Progress] I wait for '3' sec
And [Javascript] I switch back to main content
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present