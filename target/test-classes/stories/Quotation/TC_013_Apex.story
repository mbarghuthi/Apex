Scenario:  TC_013_Apex TC13S1 Apex Test Case Add Copy for Quotation

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'SPWaziriyahMrorrCard'
And [Input] I click on 'ActionButton'
And [Input] I click on 'FilterButton'
And [Input] Select 'TypeFilterDDL' value from 'p:column'
And [Input] Select 'ColumnFilterDDL' value from 'p:number'
And [Input] Set 'ValueFilterInput' value to '156'
And [Input] I click on 'SaveFilterButton'
And [Progress] I wait for '5' sec
!-- add assertion for class of business
And [Assertion] Verify 'FirstClassOfBusInTable' equals 'p:Fire' text
And [Assertion] Verify 'FirstIssueDateInTable' equals 'p:Date' text
And [Input] I click on 'EditQuotationImg'
And [Progress] I wait for '5' sec
And [Input] I click on 'CopyQuotationButton'
And [Assertion] Verify 'AlertMsgBody' contains 'p:ConfirmationMsgForCopy' text
And [Input] I click on 'CopyQuotationConfirmationButton'
And [Progress] I wait for '5' sec
And [Input] I click on 'RemoveFilterButton'
And [Progress] I wait for '5' sec
And [Input] I click on 'ActionButton'
And [Input] I click on 'DataButton'
And [Input] I click on 'SortButton'
And [Input] Select 'ColumnDDL' value from 'p:number'
And [Input] Select 'DirectionDDL' value from 'p:descending'
And [Input] I click on 'SaveFilterButton'
And [Progress] I wait for '5' sec
And [Input] Set 'SearchQuotationInput' value to 'p:Fire'
And [Input] I press Enter on 'SearchQuotationInput'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'FirstClassOfBusInTable' equals 'p:Fire' text
And [Assertion] Verify 'FirstIssueDateInTable' value equals sysdate
And [Input] I click on 'EditPinButtonMultiRows'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present