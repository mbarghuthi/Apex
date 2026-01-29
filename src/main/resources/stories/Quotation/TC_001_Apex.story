Scenario:  TC_001_Apex Apex Test Case Navigate to Quotation Page

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
And [Input] I click on 'QuotationsSideMenu'
And [Input] I click on 'QuotationMenuSideMenu'
And [Input] I click on 'QuotationNavigationSideMenu'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present