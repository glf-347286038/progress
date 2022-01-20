package com.design.pattern.factory;

/**
 * @Author: golf
 * @Date: 2022/1/20 23:06
 */
public class FactoryTest {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        animalFactory.getAnimal("Cat").move();
        animalFactory.getAnimal("Dog").move();
        animalFactory.getAnimal("Duck").move();
    }
}
