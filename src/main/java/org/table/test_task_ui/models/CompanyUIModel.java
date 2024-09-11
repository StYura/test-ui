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

    public boolean equals(CompanyUIModel companyUIModel) {
        if (!this.companyName.equals(companyUIModel.getCompanyName())
            || !this.ticker.equals(companyUIModel.getTicker())
            || !this.cobDate.equals(companyUIModel.getCobDate())
            || !this.stockPrice.equals(companyUIModel.getStockPrice())
            || !this.marketCap.equals(companyUIModel.getMarketCap())) {
            Allure.attachment("Company comparison error: ", "Company from table 1 %s should be equal to %s but it wasn't".formatted(this.toString(), companyUIModel.toString()));
            return false;
        }
        return true;
        }
    }
