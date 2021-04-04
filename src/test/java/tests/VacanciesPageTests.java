package tests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class VacanciesPageTests extends TestBase {
    @Test
    @DisplayName("Check page \"About Com\"")
    void CheckFilterOnVacanciesPage() {

        String vacancyCity = "Москва";

        open("");
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
