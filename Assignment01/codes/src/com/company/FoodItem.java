//package com.company;

public class FoodItem {

    private String foodName;
    private double cost, sellPrice;
    private int stockNum;

    // constructor
    public FoodItem(String foodName, double cost, double sellPrice, int stockNum){
        this.foodName = foodName;
        this.cost = cost;
        this.sellPrice = sellPrice;
        this.stockNum = stockNum;
    }

    // method to check the availability of the food item in stock
    /*
    A method isAvailable that checks if there are items available for selling
    (returns false is no items are available, true otherwise)
     */
    public boolean isAvailable(){
        return (stockNum > 0) ? true : false;
    }


    // method toString() to print String output if instance/object being called upon by name
    /* print food items, its selling price & its availability
    A toString method which returns a String containing the name of the food item and the selling price.
    If the item is not available, add “(SOLD OUT)” next to the price
     */
    public String toString(){
        if(isAvailable() == true){
            return "- " + foodName +
                    "\n$" + sellPrice;
        }
        else
            return "- " + foodName +
                    "\n$" + sellPrice + " (SOLD OUT)";

    }

    // method to set/override the selling price
    // updates the selling price instance variable
    public void setSellingPrice(double newPrice){
        this.sellPrice = newPrice;
    }

    // method to decrease/increase stock value of food item, affecting method of checking availability of item
    // A method decrementStock decrements the number of items in stock by 1
    // A method increaseStock that takes an amount of additional stock as a parameter,
    // and adds it to the existing stock available for selling.
    public void decrementStock() { stockNum--; }
    public void increaseStock(int stockAdd) { stockNum += stockAdd; }



    // method getSellingPrice for phase 3, to calculate totalPrice in Order class
    public double getSellingPrice(){
        return this.sellPrice;
    }


    // method returns the difference between the selling price and the cost of the FoodItem.
    public double getMarkup(){
        return sellPrice - cost;
    }




}// end FoodItem
