package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import javax.print.DocFlavor;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest {

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


        $("#firstName").setValue("Hulk");
        $("#lastName").setValue("Hogan");
        $("#userEmail").setValue("hulk@hogan.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1655783317");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1953");
        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Hulk-Hogan.jpg"));
        $("#currentAddress").setValue("Beverly Hills 90210");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").click();

        
       $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Hulk Hogan"),text("hulk@hogan.com"),text("Male"),
                text("1655783317"), text("11 August,1953"), text("Hulk-Hogan.jpg"),
                text("Beverly Hills 90210"), text("Uttar Pradesh"), text("Agra"));
    }

}
