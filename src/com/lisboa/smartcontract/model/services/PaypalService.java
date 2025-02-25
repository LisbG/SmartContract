package com.lisboa.smartcontract.model.services;

import com.lisboa.smartcontract.model.entities.Contract;
import com.lisboa.smartcontract.model.entities.Plot;
import com.lisboa.smartcontract.model.interfaces.OnlinePaymentInterface;

import java.util.Calendar;

public class PaypalService implements OnlinePaymentInterface {

    @Override
    public void processPayment(Contract contract) {

        // Divido o valor total da fatura para ter a media pela quantidade de parcelas
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
        return (plotValue + (plotValue * (0.01 * (plotInstance + 1))));
    }

    private double paymentTaxes(double plotValue) {

        return (plotValue + (plotValue * 0.02));
    }
}
