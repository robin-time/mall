package com.robintime.alibaba.dubbo.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: liuxiaoyong
 * @Date: 2019-12-20 16:20
 * @Description:
 */
@FeignClient("provider")
public interface ProviderService {

    @GetMapping("/hi")
    String hi ();
}
