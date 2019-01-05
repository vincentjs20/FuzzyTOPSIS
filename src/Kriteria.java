/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
public class Kriteria {
    private String [] namaKriteria;
    private FuzzyNumber [] nilaiKriteria;
    private FuzzyNumber [] bobotKriteria;
    private FuzzyNumber [] fpis;
    private FuzzyNumber [] fnis;
    
    public Kriteria(){

    }
    
    public Kriteria(String [] namaKriteria, FuzzyNumber [] nilaiKriteria, FuzzyNumber [] bobotKriteria){
        this.namaKriteria = namaKriteria;
        this.nilaiKriteria = nilaiKriteria;
        this.bobotKriteria = bobotKriteria;
    }

    /**
     * @return the namaKriteria
     */
    public String[] getNamaKriteria() {
        return namaKriteria;
    }

    /**
     * @param namaKriteria the namaKriteria to set
     */
    public void setNamaKriteria(String[] namaKriteria) {
        this.namaKriteria = namaKriteria;
    }

    /**
     * @return the nilaiKriteria
     */
    public FuzzyNumber[] getNilaiKriteria() {
        return nilaiKriteria;
    }

    /**
     * @param nilaiKriteria the nilaiKriteria to set
     */
    public void setNilaiKriteria(FuzzyNumber[] nilaiKriteria) {
        this.nilaiKriteria = nilaiKriteria;
    }

    /**
     * @return the bobotKriteria
     */
    public FuzzyNumber[] getBobotKriteria() {
        return bobotKriteria;
    }

    /**
     * @param bobotKriteria the bobotKriteria to set
     */
    public void setBobotKriteria(FuzzyNumber[] bobotKriteria) {
        this.bobotKriteria = bobotKriteria;
    }

    /**
     * @return the fpis
     */
    public FuzzyNumber[] getFpis() {
        return fpis;
    }

    /**
     * @param fpis the fpis to set
     */
    public void setFpis(FuzzyNumber[] fpis) {
        this.fpis = fpis;
    }

    /**
     * @return the fnis
     */
    public FuzzyNumber[] getFnis() {
        return fnis;
    }

    /**
     * @param fnis the fnis to set
     */
    public void setFnis(FuzzyNumber[] fnis) {
        this.fnis = fnis;
    }
    
    
}
