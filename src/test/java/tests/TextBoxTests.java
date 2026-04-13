package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import java.util.Locale;

import static testdata.TestData.*;
import static utils.RandomUtils.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    String userNameU;
    String userEmailU;
    String userErrorEmailU;
    String currentAddressU;
    String permanentAddressU;

    @BeforeEach
    void prepareRandomData(){
        userNameU = getRandomString(8);
        userEmailU = getRandomEmail();
        userErrorEmailU = getRandomErrorEmail();
        currentAddressU = getRandomString(15);
        permanentAddressU = getRandomString(12);
    }

    @Test
    void succesfulFillFormTest_with_random_utils_dsl() {

        textBoxPage.openPage()
                .typeUserName(userNameU)
                .typeUserEmail(userEmailU)
                .typeCurrentAddress(currentAddressU)
                .typePermanentAddress(permanentAddressU)
                .submitFormButton()
                .checkField("name", userNameU)
                .checkField("email", userEmailU)
                .checkField("currentAddress", currentAddressU)
                .checkField("permanentAddress", permanentAddressU);
    }

    @Test
    void onlyRequiredFieldSuccesfulTest2_dsl() {

        textBoxPage.openPage()

        .typeUserName(userNameU)
        .typeUserEmail(userEmailU)
                .submitFormButton()
                .checkField("name", userNameU)
                .checkField("email", userEmailU);
    }

    @Test
    void firstNegativeTest_dsl() {

        textBoxPage.openPage()

        .typeUserName(userNameU)
        .typeUserEmail(userErrorEmailU)
        .typeCurrentAddress(currentAddressU)
        .typePermanentAddress(permanentAddressU)
                .submitFormButton()
                .checkUserEmailHasErrorClass();

    }

}

