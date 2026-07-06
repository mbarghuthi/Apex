Scenario:  TC_004_Apex TC4S1 Apex Test Case FGA - Travel Setup - Travel Calculation Prices

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'TravelSetupSideMenu'
And [Input] I click on 'TravelCalculationPricesSideMenu'
And [Assertion] Verify 'TravelCalculationPricesTitle' equals 'p:TravelCalculationPrices' text
And [Assertion] Verify 'TravelCalculationPricesTable' is visible
And [Input] I click on 'TravelCalculationPricesAddRowButton'
And [Assertion] Verify IG 'TravelCalculationPricesTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'TravelCalculationPricesSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex TC4S2 Apex Test Case FGA - Travel Setup - Travel Days

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'TravelSetupSideMenu'
And [Input] I click on 'TravelDaysSideMenu'
And [Assertion] Verify 'TravelDaysTitle' equals 'p:TravelDays' text
And [Assertion] Verify 'TravelDaysTable' is visible
And [Input] I click on 'TravelDaysAddRowButton'
And [Assertion] Verify IG 'TravelDaysTable' has an empty inserted row
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_004_Apex TC4S3 Apex Test Case FGA - Travel Setup - Key Benefits

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'FGASideMenu'
And [Input] I click on 'TravelSetupSideMenu'
And [Input] I click on 'KeyBenefitsSideMenu'
And [Assertion] Verify 'KeyBenefitsTitle' equals 'p:KeyBenefits' text
And [Assertion] Verify 'KeyBenefitsTable' is visible
And [Input] I click on 'KeyBenefitsAddRowButton'
And [Assertion] Verify IG 'KeyBenefitsTable' has an empty inserted row
And [Progress] I wait for '5' sec
And [Input] I click on 'KeyBenefitsSaveButton' and if 'AlertDialog' not appear reclick
And [Assertion] Verify 'AlertMsgBody' contains 'p:CorrectErrorsBeforeSaving' text
And [Input] I click on 'OkButton'
And [Navigation] I reload page
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present