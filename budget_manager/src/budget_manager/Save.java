package budget_manager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save extends Work {
    public static void save(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            String completeList = saveToList().toString();
            writer.write(completeList);
            writer.close();
            allPurchases.clear();
            foodPurchases.clear();
            clothingPurchases.clear();
            entertainmentPurchases.clear();
            otherPurchases.clear();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("\nPurchases are now saved!\n");
        startMenu();
    }

    private static StringBuilder saveToList() {

        StringBuilder allList = new StringBuilder();

        allList.append(saveList(foodPurchases, "Food:")).
                append(saveList(clothingPurchases, "\nClothing:")).
                append(saveList(entertainmentPurchases, "\nEntertainment:")).
                append(saveList(otherPurchases, "\nOther:")).
                append("\nBalance:\n").append(Balance.getBalance());
        return allList;
    }

    private static String saveList(ArrayList<Purchase> Arraylist, String type) {
        StringBuilder purchaseList = new StringBuilder(type);
        for (Purchase val : Arraylist) {
            purchaseList.append("\n").append(val.getPurchaseName()).append("<>").append(val.getPurchasePrice());
        }
        return purchaseList.toString();
    }
}