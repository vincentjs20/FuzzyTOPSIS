
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vincent
 */
public class Tester {

    public static void main(String[] args) {
        String kriteria1 = "Efisiensi pencarian";
        String kriteria2 = "Praktis saat membayar";
        String kriteria3 = "Kemudahan pemakaian aplikasi";
        String kriteria4 = "Keyakinan pelanggan";
        String kriteria5 = "Keamanan transaksi";
        String kriteria6 = "Kepercayaan pelanggan";
        String kriteria7 = "Layanan customer service";
        String kriteria8 = "User Experience";
        String kriteria9 = "Kelengkapan produk";
        String kriteria10 = "Promo yang ditawarkan";
        FuzzyNumber efisiensi = new FuzzyNumber(3, 5, 7);
        FuzzyNumber praktis = new FuzzyNumber(1, 3, 5);
        FuzzyNumber kemudahan = new FuzzyNumber(5, 7, 9);
        FuzzyNumber keyakinan = new FuzzyNumber(3, 5, 7);
        FuzzyNumber keamanan = new FuzzyNumber(7, 9, 9);
        FuzzyNumber kepercayaan = new FuzzyNumber(3, 5, 7);
        FuzzyNumber layanan = new FuzzyNumber(1, 3, 5);
        FuzzyNumber ux = new FuzzyNumber(5, 7, 9);
        FuzzyNumber kelengkapan = new FuzzyNumber(1, 1, 3);
        FuzzyNumber promo = new FuzzyNumber(3, 5, 7);
        Kriteria bobotKriteria = new Kriteria();
        TokoOnline[] listToko = new TokoOnline[4];
        String [] kriteriaInput = new String[10];
        kriteriaInput [0] = kriteria1;
        kriteriaInput [1] = kriteria2;
        kriteriaInput [2] = kriteria3;
        kriteriaInput [3] = kriteria4;
        kriteriaInput [4] = kriteria5;
        kriteriaInput [5] = kriteria6;
        kriteriaInput [6] = kriteria7;
        kriteriaInput [7] = kriteria8;
        kriteriaInput [8] = kriteria9;
        kriteriaInput [9] = kriteria10;
        FuzzyNumber[] bobot = new FuzzyNumber[10];
        bobot[0] = new FuzzyNumber(3, 5, 7);
        bobot[1] = new FuzzyNumber(1, 3, 5);
        bobot[2] = new FuzzyNumber(5, 7, 9);
        bobot[3] = new FuzzyNumber(3, 5, 7);
        bobot[4] = new FuzzyNumber(7, 9, 9);
        bobot[5] = new FuzzyNumber(3, 5, 7);
        bobot[6] = new FuzzyNumber(1, 3, 5);
        bobot[7] = new FuzzyNumber(5, 7, 9);
        bobot[8] = new FuzzyNumber(1, 1, 3);
        bobot[9] = new FuzzyNumber(3, 5, 7);
        bobotKriteria.setNamaKriteria(kriteriaInput);
        bobotKriteria.setBobotKriteria(bobot);
        //listToko[1] = new TokoOnline();
        Scanner sc = new Scanner(System.in);
        System.out.println("Selamat datang, silahkan masukkan nama keempat toko online :");
        for (int i = 0; i < 4; i++) {
            System.out.print("nama toko ke-" + (i + 1) + ": ");
            listToko[i] = new TokoOnline();
            listToko[i].setNamaToko(sc.next());
        }
        
/* untuk input bobot secara manual
        System.out.println("Selanjutnya, silahkan masukkan data kriteria : ");
        System.out.println("Keterangan bobot kriteria (masukan angka dengan ketentuan sebagai berikut: "
                + "\n" + "1. Sangat buruk" + "\n" + "2. Buruk" + "\n" + "3. Normal" + "\n" + "4. Baik" + "\n" + "5. Sangat baik");
        for (int i = 0; i < 10; i++) {
            System.out.println("kriteria ke-" + (i + 1) + ": ");
            System.out.print("nama kriteria : ");
            kriteriaInput[i] = sc.next();
            System.out.println("bobot kriteria : ");
            int bobotMasuk = sc.nextInt();
            if (bobotMasuk == 1) {
                bobot[i] = new FuzzyNumber(1,1,3);
            } 
            else if (bobotMasuk == 2) {
                bobot[i] = new FuzzyNumber(1,3,5);
            } 
            else if (bobotMasuk == 3) {
                bobot[i] = new FuzzyNumber(3,5,7);
            } 
            else if (bobotMasuk == 4) {
                bobot[i] = new FuzzyNumber(5,7,9);
            } 
            else {
                bobot[i] = new FuzzyNumber(7,9,9);
            }
//            System.out.print("(a)= ");
//            bobot[i].setA(sc.nextInt());
//            System.out.print("(b)= ");
//            bobot[i].setB(sc.nextInt());
//            System.out.print("(c)= ");
//            bobot[i].setC(sc.nextInt());            
        }
        kriteria.setNamaKriteria(kriteriaInput);
        kriteria.setBobotKriteria(bobot);
*/

        System.out.println("==================================================");
        for (int i = 0; i < kriteriaInput.length; i++) {
            System.out.print("Bobot untuk kriteria " + bobotKriteria.getNamaKriteria()[i] + " : ");
            double bilA = bobotKriteria.getBobotKriteria()[i].getBilA();
            double bilB = bobotKriteria.getBobotKriteria()[i].getBilB();
            double bilC = bobotKriteria.getBobotKriteria()[i].getBilC();
            if(bilA == 1 && bilB == 1 && bilC == 3){
                System.out.println("Sangat tidak penting");
            }
            else if(bilA == 1 &&bilB == 3 && bilC == 5 ){
                System.out.println("Tidak penting");
            }
            else if(bilA == 3 && bilB == 5 && bilC == 7 ){
                System.out.println("Normal");
            }
            else if(bilA == 5 && bilB == 7 && bilC== 9){
                System.out.println("Penting");
            }
            else{
                System.out.println("Sangat penting");
            }
            //System.out.println(bobotKriteria.getBobotKriteria()[i].getBilA() + ", " + bobotKriteria.getBobotKriteria()[i].getBilB() + ", " + bobotKriteria.getBobotKriteria()[i].getBilC());
        }
        System.out.println("==================================================");

        
        //data tiap toko
        
        
        System.out.println("Keterangan nilai kriteria (masukan angka dengan ketentuan sebagai berikut: "
                + "\n" + "1. Sangat buruk" + "\n" + "2. Buruk" + "\n" + "3. Normal" + "\n" + "4. Baik" + "\n" + "5. Sangat baik");
        for (int i = 0; i < listToko.length; i++) {
            FuzzyNumber [] nilai = new FuzzyNumber[10];
            System.out.println("Data "+ listToko[i].getNamaToko() + ": ");
            Kriteria dataKriteria = new Kriteria();
            dataKriteria.setNamaKriteria(kriteriaInput);
            dataKriteria.setBobotKriteria(bobot);
            for (int j = 0; j < kriteriaInput.length; j++) {
                System.out.print("Nilai untuk kriteria " + dataKriteria.getNamaKriteria()[j] + " : ");
                //System.out.println("bobot kriteria : ");
                int nilaiMasuk = sc.nextInt();
                if (nilaiMasuk == 1) {
                    nilai[j] = new FuzzyNumber(1,1,3);
                } 
                else if (nilaiMasuk == 2) {
                    nilai[j] = new FuzzyNumber(1,3,5);
                } 
                else if (nilaiMasuk == 3) {
                    nilai[j] = new FuzzyNumber(3,5,7);
                } 
                else if (nilaiMasuk == 4) {
                    nilai[j] = new FuzzyNumber(5,7,9);
                } 
                else {
                    nilai[j] = new FuzzyNumber(7,9,9);
                }
                //FuzzyNumber bobot = new FuzzyNumber(bilA, bilB, bilC);
                dataKriteria.setNilaiKriteria(nilai);
                listToko[i].setDataKriteria(dataKriteria);
            }
        }
        Kriteria dataKriteria = new Kriteria();
        dataKriteria.setNamaKriteria(kriteriaInput);
        dataKriteria.setBobotKriteria(bobot);
        System.out.println("==================================================");
        for (int i = 0; i < listToko.length; i++) {
            System.out.println((i+1)+ ". Data " + listToko[i].getNamaToko()+ " :");
            for (int j = 0; j < kriteriaInput.length; j++) {
                System.out.print("Nilai untuk kriteria " + dataKriteria.getNamaKriteria()[j] + " : ");
//                int bilA = dataKriteria[i].getNilaiKriteria()[j].getBilA();
//                int bilB = dataKriteria[i].getNilaiKriteria()[j].getBilB();
//                int bilC = dataKriteria[i].getNilaiKriteria()[j].getBilC();
                double bilA = listToko[i].getDataKriteria().getNilaiKriteria()[j].getBilA();
                double bilB = listToko[i].getDataKriteria().getNilaiKriteria()[j].getBilB();
                double bilC = listToko[i].getDataKriteria().getNilaiKriteria()[j].getBilC();
                if(bilA == 1 && bilB == 1 && bilC == 3){
                    System.out.println("Sangat buruk");
                }
                else if(bilA == 1 &&bilB == 3 && bilC == 5 ){
                    System.out.println("Buruk");
                }
                else if(bilA == 3 && bilB == 5 && bilC == 7 ){
                    System.out.println("Normal");
                }
                else if(bilA == 5 && bilB == 7 && bilC== 9){
                    System.out.println("Baik");
                }
                else{
                    System.out.println("Sangat baik");
                }
            }
            
            //System.out.println(bobotKriteria.getBobotKriteria()[i].getBilA() + ", " + bobotKriteria.getBobotKriteria()[i].getBilB() + ", " + bobotKriteria.getBobotKriteria()[i].getBilC());
        }
        System.out.println("==================================================");
        
//        System.out.print("Kriteria \\ Alternatif |");
//        for (int i = 0; i < 4; i++) {
//            System.out.print(listToko[i].getNamaToko() + "|");
//        }
//        System.out.println();
//        int urutanToko = 0; 
//        for (int i = 0; i < 10; i++) {
//            int j = 0;
//            System.out.print(listToko[1].getDataKriteria().getNamaKriteria()[i] + "|");
//            while(j < 4){
//                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA() 
//                        +"," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
//                j++;
//                urutanToko++;
//            }
////            for (j = 0; j < 4; j++) {
////                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA() 
////                        +"," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
////            }
//            System.out.println();
//            //urutanToko++;
//        }
        
        FuzzyTOPSIS coba = new FuzzyTOPSIS(listToko, dataKriteria);
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
