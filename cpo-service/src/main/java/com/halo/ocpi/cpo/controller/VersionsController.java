package com.halo.ocpi.cpo.controller;

import com.halo.ocpi.cpo.model.res.VersionResponse;
import com.halo.ocpi.cpo.service.VersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 版本控制器。
 * <p>
 * 该控制器用于处理有关 OCPI 版本的信息。
 * </p>
 */
@RestController
@RequestMapping("/ocpi/versions")
public class VersionsController {

    @Autowired
    private VersionsService versionsService;

    /**
     * 获取 OCPI 版本信息列表。
     *
     * @return 支持的版本信息
     */
    @GetMapping
    public List<VersionResponse> getVersions() {
        return versionsService.getVersions();
    }
}