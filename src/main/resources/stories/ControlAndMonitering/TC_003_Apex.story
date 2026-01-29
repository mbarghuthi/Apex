Scenario:  TC_003_Apex 001 Apex Test Case Control and Monitoring - Master Files - Locations & Branches

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'LocationsAndBranchesSideMenu'
And [Assertion] Verify 'LocationsAndBranchesTitle' equals 'p:LocationsAndBranches' text
And [Input] Select 'p:SaudiArabia' value from 'LocationCombobox' dropdown list
And [Assertion] Verify 'LocationsAndBranchesTable' is visible
And [Progress] I wait for '10' sec
And [Input] I click on 'LocationsAndBranchesAddRowButton'
And [Assertion] Verify IG 'LocationsAndBranchesTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'LocationsAndBranchesTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 002 Apex Test Case Control and Monitoring - Master Files - Customers Receivable

Given [Navigation] I navigate to 'p:amanApex'
!-- And [Input] I login as 'p:adminUsername' with password 'p:password'
!-- And [Progress] I wait for '5' sec
!-- !-- When [Input] I click on 'navControlButton'
!-- When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- And [Input] I click on 'ControlAndMoniteringSideMenu'
!-- And [Input] I click on 'MasterFilesSideMenu'
!-- And [Input] I click on 'CustomersReceivableSideMenu'
!-- And [Assertion] Verify 'ShortPeriodTariffTitle' equals 'p:ShortPeriodTariff' text
!-- And [Input] Select 'p:MotorPrivate' value from 'ClassCombobox' dropdown list
!-- And [Input] Select 'p:Comprehensive' value from 'PolicyTypeCombobox' dropdown list
!-- And [Progress] I wait for '3' sec
!-- And [Assertion] Verify 'ShortPeriodTariffTable' is visible
!-- And [Input] I click on 'ShortPeriodTariffAddRowButton'
!-- And [Assertion] Verify IG 'ShortPeriodTariffTable' has an empty inserted row
!-- And [Action] I delete the inserted row in IG 'ShortPeriodTariffTable'
!-- And [Progress] I wait for '7' sec
!-- Then [Input] I click on 'UserDDL'
!-- And [Input] I click on 'LogoutButton'
!-- And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 003 Apex Test Case Control and Monitoring - Master Files - Payable Parties

Given [Navigation] I navigate to 'p:amanApex'
!-- And [Input] I login as 'p:adminUsername' with password 'p:password'
!-- And [Progress] I wait for '5' sec
!-- !-- When [Input] I click on 'navControlButton'
!-- When [Action] I ensure navbar is open using toggle 'navControlButton'
!-- And [Input] I click on 'ControlAndMoniteringSideMenu'
!-- And [Input] I click on 'MasterFilesSideMenu'
!-- And [Input] I click on 'PayablePartiesSideMenu'
!-- And [Assertion] Verify 'ProRataPeriodTariffTitle' equals 'p:ProRataPeriodTariff' text
!-- And [Assertion] Verify 'ProRataPeriodTariffTable' is visible
!-- And [Input] I click on 'ProRataPeriodTariffAddRowButton'
!-- And [Assertion] Verify IG 'ProRataPeriodTariffTable' has an empty inserted row
!-- !-- And [Action] I delete the inserted row in IG 'ProRataPeriodTariffTable'
!-- And [Navigation] I reload page
!-- And [Progress] I wait for '7' sec
!-- Then [Input] I click on 'UserDDL'
!-- And [Input] I click on 'LogoutButton'
!-- And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 004 Apex Test Case Control and Monitoring - Master Files - Class-Subclass Linking

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'ClassSubclassLinkingSideMenu'
And [Assertion] Verify 'ClassTitle' equals 'p:Class' text
And [Assertion] Verify 'ClassTable' is visible
And [Input] I click on 'ClassAddRowButton'
And [Assertion] Verify IG 'ClassTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'ClassTable'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'SubClassTable' is visible
And [Input] I click on 'SubClassAddRowButton'
And [Assertion] Verify IG 'SubClassTable' has an empty inserted row
And [Action] I delete the inserted row in IG 'SubClassTable'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present


Scenario:  TC_003_Apex 005 Apex Test Case Control and Monitoring - Master Files - Customers Address Screen

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
!-- When [Input] I click on 'navControlButton'
When [Action] I ensure navbar is open using toggle 'navControlButton'
And [Input] I click on 'ControlAndMoniteringSideMenu'
And [Input] I click on 'MasterFilesSideMenu'
And [Input] I click on 'CustomersAddressScreenSideMenu'
And [Assertion] Verify 'CustomerAddressTitle' equals 'p:CustomerAddress' text
And [Assertion] Verify 'CustomerAddressTable' is visible
And [Input] I click on 'CustomerAddressAddRowButton'
And [Progress] I wait for '5' sec
And [Assertion] Verify all fields in 'CustomerAddressRegionBody' are empty
And [Input] I click on 'CancelButton'
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present

