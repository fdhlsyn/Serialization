package Tugas;

import java.io.Serializable;

public class Mahasiswa implements Serializable {

    private String nim;
    private String nama;
    private String asal;
    private String kelasPraktikum;

    public Mahasiswa(String nim, String nama, String asal, String kelasPraktikum) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
        this.kelasPraktikum = kelasPraktikum;
    }

    public String getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public void setKelasPraktikum(String kelasPraktikum) {
        this.kelasPraktikum = kelasPraktikum;
    }

    @Override
    public String toString() {
        return "NIM: " + nim +
                ", Nama: " + nama +
                ", Asal: " + asal +
                ", Kelas: " + kelasPraktikum;
    }
}