package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class AboutUsPageTests extends TestBase {
    @Test
    @DisplayName("Check page \"About Us\"")
    void CheckPageAboutUs() {
        open("");
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//nav[@class = 'categories']/a[text() = 'О нас']").click();
        $x("//div[@class = 'middle']/h1[text() = 'О компании']").shouldHave(visible);
        $x("//div[@class = 'about']").shouldHave(visible);
        $x("//img[@alt= 'Услуги компании']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = 'О компании']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = 'Руководство']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = 'Партнёры']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = 'Лицензии и сертификаты']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = 'Благодарственные письма']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = 'Новости']").shouldHave(visible);
    }

    @Test
    @DisplayName("Check page \"About Com\"")
    void CheckCliderOnPageAboutUs() {
        open("");
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//nav[@class = 'categories']/a[text() = 'О нас']").click();

        $x("//div[@class= 'links']/a[text() = 'Руководство']").click();
        $x("//div[@class = 'middle']/h1[text() = 'Руководство компании']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = 'Партнёры']").click();
        $x("//div[@class = 'paper-content']/p[text() = 'Партнёры компании']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = 'Лицензии и сертификаты']").click();
        $x("//div[@class = 'paper-content']/p[text() = 'Лицензии и сертификаты']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = 'Благодарственные письма']").click();
        $x("//div[@class = 'paper-content']/p[text() = 'Благодарственные письма']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = 'Новости']").click();
        $x("//div[@class = 'top']/p[text() = 'Новости']").shouldHave(visible);
    }
}
