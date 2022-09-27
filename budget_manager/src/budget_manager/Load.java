package budget_manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Load extends Work {
    public static void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Scanner newScanner = new Scanner(reader);
            
            allPurchases.clear();

            while (newScanner.hasNext()) {
                purchasesList.add(newScanner.nextLine());
            }
            newScanner.close();

            Balance.setBalance(Double.parseDouble(purchasesList.get(purchasesList.size() - 1)));

                        // Load purchases to every list and to allPurchases
            loadToList("Food:", foodPurchases);
            loadToList("Clothing:", clothingPurchases);
            loadToList("Entertainment:", entertainmentPurchases);
            loadToList("Other:", otherPurchases);
            
            System.out.println("\nPurchases were loaded!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        startMenu();
    }

    private static void loadToList(String type, ArrayList<Purchase> ArrayList){
        Purchase purchase;
        String[] data;

        ArrayList.clear();

        for (int i = purchasesList.indexOf(type) + 1; i < purchasesList.size()-1; i++) {
            if(purchasesList.get(i).contains("<>")) {
                data = purchasesList.get(i).split("<>");
                purchase = new Purchase(data[0], Double.parseDouble(data[1]));
                allPurchases.add(purchase);
                ArrayList.add(purchase);
            } else {
                break;
            }
        }
    }
}
