package com.dmall.productservice.apis.dto;


//  FundProduct 的基本信息，包括产品名称、产品期限、产品收益率
public class FundProductRequest {
    private String name;
    private String term;
    private String yield;

    public FundProductRequest(String name, String term, String yield) {
        this.name = name;
        this.term = term;
        this.yield = yield;
    }

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public String getYield() {
        return yield;
    }
}
