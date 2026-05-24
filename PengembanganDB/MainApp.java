package PengembanganDB;

import java.util.Scanner;

public class MainApp {

    public static void clearScreen() {

        try {

            if (System.getProperty("os.name").contains("Windows")) {

                new ProcessBuilder(
                        "cmd",
                        "/c",
                        "cls"
                ).inheritIO().start().waitFor();

            } else {

                System.out.print("\033[H\033[2J");
                System.out.flush();

            }

        } catch (Exception e) {

            for (int i = 0; i < 20; i++) {
                System.out.println();
            }

        }

    }

    public static boolean cancel(String input) {
        return input.equalsIgnoreCase("esc");
    }

    public static void tampilMenu() {

        System.out.println();

        System.out.println("=====================");
        System.out.println(" MENU DATA MAHASISWA ");
        System.out.println("=====================");

        System.out.println();
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Print");
        System.out.println("0. Exit");

        System.out.println();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DatabaseManager db =
                new DatabaseManager();

        db.connect();

        int menu;

        do {

            clearScreen();

            db.printData();

            tampilMenu();

            System.out.print("Pilih menu : ");

            String input =
                    sc.nextLine();

            try {

                menu =
                        Integer.parseInt(input);

            }

            catch (Exception e) {

                menu = -1;

            }

            switch (menu) {

                case 1:

                    System.out.println();
                    System.out.println("--- INSERT ---");
                    System.out.println("(ketik 'esc' untuk batal)");
                    System.out.println();

                    System.out.print("NIM : ");

                    String nim =
                            sc.nextLine();

                    if (cancel(nim))
                        break;

                    System.out.print("Nama : ");

                    String nama =
                            sc.nextLine();

                    if (cancel(nama))
                        break;

                    System.out.print("Asal : ");

                    String asal =
                            sc.nextLine();

                    if (cancel(asal))
                        break;

                    System.out.print("Kelas : ");

                    String kelas =
                            sc.nextLine();

                    if (cancel(kelas))
                        break;

                    db.insertData(
                            nim,
                            nama,
                            asal,
                            kelas
                    );

                    System.out.println();
                    System.out.println("Data berhasil ditambahkan");

                    break;

                case 2:

                    System.out.println();
                    System.out.println("--- UPDATE ---");
                    System.out.println("(ketik 'esc' untuk batal)");
                    System.out.println();

                    System.out.print("NIM : ");

                    nim =
                            sc.nextLine();

                    if (cancel(nim))
                        break;

                    System.out.print("Nama Baru : ");

                    nama =
                            sc.nextLine();

                    if (cancel(nama))
                        break;

                    System.out.print("Asal Baru : ");

                    asal =
                            sc.nextLine();

                    if (cancel(asal))
                        break;

                    System.out.print("Kelas Baru : ");

                    kelas =
                            sc.nextLine();

                    if (cancel(kelas))
                        break;

                    db.updateData(
                            nim,
                            nama,
                            asal,
                            kelas
                    );

                    System.out.println();
                    System.out.println("Data berhasil diupdate");

                    break;

                case 3:

                    System.out.println();
                    System.out.println("--- DELETE ---");
                    System.out.println("(ketik 'esc' untuk batal)");
                    System.out.println();

                    System.out.print("NIM : ");

                    nim =
                            sc.nextLine();

                    if (cancel(nim))
                        break;

                    db.deleteData(nim);

                    System.out.println();
                    System.out.println("Data berhasil dihapus");

                    break;

                case 4:

                    clearScreen();

                    db.printData();

                    System.out.println();
                    System.out.println("Tekan ENTER...");

                    sc.nextLine();

                    break;

                case 0:

                    System.out.println();
                    System.out.println("Program selesai");

                    break;

                default:

                    System.out.println();
                    System.out.println("Menu tidak tersedia");

                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                break;

            }

           }

        while (menu != 0);

        sc.close();

    }

}