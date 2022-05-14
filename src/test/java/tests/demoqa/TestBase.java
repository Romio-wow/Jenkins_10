package tests.demoqa;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void preconditions() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.remote ="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void attachments(){
        Attach.screenshotAs("Мой красивый скриншот");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }
}
