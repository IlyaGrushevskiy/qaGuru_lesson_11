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
}
