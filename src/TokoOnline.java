/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
public class TokoOnline implements Comparable<TokoOnline> {
    private String namaToko;
    private Kriteria dataKriteria;
    public double totalJarakFpis;
    public double totalJarakFnis;
    public double kedekatanRelatif;
    public int ranking;
    
    public TokoOnline(String namaToko, Kriteria dataKriteria){
        this.namaToko = namaToko;
        this.dataKriteria = dataKriteria;
    }

    public TokoOnline() {
    }

    
    /**
     * @return the namaToko
     */
    public String getNamaToko() {
        return namaToko;
    }

    /**
     * @param namaToko the namaToko to set
     */
    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    /**
     * @return the dataKriteria
     */
    public Kriteria getDataKriteria() {
        return dataKriteria;
    }

    /**
     * @param dataKriteria the dataKriteria to set
     */
    public void setDataKriteria(Kriteria dataKriteria) {
        this.dataKriteria = dataKriteria;
    }

    public double getTotalJarakFnis() {
        return totalJarakFnis;
    }

    public void setTotalJarakFnis(double totalJarakFnis) {
        this.totalJarakFnis = totalJarakFnis;
    }

    public double getTotalJarakFpis() {
        return totalJarakFpis;
    }

    public void setTotalJarakFpis(double totalJarakFpis) {
        this.totalJarakFpis = totalJarakFpis;
    }

    public double getKedekatanRelatif() {
        return kedekatanRelatif;
    }

    public void setKedekatanRelatif(double kedekatanRelatif) {
        this.kedekatanRelatif = kedekatanRelatif;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public int compareTo(TokoOnline compareTokoOnline) {
        int compareRanking = ((TokoOnline) compareTokoOnline).getRanking(); 
		
        //ascending order
        return this.ranking - compareRanking;
	
        //descending order
        //return compareQuantity - this.quantity;
    }
 
}
