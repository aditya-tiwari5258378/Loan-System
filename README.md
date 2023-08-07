# Loan-System

Validation:

1. The payment date can’t be greater than the Due Date. If its greater we have to reject the
Loan and thrown the exception
2. We need to write an aggregation on the remaining amount, Interest and Penalty Group by
Lender, Group by Interest and Group by Customer ID.
3. If the Loan crosses the due date, it should write an alert in the log message.
