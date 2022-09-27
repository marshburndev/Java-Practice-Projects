package contact_application;

import java.io.FileNotFoundException;

//Program to take input from user and create a contact list.
//Uses ArrayList data structure built from the contacts class and can be sorted.
//Outputs a file with list of contact information if desired.

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;

public class ContactPrinter {
	public static void main(String[] args) throws IOException {

		List<Contacts> contactList = new ArrayList<>();// Create ArrayList to store contacts
		boolean loopRelay = true;
		Scanner scanner = new Scanner(System.in);
		FileWriter writer = null;

		while (loopRelay) { // Loop until user wishes to quit

			Contacts.menu();
			String num = scanner.next();

			switch (num) {

			case "1": {// Validation for creation of Contact object.
				try {
					System.out.print("Enter Contact Name: ");
					scanner.nextLine();
					String contactName = scanner.nextLine();

					if (contactName.length() > 25) {
						throw new Exception();
					}

					System.out.print("Enter Phone Number: ");
					String phoneNumber = scanner.nextLine();

					if (phoneNumber.length() < 15) {
						for (char i : phoneNumber.toCharArray()) {
							if (Character.isAlphabetic(i) || !Character.isDefined('-')) {
								throw new Exception();
							}
						}
					} else {
						throw new Exception();
					}

					Contacts contact = new Contacts(contactName, phoneNumber);
					contactList.add(contact);

				} catch (Exception exception) {
					System.out.println("Invalid input. Valid input is text less than 25 characters for name. "
							+ "Valid input for phone number is less than 15 characters."
							+ "Please use letters for name and numbers for phone number.");
				}
				break;
			}

			case "2": {
				Contacts.contactChecker(contactList); // Function to check if the list is empty
				contactList.sort(new Comparator<>() {
					@Override
					public int compare(Contacts o1, Contacts o2) {
						return o1.getContactName().compareTo(o2.getContactName());
					}
				});
				break;
			}

			case "3": {
				Contacts.contactChecker(contactList); // Function to check if the list is empty
				for (Contacts contact : contactList) {
					System.out.println(contact);
				}
				break;
			}

			case "4": {
				Contacts.contactChecker(contactList); // Function to check if the list is empty
				try {
					writer = new FileWriter("contact_list.txt");
					for (Contacts contact : contactList) {
						writer.write(contact + System.lineSeparator());
					}
				} catch (FileNotFoundException e) {
					throw e;
				} catch (IOException e) {
					System.err.print("Something went wrong.");
				} finally {
					writer.close();
				}
				break;
			}

			case "5": {
				System.out.println("Exiting Program.");
				loopRelay = false;
				break;
			}

			default: {
				System.out.println("Please enter a number between 1 and 5");
			}
			}
		}
		scanner.close();
	}
}
