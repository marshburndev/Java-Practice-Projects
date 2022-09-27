package online_shopping_cart;

import java.util.Scanner;

public class ShoppingCartPrinter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String itemOneName, itemTwoName;
      int itemOnePrice, itemTwoPrice, itemOneCost;
      int itemOneQuantity, itemTwoQuantity, itemTwoCost;
      int totalCost; 

      ItemToPurchase itemOne = new ItemToPurchase();
      ItemToPurchase itemTwo = new ItemToPurchase();

      System.out.println("Item 1");
      System.out.println("Enter the item name:");
      itemOneName = scnr.nextLine();
      itemOne.setName(itemOneName);
      System.out.println("Enter the item price:");
      itemOnePrice = scnr.nextInt();
      itemOne.setPrice(itemOnePrice);
      System.out.println("Enter the item quantity:");
      itemOneQuantity = scnr.nextInt();
      itemOne.setQuantity(itemOneQuantity);

      scnr.nextLine();
      System.out.println();

      System.out.println("Item 2");
      System.out.println("Enter the item name:");
      itemTwoName = scnr.nextLine();
      itemTwo.setName(itemTwoName);
      System.out.println("Enter the item price:");
      itemTwoPrice = scnr.nextInt();
      itemTwo.setPrice(itemTwoPrice);
      System.out.println("Enter the item quantity:");
      itemTwoQuantity = scnr.nextInt();
      itemTwo.setQuantity(itemTwoQuantity);
      System.out.println();

      System.out.println("TOTAL COST");
      itemOneCost = itemOne.getPrice() * itemOne.getQuantity();
      itemTwoCost = itemTwo.getPrice() * itemTwo.getQuantity();
      totalCost = itemOneCost + itemTwoCost;

      System.out.println(itemOne.getName() + " " + itemOne.getQuantity() + " @ $" + itemOne.getPrice() + " = $" + itemOneCost);
      System.out.println(itemTwo.getName() + " " + itemTwo.getQuantity() + " @ $" + itemTwo.getPrice() + " = $" + itemTwoCost);
      System.out.println();
      System.out.println("Total: $" + totalCost);
      scnr.close();
   }
}