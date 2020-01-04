package com.robintime.alibaba.dubbo.provider.service.impl;

import com.robintime.alibaba.dubbo.provider.service.ProviderService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuxiaoyong
 * @Date: 2019-12-20 16:26
 * @Description:
 */
@RestController
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String hi() {
        return "alibaba dubbo Hi~~~";
    }
}
