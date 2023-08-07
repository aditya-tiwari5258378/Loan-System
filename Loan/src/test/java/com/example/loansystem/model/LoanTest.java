package com.example.loansystem.model;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertNotNull;

public class LoanTest {

    @Test(expected = IllegalArgumentException.class)
    public void testRejectLoanIfPaymentDateGreaterThanDueDate() throws Exception {
        Loan loan = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/05/2023", 0.01);
    }

    @Test
    public void testValidLoan() throws ParseException {
        Loan loan = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
        assertNotNull(loan);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRejectLoanIfRemainingAmountGreaterThanAmount() throws ParseException {
        Loan loan = new Loan("L1", "C1", "LEN1", 10000, 11000, "05/06/2023", 1, "05/07/2023", 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRejectLoanIfNegativeInterestPerDay() throws ParseException {
        Loan loan = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", -1, "05/07/2023", 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRejectLoanIfNegativePenaltyPerDay() throws ParseException {
        Loan loan = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", -0.01);
    }
}
