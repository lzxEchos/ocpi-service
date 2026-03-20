package com.halo.ocpi.cpo.service;

import com.halo.ocpi.cpo.model.res.VersionResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 版本服务类。
 * <p>
 * 该类负责处理与版本相关的业务逻辑。
 * </p>
 */
@Service
public class VersionsService {

    /**
     * 获取支持的 OCPI 版本列表。
     *
     * @return 支持的版本信息列表
     */
    public List<VersionResponse> getVersions() {
        List<VersionResponse> versions = new ArrayList<>();

        VersionResponse version = new VersionResponse();
        version.setVersion("2.2.1");
        version.setUrl("/ocpi/2.2.1");

        versions.add(version);

        return versions;
    }
}