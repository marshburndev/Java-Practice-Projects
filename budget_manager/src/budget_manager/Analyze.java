package budget_manager;

import java.util.Collections;
import java.util.Comparator;

public class Analyze extends Work {
    public static void analyzeAll() {
        Collections.sort(allPurchases, new Comparator<Purchase>(){
            @Override
            public int compare(Purchase o1, Purchase o2) {
                return Double.compare(o2.getPurchasePrice(), o1.getPurchasePrice());//o1.getPurchaseName().compareTo(o2.getPurchaseName());, sorts by name
            }
        });
        ListPurchases.printListPurchaseMenu(allPurchases);
        startMenu();
    }
}