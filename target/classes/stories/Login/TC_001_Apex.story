!-- Scenario:  TC_001_Apex 001 Apex Test Case Login - Empty username and password

!-- Given [Navigation] I navigate to 'p:amanApex'
!-- When [Assertion] Verify 'userName' input is empty
!-- And [Assertion] Verify 'password' input is empty
!-- And [Input] I click on 'loginButton'
!-- Then [Assertion] Verify 'loginButton' is present


!-- Scenario:  TC_001_Apex 002 Apex Test Case Login - Valid username and Empty password

!-- Given [Navigation] I navigate to 'p:amanApex'
!-- When [Input] Set 'userName' value to 'p:adminUsername'
!-- And [Assertion] Verify 'password' input is empty
!-- And [Input] I click on 'loginButton'
!-- Then [Assertion] Verify 'loginAlert' contains 'p:InvalidLoginCredentials' text
!-- And [Assertion] Verify 'loginButton' is present


!-- Scenario:  TC_001_Apex 003 Apex Test Case Login - Empty username and Valid password

!-- Given [Navigation] I navigate to 'p:amanApex'
!-- When [Input] Set 'password' value to 'p:password'
!-- And [Assertion] Verify 'userName' input is empty
!-- And [Input] I click on 'loginButton'
!-- !-- Then [Assertion] Verify 'loginAlert' contains 'p:InvalidLoginCredentials' text
!-- Then [Assertion] Verify 'loginButton' is present


!-- Scenario:  TC_001_Apex 004 Apex Test Case Login - Invalid username and password

!-- Given [Navigation] I navigate to 'p:amanApex'
!-- When [Input] I login as 'p:invalidUsername' with password 'p:invalidPassword'
!-- !-- Then [Assertion] Verify 'loginAlert' contains 'p:InvalidLoginCredentials' text
!-- Then [Assertion] Verify 'loginButton' is present


!-- Scenario:  TC_001_Apex 005 Apex Test Case Login - Invalid username and Valid password

!-- Given [Navigation] I navigate to 'p:amanApex'
!-- When [Input] I login as 'p:invalidUsername' with password 'p:password'
!-- !-- Then [Assertion] Verify 'loginAlert' contains 'p:InvalidLoginCredentials' text
!-- Then [Assertion] Verify 'loginButton' is present


!-- Scenario:  TC_001_Apex 006 Apex Test Case Login - Valid username and Invalid password

!-- Given [Navigation] I navigate to 'p:amanApex'
!-- When [Input] I login as 'p:adminUsername' with password 'p:invalidPassword'
!-- Then [Assertion] Verify 'loginAlert' contains 'p:InvalidLoginCredentials' text
!-- And [Assertion] Verify 'loginButton' is present
!-- And [Assertion] Verify 'userName' input is empty
!-- And [Assertion] Verify 'password' input is empty

Scenario:  TC_001_Apex 007 Apex Test Case Login - Valid username and password

Given [Navigation] I navigate to 'p:amanApex'
When [Input] I login as 'p:adminUsername' with password 'p:password'
And [Assertion] Verify 'UserDDL' contains 'p:adminUsername' text
And [Progress] I wait for '5' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present