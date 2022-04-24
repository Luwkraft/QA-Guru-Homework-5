package org.example;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormTest {

    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

 //   private String Pic;

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillForm() {

      open("/automation-practice-form");
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String[] genderWrapper = new String[] {"Male", "Female", "Other"};
        String userNumber = "7894561230";
        String day = "11";
        String month = "August";
        String year = "1953";
        String subject = "Arts";
        String hobbies = "Sports";
        String uploadPicture = "Hulk-Hogan.jpg";
        String userAddress = faker.address().fullAddress();
        String selectState = "Uttar Pradesh";
        String selectCity = "Agra";


        String expectedFullName = format("%s %s", firstName, lastName);
        String expectedDateOfBirth = format("%s %s,%s", day,month,year);
        String expectedStateAndCity = format("%s %s", selectState, selectCity);

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(genderWrapper[0])
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .subjectsInput(subject)
                .hobbiesInput(hobbies)
                .uploadPicture(uploadPicture)
                .currentAddress(userAddress)
                .selectState(selectState)
                .selectCity(selectCity)
                .submit()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", genderWrapper[0])
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", expectedDateOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", userAddress)
                .checkResult("State and City",expectedStateAndCity);

    }

}
