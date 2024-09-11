package org.table.test_task_ui.models;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Table {
    private final SelenideElement parent;
    private final ElementsCollection headers;
    private final Map<String, Integer> columnIndexMap;

    public Table() {
        parent = $x("//tbody");
        headers = $$x("//thead//th");
        columnIndexMap = buildColumnIndexMap();
    }

    public List<CompanyUIModel> readTable() {
        scrollToBottom();
        return parent.$$x(".//tr").texts()
                .stream()
                .parallel()
                .map(text -> {
                    String[] split = text.split("\\t");
                    return CompanyUIModel.builder()
                            .companyName(split[columnIndexMap.get("Company Name")])
                            .ticker(split[columnIndexMap.get("Ticker")])
                            .cobDate(LocalDate.parse(split[columnIndexMap.get("COB Date")]))
                            .stockPrice(new BigDecimal(split[columnIndexMap.get("Stock Price")]))
                            .marketCap(new BigDecimal(split[columnIndexMap.get("Market Cap")]))
                            .build();
                })
                .toList();
    }

    private void scrollToBottom() {
        int size = 0;
        int newSize = 100;
        while (size != newSize) {
            executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
            sleep(100);
            size = newSize;
            newSize = parent.$$x(".//tr").size();
        }
    }

    private Map<String, Integer> buildColumnIndexMap() {
        Map<String, Integer> result = new HashMap<>();
        headers.forEach(header -> {
            int columnIndex = headers
                    .shouldHave(CollectionCondition.sizeGreaterThan(0))
                    .filter(text(header.text()))
                    .first()
                    .$$x(".//preceding-sibling::th")
                    .size();
            result.put(header.text(), columnIndex);
        });
        return result;
    }
}
