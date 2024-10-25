package ru.geekbrains.lesson2.task2;

import java.util.UUID;

@Table(name = "users")
public class Employee {

    @Column(name = "id", primaryKey = true)
    private UUID id;

    @Column(name = "username")
    private String name;

    @Column(name = "email")
    private String email;


    public Employee(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
