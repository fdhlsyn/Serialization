package PengembanganDB;

import java.sql.*;

public class DatabaseManager {

    String url =
            "jdbc:sqlite:mahasiswa.db";

    public Connection connect() {

        try {

            return DriverManager
                    .getConnection(url);

        }

        catch (SQLException e) {

            System.out.println(
                    e.getMessage()
            );

            return null;

        }

    }

    public void createTable() {

        String sql =
                """
                CREATE TABLE IF NOT EXISTS mahasiswa(
                
                nim TEXT PRIMARY KEY,
                nama TEXT NOT NULL,
                asal TEXT,
                kelas TEXT
                
                )
                """;

        try (

                Connection conn =
                        connect();

                Statement st =
                        conn.createStatement()

        ) {

            st.execute(sql);

        }

        catch (SQLException e) {

            System.out.println(
                    e.getMessage()
            );

        }

    }

    public void insertData(
            String nim,
            String nama,
            String asal,
            String kelas
    ) {

        String sql =
                """
                INSERT INTO mahasiswa
                VALUES(?,?,?,?)
                """;

        try (

                Connection conn =
                        connect();

                PreparedStatement ps =
                        conn.prepareStatement(
                                sql
                        )

        ) {

            ps.setString(
                    1,
                    nim
            );

            ps.setString(
                    2,
                    nama
            );

            ps.setString(
                    3,
                    asal
            );

            ps.setString(
                    4,
                    kelas
            );

            ps.execute();

            System.out.println(
                    "Data ditambahkan"
            );

        }

        catch (SQLException e) {

            System.out.println(
                    e.getMessage()
            );

        }

    }

    public void updateData(
        String nim,
        String nama,
        String asal,
        String kelas
    ) {

    String sql =
        "UPDATE mahasiswa " +
        "SET " +
        "nama = COALESCE(NULLIF(?,''), nama), " +
        "asal = COALESCE(NULLIF(?,''), asal), " +
        "kelas = COALESCE(NULLIF(?,''), kelas) " +
        "WHERE nim=?";

    try (

        Connection conn = connect();

        PreparedStatement pst =
                conn.prepareStatement(sql)

    ) {

        pst.setString(1, nama);
        pst.setString(2, asal);
        pst.setString(3, kelas);
        pst.setString(4, nim);

        int row =
                pst.executeUpdate();

        if (row > 0)
            System.out.println("\nData berhasil diupdate");

        else
            System.out.println("\nNIM tidak ditemukan");

    }

    catch (Exception e) {

        System.out.println(e.getMessage());

     }

        }

    public void deleteData(
        String nim
    ) {

    String sql =
        """
        DELETE FROM mahasiswa
        WHERE nim = ?
        """;

    try (

        Connection conn =
            connect();

        PreparedStatement ps =
            conn.prepareStatement(
                sql
            )

    ) {

        ps.setString(
            1,
            nim.trim()
        );

        int rows =
            ps.executeUpdate();

        if (
            rows > 0
        ) {

            System.out.println(
                "\nData berhasil dihapus\n"
            );

        }

        else {

            System.out.println(
                "\nNIM tidak ditemukan\n"
            );

        }

    }

    catch (
        SQLException e
    ) {

        System.out.println(
            e.getMessage()
        );

    }

}

    public void printData() {

    String sql =
    "SELECT * FROM mahasiswa";

    try (

    Connection conn =
    connect();

    Statement stmt =
    conn.createStatement();

    ResultSet rs =
    stmt.executeQuery(sql)

    ) {

    System.out.println();

    System.out.println(
    "+--------------+----------------------+---------------+----------------------+"
    );

    System.out.printf(
    "| %-12s | %-20s | %-13s | %-20s |\n",
    "NIM",
    "NAMA",
    "ASAL",
    "KELAS"
    );

    System.out.println(
    "+--------------+----------------------+---------------+----------------------+"
    );

    while (rs.next()) {

    System.out.printf(
    "| %-12s | %-20s | %-13s | %-20s |\n",

    rs.getString("nim"),

    rs.getString("nama"),

    rs.getString("asal"),

    rs.getString("kelas")

    );

    }

    System.out.println(
    "+--------------+----------------------+---------------+----------------------+"
    );

    }

    catch (Exception e) {

    System.out.println(
    e.getMessage()
    );

    }

    }

}