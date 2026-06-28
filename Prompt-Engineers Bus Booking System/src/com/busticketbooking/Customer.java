package com.busticketbooking;

public class Customer {

    private int customerId;
    private String name;
    private String password;
    private int age;
    private String gender;

    public Customer(int customerId, String name, String password, int age, String gender) {
        this.customerId = customerId;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId +
                "\nName: " + name +
                "\nAge: " + age +
                "\nGender: " + gender;
    }
}