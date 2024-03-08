package com.dynamic.data.source.module.user.service.impl;


import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dynamic.data.source.config.DynamicDataSourceChangeInterceptor;
import com.dynamic.data.source.module.user.domain.SysUser;
import com.dynamic.data.source.module.user.mapper.SysUserMapper;
import com.dynamic.data.source.module.user.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author golf
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Override
    public SysUser detail(SysUser user) {

        SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, user.getUserName()));

        this.getStarrocks();

        DynamicDataSourceContextHolder.push("tenant_" + DynamicDataSourceChangeInterceptor.TENANT_ID_THREAD_LOCAL.get());
        SysUser sysUser2 = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, user.getUserName()));
        return sysUser;
    }


    private String getStarrocks() {
        // 获取当前线程连接1
        String s1 = DynamicDataSourceContextHolder.peek();
        // 切换为目标连接2
        // 切换为连接1
        DynamicDataSourceContextHolder.push("tenant_" + DynamicDataSourceChangeInterceptor.TENANT_ID_THREAD_LOCAL.get() + "_starrocks");
        return this.baseMapper.getStarrocks();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        boolean r = isPalindrome(l1);
        System.out.println(r);
    }


    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int end = list.size() - 1;
        int start = 0;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}




