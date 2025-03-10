package com.lisboa.smartcontract.model.services;

import com.lisboa.smartcontract.model.entities.Contract;
import com.lisboa.smartcontract.model.entities.Plot;
import com.lisboa.smartcontract.model.entities.ProcessPlotCorrectedValue;
import com.lisboa.smartcontract.model.interfaces.OnlinePaymentInterface;

import java.util.Calendar;

public class PaypalService implements OnlinePaymentInterface {

    @Override
    public void processPayment(Contract contract) {

        ProcessPlotCorrectedValue processPlotCorrectedValue = new ProcessPlotCorrectedValue(0.01, 0.02);
        processPlotCorrectedValue.processPlotCorrectedValue(contract);

    }

}
