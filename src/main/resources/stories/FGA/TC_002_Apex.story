Scenario:  TC_002_Apex TC2S1 Apex Test Case FGA - Premium Tariffs Setup - FGA Rates Tariff

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'PremiumTariffsSetupSideMenu'
And [Input] I click on 'FGARatesTariffSideMenu'
And [Assertion] Verify 'FGARatesTariffTitle' equals 'p:FGARatesTariff' text
And [Assertion] Verify 'FGARatesTariffTable' is visible
And [Input] I click on 'FGARatesTariffAddRowButton'
And [Assertion] Verify IG 'FGARatesTariffTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'FGARatesTariffSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
!-- And [Action] I delete the inserted row in IG 'FGARatesTariffTable'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_002_Apex TC2S2 Apex Test Case FGA - Premium Tariffs Setup - FGA Rates (Percentages & Permils)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'PremiumTariffsSetupSideMenu'
And [Input] I click on 'FGARatesPercentagesPermilsSideMenu'
And [Assertion] Verify 'FGARatesPercentagesPermilsTitle' equals 'p:FGARatesPercentagesPermils' text
And [Assertion] Verify 'FGARatesPercentagesPermilsTable' is visible
And [Input] I click on 'FGARatesPercentagesPermilsAddRowButton'
And [Assertion] Verify IG 'FGARatesPercentagesPermilsTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'FGARatesPercentagesPermilsSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
!-- And [Action] I delete the inserted row in IG 'FGARatesPercentagesPermilsTable'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_002_Apex TC2S3 Apex Test Case FGA - Premium Tariffs Setup - Short Period Tariff(FGA Enorsement)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'PremiumTariffsSetupSideMenu'
And [Input] I click on 'ShortPeriodTariffFGAEndorsementSideMenu'
And [Assertion] Verify 'ShortPeriodTariffFGAEndorsementTitle' equals 'p:ShortPeriodTariffFGAEnorsement' text
And [Assertion] Verify 'ShortPeriodTariffFGAEndorsementTable' is visible
And [Input] I click on 'ShortPeriodTariffFGAEndorsementAddRowButton'
And [Assertion] Verify IG 'ShortPeriodTariffFGAEndorsementTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'ShortPeriodTariffFGAEndorsementSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
!-- And [Action] I delete the inserted row in IG 'ShortPeriodTariffFGAEndorsementTable'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_002_Apex TC2S4 Apex Test Case FGA - Premium Tariffs Setup - Fire Premium Setup

Given [Navigation] I navigate to 'p:amanApex'


Scenario:  TC_002_Apex TC2S5 Apex Test Case FGA - Premium Tariffs Setup - Earthquake Rate

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'PremiumTariffsSetupSideMenu'
And [Input] I click on 'EarthquakeRateSideMenu'
And [Assertion] Verify 'EarthquakeRateTitle' equals 'p:EarthquakeRate' text
And [Assertion] Verify 'EarthquakeRateTable' is visible
And [Input] I click on 'EarthquakeRateAddRowButton'
And [Assertion] Verify IG 'EarthquakeRateTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'EarthquakeRateSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
!-- And [Action] I delete the inserted row in IG 'EarthquakeRateTable'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present