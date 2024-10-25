package ru.geekbrains.lesson2.task2;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Employee user = new Employee("Ivan", "sample@m.ru");
        UUID pk = UUID.randomUUID();
        user.setId(pk);

        QueryBilder queryBilder = new QueryBilder();
        String s = queryBilder.buildQuery(user);
        System.out.println(s);

        String selectQuery = queryBilder.buildSelectQuery(Employee.class, pk);
        System.out.println(selectQuery);


    }
}
