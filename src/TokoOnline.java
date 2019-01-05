/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
public class TokoOnline {
    private String namaToko;
    private Kriteria dataKriteria;
    
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
    
    
}
