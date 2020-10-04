# Bank-program
Design a interface Bank with the following members
Member Functions: CreateAccount( ) - > Creating new Account for the particular bank
Deposit (double amount), Withdraw (double amount),Getbalance( ),GetAnnualInterest ( ) -> Returns Annual Interest Rate 
Design a three class called SBI, HDFC and ICICI which implements from BANK interface (Assume that each bank have different interest rate) with the following members
Data Members: Bankid, Branch, Location
Member function: SetMonthlyInterest ( ) ->Set Different monthly interest rate for each bank
Design a class Person inherits from above three class (SBI or HDFC or ICICI) with the following members
Data Members: PersonId, Name, Account Number, TypeofAccount, Email 
Member functions: AccountDetails () -> Display the following details for the each account holders
PersonId, Name, Bankid, Bankname, Balance, AnnualInterest (Note that AnnualInterestRate is a percentage,e.g., like 4.5%. You need to divide it by 100)

The program should have the following features
1.	Create user defined exception called Insufficientbalance whenever user withdrawing amount more than his/her balance.
2.	Convert account holders name from lowercase to uppercase except first character (Note: First character should be capital letter)
3.	Display the person name who is having maximum amount in the particular bank (use math class)
4.	Use of exception wherever possible  
Note: You can add additional functions in the classes wherever required
