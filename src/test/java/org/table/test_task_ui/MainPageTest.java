package org.table.test_task_ui;

import org.table.test_task_ui.models.CompanyUIModel;
import org.table.test_task_ui.page_objects.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        open(getUrl());
    }

    @Test
    public void compareTables() {
        MainPage mainPage = new MainPage();
        mainPage.clickOnTable1();
        List<CompanyUIModel> table1Items = mainPage.getTableItems();
        mainPage.clickOnTable2();
        List<CompanyUIModel> table2Items = mainPage.getTableItems();

        assertThat(table1Items).hasSameSizeAs(table2Items);
        assertThat(table1Items).allMatch(table1Item -> {
            CompanyUIModel table2Item = table2Items
                    .stream()
                    .filter(table2item -> table2item.getCompanyName().equals(table1Item.getCompanyName()))
                    .findFirst()
                    .orElseThrow();
            return table1Item.equalsCompany(table2Item);
        });
    }

}
