package com.lisboa.smartcontract.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Plot {

    private double plotValue;
    private Date plotDate;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Plot(double plotValue, Date plotDate) {
        this.plotValue = plotValue;
        this.plotDate = plotDate;
    }

    public Date getPlotDate() {
        return plotDate;
    }

    public double getPlotValue() {
        return plotValue;
    }

    @Override
    public String toString() {
        return "plotValue = " + this.getPlotValue() +
                ", plotDate = " + simpleDateFormat.format(this.getPlotDate());
    }
}
