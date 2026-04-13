package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import java.util.Locale;

import static testdata.TestData.*;
import static utils.RandomUtils.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void succesfulFillFormTest_with_random_utils_dsl() {


        String userName = getRandomString(8);
        String userEmail = getRandomEmail();
        String currentAddress = getRandomString(15);
        String permanentAddress = getRandomString(12);



        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitFormButton()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }

    @Test
    void onlyRequiredFieldSuccesfulTest2_dsl() {

        String userName = getRandomString(8);
        String userEmail = getRandomEmail();


        textBoxPage.openPage()

        .typeUserName(userName)
        .typeUserEmail(userEmail)
                .submitFormButton()
                .checkField("name", userName)
                .checkField("email", userEmail);
    }

    @Test
    void firstNegativeTest_dsl() {

        String userName = getRandomString(8);
        String userErrorEmail = getRandomErrorEmail();
        String currentAddress = getRandomString(15);
        String permanentAddress = getRandomString(12);

        textBoxPage.openPage()

        .typeUserName(userName)
        .typeUserEmail(userErrorEmail)
        .typeCurrentAddress(currentAddress)
        .typePermanentAddress(permanentAddress)
                .submitFormButton()
                .checkUserEmailHasErrorClass();

    }

}

