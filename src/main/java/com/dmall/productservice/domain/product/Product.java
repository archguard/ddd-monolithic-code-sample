
package com.dmall.productservice.domain.product;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {

    private Long id;

    private String name;

    private String description;

    private ProductPrice price;

    private String productPdfUrl;

    private Boolean isOnSale;

    public Product(Long id, String name, String description, ProductPrice price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(Long id, String name, String description, ProductPrice price, String productPdfUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productPdfUrl = productPdfUrl;
    }

    public void setDeleted(boolean deleted) {
        this.isOnSale = !deleted;
    }

    public boolean isProductPdfUrlValid() {
        // 使用正则表达式检查
        // 输入: https://{url}/2017-10-10-005230.OF---长盛货币B-长盛货币市场基金托管协议.pdf, 输出: true
        // 输入: http://{url}/2017-10-10-005230.OF---长盛货币B-长盛货币市场基金托管协议.pdf, 输出: true
        return productPdfUrl.matches("^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?$");
    }

    public String getFundName() {
        //use regex to match
        //input: https://{url}/2017-10-10-005230.OF---长盛货币B-长盛货币市场基金托管协议.pdf, output: 长盛货币B
        //input: https://{url}/2022-09-09-007725.OF---招商瑞文A-招商瑞文混合型证券投资基金招募说明书更新.pdf, output: 招商瑞文A
        String regex = ".*---(.*)-.*";
        return productPdfUrl.replaceAll(regex, "$1");
    }
}

