package com.halo.ocpi.cpo.model;

import lombok.Data;

/**
 * 认证信息模型类。
 * <p>
 * 该类用于表示 EMSP 和 CPO 之间的认证信息，包含 token 和端点 URL。
 * </p>
 */
@Data
public class Credentials {

    /**
     * 认证 token
     * 用于验证 EMSP 和 CPO 之间的身份
     */
    private String token;

    /**
     * 端点的 URL
     * 表示该认证信息所属的端点
     */
    private String url;

    /**
     * 参与认证的平台标识
     * 例如：ABC
     */
    private String partyId;

    /**
     * 国家代码
     * 例如：DE
     */
    private String countryCode;
}