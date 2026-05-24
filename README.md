# Pengembangan Penyimpanan Data Mahasiswa Menggunakan Object Serialization dan SQLite Database

## Deskripsi
Project ini merupakan aplikasi berbasis Java yang digunakan untuk mengelola data mahasiswa.

Pada implementasi awal, data disimpan menggunakan Object Serialization (.ser), kemudian dilakukan pengembangan menggunakan SQLite Database agar proses pengelolaan data menjadi lebih fleksibel dan efisien.

## Fitur
- Insert data mahasiswa
- Update data mahasiswa
- Delete data mahasiswa
- Menampilkan data mahasiswa
- Penyimpanan menggunakan SQLite

## Teknologi
- Java
- SQLite
- JDBC

## Struktur Project

PengembanganDB/
├── MainApp.java
├── DatabaseManager.java
├── Mahasiswa.java
├── mahasiswa.db
└── lib/

## Cara Menjalankan

Compile:

```bash
javac -cp "PengembanganDB/lib/*" PengembanganDB/*.java
