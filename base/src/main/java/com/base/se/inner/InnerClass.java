package com.base.se.inner;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: golf
 * @Date: 2022/5/8 22:05
 */
@Slf4j
public class InnerClass {
    private final int outClassMemberId = 10;

    public static void main(String[] args) {
        // 匿名内部类
        // 一般是在对接口或抽象类的实现类使用不是很广泛，很通用，只在当前的场景用一下时，就可以这么去使用匿名内部类，而不需要专门去创建实现类了。
        // 可以简化代码
        Interface01 interface01 = new Interface01() {
            @Override
            public String show(int x, String a) {
                return "使用了匿名内部类" + x + a;
            }
        };
        log.info(interface01.show(1, "golf"));

        Interface01 interface012 = (x, a) -> {
            log.info("study");
            return "使用lambda测试匿名内部类" + x + a;
        };
        log.info(interface012.show(2, "golf"));
    }

    public void out() {
        log.info("这个外部被的方法");
        MemberInner memberInner = new MemberInner();
        log.info("开始调用成员内部类的方法");
        memberInner.in();
        log.info("调用成员内部类的私有属性,memberInnerId:{}", memberInner.memberInnerId);
    }

    /**
     * 静态内部类
     */
    static class StaticInnerClass {
        private final Integer id = 2;

        void show() {
            log.info("静态内部类的方法开始执行");
        }
    }

    /**
     * 成员内部类 当某个类除了他的内部类不会被其他类使用时应选择使用成员内部类
     */
    public class MemberInner {
        private final Integer memberInnerId = 2;

        public void in() {
            // 可以使用成员内部类来获取外部类某些私有的属性
            log.info("这是内部类的方法");
        }
    }


    /**
     * 局部内部类写在外部类的某个代码块或者方法块中，如果只在某个方法或块中创建这个类的某些对象，可以使用局部内部类。
     */


}
