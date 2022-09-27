package budget_manager;

public class Balance {
	
	private static double balance = 0;

	public Balance(double balance) {
		Balance.balance = balance;
	}

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		Balance.balance = balance;
	}
}
