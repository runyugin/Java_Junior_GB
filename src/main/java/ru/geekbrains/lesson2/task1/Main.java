package ru.geekbrains.lesson2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Test test = new Test("Name", 45);
        hack(test);


    }

    private static <T> void hack(T obj) throws IllegalAccessException {
        Class<?> testClass = obj.getClass();

        Field[] fields = testClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(obj).equals("Name")) {
                fields[0].set(obj, "Имя");
            }
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
    }


}
