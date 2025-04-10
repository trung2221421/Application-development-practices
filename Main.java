package tonghop;

import java.util.*;

class Employee {
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

class Soft {
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

class Programmer {
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

public class Main {
    private List<Object> employees = new ArrayList<>();
    private Scanner S = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("============ MENU ============");
            System.out.println("1. Nhap nhan vien");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Tinh tong luong");
            System.out.println("4. Sap xep theo ten");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon: ");
            int c = S.nextInt();
            System.out.println("______________________");

            switch (c) {
                case 1: inputEmployee(); break;
                case 2: outputEmployees(); break;
                case 3: totalSalary(); break;
                case 4: sortByName(); break;
                case 5: return;
                default: System.out.println("Nhap sai, vui long nhap lai!");
            }
        }
    }

    private void inputEmployee() {
        while (true) {
            System.out.println("1. SoftWare PM");
            System.out.println("2. Programmer");
            System.out.println("3. Quay lai");
            System.out.print("Nhap lua chon: ");
            int choice = S.nextInt();
            S.nextLine();

            if (choice == 1) {
                Soft s = new Soft();
                s.input();
                employees.add(s);
            } else if (choice == 2) {
                Programmer p = new Programmer();
                p.input();
                employees.add(p);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Sai! Nhap lai.");
            }
        }
    }

    private void outputEmployees() {
        for (Object emp : employees) {
            if (emp instanceof Soft) ((Soft) emp).output();
            else if (emp instanceof Programmer) ((Programmer) emp).output();
        }
    }

    private void totalSalary() {
        double sum = 0;
        for (Object emp : employees) {
            if (emp instanceof Soft) sum += ((Soft) emp).getPayment();
            else if (emp instanceof Programmer) sum += ((Programmer) emp).getPayment();
        }
        System.out.println("Tong luong tat ca nhan vien: " + sum);
    }

    private void sortByName() {
        employees.sort((a, b) -> {
            String nameA = (a instanceof Soft) ? ((Soft) a).getName() : ((Programmer) a).getName();
            String nameB = (b instanceof Soft) ? ((Soft) b).getName() : ((Programmer) b).getName();
            return nameA.compareToIgnoreCase(nameB);
        });

        System.out.println("Danh sach sau khi sap xep:");
        outputEmployees();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
