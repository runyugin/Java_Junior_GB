package ru.geekbrains.lesson3.hw3;

import ru.geekbrains.lesson3.task2.ToDoListApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ru.geekbrains.lesson3.hw3.SerializableToFileXmlAndJson.*;

public class Main {

    public static void main(String[] args)  throws Exception {

        //* создаем объекты и помещаем в лист

        List<Person> list = new ArrayList<>();
        Person person1 = new Person("Ivan", 25);
        Person person2 = new Person("Max", 34);
        list.add(person1);
        list.add(person2);


        //* сириализуем в фаил JSON and XML


        System.out.println("_____________сириализуем в фаил JSON and XML______________");

        saveToFile(FILE_JSON, list);
        saveToFile(FILE_XML, list);


        //* де-сириализуем из фаил JSON and XML


        System.out.println("____________де-сириализуем из фаил JSON and XML_______________");

        loadFromFile(FILE_JSON);
        loadFromFile(FILE_XML);


        System.out.println("_____________сириализуем в фаил______________");

        //* сириализуем в фаил

        try (FileOutputStream fileOutputStream = new FileOutputStream("person");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(person2);

            System.out.println("Объект Person сериализован.");
        }

        System.out.println("___________ДЕ-сириализуем в фаил________________");

        //* ДЕ-сириализуем в фаил

        try (FileInputStream fileInputStream = new FileInputStream("person");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            while (true) {
                Person person = (Person) objectInputStream.readObject();

                System.out.println(person.getName() + ": " + person.getAge());
            }
        } catch (EOFException eof) {
            System.out.println("Достигнут конец файла");
            System.out.println("Объект Person Де-сериализован.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }


        System.out.println("___________________________");


    }
}
