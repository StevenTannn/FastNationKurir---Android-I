package com.example.fastnationkurir;

public class Rates {
    private String kotaasal;
    private String kotatujuan;
    private String harga;

    public Rates(String kotaasal, String kotatujuan, String harga) {
        this.kotaasal = kotaasal;
        this.kotatujuan = kotatujuan;
        this.harga = harga;
    }

    public String getKotaasal() {
        return kotaasal;
    }

    public void setKotaasal(String kotaasal) {
        this.kotaasal = kotaasal;
    }

    public String getKotatujuan() {
        return kotatujuan;
    }

    public void setKotatujuan(String kotatujuan) {
        this.kotatujuan = kotatujuan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
