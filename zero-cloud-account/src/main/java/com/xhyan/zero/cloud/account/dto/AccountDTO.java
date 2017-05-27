package com.xhyan.zero.cloud.account.dto;

import com.xhyan.zero.cloud.account.converter.annotations.Convert;
import com.xhyan.zero.cloud.account.converter.annotations.Rule;
import com.xhyan.zero.cloud.account.dto.base.BaseDTO;
import com.xhyan.zero.cloud.account.model.Account;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

/**
 * Account DTO
 *
 * @author xhyan
 */
@ApiModel
@Builder
@Convert(target = Account.class)
public class AccountDTO extends BaseDTO{
    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名", required = true)
    private String loginName;

    /**
     * 登录密码(不可逆加密)
     */
    @Rule(targetField = "tradePwd")
    @ApiModelProperty(value = "登录密码", required = true)
    private String loginPwd;

    /**
     * 交易密码(不可逆加密)
     */
    @Rule(ignore = true)
    @ApiModelProperty(hidden = true)
    private String tradePwd;

    /**
     * 账号绑定邮箱
     */
    @ApiModelProperty(value = "邮箱邮箱", required = true)
    private String email;

    /**
     * 账号绑定备用邮箱
     */
    @Rule(targetField = "emailBackup")
    @ApiModelProperty(value = "备用邮箱")
    private String emailBackup;

    /**
     * 账号绑定手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 账户类型(1个人账户；2企业账户)
     */
    @ApiModelProperty(hidden = true)
    private Integer type;

    /**
     * 账户状态：1正常,2受限,3冻结,4注销
     */
    @ApiModelProperty(hidden = true)
    private Integer status;
}
