
import java.sql.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vincent J. Sinatra
 */
public class TesterDatabase {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/Skripsi";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            Statement stmt = (Statement) conn.createStatement();
        } catch (SQLException e) {
            System.err.println(e);
        }
        Statement stmt = null;
        ResultSet rs = null;
        String select_toko = "select * from toko_online";
        String select_bobot = "select * from bobotkriteria";
        //get toko
        ArrayList<String> namaToko = new  ArrayList<String>();
        try {
            stmt = conn.prepareStatement(select_toko);
            ResultSet resultSet = stmt.executeQuery(select_toko);
            while (resultSet.next()) {                
                String columnValue = resultSet.getString("nama_toko");
                namaToko.add(columnValue);
                System.out.println(columnValue);
            }

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        //pindahin arraylist ke array
        int banyakToko = namaToko.size();
        //System.out.println(banyakToko);
        String [] tokoArr = new String[banyakToko];
        for (int i = 0; i < banyakToko; i++) {
            tokoArr[i] = namaToko.get(i);
            //System.out.println(tokoArr[i]);
        }

    }
}
