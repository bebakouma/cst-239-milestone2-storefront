package edu.gcu.storefront.model;

import java.math.BigDecimal;

/**
 * Represents a health item that can be sold in the store.
 * Extends the SalableProduct class and adds a heal attribute.
 */
public class HealthItem extends SalableProduct {

    /** The amount of health the item restores. */
    private final int heal;

    /**
     * Constructs a new HealthItem object with the specified attributes.
     *
     * @param name        the name of the health item
     * @param description the description of the health item
     * @param price       the price per unit
     * @param quantity    the quantity in stock
     * @param heal        the amount of health restored
     */
    public HealthItem(String name, String description, BigDecimal price, int quantity, int heal) {
        super(name, description, price, quantity);
        this.heal = heal;
    }

    /**
     * Gets the healing value of the item.
     *
     * @return the amount of health restored
     */
    public int getHeal() {
        return heal;
    }

    /**
     * Returns a formatted string representation of the health item.
     *
     * @return a string with product details including healing value
     */
    @Override
    public String toString() {
        return super.toString() + " | HEAL: " + heal;
    }
}
