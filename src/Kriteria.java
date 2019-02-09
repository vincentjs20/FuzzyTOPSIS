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
    private double [] jarakFpis;
    private double [] jarakFnis;
    private String [] linguistikNilai;
    private String [] linguistikBobot;
    
    public Kriteria(){

    }
    
    public Kriteria(String [] namaKriteria, String [] linguistikNilai, String [] linguistikBobot){
        this.namaKriteria = namaKriteria;
//        this.linguistikNilai = linguistikNilai;
//        this.linguistikBobot = linguistikBobot;
        this.bobotKriteria = this.linguistikBobotToFuzzy(linguistikBobot);
        this.nilaiKriteria = this.linguistikNilaiToFuzzy(linguistikNilai);
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

    public String[] getLinguistikBobot() {
        return linguistikBobot;
    }

    public void setLinguistikBobot(String[] linguistikBobot) {
        this.linguistikBobot = linguistikBobot;
    }

    public String[] getLinguistikNilai() {
        return linguistikNilai;
    }

    public void setLinguistikNilai(String[] linguistikNilai) {
        this.linguistikNilai = linguistikNilai;
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

    public double[] getJarakFnis() {
        return jarakFnis;
    }

    public void setJarakFnis(double[] jarakFnis) {
        this.jarakFnis = jarakFnis;
    }

    public double[] getJarakFpis() {
        return jarakFpis;
    }

    public void setJarakFpis(double[] jarakFpis) {
        this.jarakFpis = jarakFpis;
    }
    
    public FuzzyNumber [] linguistikNilaiToFuzzy(String [] linguistikNilai){
        FuzzyNumber [] nilaiKriteria = new FuzzyNumber[linguistikNilai.length];
        for (int i = 0; i < linguistikNilai.length; i++) {
            if(linguistikNilai[i].equalsIgnoreCase("sangat buruk")){
                nilaiKriteria[i] = new FuzzyNumber(1,1,3);
            }
            else if(linguistikNilai[i].equalsIgnoreCase("buruk")){
                nilaiKriteria[i] = new FuzzyNumber(1,3,5);
            }
            else if(linguistikNilai[i].equalsIgnoreCase("normal")){
                nilaiKriteria[i] = new FuzzyNumber(3,5,7);
            }
            else if(linguistikNilai[i].equalsIgnoreCase("baik")){
                nilaiKriteria[i] = new FuzzyNumber(5,7,9);
            }
            else if(linguistikNilai[i].equalsIgnoreCase("sangat baik")){
                nilaiKriteria[i] = new FuzzyNumber(7,9,9);
            }
        }
        return nilaiKriteria;
    }
    
    public FuzzyNumber [] linguistikBobotToFuzzy(String [] linguistikBobot){

        FuzzyNumber [] bobotKriteria = new FuzzyNumber[linguistikBobot.length];
        for (int i = 0; i < linguistikBobot.length; i++) {
            if(linguistikBobot[i].equalsIgnoreCase("sangat tidak penting")){
                bobotKriteria[i] = new FuzzyNumber(1,1,3);
            }
            else if(linguistikBobot[i].equalsIgnoreCase("kurang penting")){
                bobotKriteria[i] = new FuzzyNumber(1,3,5);
            }
            else if(linguistikBobot[i].equalsIgnoreCase("normal")){
                bobotKriteria[i] = new FuzzyNumber(3,5,7);
            }
            else if(linguistikBobot[i].equalsIgnoreCase("penting")){
                bobotKriteria[i] = new FuzzyNumber(5,7,9);
            }
            else if(linguistikBobot[i].equalsIgnoreCase("sangat penting")){
                bobotKriteria[i] = new FuzzyNumber(7,9,9);
            }
        }
        return bobotKriteria;
    }
}
