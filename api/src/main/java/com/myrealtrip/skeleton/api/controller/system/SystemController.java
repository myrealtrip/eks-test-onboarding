package com.myrealtrip.skeleton.api.controller.system;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * System Controller
 *
 * @author sarasu
 * @since 2021.09.27
 */
@Slf4j
@RestController
public class SystemController {
    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @Value("${myrealtrip.service.name}")
    private String serviceName;

    @Value("${myrealtrip.service.version}")
    private String version;

    @ApiOperation(value = "ELB Health Check")
    @GetMapping(path = "/_common/status")
    public String healthCheck() {
        return profile;
    }

    @ApiOperation(value = "System Version 정보 확인")
    @GetMapping(path = "/_common/system-info")
    public String systemInfo() {
        return serviceName + " : " + version;
    }
}
