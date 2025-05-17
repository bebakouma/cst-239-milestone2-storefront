package edu.gcu.storefront;

import edu.gcu.storefront.service.InventoryManager;

import java.util.Scanner;

/**
 * Console-based store front application for the GCU Adventure Store.
 * Allows users to view products, make purchases, and cancel purchases.
 */
public class StoreFrontApplication {

    /** Scanner used to read user input from the console. */
    private static final Scanner in = new Scanner(System.in);

    /** InventoryManager to handle product listing and operations. */
    private static final InventoryManager manager = new InventoryManager();

    /**
     * Main method that starts the store front application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Welcome to the GCU Adventure Store ===");

        boolean running = true;
        while (running) {
            printMenu();
            switch (in.nextLine().trim()) {
                case "1":
                    listProducts();
                    break;
                case "2":
                    handleBuy();
                    break;
                case "3":
                    handleCancel();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }

        System.out.println("Thanks for visiting. Goodbye!");
    }

    /**
     * Prints the main menu options for the user.
     */
    private static void printMenu() {
        System.out.println("Please choose an option:\n" +
                           "1) List Products\n" +
                           "2) Buy Product\n" +
                           "3) Cancel Purchase\n" +
                           "4) Exit\n");
        System.out.print("> ");
    }

    /**
     * Displays all products currently available in the store.
     */
    private static void listProducts() {
        manager.list().forEach(entry ->
                System.out.printf("%d) %s%n", entry.getKey(), entry.getValue()));
        System.out.println();
    }

    /**
     * Handles user input to buy a product from the store.
     * Prompts for product ID and quantity.
     * Displays confirmation or error messages.
     */
    private static void handleBuy() {
        try {
            System.out.print("Enter product ID to buy: ");
            int id = Integer.parseInt(in.nextLine());
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(in.nextLine());
            manager.buy(id, qty);
            System.out.println("Purchase successful!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Handles user input to cancel a previous purchase.
     * Prompts for product ID and quantity.
     * Displays confirmation or error messages.
     */
    private static void handleCancel() {
        try {
            System.out.print("Enter product ID to cancel: ");
            int id = Integer.parseInt(in.nextLine());
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(in.nextLine());
            manager.cancel(id, qty);
            System.out.println("Cancellation successful!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}
