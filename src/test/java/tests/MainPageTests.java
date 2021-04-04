package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Open Main page")
    void loadMainPage() {
        open("");
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//div[@class = 'who-we-are']/h1").shouldHave(text("Quality. Clarity. Performance. Reality."));
    }

    @Test
    @DisplayName("Check Main menu")
    void checkMainMenu() {
        open("");
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//div[@class = 'who-we-are']/h1").shouldHave(text("Quality. Clarity. Performance. Reality."));
        $x("//nav[@class = 'categories']/a[text() = 'О нас']").click();
        $x("//div[@class = 'middle']/h1").shouldHave(text("О компании"));
        $x("//nav[@class = 'categories']/a[text() = 'Решения и проекты']").click();
        $x("//div[@class = 'projects paper-content']/h1").shouldHave(text("Решения и проекты"));
        $x("//nav[@class = 'categories']/a[text() = 'Услуги']").click();
        $x("//div[@class = 'paper-content']/h1").shouldHave(text("Услуги для вашего бизнеса"));
        $x("//nav[@class = 'categories']/a[text() = 'Карьера']").click();
        $x("//div[@class = 'page-top']/p").shouldHave(text("Вакансии"));
        $x("//nav[@class = 'categories']/a[text() = 'Контакты']").click();
        $x("//div[@class = 'contact-detail-content paper-container']/h1").shouldHave(text("Контакты"));
    }
}
