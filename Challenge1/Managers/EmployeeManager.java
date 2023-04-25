package Challenge1.Managers;

import Challenge1.Models.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeManager {
  private List<Employee> employees = new ArrayList<>();

  public EmployeeManager() {
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public void sortByName() {
    Comparator<Employee> employeesByName = Comparator.comparing(Employee :: getName);
    employees = employees.stream()
            .sorted(employeesByName)
            .toList();
  }

  public void sortById() {
    Comparator<Employee> employeesById = Comparator.comparingInt(Employee :: getId);
    employees = employees.stream()
            .sorted(employeesById)
            .toList();
  }

  public void addEmployee(String name, int id) {
    Employee newEmployee = new Employee(name, id);
    employees.add(newEmployee);
  }

  public void printData() {
    System.out.printf("%-20s %-10s\n", "Name", "ID");
    System.out.println("---------------------------------------");
    for (Employee employee : employees) {
      System.out.printf("%-20s %-10d\n", employee.getName(), employee.getId());
    }
  }
}
