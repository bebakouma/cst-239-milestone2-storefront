package edu.gcu.storefront.service;

import edu.gcu.storefront.model.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Manages the inventory of salable products in the store.
 * Provides functionality to list, purchase, and cancel products.
 */
public class InventoryManager {

    /** A map of product IDs to salable products. */
    private final Map<Integer, SalableProduct> products = new LinkedHashMap<>();

    /** The next available unique product ID. */
    private int nextId = 1;

    /**
     * Constructs a new InventoryManager and loads initial product inventory.
     */
    public InventoryManager() {
        loadInitialInventory();
    }

    /**
     * Lists all available products in the inventory.
     *
     * @return a collection of product entries (ID and product object)
     */
    public Collection<Map.Entry<Integer, SalableProduct>> list() {
        return products.entrySet();
    }

    /**
     * Purchases a specified quantity of the product with the given ID.
     *
     * @param id  the product ID
     * @param qty the quantity to purchase
     * @throws NoSuchElementException if the product ID is invalid
     * @throws IllegalArgumentException if quantity is invalid
     */
    public void buy(int id, int qty) {
        find(id).purchase(qty);
    }

    /**
     * Cancels a specified quantity of the product with the given ID (restocks it).
     *
     * @param id  the product ID
     * @param qty the quantity to cancel
     * @throws NoSuchElementException if the product ID is invalid
     * @throws IllegalArgumentException if quantity is invalid
     */
    public void cancel(int id, int qty) {
        find(id).cancel(qty);
    }

    /**
     * Finds a product by ID.
     *
     * @param id the product ID
     * @return the corresponding product
     * @throws NoSuchElementException if the product is not found
     */
    private SalableProduct find(int id) {
        SalableProduct p = products.get(id);
        if (p == null) {
            throw new NoSuchElementException("Product not found.");
        }
        return p;
    }

    /**
     * Adds a product to the inventory and assigns a unique ID.
     *
     * @param p the product to add
     */
    private void add(SalableProduct p) {
        products.put(nextId++, p);
    }

    /**
     * Populates the inventory with a default set of weapons, armor, and health items.
     */
    private void loadInitialInventory() {
        add(new Weapon("Iron Sword", "Starter melee weapon", new BigDecimal("30.00"), 5, 15));
        add(new Weapon("Oak Bow", "Basic ranged weapon", new BigDecimal("25.00"), 3, 12));
        add(new Armor("Leather Vest", "Light protection", new BigDecimal("20.00"), 4, 8));
        add(new Armor("Steel Shield", "Blocks attacks", new BigDecimal("35.00"), 2, 15));
        add(new HealthItem("Health Potion", "Restores 50 HP", new BigDecimal("10.00"), 10, 50));
    }
}
