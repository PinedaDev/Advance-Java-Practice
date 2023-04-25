package Challenge1;

import Challenge1.Managers.EmployeeManager;
import Challenge1.services.Reader;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    EmployeeManager employees = new EmployeeManager();
    Scanner scanner = new Scanner(System.in);
    Reader file = new Reader("Challenge1/employees.csv");
    file.readFile();
    // Add the details of employees to the manager from the CSV file
    List<String[]> fileLines = file.getLines();
    for (String[] fileLine : fileLines) {
      employees.addEmployee(fileLine[0], Integer.parseInt(fileLine[1]));
    }
    System.out.println("Welcome Admin what would you like to do?:");
    System.out.println("""
       Actions:\s
       1 - Show employees data\s
       2 - Sort by Name\s
       3 - Sort by Id \s
       4 - Exit""");
    while (true) {
      int action = scanner.nextInt();
      if (action == 4) {
        System.out.println("See you soon :D");
        break;}

      switch (action) {
        case 1 -> employees.printData();
        case 2 -> {
          employees.sortByName();
          employees.printData();
        }
        case 3 -> {
          employees.sortById();
          employees.printData();
        }
        default -> System.out.println("Wrong input try with numbers");
      }
    }

  }
}
