package tests;

import com.codeborne.selenide.ElementsCollection;
import config.BaseTest;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class AboutUsPageTests extends config.BaseTest {

    @BeforeEach
    public void beforeFunction() {
        open("https://ifellow.ru/");
    }

    @Test
    @DisplayName("Check page \"About Us\"")
    void CheckPageAboutUs() {
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

    @Test
    @DisplayName("Open Main page")
    void loadMainPage() {
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//div[@class = 'who-we-are']/h1").shouldHave(text("Quality. Clarity. Performance. Reality."));
    }

    @Test
    @DisplayName("Check Main menu")
    void checkMainMenu() {
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

    @Test
    @DisplayName("Check page \"Vacancies\"")
    void CheckFilterOnVacanciesPage() {
        String vacancyCity = "Москва";
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//nav[@class = 'categories']/a[text() = 'Карьера']").click();

        $x("//span[@class = 'multiselect__placeholder']").click();
        $x("//span[contains(@class, 'multiselect__option')]/span[text() = '"+vacancyCity+"']").click();
        sleep(1000);

        ElementsCollection vacancyList = $$x("//div[@class = 'app-table']//tr");
        for (int i = 1; i < 21; i++) {
            Assertions.assertTrue(vacancyList.get(i).getText().contains(vacancyCity));
        }
    }
}
