package com.halo.ocpi.cpo.model.res;

import lombok.Data;

/**
 * OCPI 端点响应模型类。
 * <p>
 * 该类用于表示 CPO 返回给 EMSP 的端点响应信息。
 * </p>
 */
@Data
public class EndpointResponse {

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