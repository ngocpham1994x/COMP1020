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
	
	
	
	
}