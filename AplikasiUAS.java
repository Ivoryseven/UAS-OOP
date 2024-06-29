package aplikasiuas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AplikasiUAS {

    public static void main(String[] args) {
        try {
            frmdatacs Fcustomer = new frmdatacs();
            Fcustomer.setResizable(false);
            Fcustomer.setVisible(true);
        } catch (SQLException ex) {
        }
    }

    public static void list_all() throws SQLException {
        Connection cnn = Koneksi.getConnection();
        if (cnn.isClosed()) {
            System.out.println("Koneksi gagal");
        } else {
            String sqlvd = "SELECT nama, layanan, harga FROM customer;";
            PreparedStatement PS = cnn.prepareStatement(sqlvd);
            ResultSet rs = PS.executeQuery();
            while (rs.next()) {
                System.out.println("Nama       :" + rs.getString("nama"));
                System.out.println("Layanan     :" + rs.getString("layanan"));
                System.out.println("Harga       :" + rs.getString("harga"));
            }
            cnn.close();
        }
    }
}
