package Tugas;

import java.io.*;
import java.util.ArrayList;

public class SerializationMahasiswa {

    public void saveData(ArrayList<Mahasiswa> list, String fileName) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(list);

            System.out.println("Data berhasil disimpan!");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data");
        }
    }

    public ArrayList<Mahasiswa> loadData(String fileName) {

        ArrayList<Mahasiswa> list = null;

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            list = (ArrayList<Mahasiswa>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            list = new ArrayList<>();
        }

        return list;
    }
}