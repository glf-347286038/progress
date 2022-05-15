package com.base.se.equalsAndHashCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * @Author: golf
 * @Date: 2022/5/10 23:33
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        Person personOne = new Person("golf", 12);
        Person personTwo = new Person("golf", 12);
        log.info("equals:{}", personOne.equals(personTwo));
        HashSet<Person> hashSetOne = new HashSet<>();
        hashSetOne.add(personOne);
        hashSetOne.add(personTwo);
        log.info("hashSetOne:{}", hashSetOne);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
    }
}
