Scenario:  TC_001_Apex Apex Test Case

Given [Navigation] I navigate to 'p:aman'
And [Input] I login as 'p:adminUsername' with password 'p:password'
When [Input] I click on 'ClientsDataDDL'
And [Input] I click on 'ClientsDataButton'
And [Progress] I wait for '6' sec
And [Input] I click on 'IndividualButton'
And [Progress] I wait for '7' sec
!-- Switch to iframe
And [Javascript] I switch to iframe 'ClientIframe'
!-- Assert individual Radio Button is checked
And [Assertion] Verify 'IndividualClientTypeRadioButton' is selected
!-- Fill
And [Input] Set 'ClientNoInput' value to 'nanotime'
And [Action] I get text from 'ClientNoInput' and save it as 'ClientNoText'
And [Input] Set 'CustomerNameInput' value to 'random'
And [Action] I get text from 'CustomerNameInput' and save it as 'CustomerNameText'
And [Navigation] I scroll to 'CustProfessionButton' in current iframe
!-- Cust Profession
And [Input] I click on 'CustProfessionButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:GovernmentalInstitutionsEmployee' value from 'PopupLOVSearchBar' dropdown list
!-- National /resident
And [Javascript] I switch to iframe 'ClientIframe'
And [Input] I click on 'NationalityResidencyButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:NationalResident' value from 'PopupResidenceSearchBar' dropdown list
!-- PEP Status
And [Javascript] I switch to iframe 'ClientIframe'
And [Input] I click on 'PEPStatusButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:yes' value from 'PopupPEPStatusSearchBar' dropdown list
!-- Annual Income Range
And [Javascript] I switch to iframe 'ClientIframe'
And [Input] I click on 'AnnualIncomeRangeButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:BelowOrEqual2000JD' value from 'PopupAnnualIncomeRangeSearchBar' dropdown list
!-- Nationality
And [Javascript] I switch to iframe 'ClientIframe'
And [Input] I click on 'NationalityButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:Afghanistan' value from 'PopupNationalitySearchBar' dropdown list
!-- Residency
And [Javascript] I switch to iframe 'ClientIframe'
And [Input] I click on 'ResidencyButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:Afghanistan' value from 'PopupResidencySearchBar' dropdown list
!-- City of Residency
And [Javascript] I switch to iframe 'ClientIframe'
And [Input] I click on 'CityOfResidencyButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:Amman' value from 'PopupCityOfResidencySearchBar' dropdown list
!-- Product Type
And [Javascript] I switch to iframe 'ClientIframe'
And [Input] I click on 'ProductTypeButton'
And [Javascript] I switch back to main content
And [Input] Select 'p:CriticalIllnessInsuranceArabiProtect' value from 'PopupProductTypeSearchBar' dropdown list
!-- click on create
And [Javascript] I switch to iframe 'ClientIframe'
And [Navigation] I scroll to 'CustProfessionButton' in current iframe
And [Input] I click on 'CreateButton'
And [Progress] I wait for '20' sec
!-- Assert
And [Assertion] Verify text of 'ClientNoTextFromIframe' equals saved value 'ClientNoText'
And [Assertion] Verify text of 'CustomerNameTextFromIframe' equals saved value 'CustomerNameText'
!-- Exit client iframe after create
And [Javascript] I switch back to main content
And [Input] I click on 'CloseClientIframeAfterCreate'
And [Navigation] I reload page
!-- Assert table
And [Progress] I wait for '6' sec
And [Assertion] Verify text of 'CustomerNameTextFromTable' equals saved value 'CustomerNameText'
And [Assertion] Verify text of 'ClientNoTextFromTable' equals saved value 'ClientNoText'
!-- Edit
And [Input] I click on 'EditButton'
And [Javascript] I switch to iframe 'ClientIframe'
And [Assertion] Verify text of 'ClientNoTextFromIframe' equals saved value 'ClientNoText'
And [Assertion] Verify text of 'CustomerNameTextFromIframe' equals saved value 'CustomerNameText'
And [Input] I click on 'DeleteButton'
And [Javascript] I switch back to main content
And [Input] I click on 'DeleteButtonPopup'
And [Progress] I wait for '10' sec
Then [Input] I click on 'UserDDL'
And [Input] I click on 'LogoutButton'
And [Assertion] Verify 'loginButton' is present