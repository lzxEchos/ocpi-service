package com.halo.ocpi.cpo.controller;

import com.halo.ocpi.cpo.model.res.EndpointResponse;
import com.halo.ocpi.cpo.service.EndpointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务端点控制器。
 * <p>
 * 该控制器用于处理有关 OCPI 服务端点的信息，通常 EMSP 会查询此接口。
 * </p>
 */
@RestController
@RequestMapping("/ocpi/{version}/endpoints")
public class EndpointsController {

    @Autowired
    private EndpointsService endpointsService;

    /**
     * 获取支持的 OCPI 服务端点信息。
     *
     * @return 支持的端点信息
     */
    @GetMapping
    public List<EndpointResponse> getEndpoints() {
        return endpointsService.getEndpoints();
    }
}