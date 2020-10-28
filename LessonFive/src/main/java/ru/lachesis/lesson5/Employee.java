package ru.lachesis.lesson5;

import java.util.regex.Pattern;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String reg = "\\w+@\\w+\\.\\w+";
        Pattern pattern;
        if (!Pattern.matches(reg, email)) {
            System.out.println("Введите корректный электронный адрес");
            return;
        } else this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String reg = "[0-9()\\-\\+]+";
        Pattern pattern;
        if (!Pattern.matches(reg, phone)) {
            System.out.println("Введите корректный телефон");
        } else this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0)
            System.out.println("Введите корректную сумму");
        else this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age >= 90)
            System.out.println("Введите корректный возраст");
        else this.age = age;
    }

    public void printEmployee() {
        System.out.println(
                "Сотрудник:   " + name +
                        "\nДолжность:   " + position +
                        "\nemail:       " + email +
                        "\nТелефон:     " + phone +
                        "\nОклад:       " + salary +
                        "\nВозраст:     " + age
        );

    }
}
