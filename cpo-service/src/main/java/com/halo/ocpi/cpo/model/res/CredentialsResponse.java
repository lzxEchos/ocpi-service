package com.halo.ocpi.cpo.model.res;

import lombok.Data;

/**
 * 认证响应模型类。
 * <p>
 * 该类用于表示 CPO 返回给 EMSP 的认证响应信息。
 * </p>
 */
@Data
public class CredentialsResponse {

    /**
     * 认证 token
     * CPO 返回给 EMSP 的认证 token
     */
    private String token;

    /**
     * 端点的 URL
     * CPO 返回给 EMSP 的端点 URL
     */
    private String url;
}