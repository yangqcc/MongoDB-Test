package com.yqc.lookup;

/**
 * Created by yangqc on 2017/3/23.
 */
public class Look {

    private String sku;
    private String description;
    private int product;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Look{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", product=" + product +
                '}';
    }
}
