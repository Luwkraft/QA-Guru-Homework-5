package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

import org.example.Components.CalendarComponent;


import java.io.File;

import static com.codeborne.selenide.Selenide.executeJavaScript;

    public  class RegistrationFormPage {
        CalendarComponent calendar = new CalendarComponent();

        // locators
        SelenideElement firstNameInput = $("#firstName");
        SelenideElement lastNameInput = $("#setLastName");
        SelenideElement userEmailInput = $("#setUserEmail");
        SelenideElement subjectsInput = $("#setSubject");

        //actions
        public RegistrationFormPage openPage() {
            open("/automation-practice-form");
//            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//            executeJavaScript("$('footer').remove()");
//            executeJavaScript("$('#fixedban').remove()");
            zoom(0.75);
            return this;
        }

        public RegistrationFormPage setFirstName(String value) {
            firstNameInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setLastName(String value) {
            lastNameInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setEmail(String value) {
            userEmailInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setGender(String value) {
            $("#genterWrapper").$(byText(value)).click();

            return this;
        }

        public RegistrationFormPage setBirthDate(String day, String month, String year) {
            $("#dateOfBirthInput").click();
            calendar.setDate(day, month, year);
            return this;
        }

        public RegistrationFormPage setUserNumber(String value) {
            $("#userNumber").setValue(value);
            return this;
        }
        public RegistrationFormPage subjectsInput(String value) {
            subjectsInput.setValue(value);
            return this;
        }

        public RegistrationFormPage hobbiesInput(String value) {
            $(byText("Sports")).click();
            return this;
        }

        public RegistrationFormPage uploadPicture(String value) {
            $("#uploadPicture").uploadFile(new File("src/test/resources/Hulk-Hogan.jpg"));
            return this;
        }

        public RegistrationFormPage currentAddress(String value) {
            $("#currentAddress").setValue(value);
            return this;
        }
        public RegistrationFormPage selectState(String value) {
            $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
            return this;
        }
        public RegistrationFormPage selectCity(String value) {
            $("#react-select-4-input").setValue("Agra").pressEnter();
            return this;
        }

        public RegistrationFormPage submit() {
            $("#submit").click();
            return this;
        }

        public RegistrationFormPage checkResult(String key, String value) {
            $(".table-responsive").$(byText(key))
                    .parent().shouldHave(text(value));
            return this;
        }
    }
