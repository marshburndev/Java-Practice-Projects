package budget_manager;

public class Purchases extends Work {
    private static void addFoodPurchase() {

        Purchase foodPurchase = addToListPurchase();
        foodPurchases.add(foodPurchase);

        showPurchaseMenu();
    }

    private static void addClothingPurchase() {

        Purchase clothingPurchase = addToListPurchase();
        clothingPurchases.add(clothingPurchase);

        showPurchaseMenu();
    }

    private static void addEntertainmentPurchase() {

        Purchase entertainmentPurchase = addToListPurchase();
        entertainmentPurchases.add(entertainmentPurchase);

        showPurchaseMenu();
    }

    private static void addOtherPurchase() {

        Purchase otherPurchase = addToListPurchase();
        otherPurchases.add(otherPurchase);
        showPurchaseMenu();
    }

    public static Purchase addToListPurchase() {
        System.out.println();
        scnr.nextLine();

        System.out.println("Enter purchase name: ");
        String purchaseName = scnr.nextLine();

        System.out.println("Enter its price: ");
        String purchasePrice = scnr.next().replaceAll(",", ".");
        System.out.println("Purchase was added!");

        Balance.setBalance(Balance.getBalance() - Double.parseDouble(purchasePrice));

        Purchase purchase = new Purchase(purchaseName, Double.parseDouble(purchasePrice));

        allPurchases.add(purchase);

        return purchase;
    }

    public static void showPurchaseMenu(){
        loopRelayTwo = true;

        System.out.println("\n Choose the type of purchase\n");
        System.out.println("1) Food\n");
        System.out.println("2) Clothes\n");
        System.out.println("3) Entertainment\n");
        System.out.println("4) Other\n");
        System.out.println("5) Back\n");

        String userInput = scnr.next();
        
        while(loopRelayTwo){
            switch (userInput) {
                case "1":
                addFoodPurchase();
                break;
                case "2":
                addClothingPurchase();
                break;
                case "3":
                addEntertainmentPurchase();
                break;
                case "4":
                addOtherPurchase();
                break;
                case "5":
                back();
                break;
                default:
                System.out.println("please pick a number between 1 and 5.");
            }
        }
    }
}
