Scenario:  TC_001_Apex 001 Apex Test Case FGA - Codes Definition Linking Setup - FGA Address

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'CodesDefinitionLinkingSetupSideMenu'
And [Input] I click on 'FGAAddressSideMenu'
And [Assertion] Verify 'FGAAddressTitle' equals 'p:FGAAddress' text
And [Assertion] Verify 'FGAAddressTable' is visible
And [Input] I click on 'FGAAddressAddRowButton'
And [Assertion] Verify IG 'FGAAddressTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'FGAAddressSaveButton'
And [Input] I click on 'FGAAddressSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
!-- And [Action] I delete the inserted row in IG 'FGAAddressTable'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 002 Apex Test Case FGA - Codes Definition Linking Setup - Household Contents Definition

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'CodesDefinitionLinkingSetupSideMenu'
And [Input] I click on 'HouseholdContentsDefinitionSideMenu'
And [Input] Select 'p:Buildings' value from 'SysMinorCombobox' dropdown list
And [Progress] I wait for '3' sec
And [Assertion] Verify 'HouseholdContentsDefinitionTable' is visible
And [Input] I click on 'HouseholdContentsDefinitionAddRowButton'
And [Assertion] Verify IG 'HouseholdContentsDefinitionTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'HouseholdContentsDefinitionSaveButton'
And [Input] I click on 'HouseholdContentsDefinitionSaveButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
!-- And [Action] I delete the inserted row in IG 'HouseholdContentsDefinitionTable'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_001_Apex 003 Apex Test Case FGA - Codes Definition Linking Setup - FGA Cover Groups Definition

Given [Navigation] I navigate to 'p:amanApex'
