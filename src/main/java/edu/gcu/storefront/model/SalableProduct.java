package edu.gcu.storefront.model;

import java.math.BigDecimal;

/**
 * Abstract base class representing any product that can be sold in the store.
 */
public abstract class SalableProduct {

    /** The name of the product. */
    private final String name;

    /** A short description of the product. */
    private final String description;

    /** The price of a single unit of the product. */
    private BigDecimal price;

    /** The quantity of the product currently in stock. */
    private int quantity;

    /**
     * Constructs a new SalableProduct.
     *
     * @param name        the name of the product
     * @param description the description of the product
     * @param price       the price per unit
     * @param quantity    the quantity in stock
     */
    protected SalableProduct(String name, String description, BigDecimal price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Reduces the quantity of stock after a purchase.
     *
     * @param qty the number of items to purchase
     * @throws IllegalArgumentException if the quantity is invalid or exceeds available stock
     */
    public void purchase(int qty) {
        if (qty <= 0 || qty > quantity) {
            throw new IllegalArgumentException("Insufficient stock.");
        }
        quantity -= qty;
    }

    /**
     * Increases the quantity of stock after a purchase is canceled.
     *
     * @param qty the number of items to restock
     * @throws IllegalArgumentException if the quantity is not positive
     */
    public void cancel(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        quantity += qty;
    }

    /** @return the product name */
    public String getName() {
        return name;
    }

    /** @return the product description */
    public String getDescription() {
        return description;
    }

    /** @return the product price */
    public BigDecimal getPrice() {
        return price;
    }

    /** @param price sets the product price */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /** @return the current quantity in stock */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns a formatted string representation of the product.
     *
     * @return a string with product details
     */
    @Override
    public String toString() {
        return String.format("%s - %s ($%s, Qty: %d)", this.name, this.description, this.price, this.quantity);

    }
}
