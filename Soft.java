package diem;

import java.util.Scanner;

public class Soft {
    private String name;
    private String id;
    private int code;
    private double bonus;

    public Soft() {}

    public void input() {
        Scanner S = new Scanner(System.in);
        System.out.println("SoftWare PM");
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

        System.out.print("Nhap bonus: ");
        bonus = S.nextDouble();
    }

    public void output() {
        System.out.println("SoftWare PM");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
        System.out.println("Bonus: " + bonus);
    }

    public double getBasicSal() {
        switch (code) {
            case 1: return 30000000;
            case 2: return 20000000;
            case 3: return 3200000;
            default: return 0;
        }
    }

    public double getPayment() {
        return getBasicSal() + bonus;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}