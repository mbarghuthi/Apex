Scenario:  TC_008_Apex 001 Apex Test Case Marine - Marine Cargo - Certificate (Saudi Riyals)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'JeddahClaimCenterCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'MarineCard'
And [Input] I click on 'MarineCargoCard'
And [Input] I click on 'CertificateCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:MarineCargo' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:Certificate' text
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
!-- Fill in Quotation Value Types
And [Input] I click on 'EditButtonQuotationValue'
And [Progress] I wait for '5' sec
And [Assertion] Verify IG 'calc_ig' row '20 - LC invoice value' Local/Amount can be filled
And [Input] I set IG 'calc_ig' from first row '20 - LC invoice value' to random numbers between '1' and '50' for all enabled cells excluding DDL
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
And [Input] Select 'p:AWSSea' value from 'QutCoverGroupCombobox' dropdown list
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




Scenario:  TC_008_Apex 002 Apex Test Case Marine - Marine Cargo - Certificate (US Dollars)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'JeddahClaimCenterCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'MarineCard'
And [Input] I click on 'MarineCargoCard'
And [Input] I click on 'CertificateCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:MarineCargo' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:Certificate' text
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
!-- Fill in Quotation Value Types
And [Input] I click on 'EditButtonQuotationValue'
And [Progress] I wait for '5' sec
And [Assertion] Verify IG 'calc_ig' row '20 - LC invoice value' Foreign/Foreign Amount can be filled
And [Input] I set IG 'calc_ig' from first row '20 - LC invoice value' to random numbers between '1' and '50' for all enabled cells excluding DDL
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
And [Input] Select 'p:AWSSea' value from 'QutCoverGroupCombobox' dropdown list
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