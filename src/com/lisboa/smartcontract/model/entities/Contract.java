package com.lisboa.smartcontract.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    private final String contractId = RandomIdGenerator.randomId();
    private Date contractDate;
    private double contractTotalValue;
    private int contractPlotQuantity;

    private List<Plot> plots = new ArrayList<>();

    public Contract(Date contractDate, double contractTotalValue, int contractPlotQuantity) {
        this.contractDate = contractDate;
        this.contractTotalValue = contractTotalValue;
        this.contractPlotQuantity = contractPlotQuantity;
    }

    public String getContractId() {
        return contractId;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public double getContractTotalValue() {
        return contractTotalValue;
    }

    public void setContractTotalValue(double contractTotalValue) {
        this.contractTotalValue = contractTotalValue;
    }

    public int getContractPlotQuantity() {
        return contractPlotQuantity;
    }

    public void setContractPlotQuantity(int contractPlotQuantity) {
        this.contractPlotQuantity = contractPlotQuantity;
    }

    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(Plot plot) {
        this.plots.add(plot);
    }
}
