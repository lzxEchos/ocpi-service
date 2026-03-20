package com.halo.ocpi.cpo.model.res;

import lombok.Data;

/**
 * OCPI 版本响应模型类。
 * <p>
 * 该类用于表示 CPO 返回给 EMSP 的版本响应信息。
 * </p>
 */
@Data
public class VersionResponse {

    /**
     * OCPI 版本号
     * 例如：2.2.1
     */
    private String version;

    /**
     * OCPI 版本的 URL
     * 例如："/ocpi/2.2.1"
     */
    private String url;
}