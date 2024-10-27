package com.example.seminar4_;

public class Autocar {
    private int nrLocuri;
    private float rezervorCapacitate;
    private String numeSofer;
    private int CaiPutere;

    public Autocar(){
        this.nrLocuri = 0;
        this.CaiPutere = 0;
        this.numeSofer = "-";
        this.rezervorCapacitate = 0;
    }
    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public float getRezervorCapacitate() {
        return rezervorCapacitate;
    }

    public void setRezervorCapacitate(float rezervorCapacitate) {
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
