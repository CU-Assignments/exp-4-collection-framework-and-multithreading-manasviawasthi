import java.util.ArrayList;
import java.util.Scanner;

class emp {
    int id;
    String name;
    double salary;

    // Constructor to initialize employee details
    emp(int i, String n, double sa) {
        this.id = i;
        this.name = n;
        this.salary = sa;
    }
}

public class newexp4 {
    public static void main(String[] args) {
        ArrayList<emp> e = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Menu options
        System.out.println("1.Add");
        System.out.println("2.Delete");
        System.out.println("3.Display");
        System.out.println("4.Update");
        System.out.println("5.Exit");
        
        int f = sc.nextInt();
        
        while(f != 5){
            if(f == 1) {
                // Add new employee
                System.out.println("Enter Employee id:");
                int id = sc.nextInt();
                sc.nextLine();  // consume the newline character
                System.out.println("Enter Employee Name:");
                String name = sc.nextLine();
                System.out.println("Enter Employee Salary:");
                double salary = sc.nextDouble();
                
                // Add employee to the list
                e.add(new emp(id, name, salary));
                System.out.println("Employee Added!");
            }
            if(f == 2) {
                // Delete employee by ID
                System.out.println("Enter the Employee ID to delete:");
                int idToDelete = sc.nextInt();
                
                boolean found = false;
                for (emp empObj : e) {
                    if (empObj.id == idToDelete) {
                        e.remove(empObj);
                        System.out.println("Employee with ID " + idToDelete + " deleted.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Employee with ID " + idToDelete + " not found.");
                }
            }
            if(f == 3) {
                // Display all employees
                if (e.isEmpty()) {
                    System.out.println("No employees to display.");
                } else {
                    System.out.println("Employee List:");
                    for (emp empObj : e) {
                        System.out.println("ID: " + empObj.id + ", Name: " + empObj.name + ", Salary: " + empObj.salary);
                    }
                }
            }
            if(f == 4) {
                // Update employee details
                System.out.println("Enter the Employee ID to update:");
                int idToUpdate = sc.nextInt();
                
                boolean found = false;
                for (emp empObj : e) {
                    if (empObj.id == idToUpdate) {
                        found = true;
                        sc.nextLine();  // consume newline character
                        System.out.println("Enter new Name:");
                        empObj.name = sc.nextLine();
                        System.out.println("Enter new Salary:");
                        empObj.salary = sc.nextDouble();
                        System.out.println("Employee updated successfully.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Employee with ID " + idToUpdate + " not found.");
                }
            }
            
            // Ask user for the next action
            System.out.println("Enter your next choice (1.Add, 2.Delete, 3.Display, 4.Update, 5.Exit):");
            f = sc.nextInt();
        }

        sc.close();
        System.out.println("Exiting the system. Goodbye!");
    }
}
