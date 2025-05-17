package edu.gcu.storefront.model;

import java.math.BigDecimal;

/**
 * Represents an armor item that can be sold in the store.
 * Extends the SalableProduct class and adds a defense attribute.
 */
public class Armor extends SalableProduct {

    /** The amount of defense the armor provides. */
    private final int defense;

    /**
     * Constructs a new Armor object with the specified attributes.
     *
     * @param name        the name of the armor
     * @param description the description of the armor
     * @param price       the price per unit
     * @param quantity    the quantity in stock
     * @param defense     the defense value of the armor
     */
    public Armor(String name, String description, BigDecimal price, int quantity, int defense) {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    /**
     * Gets the defense value of the armor.
     *
     * @return the armor's defense value
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns a formatted string representation of the armor.
     *
     * @return a string with product details including defense
     */
    @Override
    public String toString() {
        return super.toString() + " | DEF: " + defense;
    }
}
