package JavaOOP.SemesterProject;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("Enter 1 for admin menu \nEnter 2 for customer menu \nEnter 3 for employee menu: ");
        int choice = input.nextInt();
        if (choice == 1) {
            if (admin.validation()) {
                int opt;
                System.out.println("Enter 1 to search user record \nEnter 2 to edit user record");
                System.out.println("Enter 3 to delete user record \nEnter 4 to add new user");
                System.out.println("Enter 5 to calculate customer bill: ");
                opt = input.nextInt();
                switch(opt) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Enter 1 for customer \nEnter 2 for employee: ");
                        int oopt = input.nextInt();
                        if (oopt == 1) {
                            ArrayList<Customer> list = readCustomerFile();
                            System.out.print("Enter customer ID to search: ");
                            String uID = input.nextLine();
                            int index = admin.searchCustomer(uID, list);
                            System.out.print(list.get(index).toString());
                        }
                        else {
                            ArrayList<Employee> list = readEmpFile();
                            System.out.print("Enter employee ID to search: ");
                            String uID = input.nextLine();
                            int index = admin.searchEmp(uID, list);
                            System.out.print(list.get(index).toString());
                        }
                        break;
                    case 2:
                        System.out.println("Enter 1 for customer \nEnter 2 for employee: ");
                        int Opt = input.nextInt();
                        if (Opt == 1) {
                            ArrayList<Customer> list = readCustomerFile();
                            System.out.print("Enter customer ID to edit: ");
                            String uID = input.nextLine();
                            int index = admin.searchCustomer(uID, list);
                            Customer c = new Customer();
                            c.readData();
                            list.set(index, c);
                            admin.writeFileCustomer(list);
                        }
                        else {
                            ArrayList<Employee> list = readEmpFile();
                            System.out.print("Enter employee ID to edit: ");
                            String uID = input.nextLine();
                            int index = admin.searchEmp(uID, list);
                            Employee e = new Employee();
                            e.readData();
                            list.set(index, e);
                            admin.writeFileEmployee(list);
                        }
                        break;
                    case 3:
                        System.out.println("Enter 1 for customer \nEnter 2 for employee: ");
                        int opti = input.nextInt();
                        if (opti == 1) {
                            ArrayList<Customer> list = readCustomerFile();
                            System.out.print("Enter customer ID to del: ");
                            String uID = input.nextLine();
                            admin.delCustomer(uID, list);
                        }
                        else {
                            ArrayList<Employee> list = readEmpFile();
                            System.out.print("Enter employee ID to del: ");
                            String uID = input.nextLine();
                            admin.delEmployee(uID, list);
                        }
                        break;
                    case 4:
                        System.out.println("Enter 1 for customer \nEnter 2 for employee: ");
                        int optio = input.nextInt();
                        if (optio == 1) {
                            Customer c1 = new Customer();
                            c1.readData();
                            admin.writeToFile(c1);
                        }
                        else {
                            Employee e1 = new Employee();
                            e1.readData();
                            admin.writeToFile(e1);
                        }
                        break;
                }

            }
            else System.out.println("Invalid ID or password!");
        }
        else if (choice == 2) {
            System.out.println("Enter 1 to view your profile \nEnter 2 to pay your bill: ");
            int option = input.nextInt();
            Customer c1 = new Customer();
            if (option == 1) {
                c1.customerProfile();
            }
            else {

            }
        }
        else if (choice == 3) {
            Employee em = new Employee();
            System.out.println("Enter 1 to view your profile \nEnter 2 to insert customer units: ");
            int option = input.nextInt();
            if (option == 1) {
                em.EmpProfile();
            }
        }
    }
    //storing objects in arraylist from file
    public static ArrayList<Customer> readCustomerFile() {
        ArrayList<Customer> list = new ArrayList<>();
        String path = "D:\\Visual Studio\\Java\\JavaOOP\\SemesterProject\\Customer.dat";
        try {
            File file = new File(path);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                list.add((Customer)in.readObject());
            }
        }
        catch (EOFException e) {
            System.out.println("File read!");
            e.toString();
        }
        catch (Exception e) {
            System.out.println("Exception caught");
            e.toString();
        }
        return list;
    }

    public static ArrayList<Employee> readEmpFile() {
        ArrayList<Employee> list = new ArrayList<>();
        String path = "D:\\Visual Studio\\Java\\JavaOOP\\SemesterProject\\Employee.dat";
        try {
            File file = new File(path);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                list.add((Employee)in.readObject());
            }
        }
        catch (EOFException e) {
            System.out.println("File read!");
            e.toString();
        }
        catch (Exception e) {
            System.out.println("Exception caught");
            e.toString();
        }
        return list;
    }
}
