package contact_application;

import java.util.List;

public class Contacts {

    private String contactName;
    private String phoneNumber;

    public Contacts(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }
    
    public static void menu() {//Creates menu
        System.out.println("\nThis is a contact list!");
        System.out.println("Pick an option.");
        System.out.println("1. Add Contact.");
        System.out.println("2. Sort List. ");
        System.out.println("3. Print List.");
        System.out.println("4. Output List to File.");
        System.out.println("5. Exit");
    }
    
    public static void contactChecker(List<Contacts> contactList){
        if (contactList.isEmpty()) {
            System.out.println("You do not have any contacts!");
        }   
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\nNAME: " + contactName + "\nPHONE NUMBER: " + phoneNumber;
    }
}
