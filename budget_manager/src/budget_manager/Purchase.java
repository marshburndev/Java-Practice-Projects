package budget_manager;

public class Purchase {
	private String purchaseName;
	private double purchasePrice;
	
	public Purchase(String purchaseName, double purchasePrice) {
		this.purchaseName = purchaseName;
		this.purchasePrice = purchasePrice;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}
}