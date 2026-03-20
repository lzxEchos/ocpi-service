package com.halo.ocpi.cpo.service;

import com.halo.ocpi.cpo.model.res.EndpointResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 端点服务类。
 * <p>
 * 该类负责处理与服务端点相关的业务逻辑。
 * </p>
 */
@Service
public class EndpointsService {

    /**
     * 获取支持的 OCPI 端点列表。
     *
     * @return 支持的端点信息列表
     */
    public List<EndpointResponse> getEndpoints() {
        List<EndpointResponse> endpoints = new ArrayList<>();

        EndpointResponse endpoint = new EndpointResponse();
        endpoint.setIdentifier("credentials");
        endpoint.setUrl("/ocpi/2.2.1/credentials");

        endpoints.add(endpoint);

        return endpoints;
    }
}