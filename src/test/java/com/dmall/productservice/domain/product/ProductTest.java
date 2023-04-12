package com.dmall.productservice.domain.product;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class ProductTest {

    @Test
    public void should_get_fund_name_by_product_pdf_url() {
        String url = "https://www.dmall.com/2017-10-10-005230.OF---长盛货币B-长盛货币市场基金托管协议.pdf";
        Product product = new Product(null , "name", "description", ProductPrice.of("USD", new BigDecimal("10.00")), url, false);
        assertEquals("长盛货币B", product.getFundName());
    }
}