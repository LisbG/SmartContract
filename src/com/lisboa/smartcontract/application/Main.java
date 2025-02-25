package com.lisboa.smartcontract.application;

import com.lisboa.smartcontract.model.entities.Contract;
import com.lisboa.smartcontract.model.entities.Plot;
import com.lisboa.smartcontract.model.services.MercadoPagoService;
import com.lisboa.smartcontract.model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        double contractTotalValuePaypal;
        int contractPlotQuantityPaypal;
        Date contractDatePaypal;

        double contractTotalValueMercadoPago;
        int contractPlotQuantityMercadoPago;
        Date contractDateMercadoPago;

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Paypal contract fields: ");
            System.out.print("Data (dd/MM/yyyy): ");
            contractDatePaypal = simpleDateFormat.parse(scanner.next());

            System.out.print("Value: ");
            contractTotalValuePaypal = scanner.nextDouble();

            System.out.print("Plot quantity: ");
            contractPlotQuantityPaypal = scanner.nextInt();


            System.out.println("Mercado Pago contract fields: ");
            System.out.print("Data (dd/MM/yyyy): ");
            contractDateMercadoPago = simpleDateFormat.parse(scanner.next());

            System.out.print("Value: ");
            contractTotalValueMercadoPago = scanner.nextDouble();

            System.out.print("Plot quantity: ");
            contractPlotQuantityMercadoPago = scanner.nextInt();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Contract contractPayPal = new Contract(contractDatePaypal, contractTotalValuePaypal, contractPlotQuantityPaypal, new PaypalService());
        contractPayPal.processPayment();

        Contract contractMercadoPago = new Contract(contractDateMercadoPago, contractTotalValueMercadoPago, contractPlotQuantityMercadoPago, new MercadoPagoService());
        contractMercadoPago.processPayment();

        for (Plot plot : contractPayPal.getPlots()) {
            System.out.println(plot.toString());
        }

        for (Plot plot : contractMercadoPago.getPlots()) {
            System.out.println(plot.toString());
        }


    }
}
