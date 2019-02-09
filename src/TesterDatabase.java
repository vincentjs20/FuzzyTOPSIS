
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
        String select_bobot = "select bobot from bobotkriteria";
        String select_kriteria = "select nama_kriteria from kriteria";

        //get toko
        ArrayList<String> namaToko = new ArrayList<String>();
        try {
            stmt = conn.prepareStatement(select_toko);
            ResultSet resultSet = stmt.executeQuery(select_toko);
            while (resultSet.next()) {
                String columnValue = resultSet.getString("nama_toko");
                namaToko.add(columnValue);
                //System.out.println(columnValue);
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
        String[] tokoArr = new String[banyakToko];
        for (int i = 0; i < banyakToko; i++) {
            tokoArr[i] = namaToko.get(i);
            //System.out.println(tokoArr[i]);
        }
        //buat kelas TokoOnline
        TokoOnline[] toko = new TokoOnline[banyakToko];

        //get kriteria
        ArrayList<String> listKriteria = new ArrayList<String>();
        try {
            stmt = conn.prepareStatement(select_kriteria);
            ResultSet resultSet = stmt.executeQuery(select_kriteria);
            while (resultSet.next()) {
                String columnValue = resultSet.getString("nama_kriteria");
                listKriteria.add(columnValue);
                //System.out.println(columnValue);
            }

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        //pindahin arraylist ke array
        int banyakKriteria = listKriteria.size();
        //System.out.println(banyakToko);
        String[] kriteriaArr = new String[banyakKriteria];
        for (int i = 0; i < banyakKriteria; i++) {
            kriteriaArr[i] = listKriteria.get(i);
            //System.out.println(tokoArr[i]);
        }

        //get bobot
        ArrayList<String> listBobot = new ArrayList<String>();
        try {
            stmt = conn.prepareStatement(select_bobot);
            ResultSet resultSet = stmt.executeQuery(select_bobot);
            while (resultSet.next()) {
                String columnValue = resultSet.getString("bobot");
                listBobot.add(columnValue);
                //System.out.println(columnValue);
            }

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        //pindahin arraylist ke array
        int banyakBobot = listBobot.size();
        //System.out.println(banyakToko);
        String[] bobotArr = new String[banyakBobot];
        for (int i = 0; i < banyakBobot; i++) {
            bobotArr[i] = listBobot.get(i);
            //System.out.println(bobotArr[i]);
        }
        
        Kriteria kriteria = new Kriteria();
        kriteria.setNamaKriteria(kriteriaArr); 
        kriteria.setBobotKriteria(kriteria.linguistikBobotToFuzzy(bobotArr));
        //get kriteria masing2 toko online
        for (int i = 0; i < banyakToko; i++) {
            String[] kriteriaLing = new String[10];
            String select_nilai_kriteria = "select * FROM toko_online "
                    + "JOIN nilaikriteria ON toko_online.id_toko = "
                    + "nilaikriteria.id_toko WHERE "
                    + "toko_online.nama_toko='" + tokoArr[i] + "'";
            int countKriteria = 0;
            try {
                stmt = conn.prepareStatement(select_nilai_kriteria);
                ResultSet resultSet = stmt.executeQuery(select_nilai_kriteria);
                while (resultSet.next()) {
                    String columnValue = resultSet.getString("nilai");
                    kriteriaLing[countKriteria] = columnValue;
                    countKriteria++;
                    //System.out.println(countKriteria+columnValue);
                }

                // Now do something with the ResultSet ....
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            Kriteria dataKriteria = new Kriteria();
            dataKriteria.setNamaKriteria(kriteriaArr);
            dataKriteria.setBobotKriteria(dataKriteria.linguistikBobotToFuzzy(bobotArr));
            dataKriteria.setNilaiKriteria(dataKriteria.linguistikNilaiToFuzzy(kriteriaLing));
            toko[i] = new TokoOnline(tokoArr[i], dataKriteria);
        }

        //print toko
        for (int i = 0; i < banyakToko; i++) {
            System.out.println("Toko ke " + (i + 1) + " : " + tokoArr[i]);
        }

        //print bobot
        System.out.println("==================================================");
        for (int i = 0; i < banyakBobot; i++) {
            System.out.print("Bobot untuk kriteria " + toko[0].getDataKriteria().getNamaKriteria()[i] + " : ");
            double bilA = toko[0].getDataKriteria().getBobotKriteria()[i].getBilA();
            double bilB = toko[0].getDataKriteria().getBobotKriteria()[i].getBilB();
            double bilC = toko[0].getDataKriteria().getBobotKriteria()[i].getBilC();
            if (bilA == 1 && bilB == 1 && bilC == 3) {
                System.out.println("Sangat tidak penting");
            } else if (bilA == 1 && bilB == 3 && bilC == 5) {
                System.out.println("Tidak penting");
            } else if (bilA == 3 && bilB == 5 && bilC == 7) {
                System.out.println("Normal");
            } else if (bilA == 5 && bilB == 7 && bilC == 9) {
                System.out.println("Penting");
            } else {
                System.out.println("Sangat penting");
            }
            //System.out.println(bobotKriteria.getBobotKriteria()[i].getBilA() + ", " + bobotKriteria.getBobotKriteria()[i].getBilB() + ", " + bobotKriteria.getBobotKriteria()[i].getBilC());
        }
        System.out.println("==================================================");

        //data tiap toko
        System.out.println("==================================================");
        for (int i = 0; i < banyakToko; i++) {
            System.out.println((i + 1) + ". Data " + toko[i].getNamaToko() + " :");
            for (int j = 0; j < banyakKriteria; j++) {
                System.out.print("Nilai untuk kriteria " + toko[i].getDataKriteria().getNamaKriteria()[j] + " : ");
//                int bilA = dataKriteria[i].getNilaiKriteria()[j].getBilA();
//                int bilB = dataKriteria[i].getNilaiKriteria()[j].getBilB();
//                int bilC = dataKriteria[i].getNilaiKriteria()[j].getBilC();
                double bilA = toko[i].getDataKriteria().getNilaiKriteria()[j].getBilA();
                double bilB = toko[i].getDataKriteria().getNilaiKriteria()[j].getBilB();
                double bilC = toko[i].getDataKriteria().getNilaiKriteria()[j].getBilC();
                if (bilA == 1 && bilB == 1 && bilC == 3) {
                    System.out.println("Sangat buruk");
                } else if (bilA == 1 && bilB == 3 && bilC == 5) {
                    System.out.println("Buruk");
                } else if (bilA == 3 && bilB == 5 && bilC == 7) {
                    System.out.println("Normal");
                } else if (bilA == 5 && bilB == 7 && bilC == 9) {
                    System.out.println("Baik");
                } else {
                    System.out.println("Sangat baik");
                }
            }
        }
        
        //simulasi FUZZY TOPSIS
        FuzzyTOPSIS coba = new FuzzyTOPSIS(toko, kriteria);
        coba.tampilkanData();
        coba.langkah1();
        TokoOnline[] hasil2 = coba.langkah2();
        System.out.println("-------------------Langkah 2------------------------");
        coba.tampilkanFuzzyNumber(hasil2);
        TokoOnline[] hasil3 = coba.langkah3();
        System.out.println("-------------------Langkah 3------------------------");
        coba.tampilkanFuzzyNumber(hasil3);
        Kriteria langkah4 = coba.langkah4();
        System.out.println("-------------------Langkah 4------------------------");
        coba.tampilkanFnisFpis(langkah4);
        TokoOnline[] hasil5 = coba.langkah5();
        System.out.println("-------------------Langkah 5------------------------");
        coba.tampilkanJarakFnisFpis(hasil5);
        TokoOnline [] hasil6 = coba.langkah6();
        TokoOnline [] hasil7 = coba.langkah7();
        System.out.println("-------------------Langkah 6 & 7------------------------");
        coba.tampilkanHasilAkhir(hasil7);
    }
}
