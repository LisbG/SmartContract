package com.lisboa.smartcontract.application;

import com.lisboa.smartcontract.model.entities.Contract;
import com.lisboa.smartcontract.model.entities.Plot;
import com.lisboa.smartcontract.model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        double contractTotalValue;
        int contractPlotQuantity;
        Date contractDate;

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Contract fields: ");
            System.out.print("Data (dd/MM/yyyy): ");
            contractDate = simpleDateFormat.parse(scanner.next());

            System.out.print("Value: ");
            contractTotalValue = scanner.nextDouble();

            System.out.print("Plot quantity: ");
            contractPlotQuantity = scanner.nextInt();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Contract contract = new Contract(contractDate, contractTotalValue, contractPlotQuantity, new PaypalService());

        contract.processPayment();

        for (Plot plot : contract.getPlots()) {
            System.out.println(plot.toString());
        }
    }
}
