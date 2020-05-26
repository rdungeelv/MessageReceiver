package com.tspi.to;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name = "tspiData")
public class TspiData {
    @Column(name = "nanoseconds")
    private long nanoseconds;

    @Column(name = "trackE")
    private double trackE;

    @Column(name = "trackF")
    private double trackF;

    @Column(name = "trackG")
    private double trackG;

    @Column(name = "range")
    private double rg;

    @Column(name = "azimuth")
    private double az;

    @Column(name = "elevation")
    private double el;

    @Column(name = "mode")
    private int mode;

    public TspiData() {
    }

    public TspiData(long nanoseconds, double trackE, double trackF, double trackG, double rg, double az, double el, int mode) {
        this.nanoseconds = nanoseconds;
        this.trackE = trackE;
        this.trackF = trackF;
        this.trackG = trackG;
        this.rg = rg;
        this.az = az;
        this.el = el;
        this.mode = mode;
    }

    public long getNanoseconds() {
        return nanoseconds;
    }

    public void setNanoseconds(long nanoseconds) {
        this.nanoseconds = nanoseconds;
    }

    public double getTrackE() {
        return trackE;
    }

    public void setTrackE(double trackE) {
        this.trackE = trackE;
    }

    public double getTrackF() {
        return trackF;
    }

    public void setTrackF(double trackF) {
        this.trackF = trackF;
    }

    public double getTrackG() {
        return trackG;
    }

    public void setTrackG(double trackG) {
        this.trackG = trackG;
    }

    public double getRg() {
        return rg;
    }

    public void setRg(double rg) {
        this.rg = rg;
    }

    public double getAz() {
        return az;
    }

    public void setAz(double az) {
        this.az = az;
    }

    public double getEl() {
        return el;
    }

    public void setEl(double el) {
        this.el = el;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "TspiData{" +
                "nanoseconds=" + nanoseconds +
                ", trackE=" + trackE +
                ", trackF=" + trackF +
                ", trackG=" + trackG +
                ", rg=" + rg +
                ", az=" + az +
                ", el=" + el +
                ", mode=" + mode +
                '}';
    }
}
