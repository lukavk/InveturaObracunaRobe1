package com.example.ured3.inveturaobracunarobe;

public class Artikli {



    private String NazivA;
    private String CijenaA;
    private String PDVA;
    private String ZalihaA;
    private String DonosA;
    private String UkupnoA;
    private  String OstatakA;
    private String ProdanoA;
    private String IznosA;

    public Artikli(String nazivA, String cijenaA, String PDVA, String zalihaA, String donosA, String ukupnoA, String ostatakA, String prodanoA, String iznosA) {
        NazivA = nazivA;
        CijenaA = cijenaA;
        this.PDVA = PDVA;
        ZalihaA = zalihaA;
        DonosA = donosA;
        UkupnoA = ukupnoA;
        OstatakA = ostatakA;
        ProdanoA = prodanoA;
        IznosA = iznosA;
    }

    public String getNazivA() {
        return NazivA;
    }

    public void setNazivA(String nazivA) {
        NazivA = nazivA;
    }

    public String getCijenaA() {
        return CijenaA;
    }

    public void setCijenaA(String cijenaA) {
        CijenaA = cijenaA;
    }

    public String getPDVA() {
        return PDVA;
    }

    public void setPDVA(String PDVA) {
        this.PDVA = PDVA;
    }

    public String getZalihaA() {
        return ZalihaA;
    }

    public void setZalihaA(String zalihaA) {
        ZalihaA = zalihaA;
    }

    public String getDonosA() {
        return DonosA;
    }

    public void setDonosA(String donosA) {
        DonosA = donosA;
    }

    public String getUkupnoA() {
        return UkupnoA;
    }

    public void setUkupnoA(String ukupnoA) {
        UkupnoA = ukupnoA;
    }

    public String getOstatakA() {
        return OstatakA;
    }

    public void setOstatakA(String ostatakA) {
        OstatakA = ostatakA;
    }

    public String getProdanoA() {
        return ProdanoA;
    }

    public void setProdanoA(String prodanoA) {
        ProdanoA = prodanoA;
    }

    public String getIznosA() {
        return IznosA;
    }

    public void setIznosA(String iznosA) {
        IznosA = iznosA;
    }
}

