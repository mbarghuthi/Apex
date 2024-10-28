Scenario: TC_003_UOP_001 UOP login

Given [Navigation] I navigate to 'http://172.16.30.82:8888/login.aspx'
When [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
And [Navigation] I hover over 'User Profile DDL'
!-- And [Input] I click on 'User Name Header Button'
And [Input] I click on 'Profile Header Button'
And [Assertion] Verify 'User Name Value' have attribute 'value' with 'alaa.abdelbagi' value
Then [Navigation] I hover over 'User Profile DDL'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
