package ru.lachesis.lesson5;

public class LessonFive {
    public static void main(String[] args) {

        Employee empl1 = new Employee("Иванов Иван Иваныч","Директор","ivanov@comp.com","111-11-11",1000000,45);
        empl1.setEmail("icomp.com");
        empl1.printEmployee();
        Employee empl2 = new Employee("Иванов Сергей Иваныч","Заместитель директора","ivanovS@comp.com","111-11-12",100000,39);
        Employee empl3 = new Employee("Петров Петр Петрович","Консультант","petrov@comp.com","111-11-13",100000,60);
        Employee empl4 = new Employee("Иванова Марья Петровна","Секретарь","ivanovа@comp.com","111-11-14",50000,35);
        Employee empl5 = new Employee("Джоншоев Хайридин Абдувалиевич","Сотрудник","--","111-11-20",10000,42);
        empl5.setPhone("+7(012)345-67-89");

        Employee[] employees = {empl1,empl2,empl3,empl4,empl5};
        for (Employee employee : employees) {
            if (employee.getAge()>40) {
                employee.printEmployee();
                System.out.println("---------------");
            }
        }
    }
}
