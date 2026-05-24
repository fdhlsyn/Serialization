package PengembanganDB;

public class Mahasiswa {

    private String nim;
    private String nama;
    private String asal;
    private String kelas;

    public Mahasiswa(
            String nim,
            String nama,
            String asal,
            String kelas
    ) {

        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
        this.kelas = kelas;

    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public String getKelas() {
        return kelas;
    }

}