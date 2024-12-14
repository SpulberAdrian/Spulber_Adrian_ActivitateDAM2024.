package com.example.seminar4_;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity (tableName ="Autocare")
public class Autocar implements  Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @ColumnInfo(name ="id")
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "Numar Locuri")
    private  int nrLocuri;
    @ColumnInfo(name = "Capacitate Rezervor")
    private double rezervorCapacitate;
    @NotNull
    private  String numeSofer;
    @ColumnInfo(name = "Cai putere")
    private int CaiPutere;

    public Autocar(){
        this.nrLocuri = 0;
        this.CaiPutere = 0;
        this.numeSofer = "-";
        this.rezervorCapacitate = 0;
    }

    protected Autocar(Parcel in) {
        nrLocuri = in.readInt();
        rezervorCapacitate = in.readDouble();
        numeSofer = in.readString();
        CaiPutere = in.readInt();
    }


    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public double getRezervorCapacitate() {
        return rezervorCapacitate;
    }

    public void setRezervorCapacitate(double rezervorCapacitate) {
        this.rezervorCapacitate = rezervorCapacitate;
    }

    public String getNumeSofer() {
        return numeSofer;
    }

    public void setNumeSofer(String numeSofer) {
        this.numeSofer = numeSofer;
    }

    public int getCaiPutere() {
        return CaiPutere;
    }

    public void setCaiPutere(int caiPutere) {
        CaiPutere = caiPutere;
    }

    public void writeToParcel(Parcel dest,  int flags){
        dest.writeInt(nrLocuri);
        dest.writeDouble(rezervorCapacitate);
        dest.writeString(numeSofer);
        dest.writeInt(CaiPutere);
    }

    public static final Creator<Autocar> CREATOR = new Creator<Autocar>() {
        @Override
        public Autocar createFromParcel(Parcel in) {
            return new Autocar(in);
        }

        @Override
        public Autocar[] newArray(int size) {
            return new Autocar[size];
        }
    };

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Autocar{");
        sb.append("nrLocuri=").append(nrLocuri);
        sb.append(", rezervorCapacitate=").append(rezervorCapacitate);
        sb.append(", numeSofer='").append(numeSofer).append('\'');
        sb.append(", CaiPutere=").append(CaiPutere);
        sb.append('}');
        return sb.toString();
    }
}
