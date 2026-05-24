package Tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SerializationMahasiswa sm = new SerializationMahasiswa();

        ArrayList<Mahasiswa> list =
                sm.loadData("mahasiswa.ser");

        int pilihan;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Print");
            System.out.println("5. Save");
            System.out.println("0. Exit");
            System.out.print("Pilih menu: ");

            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {

                case 1:

                    System.out.print("NIM: ");
                    String nim = sc.nextLine();

                    System.out.print("Nama: ");
                    String nama = sc.nextLine();

                    System.out.print("Asal: ");
                    String asal = sc.nextLine();

                    System.out.print("Kelas Praktikum: ");
                    String kelas = sc.nextLine();

                    list.add(new Mahasiswa(nim, nama, asal, kelas));

                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:

                    System.out.print("Masukkan NIM yang ingin diupdate: ");
                    String updateNim = sc.nextLine();

                    for (Mahasiswa m : list) {

                        if (m.getNim().equals(updateNim)) {

                            System.out.print("Nama baru: ");
                            m.setNama(sc.nextLine());

                            System.out.print("Asal baru: ");
                            m.setAsal(sc.nextLine());

                            System.out.print("Kelas baru: ");
                            m.setKelasPraktikum(sc.nextLine());

                            System.out.println("Data berhasil diupdate!");
                        }
                    }

                    break;

                case 3:

                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    String deleteNim = sc.nextLine();

                    list.removeIf(m -> m.getNim().equals(deleteNim));

                    System.out.println("Data berhasil dihapus!");
                    break;

                case 4:

                    System.out.println("\n===== DATA MAHASISWA =====");

                    for (Mahasiswa m : list) {
                        System.out.println(m);
                    }

                    break;

                case 5:

                    sm.saveData(list, "mahasiswa.ser");
                    break;

                case 0:

                    System.out.println("Program selesai");
                    break;

                default:

                    System.out.println("Pilihan tidak tersedia");
            }

        } while (pilihan != 0);

        sc.close();
    }
}