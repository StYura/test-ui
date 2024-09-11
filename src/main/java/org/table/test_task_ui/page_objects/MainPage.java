package org.table.test_task_ui.page_objects;

import io.qameta.allure.Step;
import org.table.test_task_ui.models.CompanyUIModel;
import org.table.test_task_ui.models.Table;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    @Step
    public void clickOnTable1() {
        $x("//button[.='Table 1']").click();
    }

    @Step
    public void clickOnTable2() {
        $x("//button[.='Table 2']").click();
    }

    @Step
    public List<CompanyUIModel> getTableItems() {
        return new Table().readTable();
    }
}
