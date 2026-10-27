package com.yilu.web01.controller;

import com.yilu.web01.pojo.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理健康检查请求。
 */
@RestController
public class HealthController {

    @GetMapping(value = "/api/health")
    public HealthResponse getHealth() {

        HealthResponse healthResponse = new HealthResponse();

        healthResponse.setStatus("ok");

        return healthResponse;
    }
}
