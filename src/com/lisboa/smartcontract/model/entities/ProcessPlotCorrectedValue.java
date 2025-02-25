package com.lisboa.smartcontract.model.entities;

import java.util.Calendar;

public class ProcessPlotCorrectedValue {


    private final double simpleInterest;
    private final double paymentTaxes;

    public ProcessPlotCorrectedValue(double simpleInterest, double paymentTaxes){
        this.simpleInterest = simpleInterest;
        this.paymentTaxes = paymentTaxes;
    }

    public void processPlotCorrectedValue(Contract contract) {
        double plotBaseValue = (contract.getContractTotalValue() / contract.getContractPlotQuantity());
        Calendar plotCalendar = Calendar.getInstance();
        plotCalendar.setTime(contract.getContractDate());


        for (int i = 0; i < contract.getContractPlotQuantity(); i++) {
            double correctedValue;

            correctedValue = paymentTaxes(simpleInterest(plotBaseValue, i));
            plotCalendar.add(Calendar.MONTH, 1);
            contract.setPlots(new Plot(correctedValue, plotCalendar.getTime()));

        }
    }

    private double simpleInterest(double plotValue, int plotInstance) {
        return (plotValue + (plotValue * (this.simpleInterest * (plotInstance + 1))));
    }

    private double paymentTaxes(double plotValue) {

        return (plotValue + (plotValue * this.paymentTaxes));
    }
}

