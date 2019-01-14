/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vincent J. Sinatra
 */
public class FuzzyTOPSIS {

    private TokoOnline[] listToko;
    private TokoOnline[] hasilSekarang;
    private FuzzyNumber [] bobot;

    public FuzzyTOPSIS(TokoOnline[] listToko, FuzzyNumber [] bobot) {
        this.listToko = listToko;
        this.bobot = bobot;
    }
    
    public void tampilkanFuzzyNumber(TokoOnline[] toko){
        //System.out.println("==================================================");

        System.out.print("Kriteria \\ Alternatif |");
        for (int i = 0; i < 4; i++) {
            System.out.print(toko[i].getNamaToko() + "|");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            System.out.print(toko[1].getDataKriteria().getNamaKriteria()[i] + "|");
            while (j < 4) {
                System.out.printf("(%.3f, %.3f, %.3f) |", toko[j].getDataKriteria().getNilaiKriteria()[i].getBilA()
                       ,toko[j].getDataKriteria().getNilaiKriteria()[i].getBilB(), 
                       toko[j].getDataKriteria().getNilaiKriteria()[i].getBilC());
                j++;
            }
//            for (j = 0; j < 4; j++) {
//                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA() 
//                        +"," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
//            }
            System.out.println();
        }
        System.out.println("==================================================");
    }
    
    public void tampilkanData(){
        System.out.print("Kriteria \\ Alternatif |");
        for (int i = 0; i < 4; i++) {
            System.out.print(listToko[i].getNamaToko() + "|");
        }
        System.out.println();
        int urutanToko = 0;
        for (int i = 0; i < 10; i++) {
            int j = 0;
            System.out.print(listToko[1].getDataKriteria().getNamaKriteria()[i] + "|");
            while (j < 4) {
                double bilA = listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA();
                double bilB = listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB();
                double bilC = listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC();
                if(bilA == 1 && bilB == 1 && bilC == 3){
                    System.out.print("Sangat buruk |");
                }
                else if(bilA == 1 &&bilB == 3 && bilC == 5 ){
                    System.out.print("Buruk |");
                }
                else if(bilA == 3 && bilB == 5 && bilC == 7 ){
                    System.out.print("Normal |");
                }
                else if(bilA == 5 && bilB == 7 && bilC== 9){
                    System.out.print("Baik |");
                }
                else{
                    System.out.print("Sangat baik |");
                }
//                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA()
//                        + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
                j++;
                urutanToko++;
            }
//            for (j = 0; j < 4; j++) {
//                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA() 
//                        +"," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
//            }
            System.out.println("");
        }
        System.out.println("==================================================");

    }

    public void langkah1() {
        //System.out.println("==================================================");
        System.out.println("-------------------Langkah 1------------------------");
        System.out.print("Kriteria \\ Alternatif |");
        for (int i = 0; i < 4; i++) {
            System.out.print(listToko[i].getNamaToko() + "|");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            System.out.print(listToko[1].getDataKriteria().getNamaKriteria()[i] + "|");
            while (j < 4) {
                System.out.printf("(%.0f, %.0f, %.0f) |", listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA()
                       ,listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB(), 
                       listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC());
                j++;
            }
//            for (j = 0; j < 4; j++) {
//                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA() 
//                        +"," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
//            }
            System.out.println();
        }
        System.out.println("==================================================");

    }
    
    public TokoOnline [] langkah2(){
        System.out.println("-------------------Langkah 2------------------------");
        double cMax = 9;
        TokoOnline [] hasilLangkah2 = new TokoOnline[4];
        Kriteria [] hasilNormalisasi = new Kriteria[4];
        for (int i = 0; i < hasilNormalisasi.length; i++) {
            hasilLangkah2[i] = new TokoOnline();
            hasilLangkah2[i].setNamaToko(listToko[i].getNamaToko());
            hasilNormalisasi[i] = new Kriteria();
            hasilNormalisasi[i].setNamaKriteria(listToko[i].getDataKriteria().getNamaKriteria());
            hasilNormalisasi[i].setBobotKriteria(bobot);
        }
        
        for (int i = 0; i < 4; i++) {
            FuzzyNumber [] normalisasi = new FuzzyNumber[10];
            for (int j = 0; j < 10; j++) {
                double bilA = listToko[i].getDataKriteria().getNilaiKriteria()[j].getBilA() / cMax;
                double bilB = listToko[i].getDataKriteria().getNilaiKriteria()[j].getBilB() / cMax;
                double bilC = listToko[i].getDataKriteria().getNilaiKriteria()[j].getBilC() / cMax;
                normalisasi[j] = new FuzzyNumber(bilA, bilB, bilC); 
                hasilNormalisasi[i].setNilaiKriteria(normalisasi);
                hasilLangkah2[i].setDataKriteria(hasilNormalisasi[i]);
            }            
        }
        this.hasilSekarang = hasilLangkah2;
        return hasilSekarang;
    }
    
    public TokoOnline [] langkah3(){
        System.out.println("-------------------Langkah 2------------------------");
        TokoOnline [] hasilLangkah2 = this.langkah2();
        TokoOnline [] hasilLangkah3 = new TokoOnline[4];
        Kriteria [] hasilNormalisasiBobot = new Kriteria[4];
        
        for (int i = 0; i < hasilNormalisasiBobot.length; i++) {
            hasilLangkah3[i] = new TokoOnline();
            hasilLangkah3[i].setNamaToko(listToko[i].getNamaToko());
            hasilNormalisasiBobot[i] = new Kriteria();
            hasilNormalisasiBobot[i].setNamaKriteria(listToko[i].getDataKriteria().getNamaKriteria());
            hasilNormalisasiBobot[i].setBobotKriteria(bobot);
        }
        
        for (int i = 0; i < 4; i++) {
            FuzzyNumber [] normalisasiBobot = new FuzzyNumber[10];
            for (int j = 0; j < 10; j++) {
                double bobotA = hasilNormalisasiBobot[i].getBobotKriteria()[j].getBilA();
                double bobotB = hasilNormalisasiBobot[i].getBobotKriteria()[j].getBilB();
                double bobotC = hasilNormalisasiBobot[i].getBobotKriteria()[j].getBilC();
                double bilA = hasilLangkah2[i].getDataKriteria().getNilaiKriteria()[j].getBilA() * bobotA ;
                double bilB = hasilLangkah2[i].getDataKriteria().getNilaiKriteria()[j].getBilB() * bobotB;
                double bilC = hasilLangkah2[i].getDataKriteria().getNilaiKriteria()[j].getBilC() * bobotC;
                normalisasiBobot[j] = new FuzzyNumber(bilA, bilB, bilC); 
                hasilNormalisasiBobot[i].setNilaiKriteria(normalisasiBobot);
                hasilLangkah3[i].setDataKriteria(hasilNormalisasiBobot[i]);
            }            
        }        
        this.hasilSekarang = hasilLangkah3;
        return hasilSekarang;
    }
    
//    public TokoOnline [] langkah4(){
//        
//    }
    
    
}
