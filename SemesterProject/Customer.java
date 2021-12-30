package JavaOOP.SemesterProject;

import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
public class Customer extends LogIn implements Serializable {
    protected String id;
    protected String password;
    protected String name;
    protected String address;
    protected String cnic;
    protected double age;
    protected int load;
    protected String meterNo;
    protected String connectionType;
    protected int noOfUnits;

    String ID;
    String Password;

    Filing filing = new Filing();

    public Customer() {
        name = null;
        address = null;
        cnic = null;
        age = 0.0;
        meterNo = null;
        connectionType = null;
        noOfUnits = 0;
    }

    public Customer(String name, String add, String cnic, 
    double age, String meterNo, String connection, int noOfUnits) {
        this.name = name;
        this.address = add;
        this.cnic = cnic;
        this.age = age;
        this.meterNo = meterNo;
        this.connectionType = connection;
        this.noOfUnits = noOfUnits;
    }

    public void readData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Set ID: ");
        id = input.nextLine();
        System.out.print("Set password: ");
        password = input.nextLine();
        System.out.print("Enter name: ");
        name = input.nextLine();
        System.out.print("Enter address: ");
        address = input.nextLine();
        System.out.print("Enter cnic: ");
        cnic = input.nextLine();
        System.out.print("Enter age: ");
        age = input.nextDouble();
        meterNo = meterNo();
        System.out.print("Choose a connection \nEnter 1 for residential \nEnter 2 for commercial: ");
        int type = input.nextInt();
        switch(type) {
            case 1:
                connectionType = "Residential";
                break;
            case 2:
                connectionType = "Commercial";
                break;
        }
        System.out.print("Enter load: ");
        load = input.nextInt();
    }

    public boolean validation() {
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter ID: ");
        ID = input.nextLine();
        System.out.print("Enter password: ");
        Password = input.nextLine();
        ArrayList<Customer> list = filing.readCustomerFile();
        for (int i = 0; i < list.size(); i++) {
            String tempID = list.get(i).id;
            String tempPass = list.get(i).password;
            if (ID.equals(tempID) && Password.equals(tempPass)) {
                valid = true;
            }
        }
        return valid;
    }

    public void customerProfile() {
        if (validation()) {
            String path = "D:\\Visual Studio\\Java\\JavaOOP\\SemesterProject\\Customer.dat";
            try {
                File file = new File(path);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                while (true) {
                    Customer c = (Customer)in.readObject();
                    if (c.id.equals(ID)) {
                        System.out.println(c.toString());
                    }
                }
            }
            catch (EOFException e) {
                System.out.println("\nFile read!\n");
            }
            catch (Exception e) {
                System.out.println("\nException caught");
                System.out.print(e.toString());
            }
            showBillRecord();
        }
        else System.out.println("\nInvalid ID or password!\n");
    }

    public void showBillRecord() {
        ArrayList<Record> list = filing.readBillRecord();
        for (int i = 0; i < list.size(); i++) {
            String listID = list.get(i).id;
            if (listID.equals(ID)) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    public void payBill() {
        if (validation()) {
            Scanner input = new Scanner(System.in);
            Payment p = new Payment();
            ArrayList<Record> list = filing.readBillRecord();
            showBillRecord();
            System.out.print("Enter bill month to pay bill: ");
            String billMonth = input.nextLine();
            for (int i = 0; i < list.size(); i++) {
                String rID = list.get(i).id;
                String rMonth = list.get(i).month;
                boolean rPaid = list.get(i).paid;
                if (rID.equals(ID) && rMonth.equals(billMonth) && (!rPaid)) {
                    p.PayMethod();
                    list.get(i).paid = true;
                }
            }
            filing.writeBillRecord(list, false); 
        }
        else System.out.println("\nInvalid ID or password!\n");
    }

    public String toString() {
        return ("\nID" + id + "\nName: " + name + "\nAddress: " + address + "\nCNIC: "  + cnic + "\nAge: " 
        + age + "\nLoad: " + load + "\nMeter No: " + meterNo +
        "\nConnection type: " + connectionType + "\nUnits consumed: " + noOfUnits);
    }

    public String meterNo() {
        String MeterNumber = "";
        Random random = new Random();
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 4;
        for (int i = 1; i < count - 1; i++) {
            int index = random.nextInt(alphabets.length());
            char ch = alphabets.charAt(index);
            MeterNumber += ch;
        }
        MeterNumber = MeterNumber + "-";
        for (int j = 0; j <= count; j++) {
            int num = (int)(Math.random() * 10);
            MeterNumber += num;
        }
        return MeterNumber;
    }
}