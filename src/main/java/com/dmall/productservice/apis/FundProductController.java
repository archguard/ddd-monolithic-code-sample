package com.dmall.productservice.apis;

import com.dmall.productservice.apis.dto.FundProductRequest;
import com.dmall.productservice.apis.dto.ProductResponse;
import com.dmall.productservice.application.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fund-products")
public class FundProductController {

    private final ProductService productService;

    public FundProductController(ProductService productService) {
        this.productService = productService;
    }

    // 假设要上架的产品名称已经存在于系统中, 当我在管理后台上选择上架该产品, 那么系统会提示我该产品名称已存在
    // 假设产品名称、产品期限、产品收益率有一项或多项为空, 当我在管理后台上选择上架该产品, 那么系统会提示我必填项不能为空
    // 产品期限不能小于等于0, 假设产品期限小于等于0, 当我在管理后台上选择上架该产品, 那么系统会提示我产品期限不能小于等于0
    // 假设产品收益率小于0, 当我在管理后台上选择上架该产品, 那么系统会提示我产品收益率不能小于0
    //
    @RequestMapping("/on-sale")
    public ProductResponse onSale(@RequestBody FundProductRequest fundProductRequest) {
        if (this.productService.isProductExist(fundProductRequest.getName())) {
            throw new RuntimeException("该产品名称已存在");
        }

        if (fundProductRequest.getName() == null || fundProductRequest.getTerm() == null || fundProductRequest.getYield() == null) {
            throw new RuntimeException("必填项不能为空");
        }

        if (Integer.parseInt(fundProductRequest.getTerm()) <= 0) {
            throw new RuntimeException("产品期限不能小于等于0");
        }

        if (Integer.parseInt(fundProductRequest.getYield()) < 0) {
            throw new RuntimeException("产品收益率不能小于0");
        }

        return null;
    }
}


