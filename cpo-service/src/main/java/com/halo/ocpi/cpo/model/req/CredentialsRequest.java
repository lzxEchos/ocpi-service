package com.halo.ocpi.cpo.model.req;

import lombok.Data;

/**
 * 认证请求模型类。
 * <p>
 * 该类用于表示 EMSP 向 CPO 提供的认证请求信息。
 * </p>
 */
@Data
public class CredentialsRequest {

    /**
     * 认证 token
     * EMSP 传递的 token
     */
    private String token;

    /**
     * 端点的 URL
     * EMSP 传递的端点 URL
     */
    private String url;

    /**
     * 参与认证的平台标识
     * EMSP 提供的 partyId
     */
    private String partyId;

    /**
     * 国家代码
     * EMSP 提供的国家代码
     */
    private String countryCode;
}