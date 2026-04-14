package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testdata.TestData;

import static testdata.TestData.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    TestData testData = new TestData();

    @Test
    void succesfulFillFormTest_dsl() {
        textBoxPage.openPage()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitFormButton()
                .checkField("name", testData.userName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
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
                .typeUserEmail(userErrorEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitFormButton()
                .checkUserEmailHasErrorClass();

    }

}

