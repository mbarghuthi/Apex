Scenario:  TC_001_Apex Apex Test Case

Given [Navigation] I navigate to 'p:aman'
And [Input] I login as 'p:adminUsername' with password 'p:password'
When [Input] I click on 'ClientsDataDDL'
And [Input] I click on 'ClientsDataButton'
And [Progress] I wait for '6' sec
