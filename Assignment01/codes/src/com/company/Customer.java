//package com.company;

public class Customer {

    private String customerName, emailAdd, streetAdd;
    private int MAX_ORDERS = 3;
    private Order[] customerOrder;

    // constructor
    public Customer(String customerName, String emailAdd, String streetAdd){
        this.customerName = customerName;
        this.emailAdd = emailAdd;
        this.streetAdd = streetAdd;
        this.customerOrder = new Order[MAX_ORDERS];
    }

    // method toString() to print String output if instance/object being called upon by name
    // print Customer information
    public String toString(){
        String s = "-Customer " + customerName +
                "\nEmail: " + emailAdd +
                "\nAddress: " + streetAdd ;
        return s;
    }

    /*
    An equals method that checks if two customers are equal.
    Two customers are equal if they have the same email address, since an email address should belong to only 1 customer.
     */
    public boolean equals(Customer otherCustomer){
        if(this.emailAdd == null)
            this.emailAdd = otherCustomer.emailAdd;
            return this.emailAdd.equals(otherCustomer.emailAdd);
    }


    // method getCutomerName for phase 3, to print out in toString() method in Order class
    public String getCustomerName(){
        return this.customerName;
    }


    /*
    which takes a new Order as a parameter, and adds it to the array of most recent orders.
    The rank of the orders should always be preserved, in such a way that we can print them
    from most recent to oldest. When the array is already full, update the array so that
    the oldest order gets removed and the most recent one gets added in, conserving the full ordering.
     */
    public Order[] updateRecentOrders(Order newOrder){
        for (int i = MAX_ORDERS-1; i>0; i--)
            customerOrder[i] = customerOrder[i-1];
        customerOrder[0]=newOrder;

        return customerOrder;
    }


    /*
    method returns a String representation of the most recent orders,
    preceded by “Recent orders of customer [Customer name]”.
    Follow the formatting shown in the example below exactly.
    The orders must be ordered from most recent to oldest.
     */
    public String getStringRecentOrders(){
        String s = "Recent orders of customer " + customerName + "\n";
        String order = "";

        for (int i = 0; i<MAX_ORDERS; i++)
            if(customerOrder[i] != null)
                order += customerOrder[i] +"\n";
        return s + order;
    }

}// end Customer
