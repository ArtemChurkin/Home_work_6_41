package utils;

import org.junit.jupiter.api.Test;
import testdata.TestData;

import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    public static String getRandomString(int length) {
        String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }

    public static String getRandomEmail() {

        return format("%s@%s.com", getRandomString(10), getRandomString(8));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomErrorEmail() {

        return format("%s.%s.com", getRandomString(10), getRandomString(8));
    }

    public static String getRandomPhone() {
        String phoneTemplate = "%s%s%s%s";

        return format(phoneTemplate, getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        return getRandomItemFromStringArray(months);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Physics", "Civics", "Chemistry", "English",
                "Economics", "History", "Biology"};
        return getRandomItemFromStringArray(subjects);
    }

    public static String getRandomHobbie() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromStringArray(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"img/123.png", "img/random1.jpg", "img/random2.png"};
        return getRandomItemFromStringArray(pictures);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromStringArray(states);
    }

    public static String getRandomCity(String state) {
        if (state.contains("NCR")) {
            String[] cityes = {"Delhi", "Gurgaon", "Noida"};
            return getRandomItemFromStringArray(cityes);
        }
        if (state.contains("Uttar Pradesh")) {
            String[] cityes = {"Agra", "Lucknow", "Merrut"};
            return getRandomItemFromStringArray(cityes);
        }
        if (state.contains("Haryana")) {
            String[] cityes = {"Karnal", "Panipat"};
            return getRandomItemFromStringArray(cityes);
        }
        if (state.contains("Rajasthan")) {
            String[] cityes = {"Jaipur", "Jaiselmer"};
            return getRandomItemFromStringArray(cityes);
        }
        return state;
    }

    public static String getRandomItemFromStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);

        return stringArray[randomIndex];
    }

}








