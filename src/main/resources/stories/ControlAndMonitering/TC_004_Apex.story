Scenario:  TC_004_Apex 001 Apex Test Case Control and Monitoring - Users & Authorities - Users Definition

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'UsersDefinitionSideMenu'
And [Assertion] Verify 'UsersTitle' equals 'p:Users' text
And [Input] I click on 'UsersDefinitionNewUserButton'
!-- And [Assertion] Verify all fields in 'UserDefinitionRegionBody' are empty
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'EnUserNameErrorMsg' contains 'p:EnUserNameEmptyErrorMsg' text
And [Assertion] Verify 'UserIdErrorMsg' contains 'p:UserIdEmptyErrorMsg' text
And [Assertion] Verify 'UserTypeErrorMsg' contains 'p:UserTypeEmptyErrorMsg' text
And [Assertion] Verify 'UserTypePortalErrorMsg' contains 'p:UserTypePortalEmptyErrorMsg' text
!-- Fill all Fields in User Definition Invalid Values
And [Input] Set 'EnUserNameInput' value to 'random'
And [Input] Set 'UserIdInput' value to 'random2'
And [Input] Set 'ArUserNameInput' value to 'random'
And [Input] I click on 'UserTypeAgentRadioLabel'
And [Input] Select 'p:InvalidUser' value from 'UserTypeCombobox' dropdown list
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'EnUserNameErrorMsg' contains 'p:EnUserNameInvalidErrorMsg' text
And [Assertion] Verify 'UserIdErrorMsg' contains 'p:UserIdInvalidErrorMsg' text
And [Assertion] Verify 'ArUserNameErrorMsg' contains 'p:ArUserNameInvalidErrorMsg' text
And [Assertion] Verify 'UserPasswordErrorMsg' contains 'p:PasswordEmptyErrorMsg' text
And [Assertion] Verify 'ConfirmPasswordErrorMsg' contains 'p:ConfirmPasswordEmptyErrorMsg' text
And [Input] Set 'UserPasswordInput' value to '@'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'UserPasswordErrorMsg' contains 'p:PasswordInvalidErrorMsg' text
And [Input] Set 'UserEmailInput' value to 'random'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'UserEmailErrorMsg' contains 'p:UserEmailInvalidErrorMsg' text
!-- Fill all Fields in User Definition
And [Input] Set 'EnUserNameInput' value to 'randomen'
And [Action] I get value from 'EnUserNameInput' and save it as 'EnUserName'
And [Input] Set 'UserIdInput' value to 'random'
And [Action] I get value from 'UserIdInput' and save it as 'UserId'
And [Input] Set 'ArUserNameInput' value to 'randomar'
And [Action] I get value from 'EnUserNameInput' and save it as 'ArUserName'
And [Input] Set 'UserEmailInput' value to 'statemanageremail:EnUserName'
And [Input] Set 'UserMobileInput' value to 'random5'
And [Action] I get value from 'UserMobileInput' and save it as 'UserMobile'
And [Input] Select 'p:AmmarAhmedHamzaGhurab' value from 'UserManagerInput' dropdown list
And [Input] Set 'UserPasswordInput' value to 'p:password'
And [Input] Set 'ConfirmPasswordInput' value to 'p:password'
!-- PasswordExpiryInput
And [Assertion] Verify 'PasswordExpiryInput' value equals sysdate plus '1' years
And [Input] Select 'p:SaudiArabia' value from 'UserDefaultBranchCombobox' dropdown list
And [Input] Select 'p:KSAHeadOffice' value from 'UserDefaultOfficeCombobox' dropdown list
And [Input] Select 'p:CentralOther' value from 'UserDefaultRegionCombobox' dropdown list
And [Input] Select 'p:KSAHeadOffice' value from 'UserActualOfficeCombobox' dropdown list
And [Input] Select 'p:Motor' value from 'UserDeptNoCombobox' dropdown list
And [Input] Select 'p:InvalidUser' value from 'UserTypeCombobox' dropdown list
And [Input] Select 'p:NormalUser' value from 'UserGroupCombobox' dropdown list
And [Input] Select 'p:Yes' value from 'UserAuthorizedCombobox' dropdown list
And [Input] Select 'p:Both' value from 'UserLanguageCombobox' dropdown list
And [Input] I click on 'UserRoleIdButton'
And [Input] Select 'p:NormalUser' value from 'UserRoleIdPopupLOVSearchBar' dropdown list
!-- And [Input] Select 'p:WorkshopUser' value from 'WorkshopTypesCombobox' dropdown list
And [Input] I click on 'WorkshopTypesCombobox'
And [Input] Select 'p:WorkshopUser' value from 'WorkshopTypesPopupLOVSearchBar' dropdown list
And [Input] Select 'p:No' value from 'WorkFlowCombobox' dropdown list
And [Input] Select 'p:Broker' value from 'SellerTypeCombobox' dropdown list
And [Input] Set 'MenapayEmployeeNoInput' value to 'random5'
And [Input] Set 'MappedDmsUserInput' value to 'random5'
And [Input] Select 'p:Workshop' value from 'ApplicationTypeCombobox' dropdown list
And [Input] Set 'RemarksInput' value to 'random'
And [Input] I click on 'UserTypeAgentRadioLabel'
!-- UserCreatedDateInput
And [Assertion] Verify 'UserCreatedDateInput' value equals sysdate
!-- And [Input] I click on 'CreateButton'
!-- And [Input] Set 'SearchFieldUserTable' value to 'statemanager:EnUserName'
!-- And [Input] I press Enter on 'SearchFieldUserTable'
!-- After Create
!-- And [Assertion] Verify Radio  'UserTypeAgentRadio' is clicked on
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 002 Apex Test Case Control and Monitoring - Users & Authorities - Roles Definition

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'RolesDefinitionSideMenu'
And [Assertion] Verify 'RolesTable' is visible
And [Input] I click on 'RolesAddRowButton'
And [Assertion] Verify IG 'RolesTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'RolesTable'
And [Progress] I wait for '3' sec
And [Assertion] Verify 'RolesDetTable' is visible
And [Input] I click on 'RolesDetAddRowButton'
And [Assertion] Verify IG 'RolesDetTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'RolesDetTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 003 Apex Test Case Control and Monitoring - Users & Authorities - Users' Privileges On Locations & Branches

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'UsersPrivilegesOnLocationsAndBranchesSideMenu'
And [Input] I click on 'UsersDDL'
And [Input] Select 'p:AutouTestingAutomation' value from 'PopupLOVSearchBar' dropdown list
And [Assertion] Verify tab 'LocationTab' is selected
And [Assertion] Verify 'LocationTable' is visible
And [Input] I click on 'LocationAddRowButton'
And [Progress] I wait for '3' sec
And [Assertion] Verify IG 'LocationTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'LocationTable'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'UserRoleTable' is visible
!-- And [Input] I click on 'UserRoleAddRowButton'
!-- And [Assertion] Verify IG 'UserRoleTable' has an empty inserted row
!-- And [Action] I delete the inserted row in IG 'UserRoleTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 004 Apex Test Case Control and Monitoring - Users & Authorities - User'S Privileges On Group Programs Dept. Wise

Given [Navigation] I navigate to 'p:amanApex'


Scenario:  TC_004_Apex 005 Apex Test Case Control and Monitoring - Users & Authorities - User'S Privileges On Single Programs-List

Given [Navigation] I navigate to 'p:amanApex'


Scenario:  TC_004_Apex 006 Apex Test Case Control and Monitoring - Users & Authorities - Change Password

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'ChangePasswordSideMenu'
And [Assertion] Verify 'ChangePasswordTitle' equals 'p:ChangePassword' text
And [Assertion] Verify 'UserIdValue' equals 'p:adminUsername' text
And [Assertion] Verify 'UserENameValue' equals 'p:adminUsername' text
And [Input] I click on 'ChangePasswordApplyChangesButton'
And [Assertion] Verify 'ChangePasswordUserPasswordErrorMsg' equals 'p:ChangePasswordPasswordEmptyErrorMsg' text
And [Assertion] Verify 'ChangePasswordConfirmPasswordErrorMsg' equals 'p:ChangePasswordConfirmPasswordEmptyErrorMsg' text
And [Progress] I wait for '5' sec
And [Input] Set 'ChangePasswordUserPasswordInput' value to '@'
And [Input] Set 'ChangePasswordConfirmPasswordInput' value to '123'
And [Input] I click on 'ChangePasswordApplyChangesButton'
And [Assertion] Verify 'ChangePasswordUserPasswordErrorMsg' equals 'p:ChangePasswordPasswordInvalidErrorMsg' text
And [Assertion] Verify 'ChangePasswordConfirmPasswordErrorMsgPlaceHolder' equals 'p:ChangePasswordConfirmPasswordInvalidErrorMsg' text
And [Progress] I wait for '5' sec
And [Input] Set 'ChangePasswordUserPasswordInput' value to 'ab'
And [Input] Set 'ChangePasswordConfirmPasswordInput' value to '123'
And [Input] I click on 'ChangePasswordApplyChangesButton'
And [Assertion] Verify 'ChangePasswordUserPasswordErrorMsg' equals 'p:ChangePasswordPasswordInvalidErrorMsg2' text
And [Assertion] Verify 'ChangePasswordConfirmPasswordErrorMsgPlaceHolder' equals 'p:ChangePasswordConfirmPasswordInvalidErrorMsg' text
And [Progress] I wait for '5' sec
And [Input] Set 'ChangePasswordUserPasswordInput' value to 'p:password'
And [Input] Set 'ChangePasswordConfirmPasswordInput' value to 'p:password'
And [Input] I click on 'ChangePasswordApplyChangesButton'
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 007 Apex Test Case Control and Monitoring - Users & Authorities - Authorized Buttons

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'AuthorizedButtonsSideMenu'
And [Assertion] Verify 'AuthorizedButtonsTitle' equals 'p:AuthorizedButtons' text
And [Input] Select 'p:Home' value from 'ProgramCombobox' dropdown list
And [Assertion] Verify 'AuthorizedButtonsTable' is visible
And [Input] I click on 'AuthorizedButtonsApplyChangesButton'
And [Assertion] Verify IG 'AuthorizedButtonsTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'AuthorizedButtonsTable'
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 008 Apex Test Case Control and Monitoring - Users & Authorities - User Privileges On Endt Transactions

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'UserPrivilegesOnEndtTransactionsSideMenu'
And [Assertion] Verify 'UserPrivilegesOnEndtTransactionsTitle' equals 'p:UserPrivilegesOnEndtTransactions' text
And [Input] I click on 'UserNoCombobox'
And [Input] Select 'p:TestingAutomationId' value from 'PopupLOVSearchBar' dropdown list
And [Progress] I wait for '2' sec
!-- And [Input] Select 'p:TestingAutomationId' value from 'UserNoCombobox' dropdown list
And [Input] Select 'p:MotorPrivate' value from 'ClassNoCombobox' dropdown list
And [Progress] I wait for '2' sec
!-- And [Input] Select 'p:Comprehensive' value from 'TypeNoCombobox' dropdown list
And [Input] I click on 'TypeNoCombobox'
And [Input] Select 'p:Comprehensive' value from 'TypeNoPopupLOVSearchBar' dropdown list
And [Progress] I wait for '2' sec
And [Input] Select 'p:Agent' value from 'SourceCombobox' dropdown list
And [Assertion] Verify 'TransactionTypeTable' is visible
And [Input] I click on 'TransactionTypeAddRow'
And [Assertion] Verify IG 'TransactionTypeTable' has an empty inserted row
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 009 Apex Test Case Control and Monitoring - Users & Authorities - User Privileges On Claim Payments

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'UserPrivilegesOnClaimPaymentsSideMenu'
And [Assertion] Verify 'UserPrivilegesOnClaimPaymentsTitle' equals 'p:UserPrivilegesOnClaimPayments' text
And [Input] I click on 'UserCombobox'
And [Input] Select 'p:TestingAutomationId' value from 'PopupLOVSearchBar' dropdown list
And [Progress] I wait for '2' sec
And [Input] Select 'p:paymentEstimate' value from 'AuthorityCombobox' dropdown list
And [Assertion] Verify 'UAPTable' is visible
And [Input] I click on 'UAPAddRow'
And [Assertion] Verify IG 'UAPTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'UAPTable'
And [Input] I click on 'SaveButton'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 010 Apex Test Case Control and Monitoring - Users & Authorities - Password Policy Rules

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'PasswordPolicyRulesSideMenu'
And [Assertion] Verify 'PasswordPolicyRulesTitle' equals 'p:PasswordPolicyRules' text
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 011 Apex Test Case Control and Monitoring - Users & Authorities - User Access Violations

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'UserAccessViolationsSideMenu'
And [Assertion] Verify 'UserAccessViolationsTitle' equals 'p:UserAccessViolations' text
And [Assertion] Verify 'UserAccessViolationsTable' is visible
And [Assertion] Verify 'SuccessRadioButtons' is selected
And [Table] I save table snapshot from 'UserAccessViolationsTable' in variable 'SuccessSnap'
And [Input] I click on 'ViolationRadioButtons'
And [Progress] I wait for '10' sec
And [Table] Verify table 'UserAccessViolationsTable' snapshot differs from 'SuccessSnap'
And [Assertion] Verify 'ViolationRadioButtons' is selected
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 012 Apex Test Case Control and Monitoring - Users & Authorities - User Privileges On Quotation Posting

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'UserPrivilegesOnQuotationPostingSideMenu'
And [Assertion] Verify 'UserPrivilegeOnQuotationPostingTitle' equals 'p:UserPrivilegeOnQuotationPosting' text
And [Input] I click on 'UserIdCombobox'
And [Input] Select 'p:autouId' value from 'PopupLOVSearchBar' dropdown list
And [Assertion] Verify 'UserQuotationPostingTable' is visible
And [Input] I click on 'UserQuotationPostingAddRow'
And [Assertion] Verify IG 'UserQuotationPostingTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'UserQuotationPostingTable'
And [Input] I click on 'SaveButton'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex 013 Apex Test Case Control and Monitoring - Users & Authorities - Link Region/City Screen

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'UsersAndAuthoritiesSideMenu'
And [Input] I click on 'LinkRegionCityScreenSideMenu'
And [Assertion] Verify 'LinkRegionCityScreenTitle' equals 'p:LinkRegionCityScreen' text
And [Input] I click on 'RangesCombobox'
And [Input] Select 'p:CentralOther' value from 'PopupLOVSearchBar' dropdown list
And [Assertion] Verify 'RangesTable' is visible
And [Input] I click on 'RangesAddRow'
And [Assertion] Verify IG 'RangesTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'RangesTable'
And [Input] I click on 'SaveButton'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present