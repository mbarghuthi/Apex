Scenario:  TC_002_Apex 001 Apex Test Case Home Page

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Assertion] Verify 'UserDDL' contains 'p:adminUsername' text
And [Progress] I wait for '5' sec
!-- Make sure that the home module appear
When [Assertion] Verify 'DashboardButton' is visible

!-- Check every card on the home page where it direct
And [Input] I click on 'ControlAndMoniteringCardDashboard'
And [Assertion] Verify 'SystemCodeRanksCardDashboard' is visible
And [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'HomeSideMenu'
And [Assertion] Verify 'DashboardButton' is visible

And [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'HomeSideMenu'
And [Assertion] Verify 'DashboardButton' is visible

And [Input] I click on 'GeneralCardDashboard'
!-- And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'HomeSideMenu'
And [Assertion] Verify 'DashboardButton' is visible

And [Input] I click on 'MotorCardDashboard'
And [Assertion] Verify 'MotorTitle' equals 'Motor' text
And [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'HomeSideMenu'
And [Assertion] Verify 'DashboardButton' is visible

And [Input] I click on 'FGACardDashboard'
And [Assertion] Verify 'FGATitle' equals 'FGA' text
And [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'HomeSideMenu'
And [Assertion] Verify 'DashboardButton' is visible

And [Input] I click on 'AccountingCardDashboard'
And [Assertion] Verify 'AccountingTitle' equals 'Accounting' text
And [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'HomeSideMenu'
And [Assertion] Verify 'DashboardButton' is visible

And [Input] I click on 'ReInsuranceCardDashboard'
And [Assertion] Verify 'ReInsuranceTitle' equals 'Re-Insurance' text
And [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'HomeSideMenu'
And [Assertion] Verify 'DashboardButton' is visible

Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present