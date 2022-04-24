package org.example;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

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


       // String expectedFullName = format("%s %s", firstName, lastName);

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
                .submit();
//                .checkResult();


    //    $("#firstName").setValue(firstName);
    //    $("#lastName").setValue(lastName);
    //    $("#userEmail").setValue(email);
    //    $("#genterWrapper").$(byText(genderWrapper[0])).click();
    //    $("#userNumber").setValue(userNumber);
    //    $("#dateOfBirthInput").click();
    //    $(".react-datepicker__month-select").selectOption("August");
    //    $(".react-datepicker__year-select").selectOption("1953");
    //    $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month").click();
    //    $("#subjectsInput").setValue("Arts").pressEnter();
    //    $(byText("Sports")).click();
    //    $("#uploadPicture").uploadFile(new File("src/test/resources/Hulk-Hogan.jpg"));
    //    $("#currentAddress").setValue(userAddress);
    //    $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
    //    $("#react-select-4-input").setValue("Agra").pressEnter();
    //    $("#submit").click();

//
//       $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
//                text(email),
//                text(genderWrapper[0]),
//                text(userNumber),
//                text("11 August,1953"),
//                text("Hulk-Hogan.jpg"),
//                text(userAddress),
//                text("Uttar Pradesh"),
//                text("Agra"));
    }
}
