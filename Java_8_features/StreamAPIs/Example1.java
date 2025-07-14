package stream_APIs;
/*
 * Create a program that filters a list of employees based on various conditions using the `Predicate` functional interface.

Requirements:
     - Define an `Employee` class with fields such as `name`, `age`, `salary`, etc.
     - Create a list of `Employee` objects.
     - Use `Predicate<Employee>` to filter employees based on different conditions:
          - Age greater than 30.
          - Salary greater than a certain threshold.
          - Employees with a name that starts with a particular letter.
     - Use `Predicate.and()`, `Predicate.or()`, and `Predicate.negate()` to combine multiple conditions.

Allow users to enter the filter condition dynamically (e.g., through input) and apply it.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee{

    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
}
public class Example1 {

    public static void filterStudents(List<Employee> eList,Predicate<Employee> p1,Predicate<Employee> p2,Predicate<Employee> p3){

        // Filters and print student names based on filtering conditions.
        eList.stream().filter(p1.and(p2).and(p3)).forEach(e-> System.out.println(e.name));
    }

    public static void main(String[] args) {
        
        List<Employee> eList = new ArrayList<Employee>();
        eList.add(new Employee("shyam",31,50000));
        eList.add(new Employee("Ram",32,75000));
        eList.add(new Employee("sam",25,15000));

        Predicate<Employee> p1 = e-> e.age>30;
        Predicate<Employee> p2 = e-> e.salary>40000;
        Predicate<Employee> p3 = e-> e.name.startsWith("s");

        // eList.stream().filter(p1.and(p2).and(p3)).forEach(e-> System.out.println(e.name));
        filterStudents(eList,p1,p2,p3);

        
    }
    
}
