Scenario:  TC_003_Apex 001 Apex Test Case Motor - Motor Private - Third Party (Saudi Riyals)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'JeddahClaimCenterCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'MotorCard'
And [Input] I click on 'MotorPrivateCard'
And [Input] I click on 'ThirdPartyCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:MotorPrivate' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:ThirdParty' text
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
And [Assertion] Verify 'QutInsEdDateInput' value equals sysdate plus '1' years minus one day
And [Navigation] I scroll to 'QutAwardedToInput'
And [Progress] I wait for '5' sec
And [Input] Set 'QutAwardedToInput' value to 'random5'
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
And [Input] Select 'p:komatsu' value from 'QurVehicleMakeCombobox' dropdown list
And [Input] Select 'p:Equipment' value from 'QurVehicleModelCombobox' dropdown list
And [Input] Set 'QurYearOfMakeCombobox' value to 'sysyear'
And [Input] Set 'QurChassisNoCombobox' value to 'nanotime'
And [Input] Set 'QurRegistrationNoCombobox' value to 'nanotime'
And [Input] Select 'p:red' value from 'QurPlateColorCombobox' dropdown list
And [Input] Select 'p:Sedan' value from 'QurTypeOfBodyCombobox' dropdown list
And [Input] Select 'p:Green' value from 'QurVehicleColorCombobox' dropdown list
And [Navigation] I scroll to 'CreateButton'
And [Input] I click on 'CreateButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to 'SuccessfullyAlert'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:RowCreated' text
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk Value Types
And [Navigation] I scroll to 'EditButton'
And [Input] I click on 'EditButton'
And [Assertion] Verify IG 'RiskCalculation_ig' row '1 - SI' Local/Amount can be filled
And [Input] I set SECOND IG 'RiskCalculation_ig' from first row '1 - SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '7' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill in Quotation Value Types
And [Input] I click on 'EditButtonQuotationValue'
And [Assertion] Verify IG 'calc_ig' row '10 - Stamp Fees' Local/Amount can be filled
And [Input] I set IG 'calc_ig' from first row '1 - SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '10' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '10' sec
And [Navigation] I scroll to top of page
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
And [Input] Select 'p:DriverOnly' value from 'QutCoverGroupCombobox' dropdown list
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


Scenario:  TC_003_Apex 002 Apex Test Case Motor - Motor Private - Third Party (US Dollars)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'JeddahClaimCenterCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'MotorCard'
And [Input] I click on 'MotorPrivateCard'
And [Input] I click on 'ThirdPartyCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:MotorPrivate' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:ThirdParty' text
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
And [Assertion] Verify 'QutInsEdDateInput' value equals sysdate plus '1' years minus one day
And [Navigation] I scroll to 'QutAwardedToInput'
And [Progress] I wait for '5' sec
And [Input] Set 'QutAwardedToInput' value to 'random5'
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
And [Input] Select 'p:komatsu' value from 'QurVehicleMakeCombobox' dropdown list
And [Input] Select 'p:Equipment' value from 'QurVehicleModelCombobox' dropdown list
And [Input] Set 'QurYearOfMakeCombobox' value to 'sysyear'
And [Input] Set 'QurChassisNoCombobox' value to 'nanotime'
And [Input] Set 'QurRegistrationNoCombobox' value to 'nanotime'
And [Input] Select 'p:red' value from 'QurPlateColorCombobox' dropdown list
And [Input] Select 'p:Sedan' value from 'QurTypeOfBodyCombobox' dropdown list
And [Input] Select 'p:Green' value from 'QurVehicleColorCombobox' dropdown list
And [Navigation] I scroll to 'CreateButton'
And [Input] I click on 'CreateButton'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to 'SuccessfullyAlert'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:RowCreated' text
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk Value Types
And [Navigation] I scroll to 'EditButton'
And [Input] I click on 'EditButton'
And [Assertion] Verify IG 'RiskCalculation_ig' row '1 - SI' Foreign/Foreign Amount can be filled
And [Input] I set SECOND IG 'RiskCalculation_ig' from first row '1 - SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '7' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill in Quotation Value Types
And [Input] I click on 'EditButtonQuotationValue'
And [Assertion] Verify IG 'calc_ig' row '10 - Stamp Fees' Foreign/Foreign Amount can be filled
And [Input] I set IG 'calc_ig' from first row '1 - SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '10' sec
And [Input] I click on 'SaveButton'
And [Progress] I wait for '10' sec
And [Navigation] I scroll to top of page
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
And [Input] Select 'p:DriverOnly' value from 'QutCoverGroupCombobox' dropdown list
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