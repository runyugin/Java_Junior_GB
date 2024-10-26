package ru.geekbrains.lesson3.hw3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableToFileXmlAndJson {

    public static final String FILE_JSON = "person.json";
    public static final String FILE_XML = "person.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    public static void saveToFile(String fileName, List<Person> personList) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), personList);

                System.out.println("Объект Person в фаил JSON.");
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), personList);
                System.out.println("Объект Person в фаил XML.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static List<Person> loadFromFile(String fileName) {
        List<Person> personList = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    System.out.println("из JSON:");
                    personList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
                }  else if (fileName.endsWith(".xml")) {
                    System.out.println("из XML:");
                    personList = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        personList.stream().forEach(System.out::println);

        return personList;
    }

}
