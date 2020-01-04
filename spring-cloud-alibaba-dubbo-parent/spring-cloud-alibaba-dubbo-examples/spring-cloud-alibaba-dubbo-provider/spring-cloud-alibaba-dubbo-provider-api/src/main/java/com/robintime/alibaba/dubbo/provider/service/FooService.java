package com.robintime.alibaba.dubbo.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: liuxiaoyong
 * @Date: 2019-12-20 16:22
 * @Description:
 */
@FeignClient("provider")
public interface FooService {
    @GetMapping("/foo")
    String foo();
}
