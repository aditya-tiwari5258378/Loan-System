package com.example.loansystem.service;

import com.example.loansystem.model.Loan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanStoreTest {

    @Test
    public void testLoanStoreAggregationByRemainingAmount() throws Exception {
        LoanStore loanStore = new LoanStore();
        Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
        Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, "01/06/2023", 1, "05/08/2023", 0.01);
        loanStore.addLoan(loan1);
        loanStore.addLoan(loan2);
        assertEquals(loan1.getRemainingAmount() + loan2.getRemainingAmount(), loanStore.aggregateByRemainingAmount().get("LEN1"), 0.01);
    }

    @Test
    public void testLoanStoreAggregationByInterest() throws Exception {
        LoanStore loanStore = new LoanStore();
        Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
        Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, "01/06/2023", 1, "05/08/2023", 0.01);
        Loan loan3 = new Loan("L3", "C2", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);

        loanStore.addLoan(loan1);
        loanStore.addLoan(loan2);
        loanStore.addLoan(loan3);

        assertEquals(loan1.getRemainingAmount() + loan2.getRemainingAmount(), loanStore.aggregateByInterest().get(loan1.getInterestPerDay()), 0.01);
        assertEquals(loan3.getRemainingAmount(), loanStore.aggregateByInterest().get(loan3.getInterestPerDay()), 0.01);
    }

    @Test
    public void testLoanStoreAggregationByCustomerId() throws Exception {
        LoanStore loanStore = new LoanStore();
        Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
        Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, "01/06/2023", 1, "05/08/2023", 0.01);
        Loan loan3 = new Loan("L3", "C2", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);

        loanStore.addLoan(loan1);
        loanStore.addLoan(loan2);
        loanStore.addLoan(loan3);

        assertEquals(loan1.getRemainingAmount() + loan2.getRemainingAmount(), loanStore.aggregateByCustomerId().get(loan1.getCustomerId()), 0.01);
        assertEquals(loan3.getRemainingAmount(), loanStore.aggregateByCustomerId().get(loan3.getCustomerId()), 0.01);
    }

}