package com.example.loansystem.model;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class Loan {

    private String loanId;
    private String customerId;
    private String lenderId;
    private double amount;
    private double remainingAmount;
    private Date paymentDate;
    private int interestPerDay;
    private Date dueDate;
    private double penaltyPerDay;
    private boolean cancel;

    private static final Logger LOGGER = Logger.getLogger(Loan.class.getName());

    public Loan(String loanId, String customerId, String lenderId, double amount, double remainingAmount,
                String paymentDate, int interestPerDay, String dueDate, double penaltyPerDay) throws ParseException {
        this.loanId = loanId;
        this.customerId = customerId;
        this.lenderId = lenderId;
        this.amount = amount;
        this.remainingAmount = remainingAmount;

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.paymentDate = dateFormat.parse(paymentDate);
        this.interestPerDay = interestPerDay;
        this.dueDate = dateFormat.parse(dueDate);
        this.penaltyPerDay = penaltyPerDay;

        if (this.paymentDate.compareTo(this.dueDate) > 0) {
            throw new IllegalArgumentException("Payment date cannot be greater than the due date.");
        }
    }

    public void checkDueDate() {
        if (new Date().compareTo(this.dueDate) > 0) {
            LOGGER.log(Level.WARNING, "Loan with ID " + this.loanId + " has crossed the due date.");
        }
    }
}
