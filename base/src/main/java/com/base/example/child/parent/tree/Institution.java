package com.base.example.child.parent.tree;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 机构树实体类
 *
 * @author golf
 * @date 2022/8/23 11:49
 */
@Data
public class Institution implements Serializable {
    private static final long serialVersionUID = 1072526945862886642L;
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

    public void addChild(Institution child) {
        if (childList == null) {
            childList = new ArrayList<>();
        }
        this.childList.add(child);
    }

    public Institution(Integer id, String name, Integer level, Integer parentId) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.parentId = parentId;
    }
}
