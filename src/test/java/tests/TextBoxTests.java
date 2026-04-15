package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testdata.TestData;

import testdata.TestData.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    TestData testData = new TestData();

    @Test
    void succesfulFillFormTest_dsl() {
        textBoxPage.openPage()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .submitFormButton()
                .checkField("name", testData.userName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.permanentAddress);
    }

    @Test
    void onlyRequiredFieldSuccesfulTest2_dsl() {

        textBoxPage.openPage()

                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .submitFormButton()
                .checkField("name", testData.userName)
                .checkField("email", testData.userEmail);
    }

    @Test
    void firstNegativeTest_dsl() {

        textBoxPage.openPage()

                .typeUserName(testData.userName)
                .typeUserEmail(testData.userErrorEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .submitFormButton()
                .checkUserEmailHasErrorClass();

    }

}

