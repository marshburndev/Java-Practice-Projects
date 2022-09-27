package budget_manager;

import java.util.ArrayList;

public class ListPurchases extends Purchases {
    private static double amount;

    private static void showListOfFoodPurchases() {
        System.out.println("\nFood:");
        printListPurchaseMenu(foodPurchases);
        showListPurchaseMenu();
    }

    private static void showListOfClothingPurchases() {
        System.out.println("\nClothes:");
        printListPurchaseMenu(clothingPurchases);
        showListPurchaseMenu();
    }

    private static void showListOfEntertainmentPurchases() {
        System.out.println("\nEntertainment:");
        printListPurchaseMenu(entertainmentPurchases);
        showListPurchaseMenu();
    }

    private static void showListOfOtherPurchases() {
        System.out.println("\nOther:");
        printListPurchaseMenu(otherPurchases);
        showListPurchaseMenu();
    }

    private static void showListOfAllPurchases() {
        System.out.println("\nAll:");
        printListPurchaseMenu(allPurchases);
        showListPurchaseMenu();
    }

    public static void printListPurchaseMenu(ArrayList<Purchase> ArrayList){
        if (ArrayList.size() == 0) {
            System.out.println("\n Nothing purchased!\n");
        } else {
            for(Purchase purchase : ArrayList){
                System.out.println(purchase.getPurchaseName() + " $" + decimalFormat.format(purchase.getPurchasePrice())); //Check on replace regex part here
            }
            System.out.println("Total amount: $" + decimalFormat.format(countTotalAmount(ArrayList)));
        }
    };

    public static double countTotalAmount(ArrayList<Purchase> ArrayList){
        amount = 0;
        for(Purchase purchase : ArrayList) {
            amount += purchase.getPurchasePrice();
        }
        return amount;
    }

    public static void showListPurchaseMenu(){
        loopRelayTwo = true;

        System.out.println("\nChoose the purchase type\n");
        System.out.println("1) Food.\n");
        System.out.println("2) Clothing.\n");
        System.out.println("3) Entertainment.\n");
        System.out.println("4) Other.\n");
        System.out.println("5) All.\n");
        System.out.println("6) Back.\n");

        String userInput = scnr.next();
        
        while (loopRelayTwo){
            switch (userInput){
            case "1":
            showListOfFoodPurchases();
            break;
            case "2":
            showListOfClothingPurchases();
            break;
            case "3":
            showListOfEntertainmentPurchases();
            case "4": 
            showListOfOtherPurchases();
            break;
            case "5":
            showListOfAllPurchases();
            break;
            case "6":
            back();
            break;
            default:
            System.out.println("please pick a number between 1 and 6.");
            }
        }
    }
}