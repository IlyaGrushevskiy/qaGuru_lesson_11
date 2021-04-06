package tests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
        $x("//nav[@class = 'categories']/a[text() = '� ���']").click();
        $x("//div[@class = 'middle']/h1[text() = '� ��������']").shouldHave(visible);
        $x("//div[@class = 'about']").shouldHave(visible);
        $x("//img[@alt= '������ ��������']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = '� ��������']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = '�����������']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = '�������']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = '�������� � �����������']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = '���������������� ������']").shouldHave(visible);
        $x("//div[@class= 'links']/a[text() = '�������']").shouldHave(visible);
    }

    @Test
    @DisplayName("Check page \"About Com\"")
    void CheckCliderOnPageAboutUs() {
        open("");
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//nav[@class = 'categories']/a[text() = '� ���']").click();

        $x("//div[@class= 'links']/a[text() = '�����������']").click();
        $x("//div[@class = 'middle']/h1[text() = '����������� ��������']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = '�������']").click();
        $x("//div[@class = 'paper-content']/p[text() = '������� ��������']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = '�������� � �����������']").click();
        $x("//div[@class = 'paper-content']/p[text() = '�������� � �����������']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = '���������������� ������']").click();
        $x("//div[@class = 'paper-content']/p[text() = '���������������� ������']").shouldHave(visible);

        $x("//div[@class= 'links']/a[text() = '�������']").click();
        $x("//div[@class = 'top']/p[text() = '�������']").shouldHave(visible);
    }

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
        $x("//nav[@class = 'categories']/a[text() = '� ���']").click();
        $x("//div[@class = 'middle']/h1").shouldHave(text("� ��������"));
        $x("//nav[@class = 'categories']/a[text() = '������� � �������']").click();
        $x("//div[@class = 'projects paper-content']/h1").shouldHave(text("������� � �������"));
        $x("//nav[@class = 'categories']/a[text() = '������']").click();
        $x("//div[@class = 'paper-content']/h1").shouldHave(text("������ ��� ������ �������"));
        $x("//nav[@class = 'categories']/a[text() = '�������']").click();
        $x("//div[@class = 'page-top']/p").shouldHave(text("��������"));
        $x("//nav[@class = 'categories']/a[text() = '��������']").click();
        $x("//div[@class = 'contact-detail-content paper-container']/h1").shouldHave(text("��������"));
    }

    @Test
    @DisplayName("Check page \"Vacancies\"")
    void CheckFilterOnVacanciesPage() {

        String vacancyCity = "������";

        open("");
        sleep(2000);
        if ($x("//button[@class = 'app-close']").isDisplayed())
            $x("//button[@class = 'app-close']").click();
        $x("//nav[@class = 'categories']/a[text() = '�������']").click();

        $x("//span[@class = 'multiselect__placeholder']").click();
        $x("//span[contains(@class, 'multiselect__option')]/span[text() = '"+vacancyCity+"']").click();
        sleep(1000);

        ElementsCollection vacancyList = $$x("//div[@class = 'app-table']//tr");
        for (int i = 1; i < 21; i++) {
            Assertions.assertTrue(vacancyList.get(i).getText().contains(vacancyCity));
        }
    }
}
