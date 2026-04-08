Scenario:  TC_012_Apex TC12S1 Apex Test Case FGA - Engineering - Open Cover (Saudi Riyals)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'SPWaziriyahMrorrCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'FGACard'
And [Input] I click on 'EngineeringCard'
And [Input] I click on 'OpenCoverCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:Engineering' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:Engineering_OpenCover' text
And [Assertion] Verify 'QutStatusDisplay' equals 'p:Draft' text
And [Assertion] Verify 'QutValidityStatusDisplay' equals 'p:Valid' text
!-- Fill the mandatory Quotation Details
And [Assertion] Verify tab 'MainTab' is selected
And [Navigation] I scroll to 'CreateButton'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'ErrorAlert' is enable
And [Assertion] Verify 'QutSourceErrorMsg' contains 'p:QutSourceEmptyErrorMsg' text
And [Assertion] Verify 'QutInsStDateErrorMsg' contains 'p:QutInsStDateEmptyErrorMsg' text
And [Assertion] Verify 'QutInsEdDateErrorMsg' contains 'p:QutInsEdDateEmptyErrorMsg' text
And [Navigation] I scroll to top of page
And [Input] I click on 'CalculationsTab'
And [Assertion] Verify tab 'CalculationsTab' is selected
And [Assertion] Verify 'QutCalculationBasisErrorMsg' contains 'p:QutCalculationBasisEmptyErrorMsg' text
And [Assertion] Verify 'QutCrCdErrorMsg' contains 'p:QutCrCdEmptyErrorMsg' text
And [Assertion] Verify 'QutQuotNoCreateText' input is empty
And [Input] I click on 'MainTab'
And [Assertion] Verify tab 'MainTab' is selected
And [Input] Select 'p:Direct' value from 'QutSourceCombobox' dropdown list
And [Assertion] Verify 'QutPaymentTermCombobox' contains 'p:Account' text
And [Assertion] Verify 'QutQuotDate' value equals sysdate
!-- And [Assertion] Verify 'QutQuotValidityDate' value equals sysdate plus '0' months plus '30' day
And [Input] Set 'QutInsStDateInput' value to 'sysdateformatted'
And [Progress] I wait for '5' sec
And [Input] I click on 'QutInsStDateInput'
And [Input] I press Enter on 'QutInsStDateInput'
And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'QutInsEdDateInput' value equals sysdate plus '1' years minus one day
And [Assertion] Verify 'QutInsEdDateInput' value equals sysdate
And [Input] I click on 'CalculationsTab'
And [Assertion] Verify tab 'CalculationsTab' is selected
And [Input] Select 'p:ProRata' value from 'QutCalculationBasisCombobox' dropdown list
And [Input] Select 'p:SaudiRiyals' value from 'QutCrCdCombobox' dropdown list
And [Progress] I wait for '3' sec
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
!-- Fill the mandatory Items Details
And [Input] I click on 'AddNewItemButton'
And [Javascript] I switch to iframe 'FireRiskItemsIframe'
And [Input] I click on 'RiqItemCodeCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Buildings' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'FireRiskItemsIframe'
And [Input] I click on 'RiqSaveButtonIframe'
And [Javascript] I switch back to main content
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk/Item Value Types
And [Navigation] I scroll to 'ItemCalculationButton'
And [Input] I click on 'ItemCalculationButton'
And [Javascript] I switch to iframe 'ItemCalculationIframe'
And [Input] I click on 'ItemCalculationEditButton'
And [Assertion] Verify IG 'item_c_ig' row '42 - Fire SI' Local/Amount can be filled
And [Input] I set SECOND IG 'item_c_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
And [Navigation] I scroll to 'RiskCalculationButton'
And [Input] I click on 'RiskCalculationButton'
And [Javascript] I switch to iframe 'RiskCalculationIframe'
And [Input] I click on 'RiskCalculationEditButton'
!-- And [Assertion] Verify IG 'RISK_CALC_REGION_ig' row '42 - Fire SI' Local/Amount can be filled
And [Input] I set SECOND IG 'RISK_CALC_REGION_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
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
!-- Fill in All Quotation Details
And [Assertion] Verify text of 'QutQuotNoAllQuotationDetails' contains saved value 'QuotationNo'
And [Input] Select 'p:Cheque' value from 'QutCollectionTypeCombobox' dropdown list
And [Navigation] I scroll to 'CustomerInfoButton'
And [Input] I click on 'CustomerInfoButton'
And [Input] Select 'p:ClientName' value from 'QurQutClientCombobox' dropdown list
And [Input] Select 'p:ClientName' value from 'QurQutClientNoCombobox' dropdown list
And [Input] I click on 'ApplyChangesButton'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataUpdatedSuccessfully' text
And [Progress] I wait for '5' sec
!-- Risk Quotation Button
And [Navigation] I scroll to end of page
And [Input] I click on 'RiskQuotationButton'
And [Assertion] Verify 'RiskTable' is visible
And [Input] I click on 'RiskDetailsBackButton'
And [Progress] I wait for '5' sec
!-- Beneficiary Button
And [Navigation] I scroll to end of page
And [Input] I click on 'BeneficiaryButton'
And [Javascript] I switch to iframe 'BeneficiaryIframe'
And [Assertion] Verify 'BeneficiaryTable' is visible
And [Input] I click on 'BeneficiaryAddRow'
!-- And [Input] I click on 'BeneficiarySerialRow'
And [Input] Set 'BeneficiarySerialRow' value to '1'
And [Input] I click on 'BeneficiaryRow'
And [Input] I click on 'BeneficiaryComboboxRow'
And [Javascript] I switch back to main content
And [Input] Select 'p:ClientName' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'BeneficiaryIframe'
And [Progress] I wait for '5' sec
And [Input] I click on 'IdNumberRow'
And [Input] Set 'BeneficiaryIdNumberRow' value to '1'
And [Input] I click on 'NationalityRow'
And [Input] I click on 'NationalityRow'
!-- And [Input] I click on 'BeneficiaryNationalityRow'
And [Javascript] I switch back to main content
And [Input] Select 'p:Afghani' value from 'BeneficiaryNationalityPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'BeneficiaryIframe'
And [Input] I click on 'ClassificationRow'
And [Input] I click on 'BeneficiaryClassificationRow'
And [Input] Select 'p:PerRegistrationNo' value from 'BeneficiaryClassificationRow' dropdown list
And [Input] I click on 'BeneficiarySaveButton'
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
And [Input] I click on 'BeneficiaryIframeCloseButton'
!-- Covers Button
And [Input] I click on 'CoversButton'
And [Javascript] I switch to iframe 'CoversIframe'
And [Progress] I wait for '3' sec
And [Assertion] Verify 'CoversTable' is visible
And [Input] I click on 'CoverDeleteFirstRow' if present
And [Input] I click on 'CoversSaveButton'
And [Input] I click on 'CoversAddRow'
And [Input] I click on 'CoversSerialRow'
And [Input] Set 'CoversSerialRow' value to '1'
And [Input] I click on 'CoversRow'
And [Input] I click on 'CoversComboboxRow'
And [Javascript] I switch back to main content
And [Input] Select 'p:Aircraft' value from 'CoversPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'CoversIframe'
And [Input] I click on 'PremRow'
And [Input] Set 'CoversPremRow' value to '1'
And [Input] I click on 'CoversSaveButton'
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
And [Input] I click on 'CloseButtonFromPopup'
!-- REI Plan
And [Input] I click on 'REIPlanButton'
And [Javascript] I switch to iframe 'ReInsurancePlansIframe'
And [Input] I click on 'REIPlanSaveButton'
And [Assertion] Verify 'ReinsurancePlanErrorMsg' contains 'p:ReinsurancePlanEmptyErrorMsg' text
And [Assertion] Verify 'ReiMethodErrorMsg' contains 'p:ReiMethodEmptyErrorMsg' text
!-- And [Input] Select '$optionValue' value from 'ReinsurancePlanCombobox' dropdown list
And [Input] Select 'p:PolicyWise' value from 'ReiMethodCombobox' dropdown list
!-- And [Input] I click on 'REIPlanSaveButton'
And [Javascript] I switch back to main content
And [Input] I click on 'CloseButtonFromPopup'
And [Navigation] I scroll to 'DeleteButton'
And [Input] I click on 'DeleteButton'
And [Input] I click on 'DeleteButtonPopup'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:QuotationDeletedSuccessfully' text
And [Input] Set 'SearchQuotationInput' value to 'p:Cancelled'
And [Input] I press Enter on 'SearchQuotationInput'
And [Progress] I wait for '5' sec
And [Input] I click on 'QuotationNumberTable'
And [Input] Set 'QuotationNumberSearch' value to 'statemanager:QuotationNo'
And [Input] I press Enter on 'QuotationNumberSearch'
And [Progress] I wait for '5' sec
And [Navigation] I reload page
And [Input] I click on 'EditQuotationImg'
And [Progress] I wait for '5' sec
And [Assertion] Verify text of 'StatusAllQuotationDetails' equals saved value 'p:Cancelled'
And [Assertion] Verify text of 'ValidityStatusAllQuotationDetails' equals saved value 'p:Invalid'
And [Assertion] Verify text of 'QutQuotNoAllQuotationDetails' equals saved value 'statemanager:QuotationNo'
!-- Logout
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present



Scenario:  TC_012_Apex TC12S2 Apex Test Case FGA - Engineering - Open Cover (US Dollars)

Given [Navigation] I navigate to 'p:amanApex'
And [Input] I login as 'p:adminUsername' with password 'p:password'
And [Progress] I wait for '5' sec
When [Input] I click on 'QuotationCardDashboard'
And [Assertion] Verify 'QuotationsTitle' equals 'Quotations' text
And [Input] I click on 'SPWaziriyahMrorrCard'
And [Input] I click on 'NewQuotationButton'
And [Input] I click on 'FGACard'
And [Input] I click on 'EngineeringCard'
And [Input] I click on 'OpenCoverCard'
And [Assertion] Verify 'QutClassOfBusinessDisplay' equals 'p:Engineering' text
And [Assertion] Verify 'QutPolicyTypeDisplay' equals 'p:Engineering_OpenCover' text
And [Assertion] Verify 'QutStatusDisplay' equals 'p:Draft' text
And [Assertion] Verify 'QutValidityStatusDisplay' equals 'p:Valid' text
!-- Fill the mandatory Quotation Details
And [Assertion] Verify tab 'MainTab' is selected
And [Navigation] I scroll to 'CreateButton'
And [Input] I click on 'CreateButton'
And [Assertion] Verify 'ErrorAlert' is enable
And [Assertion] Verify 'QutSourceErrorMsg' contains 'p:QutSourceEmptyErrorMsg' text
And [Assertion] Verify 'QutInsStDateErrorMsg' contains 'p:QutInsStDateEmptyErrorMsg' text
And [Assertion] Verify 'QutInsEdDateErrorMsg' contains 'p:QutInsEdDateEmptyErrorMsg' text
And [Navigation] I scroll to top of page
And [Input] I click on 'CalculationsTab'
And [Assertion] Verify tab 'CalculationsTab' is selected
And [Assertion] Verify 'QutCalculationBasisErrorMsg' contains 'p:QutCalculationBasisEmptyErrorMsg' text
And [Assertion] Verify 'QutCrCdErrorMsg' contains 'p:QutCrCdEmptyErrorMsg' text
And [Assertion] Verify 'QutQuotNoCreateText' input is empty
And [Input] I click on 'MainTab'
And [Assertion] Verify tab 'MainTab' is selected
And [Input] Select 'p:Direct' value from 'QutSourceCombobox' dropdown list
And [Assertion] Verify 'QutPaymentTermCombobox' contains 'p:Account' text
And [Assertion] Verify 'QutQuotDate' value equals sysdate
!-- And [Assertion] Verify 'QutQuotValidityDate' value equals sysdate plus '0' months plus '30' day
And [Input] Set 'QutInsStDateInput' value to 'sysdateformatted'
And [Progress] I wait for '5' sec
And [Input] I click on 'QutInsStDateInput'
And [Input] I press Enter on 'QutInsStDateInput'
And [Progress] I wait for '5' sec
!-- And [Assertion] Verify 'QutInsEdDateInput' value equals sysdate plus '1' years minus one day
And [Assertion] Verify 'QutInsEdDateInput' value equals sysdate
And [Input] I click on 'CalculationsTab'
And [Assertion] Verify tab 'CalculationsTab' is selected
And [Input] Select 'p:ProRata' value from 'QutCalculationBasisCombobox' dropdown list
And [Input] Select 'p:USDollars' value from 'QutCrCdCombobox' dropdown list
And [Progress] I wait for '3' sec
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
!-- Fill the mandatory Items Details
And [Input] I click on 'AddNewItemButton'
And [Javascript] I switch to iframe 'FireRiskItemsIframe'
And [Input] I click on 'RiqItemCodeCombobox'
And [Javascript] I switch back to main content
And [Input] Select 'p:Buildings' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'FireRiskItemsIframe'
And [Input] I click on 'RiqSaveButtonIframe'
And [Javascript] I switch back to main content
And [Progress] I wait for '5' sec
And [Navigation] I scroll to top of page
And [Input] I click on 'NextButton'
And [Progress] I wait for '5' sec
!-- Fill the mandatory Risk/Item Value Types
And [Navigation] I scroll to 'ItemCalculationButton'
And [Input] I click on 'ItemCalculationButton'
And [Javascript] I switch to iframe 'ItemCalculationIframe'
And [Input] I click on 'ItemCalculationEditButton'
And [Assertion] Verify IG 'item_c_ig' row '42 - Fire SI' Foreign/Foreign Amount can be filled
And [Input] I set SECOND IG 'item_c_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
And [Navigation] I scroll to 'RiskCalculationButton'
And [Input] I click on 'RiskCalculationButton'
And [Javascript] I switch to iframe 'RiskCalculationIframe'
And [Input] I click on 'RiskCalculationEditButton'
!-- And [Assertion] Verify IG 'RISK_CALC_REGION_ig' row '42 - Fire SI' Foreign/Foreign Amount can be filled
And [Input] I set SECOND IG 'RISK_CALC_REGION_ig' from first row '42 - Fire SI' to random numbers between '1' and '50' for all enabled cells excluding DDL
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
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
!-- Fill in All Quotation Details
And [Assertion] Verify text of 'QutQuotNoAllQuotationDetails' contains saved value 'QuotationNo'
And [Input] Select 'p:Cheque' value from 'QutCollectionTypeCombobox' dropdown list
And [Navigation] I scroll to 'CustomerInfoButton'
And [Input] I click on 'CustomerInfoButton'
And [Input] Select 'p:ClientName' value from 'QurQutClientCombobox' dropdown list
And [Input] Select 'p:ClientName' value from 'QurQutClientNoCombobox' dropdown list
And [Input] I click on 'ApplyChangesButton'
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:DataUpdatedSuccessfully' text
And [Progress] I wait for '5' sec
!-- Risk Quotation Button
And [Navigation] I scroll to end of page
And [Input] I click on 'RiskQuotationButton'
And [Assertion] Verify 'RiskTable' is visible
And [Input] I click on 'RiskDetailsBackButton'
And [Progress] I wait for '5' sec
!-- Beneficiary Button
And [Navigation] I scroll to end of page
And [Input] I click on 'BeneficiaryButton'
And [Javascript] I switch to iframe 'BeneficiaryIframe'
And [Assertion] Verify 'BeneficiaryTable' is visible
And [Input] I click on 'BeneficiaryAddRow'
!-- And [Input] I click on 'BeneficiarySerialRow'
And [Input] Set 'BeneficiarySerialRow' value to '1'
And [Input] I click on 'BeneficiaryRow'
And [Input] I click on 'BeneficiaryComboboxRow'
And [Javascript] I switch back to main content
And [Input] Select 'p:ClientName' value from 'PopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'BeneficiaryIframe'
And [Progress] I wait for '5' sec
And [Input] I click on 'IdNumberRow'
And [Input] Set 'BeneficiaryIdNumberRow' value to '1'
And [Input] I click on 'NationalityRow'
And [Input] I click on 'NationalityRow'
!-- And [Input] I click on 'BeneficiaryNationalityRow'
And [Javascript] I switch back to main content
And [Input] Select 'p:Afghani' value from 'BeneficiaryNationalityPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'BeneficiaryIframe'
And [Input] I click on 'ClassificationRow'
And [Input] I click on 'BeneficiaryClassificationRow'
And [Input] Select 'p:PerRegistrationNo' value from 'BeneficiaryClassificationRow' dropdown list
And [Input] I click on 'BeneficiarySaveButton'
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
And [Input] I click on 'BeneficiaryIframeCloseButton'
!-- Covers Button
And [Input] I click on 'CoversButton'
And [Javascript] I switch to iframe 'CoversIframe'
And [Assertion] Verify 'CoversTable' is visible
And [Input] I click on 'CoverDeleteFirstRow' if present
And [Input] I click on 'CoversSaveButton'
And [Input] I click on 'CoversAddRow'
And [Input] I click on 'CoversSerialRow'
And [Input] Set 'CoversSerialRow' value to '1'
And [Input] I click on 'CoversRow'
And [Input] I click on 'CoversComboboxRow'
And [Javascript] I switch back to main content
And [Input] Select 'p:Aircraft' value from 'CoversPopupLOVSearchBar' dropdown list
And [Javascript] I switch to iframe 'CoversIframe'
And [Input] I click on 'PremRow'
And [Input] Set 'CoversPremRow' value to '1'
And [Input] I click on 'CoversSaveButton'
And [Progress] I wait for '5' sec
And [Javascript] I switch back to main content
And [Input] I click on 'CloseButtonFromPopup'
!-- REI Plan
And [Input] I click on 'REIPlanButton'
And [Javascript] I switch to iframe 'ReInsurancePlansIframe'
And [Input] I click on 'REIPlanSaveButton'
And [Assertion] Verify 'ReinsurancePlanErrorMsg' contains 'p:ReinsurancePlanEmptyErrorMsg' text
And [Assertion] Verify 'ReiMethodErrorMsg' contains 'p:ReiMethodEmptyErrorMsg' text
!-- And [Input] Select '$optionValue' value from 'ReinsurancePlanCombobox' dropdown list
And [Input] Select 'p:PolicyWise' value from 'ReiMethodCombobox' dropdown list
!-- And [Input] I click on 'REIPlanSaveButton'
And [Javascript] I switch back to main content
And [Input] I click on 'CloseButtonFromPopup'
And [Navigation] I scroll to 'DeleteButton'
And [Input] I click on 'DeleteButton'
And [Input] I click on 'DeleteButtonPopup'
And [Progress] I wait for '5' sec
And [Assertion] Verify 'SuccessfullyAlert' contains 'p:QuotationDeletedSuccessfully' text
And [Input] Set 'SearchQuotationInput' value to 'p:Cancelled'
And [Input] I press Enter on 'SearchQuotationInput'
And [Input] I click on 'QuotationNumberTable'
And [Input] Set 'QuotationNumberSearch' value to 'statemanager:QuotationNo'
And [Input] I press Enter on 'QuotationNumberSearch'
And [Progress] I wait for '5' sec
And [Navigation] I reload page
And [Input] I click on 'EditQuotationImg'
And [Progress] I wait for '7' sec
And [Assertion] Verify text of 'StatusAllQuotationDetails' equals saved value 'p:Cancelled'
And [Assertion] Verify text of 'ValidityStatusAllQuotationDetails' equals saved value 'p:Invalid'
And [Assertion] Verify text of 'QutQuotNoAllQuotationDetails' equals saved value 'statemanager:QuotationNo'
!-- Logout
And [Progress] I wait for '7' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present