public class Account{

	private int accountNumber;
	private double balance;

	public Account(){
		balance = 0.0;
	}

	public Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(int accountNumber){
		this(accountNumber, 0.0);
	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	public double getBalance(){
		return this.balance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}

	public void credit(double amount){
		this.balance += amount;
	}

	public void debit(double amount){
		if (this.balance >= amount){
			this.balance = this.balance - amount;
		}
		else{
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}

	public String toString(){
		return String.format("A/C no:%d, Balance=$%.2f", this.accountNumber, this.balance);
	}
}
