package Assignments;
//Custom Exception
class LessBalanceException extends Exception {
 LessBalanceException(double amount) {
     super("Withdraw amount (Rs " + amount + ") is not valid. Insufficient balance.");
 }
}

//Bank Account Class
class Bank_Account {
 double balance;
 final double MIN_BALANCE = 1000;

 // Constructor
 Bank_Account(double balance) {
     if (balance < MIN_BALANCE) {
         System.out.println("Initial balance must be at least Rs 1000");
         this.balance = MIN_BALANCE;
     } else {
         this.balance = balance;
     }
 }

 // Deposit Method
 void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited: Rs " + amount);
 }

 // Withdraw Method
 void withdraw(double amount) throws LessBalanceException {
     if ((balance - amount) < MIN_BALANCE) {
         throw new LessBalanceException(amount);
     } else {
         balance -= amount;
         System.out.println("Withdrawn: Rs " + amount);
     }
 }

 // Display Balance
 void displayBalance() {
     System.out.println("Current Balance: Rs " + balance);
 }
}


public class Assignment6 {
	public static void main(String[] args) {

	     // Create Account
	     Bank_Account acc = new Bank_Account(2000);

	     acc.displayBalance();

	     // Deposit
	     acc.deposit(500);
	     acc.displayBalance();

	     // Withdraw with Exception Handling
	     try {
	         acc.withdraw(1800); // This should trigger exception
	     } catch (LessBalanceException e) {
	         System.out.println(e.getMessage());
	     }

	     acc.displayBalance();

	     // Demonstrate ArithmeticException
	     try {
	         int a = 10;
	         int b = 0;
	         int result = a / b; // Division by zero
	     } catch (ArithmeticException e) {
	         System.out.println("Arithmetic Exception caught: Division by zero is not allowed.");
	     }
	 }
}
