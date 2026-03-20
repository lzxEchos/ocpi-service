package com.halo.ocpi.cpo.controller;

import com.halo.ocpi.cpo.model.req.CredentialsRequest;
import com.halo.ocpi.cpo.model.res.CredentialsResponse;
import com.halo.ocpi.cpo.service.CredentialsService;
import com.halo.ocpi.cpo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证控制器。
 * <p>
 * 该控制器用于 EMSP 和 CPO 之间的认证流程。
 * </p>
 */
@RestController
@RequestMapping("/ocpi/{version}/credentials")
public class CredentialsController {

    @Autowired
    private CredentialsService credentialsService;

    /**
     * 接收 EMSP 提供的认证信息，完成互联认证。
     *
     * @param credentialsRequest EMSP 提供的认证信息
     * @return 返回认证成功的认证信息
     */
    @PostMapping
    public CredentialsResponse postCredentials(@RequestBody CredentialsRequest credentialsRequest) {
        return credentialsService.processCredentials(credentialsRequest);
    }
}