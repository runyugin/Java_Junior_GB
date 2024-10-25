package ru.geekbrains.lesson2.hw1;

/*

Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.

*/

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        String string = "Объект String";
        getMetodString(string);

        System.out.println("__________________");

        int intt = 1;
        getMetodString(intt);
    }

    private static <T> void getMetodString(T obj) throws IllegalAccessException {
        Class<?> testClass = obj.getClass();

        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {

            System.out.println(method.getName());
        }


    }

}
