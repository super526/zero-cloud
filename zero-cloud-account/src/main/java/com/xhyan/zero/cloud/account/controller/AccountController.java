package com.xhyan.zero.cloud.account.controller;

import com.google.gson.Gson;
import com.xhyan.zero.cloud.account.converter.Converter;
import com.xhyan.zero.cloud.account.converter.annotations.Convert;
import com.xhyan.zero.cloud.account.dto.AccountDTO;
import com.xhyan.zero.cloud.account.model.Account;
import com.xhyan.zero.cloud.account.service.AccountService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 账户的REST服务
 */
@RestController
@Api(value = "/group", description = "账户相关的服务")
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(notes = "create account", httpMethod = "POST", value = "添加账户")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "参数错误")
    })
    public boolean save(@ApiParam(required = true, value = "account data") @RequestBody AccountDTO account) {
        Account acc = Converter.CONVERTER.convert(account, Account.class);
        return accountService.save(acc) > 0;
    }

    @ApiOperation(notes = "test", httpMethod = "GET", value = "测试接口")
    @GetMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public String test() {
        AccountDTO dto = AccountDTO.builder().email("222222").loginName("xhyan").loginPwd("1234").tradePwd("4321").status(1).build();
        Account account = Converter.CONVERTER.convert(dto, Account.class);
        return new Gson().toJson(account);
    }
}
