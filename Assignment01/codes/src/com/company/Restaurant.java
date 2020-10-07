//package com.company;

public class Restaurant {

    private String restaurantName;
    private double profit;
    private FoodItem[] menu;  // the array size and content of FoodItem[] menu are given

    // constructor
    public Restaurant(String restaurantName, FoodItem[] menu){
        this.restaurantName = restaurantName;
        this.menu = menu;
    }

    // printing the Restaurant, its profit, its given menu if the instance/object being called upon by name
    // method loops through the menu to have a complete given menu printed
    public String toString(){
        String s = "-- Restaurant " + restaurantName +
                "\nProfit = " + profit +
                "\nMenu: \n";
        for (int i = 0; i< menu.length; i++)
            s += menu[i] + "\n";
        return s;

    }


    // method getRestaurantName for phase 3, to print out in toString() method in Order class
    public String getRestaurantName(){
        return this.restaurantName;
    }


    /*
    This method updates the profit instance variable of the restaurant using the parameters representing the order.
    The profit on the order corresponds to the sum of markups on all the FoodItems minus the fees percentage paid to
    the FoodApp on the total price of the order. You can assume that the FoodItems array will not be empty
     */
    public double fillOrder(double totalPrice, FoodItem[] foodItem, int foodItemPopulation, double fee){
        double sumMarkups = 0;
        for(int i=0; i < foodItemPopulation; i++){ sumMarkups += foodItem[i].getMarkup(); }

        double appFee = 0;
        appFee = totalPrice * fee;

        profit = sumMarkups - appFee;

        return profit;
    }


}// end Restaurant
