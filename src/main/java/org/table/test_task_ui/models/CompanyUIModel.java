package org.table.test_task_ui.models;

import io.qameta.allure.Allure;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class CompanyUIModel {
    private String companyName;
    private String ticker;
    private LocalDate cobDate;
    private BigDecimal stockPrice;
    private BigDecimal marketCap;

    public boolean equalsCompany(CompanyUIModel companyUIModel) {
        boolean isEqual = true;

        if (!this.ticker.equals(companyUIModel.getTicker())) {
            Allure.attachment("Company %s comparison error: ".formatted(companyUIModel.getCompanyName()),
                    String.format("Ticker mismatch: %s != %s", this.ticker, companyUIModel.getTicker()));
            isEqual = false;
        }

        if (!this.cobDate.equals(companyUIModel.getCobDate())) {
            Allure.attachment("Company %s comparison error: ".formatted(companyUIModel.getCompanyName()),
                    String.format("COB Date mismatch: %s != %s", this.cobDate, companyUIModel.getCobDate()));
            isEqual = false;
        }

        if (!this.stockPrice.equals(companyUIModel.getStockPrice())) {
            Allure.attachment("Company %s comparison error: ".formatted(companyUIModel.getCompanyName()),
                    String.format("Stock Price mismatch: %s != %s", this.stockPrice, companyUIModel.getStockPrice()));
            isEqual = false;
        }

        if (!this.marketCap.equals(companyUIModel.getMarketCap())) {
            Allure.attachment("Company %s comparison error: ".formatted(companyUIModel.getCompanyName()),
                    String.format("Market Cap mismatch: %s != %s", this.marketCap, companyUIModel.getMarketCap()));
            isEqual = false;
        }

        return isEqual;
    }
}
