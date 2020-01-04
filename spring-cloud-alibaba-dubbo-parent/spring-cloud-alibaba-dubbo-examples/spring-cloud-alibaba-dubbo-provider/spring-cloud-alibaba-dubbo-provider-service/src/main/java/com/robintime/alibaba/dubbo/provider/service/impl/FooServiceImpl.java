package com.robintime.alibaba.dubbo.provider.service.impl;

import com.robintime.alibaba.dubbo.provider.service.FooService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuxiaoyong
 * @Date: 2019-12-20 16:28
 * @Description:
 */
@RestController
public class FooServiceImpl implements FooService {
    @Override
    public String foo() {
        return "alibaba dubbo foo~~~";
    }
}
