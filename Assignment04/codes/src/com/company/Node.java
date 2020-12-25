/* *
 * [Node]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [4]
 * QUESTION:
 *
 * PURPOSE: [Create a Node class.]
 */

//Status of the class: this class is complete as per assignment

package com.company;

public class Node
{
	/*
	The following code is provided. You are not allowed to modify it.
	*/
	
	//
	//Instance variables
	//
	private Number data; //the data stored in the node must be a subclass of Number (in our assignment, it could be either an Integer, Double or Long)
	
	private Node previous;  //a link to the previous Node
	private Node next;  //a link to the next Node
	
	
	//
	//Constructor
	//
	public Node(Number data, Node previous, Node next)
	{
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
	
	
	//
	//Instance methods
	//
	
	//accessor for the data
	public Number getData()
	{
		return data;
	}
	
	//accessor for the previous Node
	public Node getPrevious()
	{
		return previous;
	}
	
	//accessor for the next Node
	public Node getNext()
	{
		return next;
	}
	
	//mutator for the previous Node
	public void setPrevious(Node newPrev)
	{
		previous = newPrev;
	}
	
	//mutator for the next Node
	public void setNext(Node newNext)
	{
		next = newNext;
	}
	
	/*
	End of the provided code.
	*/
	
	//Add your code below.
	
	
	//***PHASE 4***

	//A public int compareTo(Node) method that will compare this Node with the Node received as a parameter.
	// As usual, the compareTo method must return an int value that is either a negative int, a positive int or 0,
	// depending on whether this Node is smaller, greater or equal (respectively) to the Node received as a parameter.
	// use the ‘data’ instance variable to compare Nodes. Note that the type of the ‘data’ instance variable is Number,
	// and the Number class does not define a compareTo method.
	// You will have to follow these rules to compare the different possible subtypes of Numbers that can be stored in ‘data’:
	// o When comparing Nodes that contain different subtypes, we will always follow this ordering of subtypes:
	// Integer < Long < Double.
	// So for example, a Node containing an Integer will always be smaller than a Node containing a Long, no matter what the actual values are
	// (e.g. 2 < 1L in our system).
	// o When comparing Nodes that contain the same subtype of Number, an actual comparison of the values must be made
	// to determine the order.
	public int compareTo(Node node) {
		//Integer < Long < Double
		//case 1: the current node is Integer
		if (this.data instanceof Integer) {

			if (node.data instanceof Integer)            // if the given-node's data is also an Integer
//				return this.data.intValue() - node.data.intValue();
				return ((Integer)this.data).compareTo((Integer)node.data);
			else                                        // if the given-node's data is either Long or Double, then this.data is always smaller than node.data
				return -1;

		}

		//case 2: the current node is Long
		else if (this.data instanceof Long) {

			if (node.data instanceof Long)				// if the given-node's data is also a Long
//				return (int) (this.data.longValue() - node.data.longValue());
				return ((Long)this.data).compareTo((Long)node.data);
			else if (node.data instanceof Integer)		// if the given-node's data is an Integer: Integer < Long < Double
				return 1;
			else 		// if the given-node's data is a Double: Integer < Long < Double
				return -1;
		}

		//case 3: the current node is Double
		else if (this.data instanceof Double) {

			if (node.data instanceof Double)			// if the given-node's data is also a Double
//				return (int) (this.data.doubleValue() - node.data.doubleValue());
				return ((Double)this.data).compareTo((Double)node.data);
			else										// if the given-node's data is either Integer or Long, then this.data is always greater than node.data
				return 1;
		}

		else
			return -1;
	}

}
