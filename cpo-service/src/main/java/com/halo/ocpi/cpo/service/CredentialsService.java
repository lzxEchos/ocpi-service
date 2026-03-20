package com.halo.ocpi.cpo.service;

import com.halo.ocpi.cpo.model.req.CredentialsRequest;
import com.halo.ocpi.cpo.model.res.CredentialsResponse;
import org.springframework.stereotype.Service;

/**
 * 认证服务类。
 * <p>
 * 该类负责处理与认证信息相关的业务逻辑。
 * </p>
 */
@Service
public class CredentialsService {

    /**
     * 处理 EMSP 提供的认证信息。
     *
     * @param credentialsRequest EMSP 提供的认证信息
     * @return 返回认证成功的认证信息
     */
    public CredentialsResponse processCredentials(CredentialsRequest credentialsRequest) {
        // 在这里可以进行验证逻辑，返回适当的认证信息
        CredentialsResponse response = new CredentialsResponse();
        response.setToken(credentialsRequest.getToken());
        response.setUrl(credentialsRequest.getUrl());
        return response;
    }
}