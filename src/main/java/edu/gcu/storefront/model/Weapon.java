package edu.gcu.storefront.model;

import java.math.BigDecimal;

/**
 * Represents a weapon item that can be sold in the store.
 * Extends the SalableProduct class and adds a damage attribute.
 */
public class Weapon extends SalableProduct {

    /** The amount of damage the weapon deals. */
    private final int damage;

    /**
     * Constructs a new Weapon with the specified attributes.
     *
     * @param name        the name of the weapon
     * @param description the description of the weapon
     * @param price       the price per unit
     * @param quantity    the quantity in stock
     * @param damage      the damage value of the weapon
     */
    public Weapon(String name, String description, BigDecimal price, int quantity, int damage) {
        super(name, description, price, quantity);
        this.damage = damage;
    }

    /**
     * Gets the damage value of the weapon.
     *
     * @return the weapon's damage value
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns a formatted string representation of the weapon.
     *
     * @return a string with product details including damage
     */
    @Override
    public String toString() {
        return super.toString() + " | DMG: " + damage;
    }
}
