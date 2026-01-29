Scenario:  TC_013_Apex 001 Apex Test Case Add Revision for Quotation

Given [Navigation] I navigate to 'p:amanApex'
!-- And [Input] I login as 'p:adminUsername' with password 'p:password'
!-- And [Progress] I wait for '5' sec
!-- When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- When [Input] I click on 'navControlButton'
!-- And [Input] I click on 'QuotationsSideMenu'
!-- And [Input] I click on 'QuotationMenuSideMenu'
!-- And [Input] I click on 'QuotationNavigationSideMenu'
!-- And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
!-- And [Input] I click on 'JeddahClaimCenterCard'
!-- And [Input] I click on 'ActionButton'
!-- And [Input] I click on 'FilterButton'
!-- And [Input] Select 'ColumnFilterDDL' value from 'p:number'
!-- And [Input] Set 'ValueFilterInput' value to '59'
!-- And [Input] I click on 'SaveFilterButton'
!-- And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'RevisionIconDisable' is disable
!-- And [Input] I click on 'EditPinButton'
!-- And [Progress] I wait for '5' sec
!-- And [Input] I click on 'RevisionQuotationButton'
!-- And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'RevisionIconEnable' is enable
!-- And [Input] I click on 'RevisionIconEnable'
!-- And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'RevisionZeroRow' is present
!-- And [Input] I click on 'MainQuotationsButton'
!-- And [Progress] I wait for '5' sec
!-- And [Input] I click on 'EditPinButton'
!-- And [Navigation] I scroll to 'DeleteButton'
!-- And [Input] I click on 'DeleteButton'
!-- And [Input] I click on 'DeleteButtonPopup'
!-- And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'SuccessfullyAlert' contains 'p:QuotationDeletedSuccessfully' text
!-- And [Assertion] Verify 'RevisionIconDisable' is disable
!-- And [Progress] I wait for '7' sec
!-- Then [Input] I click on 'UserDDL'
!-- And [Input] I click on 'LogoutButton'
!-- And [Assertion] Verify 'loginButton' is present


Scenario:  TC_013_Apex 002 Apex Test Case Add Copy for Quotation

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'JeddahClaimCenterCard'
And [Input] I click on 'ActionButton'
And [Input] I click on 'FilterButton'
And [Input] Select 'ColumnFilterDDL' value from 'p:number'
And [Input] Set 'ValueFilterInput' value to '59'
And [Input] I click on 'SaveFilterButton'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'RevisionIconDisable' is disable
!-- add assertion for class of business
And [Assertion] Verify 'FirstClassOfBusInTable' equals 'p:Fire' text
And [Assertion] Verify 'FirstIssueDateInTable' equals 'p:Date' text
And [Input] I click on 'EditPinButton'
And [Progress] I wait for '5' sec
And [Input] I click on 'CopyQuotationButton'
And [Progress] I wait for '5' sec
And [Input] I click on 'RemoveFilterButton'
And [Input] I click on 'ActionButton'
And [Input] I click on 'DataButton'
And [Input] I click on 'SortButton'
And [Input] Select 'ColumnDDL' value from 'p:number'
And [Input] Select 'DirectionDDL' value from 'p:descending'
And [Input] I click on 'SaveFilterButton'
And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'RevisionIconDisable' is disable
And [Assertion] Verify 'FirstClassOfBusInTable' equals 'p:Fire' text
And [Assertion] Verify 'FirstIssueDateInTable' value equals sysdate
And [Input] I click on 'EditPinButtonMultiRows'


!-- And [Input] I click on 'EditPinButton'
!-- And [Navigation] I scroll to 'DeleteButton'
!-- And [Input] I click on 'DeleteButton'
!-- And [Input] I click on 'DeleteButtonPopup'
!-- And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'SuccessfullyAlert' contains 'p:QuotationDeletedSuccessfully' text
!-- And [Assertion] Verify 'RevisionIconDisable' is disable
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present