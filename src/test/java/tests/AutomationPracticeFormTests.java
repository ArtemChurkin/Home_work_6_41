package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import testdata.TestData;
import testdata.TestData.*;
//import static testdata.TestData.*;


public class AutomationPracticeFormTests extends TestBase {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    TestData testData = new TestData();


    @Test
    void succesfulFillTest() {

        automationPracticeFormPage.openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userEmail)
                .typeUserGender(testData.userGender)
                .typeUserNumber(testData.userPhoneNumber)
                .setBirthDay(testData.userBirthDay, testData.userBirthdayMonth, testData.userBirthdayYear)

                .typeSubject(testData.subject)
                .typeHobbie(testData.hobbie)
                .typePicture(testData.picturePath)
                .typeCurrentAddress(testData.currentAddress)

                .stateSelectList()
                .typeState(testData.state)
                .citySelectList()
                .typeCity(testData.city)
                .submitFormButton()

                .resultTable()

                .closeFormButton();
    }

    @Test
    void onlyRequiredFieldSuccesfulTest() {

        automationPracticeFormPage.openPage()

                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userEmail)
                .typeUserGender(testData.userGender)
                .typeUserNumber(testData.userPhoneNumber)
                .submitFormButton()
                .closeFormButton();

    }

    @Test
    void firstNegativeTest() {
        automationPracticeFormPage.openPage()
                .submitFormButton()
                .checkFirstNameErrorBorder()
                .checkFirstNameErrorIcon();


    }

    @Test
    void secondNegativeTest() {

        automationPracticeFormPage.openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userErrorEmail)
                .typeUserGender(testData.userGender)
                .typeUserNumber(testData.userPhoneNumber)

                .setBirthDay(testData.userBirthDay, testData.userBirthdayMonth, testData.userBirthdayYear)

                .typeSubject(testData.subject)
                .typeHobbie(testData.hobbie)
                .typePicture(testData.picturePath)
                .typeCurrentAddress(testData.currentAddress)
                .stateSelectList()
                .typeState(testData.state)
                .citySelectList()
                .typeCity(testData.city)
                .submitFormButton()

                .checkEmailErrorBorder()
                .checkEmailErrorIcon();


    }

    @Test
    void thirdNegativeTest() {
        automationPracticeFormPage.openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userEmail)
                .typeUserGender(testData.userGender)
                .typeUserNumber(testData.userErrorPhoneNumber)

                .setBirthDay(testData.userBirthDay, testData.userBirthdayMonth, testData.userBirthdayYear)

                .typeSubject(testData.subject)
                .typeHobbie(testData.hobbie)
                .typePicture(testData.picturePath)
                .typeCurrentAddress(testData.currentAddress)

                .stateSelectList()
                .typeState(testData.state)
                .citySelectList()
                .typeCity(testData.city)
                .submitFormButton()

                .checkNumberErrorBorder()
                .checkNumberErrorIcon();
    }

}
