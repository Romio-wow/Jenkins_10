package tests.demoqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("demoqa")

public class RegistrationTest extends TestBase{


    @Test
    @DisplayName("Успешное заполнения формы регистрации")
    void fillFormTest() {
        step("Открытие формы регистрации", () -> {
            open("automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });
        step("Заполнение формы регистрации", () -> {
            $("#firstName").setValue("Джон");
            $("#lastName").setValue("Конар");
            $("#userEmail").setValue("roman.mi@mail.ru");
            $("#genterWrapper").$(byText("Other")).click();
            $("#userNumber").setValue("1231231230");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("2005");
            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("img/1.png");
            $("#currentAddress").setValue("Some street 1");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();
        });
        step("Проверить данные формы", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Джон Конар"), text("roman.mi@mail.ru"), text("Other"));
        });


    }


}
