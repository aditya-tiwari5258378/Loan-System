package com.example.loansystem.service;

import com.example.loansystem.model.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanStore {

    private List<Loan> loans;

    public LoanStore() {
        this.loans = new ArrayList<>();
    }

    public void addLoan(Loan loan) throws Exception {
        loans.add(loan);
    }

    public Map<String, Double> aggregateByRemainingAmount() {
        Map<String, Double> aggregation = new HashMap<>();
        for (Loan loan : loans) {
            String lenderId = loan.getLenderId();
            double remainingAmount = loan.getRemainingAmount();
            aggregation.put(lenderId, aggregation.getOrDefault(lenderId, 0.0) + remainingAmount);
        }
        return aggregation;
    }

    public Map<Integer, Double> aggregateByInterest() {
        Map<Integer, Double> aggregation = new HashMap<>();
        for (Loan loan : loans) {
            int interestPerDay = loan.getInterestPerDay();
            double remainingAmount = loan.getRemainingAmount();
            aggregation.put(interestPerDay, aggregation.getOrDefault(interestPerDay, 0.0) + remainingAmount);
        }
        return aggregation;
    }

    public Map<String, Double> aggregateByCustomerId() {
        Map<String, Double> aggregation = new HashMap<>();
        for (Loan loan : loans) {
            String customerId = loan.getCustomerId();
            double remainingAmount = loan.getRemainingAmount();
            aggregation.put(customerId, aggregation.getOrDefault(customerId, 0.0) + remainingAmount);
        }
        return aggregation;
    }
}
