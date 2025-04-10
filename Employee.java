package vu;
import java.util.Scanner;

public class Employee {
    private String name;
    private String id;
    private int code;

    public Employee() {}

    public void input() {
        Scanner S = new Scanner(System.in);
        System.out.print("Nhap Id: ");
        id = S.next();

        System.out.print("Nhap ten: ");
        name = S.next();

        while (true) {
            System.out.print("Nhap code (1-3): ");
            code = S.nextInt();
            if (code >= 1 && code <= 3) break;
            else System.out.println("Sai! Nhap lai.");
        }
    }

    public void output() {
        System.out.println("Nhan vien chung:");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
    }

    public double getBasicSal() {
        return 0;
    }

    public double getPayment() {
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

