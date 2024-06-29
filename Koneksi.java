/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasiuas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Arya Restyandika
 */
public class Koneksi {
    public static Connection getConnection() throws SQLException{
        Connection cnn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bengkel", "root", "");
        } catch (ClassNotFoundException ex) {
            System.out.println("Koneksi ke Database Gagal");
        }
        return cnn;
        
    }
}
