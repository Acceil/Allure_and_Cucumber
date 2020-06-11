package appline.stepdefs;

import appline.pages.ContributionsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContributionsPageSteps {
    private ContributionsPage contributionsPage = new ContributionsPage();

    @When("Выбираем валюту {string}")
    public void chooseCurrency(String currency) {
        contributionsPage.chooseCurrency(currency);
    }

    @When("Заполняются поля:")
    public void fillFields(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> contributionsPage.input((String) field, (String) value));
    }

    @When("Ставим галочку 'Ежемесячная капитализация'")
    public void checkBox() {
        contributionsPage.selectCheckBox();
    }

    @When("Выполнена проверка значений:")
    public void checkValues(DataTable values) {
        values.asMap(String.class, String.class)
                .forEach((field, value) -> assertThat(
                        String.format("Значение поля [%s] должно быть равно [%s]. Актуальное - [%s]", field, value,
                                contributionsPage.getValues((String) field)),
                        (contributionsPage.getValues((String) field)).equals((String) value)));
    }
}
