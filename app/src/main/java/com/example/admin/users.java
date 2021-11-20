package com.example.admin;

public class users {
    String fruitName;
    String fruitUnit;
    String unit;

    public String getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(String fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    String fruitPrice;

    public users(String fruitName, String fruitUnit, String unit, String fruitPrice) {
        this.fruitName = fruitName;
        this.fruitUnit = fruitUnit;
        this.unit = unit;
        this.fruitPrice =fruitPrice;

    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitUnit() {
        return fruitUnit;
    }

    public void setFruitUnit(String fruitUnit) {
        this.fruitUnit = fruitUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }



    public users()
    {

    }

}

