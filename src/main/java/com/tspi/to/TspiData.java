package com.tspi.to;

public class TspiData {
    private long nanoseconds;
    private double trackE;
    private double trackF;
    private double trackG;
    private double rg_A;
    private double az_A;
    private double el_A;
    private int mode_A;
    private double rg_B;
    private double az_B;
    private double el_B;
    private int mode_B;
    private double rg_C;
    private double az_C;
    private double el_C;
    private int mode_C;

    public TspiData() {
    }

    public TspiData(long nanoseconds, double trackE, double trackF, double trackG, double rg_A,
                    double az_A, double el_A, int mode_A, double rg_B, double az_B, double el_B,
                    int mode_B, double rg_C, double az_C, double el_C, int mode_C) {
        this.nanoseconds = nanoseconds;
        this.trackE = trackE;
        this.trackF = trackF;
        this.trackG = trackG;
        this.rg_A = rg_A;
        this.az_A = az_A;
        this.el_A = el_A;
        this.mode_A = mode_A;
        this.rg_B = rg_B;
        this.az_B = az_B;
        this.el_B = el_B;
        this.mode_B = mode_B;
        this.rg_C = rg_C;
        this.az_C = az_C;
        this.el_C = el_C;
        this.mode_C = mode_C;
    }

    public void setNanoseconds(long nanoseconds) {
        this.nanoseconds = nanoseconds;
    }

    public void setTrackE(double trackE) {
        this.trackE = trackE;
    }

    public void setTrackF(double trackF) {
        this.trackF = trackF;
    }

    public void setTrackG(double trackG) {
        this.trackG = trackG;
    }

    public void setRg_A(double rg_A) {
        this.rg_A = rg_A;
    }

    public void setAz_A(double az_A) {
        this.az_A = az_A;
    }

    public void setEl_A(double el_A) {
        this.el_A = el_A;
    }

    public void setMode_A(int mode_A) {
        this.mode_A = mode_A;
    }

    public void setRg_B(double rg_B) {
        this.rg_B = rg_B;
    }

    public void setAz_B(double az_B) {
        this.az_B = az_B;
    }

    public void setEl_B(double el_B) {
        this.el_B = el_B;
    }

    public void setMode_B(int mode_B) {
        this.mode_B = mode_B;
    }

    public void setRg_C(double rg_C) {
        this.rg_C = rg_C;
    }

    public void setAz_C(double az_C) {
        this.az_C = az_C;
    }

    public void setEl_C(double el_C) {
        this.el_C = el_C;
    }

    public void setMode_C(int mode_C) {
        this.mode_C = mode_C;
    }

    @Override
    public String toString() {
        return "TspiData{" +
                "nanoseconds=" + nanoseconds +
                ", trackE=" + trackE +
                ", trackF=" + trackF +
                ", trackG=" + trackG +
                ", rg_A=" + rg_A +
                ", az_A=" + az_A +
                ", el_A=" + el_A +
                ", mode_A=" + mode_A +
                ", rg_B=" + rg_B +
                ", az_B=" + az_B +
                ", el_B=" + el_B +
                ", mode_B=" + mode_B +
                ", rg_C=" + rg_C +
                ", az_C=" + az_C +
                ", el_C=" + el_C +
                ", mode_C=" + mode_C +
                '}';
    }
}
