package com.dynamic.data.source.module.user.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户表
 *
 * @author golf
 */
@Accessors(chain = true)
@TableName(value = "sys_user")
@Data
public class SysUser {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 删除区分
     */
    private Byte delFlag;

    /**
     * 创建者ID
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者ID
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;
}