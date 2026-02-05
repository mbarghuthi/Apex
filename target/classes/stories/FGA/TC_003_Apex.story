Scenario:  TC_003_Apex 001 Apex Test Case FGA - Malpractice Setup - Categories-Professions Definition

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'MalpracticeSetupSideMenu'
And [Input] I click on 'CategoriesProfessionsDefinitionSideMenu'
And [Assertion] Verify tab 'CategoriesTab' is selected
And [Assertion] Verify 'CategoriesTable' is visible
And [Input] I click on 'CategoriesAddRowButton'
And [Assertion] Verify IG 'CategoriesTable' has an empty inserted row
And [Navigation] I reload page
And [Input] I click on 'ProfessionsTab'
And [Assertion] Verify tab 'ProfessionsTab' is selected
And [Assertion] Verify 'ProfessionsTable' is visible
And [Input] I click on 'ProfessionsAddRowButton'
And [Assertion] Verify IG 'ProfessionsTable' has an empty inserted row
And [Navigation] I reload page
And [Input] I click on 'LinkingTab'
And [Assertion] Verify tab 'LinkingTab' is selected
And [Assertion] Verify 'LinkingTable' is visible
And [Input] I click on 'LinkingAddRowButton'
And [Assertion] Verify IG 'LinkingTable' has an empty inserted row
And [Navigation] I reload page
And [Input] I click on 'CategoriesTab'
And [Assertion] Verify tab 'CategoriesTab' is selected
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 002 Apex Test Case FGA - Malpractice Setup - Coverage Limit AOO-AAA

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'MalpracticeSetupSideMenu'
And [Input] I click on 'CoverageLimitAOO_AAASideMenu'
And [Assertion] Verify 'CoverageLimitAOO_AAATitle' equals 'p:CoverageLimitAOO_AAA' text
And [Assertion] Verify 'CoverageLimitAOO_AAATable' is visible
And [Input] I click on 'CoverageLimitAOO_AAAAddRowButton'
And [Assertion] Verify IG 'CoverageLimitAOO_AAATable' has an empty inserted row
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 003 Apex Test Case FGA - Malpractice Setup - Malpractice Tariff Definition

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'MalpracticeSetupSideMenu'
And [Input] I click on 'MalpracticeTariffDefinitionSideMenu'
And [Assertion] Verify 'MalpracticeTariffDefinitionTitle' equals 'p:MalpracticeTariffDefinition' text
And [Assertion] Verify 'MalpracticeTariffDefinitionTable' is visible
And [Input] I click on 'MalpracticeTariffDefinitionAddRowButton'
And [Assertion] Verify IG 'MalpracticeTariffDefinitionTable' has an empty inserted row
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 004 Apex Test Case FGA - Malpractice Setup - Malpractice Questions

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'MalpracticeSetupSideMenu'
And [Input] I click on 'MalpracticeQuestionsSideMenu'
And [Assertion] Verify 'MalpracticeQuestionsTitle' equals 'p:MalpracticeQuestions' text
And [Assertion] Verify 'MalpracticeQuestionsTable' is visible
And [Input] I click on 'MalpracticeQuestionsAddRowButton'
And [Assertion] Verify IG 'MalpracticeQuestionsTable' has an empty inserted row
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 005 Apex Test Case FGA - Malpractice Setup - MMP Periods

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'MalpracticeSetupSideMenu'
And [Input] I click on 'MMPPeriodsSideMenu'
And [Assertion] Verify 'MMPPeriodsTitle' equals 'p:MMPPeriods' text
And [Input] Select 'p:AdditionalRetroactivePeriod' value from 'MMPPeriodsCombobox' dropdown list
And [Assertion] Verify 'MMPPeriodsCombobox' selected value equals 'p:AdditionalRetroactivePeriod'
And [Assertion] Verify 'MMPPeriodsTable' is visible
And [Input] I click on 'MMPPeriodsAddRowButton'
And [Assertion] Verify IG 'MMPPeriodsTable' has an empty inserted row
And [Navigation] I reload page
And [Progress] I wait for '3' sec
And [Input] Select 'p:ExtendedReportingPeriod' value from 'MMPPeriodsCombobox' dropdown list
And [Assertion] Verify 'MMPPeriodsCombobox' selected value equals 'p:ExtendedReportingPeriod'
And [Assertion] Verify 'MMPPeriodsTable' is visible
And [Input] I click on 'MMPPeriodsAddRowButton'
And [Assertion] Verify IG 'MMPPeriodsTable' has an empty inserted row
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present