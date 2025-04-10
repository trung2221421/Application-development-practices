package duong;

import java.util.Scanner;

public class Programmer {
    private String name;
    private String id;
    private int code;
    private double bonus;
    private int OTMoney;

    public Programmer() {}

    public void input() {
        Scanner S = new Scanner(System.in);
        System.out.println("Programmer");
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
        System.out.print("Nhap OTMoney: ");
        OTMoney = S.nextInt();
    }

    public void output() {
        System.out.println("Programmer");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
        System.out.println("Bonus: " + bonus);
        System.out.println("OTMoney: " + OTMoney);
    }

    public double getBasicSal() {
        switch (code) {
            case 1: return 25000000;
            case 2: return 13000000;
            case 3: return 600000;
            default: return 0;
        }
    }

    public double getPayment() {
        return getBasicSal() + bonus + OTMoney + (getBasicSal() / 24);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}