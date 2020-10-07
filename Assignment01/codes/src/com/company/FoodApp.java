//package com.company;

public class FoodApp {

    private static final int MAX_CUSTOMERS = 100;
    private String foodAppName;
    private double fee;
    private Customer[] customersArr;
    private int population;


    public FoodApp(String foodAppName, double fee){
        this.foodAppName = foodAppName;
        this.fee = fee;
        customersArr = new Customer[MAX_CUSTOMERS];
        population = 0;
    }

    /*
    A method getCustomerIndex(Customer) that looks for and returns the index of the customer given as
    a parameter in the array of customers, using the equals method of the Customer class.
    The method must return -1 if the customer is not found in the array
     */
    // note that the execution order of methods (getCustomerIndex & addCustomer) does not have to be like this.
    // method is executed only when being called upon. This case getCustomerIndex() is called from addCustomer,
    // it's ok that there is no customer in the customerArr[] at the moment to get index because it won't be
    // assigned index until later - being called by addCustomer() method
    public int getCustomerIndex(Customer otherCustomer) {
        int index = -1;
        for (int i = 0; i < population; i++) {    // iterate through the population only!
            if (otherCustomer.equals(customersArr[i]))
                index = i;
        }
        return index;
    }

    /*
    An addCustomer(Customer) method that adds the Customer to the customer array,
    only if the customer is not already present, and returns true if the customer was added.
    If there is already a customer with the same email address, the method should simply return false.
    You can assume that there will be enough space to add the customer otherwise (no checks required for space)
     */
    public boolean addCustomer(Customer otherCustomer){
        int index = getCustomerIndex(otherCustomer);
        if(index == -1){
            {
                customersArr[population]=otherCustomer;
                population++;   // update size of the array
            }
            return true;
        }
        else
            return false;
    }

    /*
    A removeCustomer(Customer) method that removes the specified customer from the customer array,
    only if it is found (following again the equals rule of the Customer class).
    The method returns true if a customer is removed, and false otherwise.
    When removing a customer, you must fill in the gap by shifting up all the following customers.
     */
    public boolean removeCustomer(Customer otherCustomer){
        int index = getCustomerIndex(otherCustomer);
        if(index != -1){
            customersArr[index]=null;
            for (int i=index;i<population;i++)    // shifting the order of the customers
                customersArr[index] = customersArr[index + 1];
            population--;   // update size of the array
            return true;
        }
        else
            return false;
    }


    // A toString method that returns a String containing the name of the FoodApp,
    // the number of customers and the list of those customers
    public String toString(){
        String s = "-- FoodApp " + foodAppName +
                "\n" + population + " customer(s) registered:";
        for (int i=0; i<population; i++){
            if(i<population-1)
                s += "\n" + customersArr[i];
            if(i==population-1)
                s += "\n" + customersArr[i] + "\n";
        }
        return s;
    }


    // method getFoodAppName for phase 3, to print out in Order class
    public String getFoodAppName(){
        return this.foodAppName;
    }


    // method getFee for phase 4, to get the fee charged for using app
    // this fee is in percentage
    public double getFeePercentage(){
        return this.fee;
    }


} // end FoodApp
