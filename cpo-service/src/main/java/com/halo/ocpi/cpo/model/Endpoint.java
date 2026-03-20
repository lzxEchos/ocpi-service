package com.halo.ocpi.cpo.model;

import lombok.Data;

/**
 * OCPI 服务端点模型类。
 * <p>
 * 该类表示一个 OCPI 协议中的服务端点信息，包括端点标识符和对应的 URL。
 * </p>
 */
@Data
public class Endpoint {

    /**
     * 端点的唯一标识符
     * 例如：credentials
     */
    private String identifier;

    /**
     * 端点对应的 URL
     * 例如："/ocpi/2.2.1/credentials"
     */
    private String url;
}