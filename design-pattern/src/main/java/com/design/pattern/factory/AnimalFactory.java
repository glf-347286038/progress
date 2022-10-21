package com.design.pattern.factory;

import lombok.NonNull;

/**
 * @Author: golf
 * @Date: 2022/1/20 22:51
 */
public class AnimalFactory {
    private static final String CAT = "Cat";
    private static final String DOG = "Dog";
    private static final String DUCK = "Duck";

    public Animal getAnimal(@NonNull String type) {
        switch (type) {
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
            case DUCK:
                return new Duck();
            default:
                return null;
        }
    }
}
