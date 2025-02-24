package com.lisboa.smartcontract.model.interfaces;

import com.lisboa.smartcontract.model.entities.Contract;

public interface OnlinePaymentInterface {

    public void processPayment(Contract contract);
}
