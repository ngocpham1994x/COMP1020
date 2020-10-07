//package com.company;

public class Order {

    // The order number shall have 6 digits, and start with a 9.
    // Every order should have a distinct order number, starting from 900001, then 900002, then 900003 and so on
    private static int orderNum = 900001;  // class variable for initialize order number

    // Instance variables (7)
    private int instanceOrderNum;   // instance variable for instance order number
    private Customer customer;
    private Restaurant restaurant;
    private FoodApp foodApp;
    private FoodItem[] foodItem;
    private int foodItemPopulation;  // total number of items ordered
    private double totalPrice;

    private static final int MAX_ITEMS = 10;

    // constructor
    public Order(Customer customer, Restaurant restaurant, FoodApp foodApp){
        this.customer = customer;
        this.restaurant = restaurant;
        this.foodApp = foodApp;
        foodItem = new FoodItem[MAX_ITEMS];
        foodItemPopulation = 0;
        totalPrice = 0;
        instanceOrderNum = orderNum;   // store instance order number
        orderNum++;   // increment every time new order comes in
    }



    /*
    method that adds the FoodItem received as a parameter to the FoodItem array,
    only if it is available (i.e. not sold out) and if there is space left in the array.
    If the FoodItem was added, the method returns true (it returns false otherwise).
    You can assume that the FoodItem belongs to the restaurant’s menu (no need to check if it’s on the menu)
    Update here: the amount in stock for the FoodItem (decrement by 1), the total price of the order, and the total number of items ordered.
     */
    public boolean addToOrder(FoodItem foodItem){
        if(foodItem.isAvailable() && foodItemPopulation < 10){
            this.foodItem[foodItemPopulation] = foodItem;
            foodItemPopulation++;
            foodItem.decrementStock();
            totalPrice += foodItem.getSellingPrice();
            return true;
        }
        else
            return false;
    }



    // method toString() containing the FoodApp name, the order #, the customer name,
    // the Restaurant name, the list of items ordered and the total price
    // created getter methods in other classes to obtain the names
    public String toString(){
        String items = "";
        String price = "\nTotal price: $" + totalPrice;

        for(int i = 0; i<foodItemPopulation; i++){
            items += "\n" + foodItem[i];
        }

        String s = "-- " + foodApp.getFoodAppName() + " order #" + instanceOrderNum +
                "\nFor customer " + customer.getCustomerName() + " with restaurant " + restaurant.getRestaurantName() +
                items + price;


        return s;
    }


    //method that will simply call the fillOrder and the updateRecentOrders in the Restaurant and Customer classes
    // respectively with the appropriate parameters
    // fillOrder will update the profit of the restaurant and
    // updateRecentOrder will get 3 most recent orders to appear in customer array of orders
    public void submitOrder(){
        restaurant.fillOrder( totalPrice , foodItem , foodItemPopulation , foodApp.getFeePercentage() );
        customer.updateRecentOrders( this );
    }



}// end Order
