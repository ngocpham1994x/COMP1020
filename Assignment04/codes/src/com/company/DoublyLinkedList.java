/* *
 * [DoublyLinkedList]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [4]
 * QUESTION:
 *
 * PURPOSE: [Create a DoublyLinkedList class with methods]
 */

//Status of the class:  Phase 5 complete but Stacked Overflow

package com.company;

import java.io.*;
import java.util.*;

public class DoublyLinkedList
{
	/*
	The following code is provided. You are not allowed to modify it.
	*/
	
	//
	//Instance variables
	//
	private Node first;  //the first Node (or the top Node) of the list
	private Node last;  //the last Node of the list
	
	//
	//Instance methods
	//
	
	//accessor for the first Node
	public Node getFirst()
	{
		return first;
	}
	
	//accessor for the last Node
	public Node getLast()
	{
		return last;
	}
	
	
	/*
	End of the provided code.
	*/
	
	//Add your code below.

	//***PHASE 1***

	//A public void addFront(Number) method that adds a new Node containing the Number received
	// as a parameter to the beginning (front) of the list. This method does not require recursion
	public void addFront(Number num){
		if(first == null) {  //empty list
			first = new Node (num,null,null );
			last = first;
		}
		else {
			Node newNode = new Node(num, null, first);
			first.setPrevious(newNode);
			first = newNode;
		}
	}


	//A public void addEnd(Number) method that adds a new Node containing the Number received
	// as a parameter to the end of the list. This method does not require recursion.
	public void addEnd(Number num){
		if(last == null) {  //empty list
			last = new Node (num,null,null );
			first = last;
		}
		else {
			Node newNode = new Node(num, last, null);
			last.setNext(newNode);
			last = newNode;
		}
	}


	//A public int size() method. This method is the public interface to the sizeRec method described below.
	// This method must return the size of the list (i.e. how many nodes are in the list).
	public int size(){
		return sizeRec(first);
	}

	//A private int sizeRec(node) method.
	// This method will use recursive calls (to itself) to move through the list and count the number of nodes.
	private int sizeRec(Node node){
		if(node == null)
			return 0;
		return sizeRec( node.getNext() )+1;
	}

	//A public String toString() method.
	// This method is the public interface to the toStringRec method described below.
	// This method must return a String representation of the list, enclosed within the << and >> pairs of characters
	// (as in the example output shown below).
	public String toString(){
		return "<< " + toStringRec(first) + ">>";
	}


	//A private String toStringRec(node) method.
	// This method will use recursive calls (to itself) to move through the list and build a String representation of it.
	private String toStringRec(Node node){
		if(node == null)
			return "";
		return node.getData() + " " + toStringRec( node.getNext() );
	}

	//A public String toStringReversed() method. This method is the public interface to the toStringReversedRec method
	// described below. The goal of this method is to return a String representation of the list
	// (also using the << and >> pairs of characters), but in reverse order (i.e. starting from the end of the list).
	public String toStringReversed(){
		return "<< " + toStringReversedRec(last) + ">>";
	}


	//A private String toStringReversedRec(node) method. T
	// his method will use recursive calls (to itself) to move through the list (in the reverse order)
	// and build a String representation of it.
	private String toStringReversedRec(Node node){
		if(node == null)
			return "";
		return node.getData() + " " + toStringReversedRec( node.getPrevious() );
	}


	//***PHASE 2***

	//A public static DoublyLinkedList createList(String) method. The ultimate goal of this method is to create and return
	// a new DoublyLinkedList based on the parsing of a file (the filename is the received String parameter).
	//This method must open the file represented by the filename parameter using a Scanner (this is important for the next steps).
	// Then, it must call the recursive method parseScanner described below.
	// Your method must handle the type of exception thrown by doing this here, with an appropriate try-catch
	// (do not add a “throws” statement to the signature of this method, otherwise the automated tests will fail).
	public static DoublyLinkedList createList(String filename) {
		DoublyLinkedList newList = new DoublyLinkedList();
		try {
			Scanner inFile = new Scanner(new File(filename));
			parseScanner(inFile, newList);
			inFile.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return newList;

	}

	//A private static void parseScanner(Scanner, DoublyLinkedList) method.
	// This method will use recursive calls (to itself) to move through the Scanner received as a parameter and add to the list
	// received as a parameter. This method must add to the list only the tokens read from the file (through the Scanner)
	// that correspond to either an Integer, a Long or a Double. All other tokens must simply be ignored.
	// In the end, the list must be in the same order as in the file.
	private static void parseScanner(Scanner theInFile, DoublyLinkedList theNewList) {
		if(!theInFile.hasNext()) { return;}
		else {
			if (theInFile.hasNextInt()) {
				theNewList.addEnd(theInFile.nextInt());
				parseScanner(theInFile, theNewList);
			}
			else if (theInFile.hasNextLong()) {
				theNewList.addEnd(theInFile.nextLong());
				parseScanner(theInFile, theNewList);
			}
			else if (theInFile.hasNextDouble()) {
				theNewList.addEnd(theInFile.nextDouble());
				parseScanner(theInFile, theNewList);
			}
			else {
				theInFile.next();
				parseScanner(theInFile, theNewList);
			}
		}
	}


	//***PHASE 3***

	//A private void removeNode(Node) method. This method does not use recursion.
	// The goal of this method is to remove from the current list the Node that is received as a parameter
	// (you can assume that the Node is for sure in this list).
	// This method will be useful for other methods in this assignment, including the methods below.
	//(note that index 0 corresponds to the first Node). It must also return the Node that was just removed.
	// If there is no Node at that index, or if the index received is a negative number,
	// an IndexOutOfBoundsException must be thrown (you can do that here and/or in the recursive method below).
	private void removeNode(Node node){
		//case 1: if node is the first node
		if (node.getPrevious() == null) {
			this.first = node.getNext();  //set the first pointer to the given node's next node

			//the "new first node"
			if (this.first != null) 		// Set the new first node's previous node to null, if the new first node is not null yet
				this.first.setPrevious(null);

			else if (this.first == this.last)   // if there is one item in the list, then first = last = null
				this.last.setPrevious(null);

			else if (this.first == null)
				this.last = null; 				// if first is null that means that the list is empty, so set last node as null

		}

		//case 2: if node is the last node
		else if (node.getNext() == null) {
			this.last = node.getPrevious(); // Set the previous node to last

			//the "new last node"
			if (this.last != null)     	// Set the new last node's next node to null, if the new last node is not null yet
				this.last.setNext(null);

			else if (this.last == this.first) // if there is one item in the list, then first = last = null
				this.first.setNext(null);

			else if (this.last == null) // empty list, set first as null
				this.first = null;

		}

		//case 3: if the node that we want to remove is in the middle
		else {
			Node prevNode = node.getPrevious();
			prevNode.setNext(node.getNext()); // set the previous node's next to node's next to skip the removed-node

			Node nextNode = node.getNext();
			nextNode.setPrevious(node.getPrevious()); // set the next node's previous to node's prev to skip the removed-node
		}
	}

	//A public Node remove(int) method.
	// This method is the public interface to the removeRec method described below.
	// The goal of this method is to remove the Node that is at the index (i.e. position) received as a parameter
	public Node remove(int index){   //interface method
		if (index < 0)  //if the index received is a negative number
			throw new IndexOutOfBoundsException();

		Node node = removeRec(first, 0, index);  //starting from first node, index 0

		if (node == null) //If there is no Node at that index
			throw new IndexOutOfBoundsException();
		else
			return node; //return the Node that was just removed
	}


	//A private Node removeRec(node, current, index) method.
	// This method will use recursive calls (to itself) to move through the list and remove the correct Node (and return it).
	// Choose parameter(s) that will allow you to do that.
	private Node removeRec(Node node, int current, int index){
		// easy case: if node is null, means pointer is at last node of the list
		// and still not able to find the node to remove,
		// meaning the index is greater than the total number of nodes in the list
		if (node == null)
			return null;

		if (current == index) {   	//if "current" is equal to index
			removeNode(node);   	//remove node from the list
			return node;			//return node
		}

		//advance (move on) to the next node, keep the same index
		return removeRec(node.getNext(), current + 1, index);
	}



	//***PHASE 4***

	//A public Node findMax() method. This method is the public interface to the findMaxRec method described below.
	// The goal of this method is to return the largest Node in the list, using the compareTo method of the Node class.
	// If the list is empty, it should simply return null.
	public Node findMax(){   //interface
		if(first == null)    //if the list is empty
			return null;
		else
			return findMaxRec(first, first.getNext());   //same idea as Math.max(a,b)
	}

	//A private Node findMaxRec(node, nextNode) method.
	// This method will use recursive calls (to itself) to move through the list and return the largest Node in the list
	// (using the compareTo method of the Node class). Choose parameter(s) that will allow you to do that.
	private Node findMaxRec(Node node, Node nextNode){
		Node maxNode = node;
		if (nextNode == null)   //if there is one item in the list
			return maxNode;
		if ( nextNode.compareTo(maxNode) > 0 )	//same idea as Math.max(a,b)
			maxNode = nextNode;
		return findMaxRec(maxNode, nextNode.getNext());		//advance to nextNode
	}


	//***PHASE 5***

	//A public void orderedInsertRec(Node toInsert, Node current) method.
	// This method is recursive, but we will not create an interface for this one.
	// We will keep this method public here, because we want to be able to test it independently.
	// For that reason, we also provide the required parameters: one Node that must be inserted,
	// and the current Node, representing where to start the ordered insertion process.
	//The goal of this method is to make an ordered insertion of the toInsert Node,
	// following the rules of the compareTo method defined in the Node class,
	// following an ascending order from left to right.
	// A call to this method would only affect the portion of the list starting from the first Node (of the list)
	// to the current Node (the parameter). In other words, this recursive method is moving through the list backwards
	// starting from the given current Node, and inserts the toInsert Node as soon as it finds the right spot for it.
	public void orderedInsertRec(Node toInsert, Node current){

		//case: items in list

			if(current == null){		//base case: add front
//				toInsert.setNext(this.first);
//				this.first.setPrevious(toInsert);
//				this.first = toInsert;
				addFront(toInsert.getData());
			}

			else if (current.compareTo(toInsert) < 0 && current != last){		//base case: add middle
				current.getNext().setPrevious(toInsert);
				toInsert.setNext(current.getNext());
				toInsert.setPrevious(current);
				current.setNext(toInsert);
			}
			else if(current.compareTo(toInsert) < 0 && current == last){		//base case: add last
//				toInsert.setPrevious(current);
//				current.setNext(toInsert);
//				this.last = toInsert;
				addEnd(toInsert.getData());
			}

			else if(current.compareTo(toInsert) > 0)
				orderedInsertRec(toInsert, current.getPrevious());
		}



	//A public void insertionSort() method.
	// This method is the public interface to the insertionSortRec method described below.
	// The goal of this method is to implement a recursive insertion sort algorithm,
	// which will result in the full list being sorted in ascending order.
	public void insertionSort(){
		if (first == null || first == last) //empty list or list with only 1 element, nothing to do
			return;
		insertionSortRec(this.first);
	}


	//A private void insertionSortRec() method.
	// This method will use recursive calls (to itself) to move through the list,
	// take the current Node and insert it in the right spot inside the sorted part of the list (it will be on the left),
	// following the traditional insertion sort algorithm. Of course you should make use of the orderedInsertRec method here,
	// and maybe other method(s) defined previously in this assignment. This method should be quite short.
	// If you have more than 6-8 lines of code here, rethink your approach.


	// idea is to have 2 params 2 small lists within the big list.
	//lastSortedNode is the last node on the sorted side of the list (left side)
	//nonSortedNode is the first node on the non-sorted side of the list (right side)
	private void insertionSortRec(Node nonSortedNode){
		if(nonSortedNode == null)
			return;
		else {
			Node nextNode = nonSortedNode.getNext();	// prep for next run of recursion
//			lastSortedNode.setNext(nextNode);
//			nextNode.setPrevious(lastSortedNode);
//			nonSortedNode.setNext(null);
//			nonSortedNode.setPrevious(null);
			removeNode(nonSortedNode);
			orderedInsertRec(nonSortedNode,nonSortedNode.getPrevious());
			insertionSortRec(nextNode);  // next node of non-sorted
		}
	}



}//end class DoublyLinkedList

