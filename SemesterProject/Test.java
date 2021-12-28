package JavaOOP.SemesterProject;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        Filing filing = new Filing();
        do {
            System.out.print("\nEnter 1 for admin menu \nEnter 2 for customer menu \nEnter 3 for employee menu \nEnter 0 to exit --> ");
            choice = input.nextInt();
            if (choice == 1) {
                if (admin.validation()) {
                    int opt;
                    do {
                        System.out.println("\nEnter 1 to search user record \nEnter 2 to edit user record");
                        System.out.println("Enter 3 to delete user record \nEnter 4 to add new user");
                        System.out.print("Enter 5 to calculate customer bill \nEnter 0 to exit --> ");
                        opt = input.nextInt();
                        switch(opt) {
                            case 0:
                                break;
                            case 1:
                                System.out.print("\nEnter 1 for customer \nEnter 2 for employee: ");
                                int oopt = input.nextInt();
                                if (oopt == 1) {
                                    ArrayList<Customer> list = filing.readCustomerFile();
                                    System.out.print("Enter customer ID to search: ");
                                    String uID = input.next();
                                    int index = admin.searchCustomer(uID, list);
                                    if (index != -1) {
                                        System.out.print(list.get(index));
                                    }
                                    else System.out.println("\nNot found\n");
                                }
                                else {
                                    ArrayList<Employee> list = filing.readEmpFile();
                                    System.out.print("Enter employee ID to search: ");
                                    String uID = input.next();
                                    int index = admin.searchEmp(uID, list);
                                    if (index != -1) {
                                        System.out.print(list.get(index));
                                    }
                                    else System.out.println("\nNot found\n");
                                }
                                break;
                            case 2:
                                System.out.print("\nEnter 1 for customer \nEnter 2 for employee: ");
                                int Opt = input.nextInt();
                                if (Opt == 1) {
                                    ArrayList<Customer> list = filing.readCustomerFile();
                                    System.out.print("Enter customer ID to edit: ");
                                    String uID = input.next();
                                    int index = admin.searchCustomer(uID, list);
                                    Customer c = new Customer();
                                    c.readData();
                                    list.set(index, c);
                                    filing.writeFileCustomer(list);
                                }
                                else {
                                    ArrayList<Employee> list = filing.readEmpFile();
                                    System.out.print("Enter employee ID to edit: ");
                                    String uID = input.next();
                                    int index = admin.searchEmp(uID, list);
                                    Employee e = new Employee();
                                    e.readData();
                                    list.set(index, e);
                                    filing.writeFileEmployee(list);
                                }
                                break;
                            case 3:
                                System.out.print("\nEnter 1 for customer \nEnter 2 for employee: ");
                                int opti = input.nextInt();
                                if (opti == 1) {
                                    ArrayList<Customer> list = filing.readCustomerFile();
                                    System.out.print("Enter customer ID to del: ");
                                    String uID = input.next();
                                    admin.delCustomer(uID, list);
                                }
                                else {
                                    ArrayList<Employee> list = filing.readEmpFile();
                                    System.out.print("Enter employee ID to del: ");
                                    String uID = input.next();
                                    admin.delEmployee(uID, list);
                                }
                                break;
                            case 4:
                                System.out.print("\nEnter 1 for customer \nEnter 2 for employee: ");
                                int optio = input.nextInt();
                                if (optio == 1) {
                                    Customer c1 = new Customer();
                                    c1.readData();
                                    filing.writeToFile(c1);
                                }
                                else {
                                    Employee e1 = new Employee();
                                    e1.readData();
                                    filing.writeToFile(e1);
                                }
                                break;
                            case 5:
                                ArrayList<Customer> list = filing.readCustomerFile();
                                admin.calBill(list);
                        }
                    } while (opt != 0);

                }
                else System.out.println("\nInvalid ID or password!\n");
            }
            else if (choice == 2) {
                System.out.print("\nEnter 1 to view your profile \nEnter 2 to pay your bill: ");
                int option = input.nextInt();
                Customer c1 = new Customer();
                if (option == 1) {
                    c1.customerProfile();
                }
                // else {

                // }
            }
            else if (choice == 3) {
                Employee em = new Employee();
                System.out.print("\nEnter 1 to view your profile \nEnter 2 to insert customer units: ");
                int option = input.nextInt();
                if (option == 1) {
                    em.EmpProfile();
                }
                else {
                    ArrayList<Customer> list = filing.readCustomerFile();
                    em.setNoOfUnits(list);
                }
            }
        } while (choice != 0);
    }
}
