
import java.util.Arrays;

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
    private Kriteria [] dataKriteria;

    public FuzzyTOPSIS(TokoOnline[] listToko, FuzzyNumber [] bobot, Kriteria [] dataKriteria) {
        this.listToko = listToko;
        this.bobot = bobot;
        this.dataKriteria = dataKriteria;
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
    
    public void tampilkanFnisFpis(Kriteria hasil){
        System.out.println("Kriteria | FPIS | FNIS");
        for (int i = 0; i < 10; i++) {
            //int j = 0;
            System.out.print(dataKriteria[0].getNamaKriteria()[i]+" | ");
            System.out.printf("(%.3f, %.3f, %.3f) | (%.3f, %.3f, %.3f)", hasil.getFpis()[i].getBilA()
                   ,hasil.getFpis()[i].getBilB(), hasil.getFpis()[i].getBilC(), hasil.getFnis()[i].getBilA()
                   ,hasil.getFnis()[i].getBilB(), hasil.getFnis()[i].getBilC());
            System.out.println();
        }
        System.out.println("==================================================");
    }
    
    public void tampilkanJarakFnisFpis(TokoOnline [] toko){
        System.out.println("Jarak ke fpis");
        System.out.print("Kriteria \\ Alternatif |");
        for (int i = 0; i < 4; i++) {
            System.out.print(toko[i].getNamaToko() + "|");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            System.out.print(toko[1].getDataKriteria().getNamaKriteria()[i] + "|");
            while (j < 4) {
                System.out.printf("%.3f |", toko[j].getDataKriteria().getJarakFpis()[i]);
                j++;
            }
//            for (j = 0; j < 4; j++) {
//                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA() 
//                        +"," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
//            }
            System.out.println();
        }
        System.out.print("Total jarak |");
        for (int i = 0; i < 4; i++) {
            System.out.printf(" %.3f | ", toko[i].getTotalJarakFpis());
        }
        System.out.println();
        System.out.println("==================================================");
        System.out.println("Jarak ke fnis");
        System.out.print("Kriteria \\ Alternatif |");
        for (int i = 0; i < 4; i++) {
            System.out.print(toko[i].getNamaToko() + "|");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            System.out.print(toko[1].getDataKriteria().getNamaKriteria()[i] + "|");
            while (j < 4) {
                System.out.printf("%.3f |", toko[j].getDataKriteria().getJarakFnis()[i]);
                j++;
            }
//            for (j = 0; j < 4; j++) {
//                System.out.print("(" + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilA() 
//                        +"," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilB() + "," + listToko[j].getDataKriteria().getNilaiKriteria()[i].getBilC() + ") |");
//            }
            System.out.println();
        }
        System.out.print("Total jarak |");
        for (int i = 0; i < 4; i++) {
            System.out.printf(" %.3f |", toko[i].getTotalJarakFnis());
        }
        System.out.println();
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
            System.out.println();
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
        //System.out.println("-------------------Langkah 2------------------------");
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
        //System.out.println("-------------------Langkah 2------------------------");
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
    
    public Kriteria langkah4(){
        TokoOnline [] hasilLangkah3 = this.langkah3();
        double [] bilATemp = new double[4];
        double [] bilBTemp = new double[4];
        double [] bilCTemp = new double[4];
        FuzzyNumber [] fpis = new FuzzyNumber[10];
        FuzzyNumber [] fnis = new FuzzyNumber[10];
        Kriteria hasil = new Kriteria();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                bilATemp[j] = hasilLangkah3[j].getDataKriteria().getNilaiKriteria()[i].getBilA();
                bilBTemp[j] = hasilLangkah3[j].getDataKriteria().getNilaiKriteria()[i].getBilB();
                bilCTemp[j] = hasilLangkah3[j].getDataKriteria().getNilaiKriteria()[i].getBilC();
            }
            Arrays.sort(bilATemp);
            Arrays.sort(bilBTemp);
            Arrays.sort(bilCTemp);
            double minA = bilATemp[0];
            double maxA = bilATemp[bilATemp.length-1];
            double minB = bilBTemp[0];
            double maxB = bilBTemp[bilBTemp.length-1];
            double minC = bilCTemp[0];
            double maxC = bilCTemp[bilCTemp.length-1];
            fpis[i] = new FuzzyNumber(maxA, maxB, maxC);
            fnis[i] = new FuzzyNumber(minA, minB, minC);
        }
        hasil.setFnis(fnis);
        hasil.setFpis(fpis);
        return hasil;
    }
    
    public TokoOnline [] langkah5(){
        TokoOnline [] hasilLangkah3 = this.langkah3();
        Kriteria hasilLangkah4 = this.langkah4();
        TokoOnline [] hasilLangkah5 = new TokoOnline[4];
        Kriteria [] jarakFpisFnis = new Kriteria[4];
        for (int i = 0; i < jarakFpisFnis.length; i++) {
            hasilLangkah5[i] = new TokoOnline();
            hasilLangkah5[i].setNamaToko(listToko[i].getNamaToko());
            jarakFpisFnis[i] = new Kriteria();
            jarakFpisFnis[i].setNamaKriteria(listToko[i].getDataKriteria().getNamaKriteria());
            jarakFpisFnis[i].setBobotKriteria(bobot);
        }
        
        for (int i = 0; i < 4; i++) {
            double [] jarakFpis = new double [10];
            double [] jarakFnis = new double [10];
            for (int j = 0; j < 10; j++) {
                double an = hasilLangkah4.getFnis()[j].getBilA();
                double bn = hasilLangkah4.getFnis()[j].getBilB();
                double cn = hasilLangkah4.getFnis()[j].getBilC();
                double ap = hasilLangkah4.getFpis()[j].getBilA();
                double bp = hasilLangkah4.getFpis()[j].getBilB();
                double cp = hasilLangkah4.getFpis()[j].getBilC();
                double bilA = hasilLangkah3[i].getDataKriteria().getNilaiKriteria()[j].getBilA()  ;
                double bilB = hasilLangkah3[i].getDataKriteria().getNilaiKriteria()[j].getBilB() ;
                double bilC = hasilLangkah3[i].getDataKriteria().getNilaiKriteria()[j].getBilC() ;
                double hasilFpis = Math.sqrt((Math.pow((bilA-ap), 2)+ (Math.pow((bilB-bp), 2))+(Math.pow((bilC-cp), 2)))/3.0);;
                double hasilFnis = Math.sqrt((Math.pow((bilA-an), 2)+ (Math.pow((bilB-bn), 2))+(Math.pow((bilC-cn), 2)))/3.0);;
                //normalisasiBobot[j] = new FuzzyNumber(bilA, bilB, bilC); 
                jarakFpis[j] = hasilFpis;
                jarakFnis[j] = hasilFnis;
                jarakFpisFnis[i].setJarakFnis(jarakFnis);
                jarakFpisFnis[i].setJarakFpis(jarakFpis);
                hasilLangkah5[i].setDataKriteria(jarakFpisFnis[i]);
            }
            double totalJarakFpis = 0;
            double totalJarakFnis = 0;

            for (int j = 0; j < 10; j++) {
                totalJarakFpis += hasilLangkah5[i].getDataKriteria().getJarakFpis()[j];
                totalJarakFnis += hasilLangkah5[i].getDataKriteria().getJarakFnis()[j];
                hasilLangkah5[i].setTotalJarakFpis(totalJarakFpis);
                hasilLangkah5[i].setTotalJarakFnis(totalJarakFnis);
            }
        }
        this.hasilSekarang = hasilLangkah5;
        return hasilSekarang;
    }    
    
    public TokoOnline [] langkah6(){
        TokoOnline [] hasilLangkah5 = this.langkah5();
        double [] hasilKedekatanRelatif = new double [4];
        for (int i = 0; i < 4; i++) {
            hasilKedekatanRelatif[i] = hasilLangkah5[i].getTotalJarakFnis() / 
                    (hasilLangkah5[i].getTotalJarakFnis() + hasilLangkah5[i].getTotalJarakFpis());
            hasilSekarang[i].setKedekatanRelatif(hasilKedekatanRelatif[i]);
        }
        return hasilSekarang;
    }
    
    public TokoOnline [] langkah7(){
        TokoOnline [] hasil = hasilSekarang;
        double [] nilai = new double [4];
        for (int i = 0; i < 4; i++) {
            nilai[i] = hasil[i].getKedekatanRelatif();
        }
        Arrays.sort(nilai);
        int j = 1;
        for (int i = 3; i >= 0; i--) {
            int indexKe = Arrays.binarySearch(nilai, nilai[i]);
            hasil[indexKe].setRanking(j);
            j++;
        }
        return hasil;
    }
    
    public void tampilkanHasilAkhir(TokoOnline [] hasil){
        System.out.println("Alternatif | dj+ | dj- | CCi | rank");
        for (int i = 0; i < 4; i++) {
            System.out.print(hasil[i].getNamaToko()+ " | ");
            System.out.printf("%.3f | %.3f | %.3f | ", hasil[i].getTotalJarakFpis(), 
                    hasil[i].getTotalJarakFnis(), hasil[i].getKedekatanRelatif());
            System.out.println(hasil[i].getRanking());
        }
    }
}
