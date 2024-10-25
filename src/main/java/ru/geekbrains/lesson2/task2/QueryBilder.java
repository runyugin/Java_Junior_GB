package ru.geekbrains.lesson2.task2;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBilder {

    public String buildQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if (clazz.isAnnotationPresent(Table.class)) {
            query.append(clazz.getAnnotation(Table.class).name());
            query.append(" (");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    query.append(field.getAnnotation(Column.class).name()).append(", ");
                }
            }

            if(query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(") VALUES (");

            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    query.append("'").append(field.get(obj)).append("', ");
                }
            }

            if(query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(")");
        }
        else {
            return null;
        }


        return query.toString();
    }

    public String buildSelectQuery(Class<?> clazz, UUID primaryKey) throws IllegalAccessException {

        StringBuilder query = new StringBuilder("SELECT * FROM ");


        if (clazz.isAnnotationPresent(Table.class)) {
            query.append(clazz.getAnnotation(Table.class).name());
            query.append(" WHERE ");
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query.append(field.getAnnotation(Column.class).name()).append(" = ").append(primaryKey);
                    break;
                }
            }
        }

        return  query.toString();
        }
}
