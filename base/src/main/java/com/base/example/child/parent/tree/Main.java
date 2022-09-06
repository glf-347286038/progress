package com.base.example.child.parent.tree;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author golf
 * @date 2022/8/23 14:15
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        Institution institution1 = new Institution(1, "机构1", 1, 0);
        Institution institution2 = new Institution(2, "机构2", 1, 0);
        Institution institution3 = new Institution(3, "机构3", 1, 0);

        Institution institution4 = new Institution(4, "机构3-1", 2, 3);
        Institution institution5 = new Institution(5, "机构3-1-1", 3, 4);
        Institution institution6 = new Institution(6, "机构3-1-2", 3, 4);

        Institution institution7 = new Institution(7, "机构1-1", 2, 1);

        List<Institution> institutionList = new ArrayList<>(10);
        institutionList.add(institution1);
        institutionList.add(institution2);
        institutionList.add(institution3);
        institutionList.add(institution4);
        institutionList.add(institution5);
        institutionList.add(institution6);
        institutionList.add(institution7);
        log.info("mock数据库查询出来的原始list:{}", JSON.toJSONString(institutionList));

        Map<Integer, Institution> groupMap = institutionList.stream().collect(Collectors.toMap(Institution::getId, Function.identity()));
        Set<Integer> hasParentIdSet = new HashSet<>();
        for (Map.Entry<Integer, Institution> institutionEntry : groupMap.entrySet()) {
            Institution mapValue = institutionEntry.getValue();
            // 查询机构的父机构
            Institution parentInstitution = groupMap.get(mapValue.getParentId());
            if (parentInstitution != null) {
                parentInstitution.addChild(mapValue);
                hasParentIdSet.add(mapValue.getId());
            }
        }
        for (Integer id : hasParentIdSet) {
            groupMap.remove(id);
        }
        log.info("树结构:{}", JSON.toJSON(groupMap).toString());
    }
}
