package com.example.fastnationkurir;

public class Outlet {
    private String nama;
    private String alamat;
    private String notelp;

    public Outlet(String nama, String alamat, String notelp) {
        this.nama = nama;
        this.alamat = alamat;
        this.notelp = notelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}
