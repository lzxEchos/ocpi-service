package com.halo.ocpi.cpo.model;

import lombok.Data;

/**
 * OCPI 版本信息模型类。
 * <p>
 * 该类表示 OCPI 协议的版本信息。
 * </p>
 */
@Data
public class Version {

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