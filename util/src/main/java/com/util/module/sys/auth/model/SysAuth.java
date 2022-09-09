package com.util.module.sys.auth.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author golf
 * @date 2022/9/9 9:55
 */
@Data
@Builder
public class SysAuth {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 权限名称
     */
    private String authName;
    /**
     * 权限路径
     */
    private String authPath;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}