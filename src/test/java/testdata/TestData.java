package testdata;

import com.github.javafaker.Faker;
import utils.RandomUtils.*;

import static utils.RandomUtils.*;

public class TestData {
    Faker faker = new Faker();

    public String userName = faker.name().username();
    public String userEmail = faker.internet().emailAddress();
    public String userErrorEmail = getRandomErrorEmail();
    public String currentAddress = faker.address().cityName();
    public String permanentAddress = faker.address().cityName();

    public  String userFirstName = faker.name().firstName();
    public  String userLastName = faker.name().lastName();
    public  String userGender = getRandomGender();
    public  String userPhoneNumber = getRandomPhone();
    public  String userErrorPhoneNumber = getRandomString(6);
    public  String userBirthdayMonth = getRandomMonth();
    public  String userBirthdayYear = (String.valueOf(getRandomInt(1950, 2026)));
    public  String userBirthDay = (String.valueOf(getRandomInt(1,28)));
    public  String userBirthDayDate = userBirthDay+" "+ userBirthdayMonth+","+userBirthdayYear;
    public  String subject = getRandomSubject();
    public  String hobbie = getRandomHobbie();

    public  String pictureName = getRandomPicture();
    public  String state = getRandomState();
    public  String city = getRandomCity(state);

    public static String tableTitle = "Thanks for submitting the form";
    public static String borderColor = "border-color";
    public static String red = "rgb(220, 53, 69)";
    public static String backroundImage = "background-image";
    public static String errorIcon = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";

}
