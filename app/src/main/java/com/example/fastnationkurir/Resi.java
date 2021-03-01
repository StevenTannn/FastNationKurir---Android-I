package com.example.fastnationkurir;

import android.os.Parcel;
import android.os.Parcelable;

public class Resi implements Parcelable {
    private String noresi;
    private String namapengirim;
    private String namapenerima;
    private String kotaasal;
    private String kotatujuan;
    private String status;

    public Resi(String noresi, String namapengirim, String namapenerima, String kotaasal, String kotatujuan, String status) {
        this.noresi = noresi;
        this.namapengirim = namapengirim;
        this.namapenerima = namapenerima;
        this.kotaasal = kotaasal;
        this.kotatujuan = kotatujuan;
        this.status = status;
    }

    protected Resi(Parcel in) {
        noresi = in.readString();
        namapengirim = in.readString();
        namapenerima = in.readString();
        kotaasal = in.readString();
        kotatujuan = in.readString();
        status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noresi);
        dest.writeString(namapengirim);
        dest.writeString(namapenerima);
        dest.writeString(kotaasal);
        dest.writeString(kotatujuan);
        dest.writeString(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Resi> CREATOR = new Creator<Resi>() {
        @Override
        public Resi createFromParcel(Parcel in) {
            return new Resi(in);
        }

        @Override
        public Resi[] newArray(int size) {
            return new Resi[size];
        }
    };

    public String getNamapengirim() {
        return namapengirim;
    }

    public void setNamapengirim(String namapengirim) {
        this.namapengirim = namapengirim;
    }

    public String getNoresi() {
        return noresi;
    }

    public void setNoresi(String noresi) {
        this.noresi = noresi;
    }

    public String getNamapenerima() {
        return namapenerima;
    }

    public void setNamapenerima(String namapenerima) {
        this.namapenerima = namapenerima;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
