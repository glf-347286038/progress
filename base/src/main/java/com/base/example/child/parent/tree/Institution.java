package com.base.example.child.parent.tree;

import lombok.Data;

import java.util.List;

/**
 * 机构树实体类
 *
 * @author golf
 * @date 2022/8/23 11:49
 */
@Data
public class Institution {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 子级列表
     */
    private List<Institution> childList;
}
