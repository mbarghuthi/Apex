Scenario:  TC_001_Apex Apex Test Case

Given [Navigation] I navigate to 'p:aman'
And [Input] I login as 'p:adminUsername' with password 'p:password'
When [Input] I click on 'ClientsDataDDL'
And [Progress] I wait for '2' sec
And [Input] I click on 'ClientDataButton'

