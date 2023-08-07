package com.example.loansystem;

import com.example.loansystem.model.Loan;
import com.example.loansystem.service.LoanStore;

public class LoanSystemApplication {
    public static void main(String[] args) {
        LoanStore loanStore = new LoanStore();

        try {
            Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
            Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, "01/06/2023", 1, "05/08/2023", 0.01);
            Loan loan3 = new Loan("L3", "C2", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);
            Loan loan4 = new Loan("L4", "C3", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);

            loanStore.addLoan(loan1);
            loanStore.addLoan(loan2);
            loanStore.addLoan(loan3);
            loanStore.addLoan(loan4);

            System.out.println("Aggregation by Remaining Amount: " + loanStore.aggregateByRemainingAmount());
            System.out.println("Aggregation by Interest: " + loanStore.aggregateByInterest());
            System.out.println("Aggregation by Customer ID: " + loanStore.aggregateByCustomerId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
