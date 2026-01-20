Scenario:  TC_012_Apex 001 Apex Test Case FGA - Engineering - Open Cover (Saudi Riyals)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'JeddahClaimCenterCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'FGACard'
And [Input] I click on 'EngineeringCard'
And [Input] I click on 'OpenCoverCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:Engineering' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:Engineering_OpenCover' text
!-- Fill the mandatory Quotation Details
And [Input] Select 'p:Direct' value from 'QutSourceCombobox' dropdown list
And [Assertion] Verify 'QutPaymentTermCombobox' contains 'p:Account' text
And [Assertion] Verify 'QutQuotDate' value equals sysdate
And [Assertion] Verify 'QutQuotValidityDate' value equals sysdate plus '1' months minus one day
And [Input] Set 'QutInsStDateInput' value to 'sysdateformatted'
And [Progress] I wait for '5' sec
And [Input] I click on 'QutInsStDateInput'
And [Input] I press Enter on 'QutInsStDateInput'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'QutInsEdDateInput' input is empty
And [Input] Select 'p:AirForce' value from 'QutBusinessTypeCombobox' dropdown list
And [Navigation] I scroll to 'QutCalculationBasisCombobox'
And [Progress] I wait for '5' sec
And [Input] Select 'p:ProRata' value from 'QutCalculationBasisCombobox' dropdown list
And [Input] Select 'p:SaudiRiyals' value from 'QutCrCdCombobox' dropdown list
And [Assertion] Verify 'QutUnitPriceVal' equals '1' text
And [Navigation] I scroll to 'CreateButton'
And [Input] I click on 'CreateButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to 'SuccessfullyAlert'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataSavedSuccessfully' text
And [Action] I get text from 'QutQuotNoCreateText' and save it as 'QuotationNo'
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk Details
And [Input] I click on 'AddNewRiskButton'
And [Javascript] I switch to iframe 'AddNewRiskIframe'
And [Input] I click on 'RiskTypeLiabilityCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Warehouse' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'AddNewRiskIframe'
And [Input] Select 'p:ItemBasis' value from 'BreakdownCombobox' dropdown list
And [Input] I click on 'ApplyChangesButtonIframe'
And [Javascript] I switch back to main content
And [Progress] I wait for '5' sec
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Items Details
And [Input] I click on 'AddNewItemButton'
And [Javascript] I switch to iframe 'FireRiskItemsUpdatingAppIframe'
And [Input] I click on 'RiqItemCodeCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Buildings' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'FireRiskItemsUpdatingAppIframe'
And [Input] I click on 'RiqSaveButtonIframe'
And [Javascript] I switch back to main content
And [Progress] I wait for '5' sec
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Item Value Types
And [Navigation] I scroll to 'ItemValueTypesEditButton'
And [Input] I click on 'ItemValueTypesEditButton'
And [Assertion] Verify IG 'item_c_ig' row '42 - Fire SI' Local/Amount can be filled
And [Input] I set SECOND IG 'item_c_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk Value Types
And [Navigation] I scroll to 'EditButton'
And [Input] I click on 'EditButton'
And [Assertion] Verify IG 'RiskCalculation_ig' row '42 - Fire SI' Local/Amount can be filled
And [Input] I set SECOND IG 'RiskCalculation_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill in Quotation Value Types
And [Input] I click on 'EditButtonQuotationValue'
And [Progress] I wait for '5' sec
And [Assertion] Verify IG 'calc_ig' row '11 - Issues Fees' Local/Amount can be filled
And [Input] I set IG 'calc_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Input] I click on 'SaveButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Progress] I wait for '5' sec
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill in Quotation Client
And [Input] Select 'p:StaffAmmarAhmedHamzaGhor' value from 'QurQutClientCombobox' dropdown list
And [Input] Select 'p:StaffAmmarAhmedHamzaGhor' value from 'QurQutClientNoCombobox' dropdown list
And [Input] I click on 'ApplyChangesButton'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataUpdatedSuccessfully' text
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Last Page
And [Input] Select 'p:FireAndSpecialPerils' value from 'QutCoverGroupCombobox' dropdown list
And [Input] Select 'p:Cheque' value from 'QutCollectionTypeCombobox' dropdown list
And [Navigation] I scroll to end of page
And [Input] I click on 'ApplyChangesButton'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataUpdatedSuccessfully' text
And [Assertion] Verify text of 'QutQuotNoFinalPageText' contains saved value 'QuotationNo'
And [Navigation] I scroll to 'DeleteButton'
And [Input] I click on 'DeleteButton'
And [Input] I click on 'DeleteButtonPopup'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:QuotationDeletedSuccessfully' text
!-- Logout
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present



Scenario:  TC_012_Apex 002 Apex Test Case FGA - Engineering - Open Cover (US Dollars)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'JeddahClaimCenterCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'FGACard'
And [Input] I click on 'EngineeringCard'
And [Input] I click on 'OpenCoverCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:Engineering' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:Engineering_OpenCover' text
!-- Fill the mandatory Quotation Details
And [Input] Select 'p:Direct' value from 'QutSourceCombobox' dropdown list
And [Assertion] Verify 'QutPaymentTermCombobox' contains 'p:Account' text
And [Assertion] Verify 'QutQuotDate' value equals sysdate
And [Assertion] Verify 'QutQuotValidityDate' value equals sysdate plus '1' months minus one day
And [Input] Set 'QutInsStDateInput' value to 'sysdateformatted'
And [Progress] I wait for '5' sec
And [Input] I click on 'QutInsStDateInput'
And [Input] I press Enter on 'QutInsStDateInput'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'QutInsEdDateInput' input is empty
And [Input] Select 'p:AirForce' value from 'QutBusinessTypeCombobox' dropdown list
And [Navigation] I scroll to 'QutCalculationBasisCombobox'
And [Progress] I wait for '5' sec
And [Input] Select 'p:ProRata' value from 'QutCalculationBasisCombobox' dropdown list
And [Input] Select 'p:USDollars' value from 'QutCrCdCombobox' dropdown list
And [Assertion] Verify 'QutUnitPriceVal' equals '3.75' text
And [Navigation] I scroll to 'CreateButton'
And [Input] I click on 'CreateButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to 'SuccessfullyAlert'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataSavedSuccessfully' text
And [Action] I get text from 'QutQuotNoCreateText' and save it as 'QuotationNo'
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk Details
And [Input] I click on 'AddNewRiskButton'
And [Javascript] I switch to iframe 'AddNewRiskIframe'
And [Input] I click on 'RiskTypeLiabilityCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Warehouse' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'AddNewRiskIframe'
And [Input] Select 'p:ItemBasis' value from 'BreakdownCombobox' dropdown list
And [Input] I click on 'ApplyChangesButtonIframe'
And [Javascript] I switch back to main content
And [Progress] I wait for '5' sec
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Items Details
And [Input] I click on 'AddNewItemButton'
And [Javascript] I switch to iframe 'FireRiskItemsUpdatingAppIframe'
And [Input] I click on 'RiqItemCodeCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Buildings' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'FireRiskItemsUpdatingAppIframe'
And [Input] I click on 'RiqSaveButtonIframe'
And [Javascript] I switch back to main content
And [Progress] I wait for '5' sec
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Item Value Types
And [Navigation] I scroll to 'ItemValueTypesEditButton'
And [Input] I click on 'ItemValueTypesEditButton'
And [Assertion] Verify IG 'item_c_ig' row '42 - Fire SI' Foreign/Foreign Amount can be filled
And [Input] I set SECOND IG 'item_c_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk Value Types
And [Navigation] I scroll to 'EditButton'
And [Input] I click on 'EditButton'
And [Assertion] Verify IG 'RiskCalculation_ig' row '42 - Fire SI' Foreign/Foreign Amount can be filled
And [Input] I set SECOND IG 'RiskCalculation_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill in Quotation Value Types
And [Input] I click on 'EditButtonQuotationValue'
And [Progress] I wait for '5' sec
And [Assertion] Verify IG 'calc_ig' row '11 - Issues Fees' Foreign/Foreign Amount can be filled
And [Input] I set IG 'calc_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Input] I click on 'SaveButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Progress] I wait for '5' sec
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill in Quotation Client
And [Input] Select 'p:StaffAmmarAhmedHamzaGhor' value from 'QurQutClientCombobox' dropdown list
And [Input] Select 'p:StaffAmmarAhmedHamzaGhor' value from 'QurQutClientNoCombobox' dropdown list
And [Input] I click on 'ApplyChangesButton'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataUpdatedSuccessfully' text
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Last Page
And [Input] Select 'p:FireAndSpecialPerils' value from 'QutCoverGroupCombobox' dropdown list
And [Input] Select 'p:Cheque' value from 'QutCollectionTypeCombobox' dropdown list
And [Navigation] I scroll to end of page
And [Input] I click on 'ApplyChangesButton'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataUpdatedSuccessfully' text
And [Assertion] Verify text of 'QutQuotNoFinalPageText' contains saved value 'QuotationNo'
And [Navigation] I scroll to 'DeleteButton'
And [Input] I click on 'DeleteButton'
And [Input] I click on 'DeleteButtonPopup'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:QuotationDeletedSuccessfully' text
!-- Logout
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present