package com.example.zeeshan.firebaseopterations_v1;

public class Student {

    private String id;
    private String roll_number;
    private String name;

    public Student(String id, String roll_number, String name) {
        this.id = id;
        this.roll_number = roll_number;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
