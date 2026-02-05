Scenario:  TC_006_Apex 001 Apex Test Case Control and Monitoring - Mail & SMS - Mail and SMS Notification Configuration

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MailAndSmsSideMenu'
And [Input] I click on 'MailAndSmsNotificationConfigurationSideMenu'
And [Assertion] Verify 'MailAndSmsNotificationConfigurationTitle' equals 'p:MailAndSmsNotificationConfiguration' text
And [Assertion] Verify 'MailAndSmsNotificationConfigurationTable' is visible
And [Input] I click on 'MailAndSmsNotificationConfigurationAddRowButton'
And [Assertion] Verify IG 'MailAndSmsNotificationConfigurationTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'MailAndSmsNotificationConfigurationTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_006_Apex 002 Apex Test Case Control and Monitoring - Mail & SMS - Mail Setup

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MailAndSmsSideMenu'
And [Input] I click on 'MailSetupSideMenu'
And [Assertion] Verify 'MailSetupTitle' equals 'p:MailSetup' text
And [Assertion] Verify 'MailSetupTable' is visible
And [Input] I click on 'CreateButton'
And [Progress] I wait for '3' sec
And [Javascript] I switch to iframe 'MailSetupIframe'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'EmailSmtpErrorMsg' contains 'p:EmailSmtpEmptyErrorMsg' text
And [Assertion] Verify 'SmtpPortErrorMsg' contains 'p:SmtpPortEmptyErrorMsg' text
And [Input] Set 'SmtpPortInput' value to 'random'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'SmtpPortErrorMsg' contains 'p:SmtpPortInvalidErrorMsg' text
And [Input] Set 'EmailSmtpInput' value to 'randomen'
And [Action] I get value from 'EmailSmtpInput' and save it as 'EmailSmtpText'
And [Input] Set 'SmtpPortInput' value to 'random2'
And [Action] I get value from 'SmtpPortInput' and save it as 'SmtpPortText'
And [Input] I click on 'CreateButton'
And [Progress] I wait for '3' sec
And [Javascript] I switch back to main content
And [Input] Set 'MailSetupTableSearch' value to 'statemanager:EmailSmtpText'
And [Input] I press Enter on 'MailSetupTableSearch'
And [Progress] I wait for '3' sec
And [Input] I click on 'MailSetupTableEdit'
And [Javascript] I switch to iframe 'MailSetupIframe'
And [Input] I click on 'DeleteButton'
And [Progress] I wait for '3' sec
And [Javascript] I switch back to main content
And [Input] I click on 'DeleteButtonPopup'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_006_Apex 003 Apex Test Case Control and Monitoring - Mail & SMS - Mail & SMS Notifications

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MailAndSmsSideMenu'
And [Input] I click on 'MailAndSmsNotificationsSideMenu'
And [Assertion] Verify 'MailAndSmsNotificationsTitle' equals 'p:MailAndSmsNotifications' text
And [Assertion] Verify 'MSNotificationReportTable' is visible
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_006_Apex 004 Apex Test Case Control and Monitoring - Mail & SMS - SMS Notifications

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MailAndSmsSideMenu'
And [Input] I click on 'SmsNotificationsSideMenu'
And [Assertion] Verify 'SmsNotificationsTitle' equals 'p:SmsNotifications' text
And [Assertion] Verify 'SmsNotificationTable' is visible
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_006_Apex 005 Apex Test Case Control and Monitoring - Mail & SMS - SMS GateWay Definition

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MailAndSmsSideMenu'
And [Input] I click on 'SmsGateWayDefinitionSideMenu'
And [Assertion] Verify 'SmsGateWayDefinitionTitle' equals 'p:SmsGateWayDefinition' text
And [Assertion] Verify 'SmsGateWayDefinitionTable' is visible
And [Input] I click on 'SmsGateWayDefinitionAddRowButton'
And [Assertion] Verify IG 'SmsGateWayDefinitionTable' has an empty inserted row
!-- And [Progress] I wait for '3' sec
!-- And [Action] I delete the inserted row in IG 'SmsGateWayDefinitionTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present