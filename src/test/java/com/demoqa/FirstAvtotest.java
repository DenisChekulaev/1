package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstAvtotest {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";

    }
    @Test

    void formTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Denis");
        $("#lastName").setValue("Chekulaev");
        $("#userEmail").setValue("Chekulaev@mail.ru");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("7918888888");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1986");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("[for = hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Road.jpg"));
        $("#currentAddress").setValue("Rostov-on-Don");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Denis Chekulaev"));
        $(".modal-body").shouldHave(text("Chekulaev@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("7918888888"));
        $(".modal-body").shouldHave(text("05 August,1986"));
        $(".modal-body").shouldHave(text("Economics"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("Road.jpg"));
        $(".modal-body").shouldHave(text("Rostov-on-Don"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
    }


}
