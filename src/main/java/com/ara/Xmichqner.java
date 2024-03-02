package com.ara;

import java.util.List;
import java.util.Objects;

public class Xmichqner {
    private  String name ;
    private int price ;
    private  String description;
     private List<Integer> ingredientCostList;
     private boolean alcho ;
     private boolean shakeNoShake;
    private int drink_id;
    private String img;
    private boolean available;
    private boolean bnakanDrink;

    public Xmichqner(String name, int price, String description, List<Integer> ingredientCostList, boolean alcho, boolean shakeNoShake, int drink_id, String img, boolean available, boolean bnakanDrink) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.ingredientCostList = ingredientCostList;
        this.alcho = alcho;
        this.shakeNoShake = shakeNoShake;
        this.drink_id = drink_id;
        this.img = img;
        this.available = available;
        this.bnakanDrink = bnakanDrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getIngredientCostList() {
        return ingredientCostList;
    }

    public void setIngredientCostList(List<Integer> ingredientCostList) {
        this.ingredientCostList = ingredientCostList;
    }

    public boolean isAlcho() {
        return alcho;
    }

    public void setAlcho(boolean alcho) {
        this.alcho = alcho;
    }

    public boolean isShakeNoShake() {
        return shakeNoShake;
    }

    public void setShakeNoShake(boolean shakeNoShake) {
        this.shakeNoShake = shakeNoShake;
    }

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isBnakanDrink() {
        return bnakanDrink;
    }

    public void setBnakanDrink(boolean bnakanDrink) {
        this.bnakanDrink = bnakanDrink;
    }

    @Override
    public String toString() {
        return "Xmichqner{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", ingredientCostList=" + ingredientCostList +
                ", alcho=" + alcho +
                ", shakeNoShake=" + shakeNoShake +
                ", drink_id=" + drink_id +
                ", img='" + img + '\'' +
                ", available=" + available +
                ", bnakanDrink=" + bnakanDrink +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xmichqner xmichqner = (Xmichqner) o;
        return price == xmichqner.price && alcho == xmichqner.alcho && shakeNoShake == xmichqner.shakeNoShake && drink_id == xmichqner.drink_id && available == xmichqner.available && bnakanDrink == xmichqner.bnakanDrink && Objects.equals(name, xmichqner.name) && Objects.equals(description, xmichqner.description) && Objects.equals(ingredientCostList, xmichqner.ingredientCostList) && Objects.equals(img, xmichqner.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, ingredientCostList, alcho, shakeNoShake, drink_id, img, available, bnakanDrink);
    }
}
