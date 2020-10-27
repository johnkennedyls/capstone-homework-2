package model;
//Adapted geek for geeks to create double linked list matrix
public class Game {
	
	private Box first;

	private int n;
	private char m;	
	private int k;
	private String nickName;
	
	public Game(int n, char m, int k, String nic) {
		first = null;
		this.n = n;
		this.m = m;
		this.k = k;
		nickName = nic;
		
		
		
	}
	
	public Box createMatrix(int n2, char m2) {
		return createMatrix(n2, m2,first);
	}

	private Box createMatrix(int i, char j, Box current) {
		

        if (i >= n || j >= m) { 
            return null; 
        } 
		
		Box temp = new Box(i,j);
		
		temp.setPrev(current);
		temp.setUp(current);
		temp.setNext(createMatrix(i, (char)(j + (char)1), current));
		temp.setPrev(createMatrix(i+1, j, current));
		
		return current;
	}
	
	
	public void display(Box head) {
		
		Box down= head;
		display1(down);
	}
	
	public String display1(Box head) {
		String message = "";
		Box right;
		Box down = head;
		if(down != null) { 
		      
	            right = down; 
	      
	             display2(right);
	      
	            message = "\n" ;
	            down = down.getDown(); 
	            display1(down);
	        } 
		return message;
	}
	
	public String display2(Box right) {
		String message = "";
		 
       if(right!=null) { 
           message = "[ ]"; 
            right = right.getNext();
            display2(right);
        }
		return message;

	}

	public Box getFirst() {
		return first;
	}

	public void setFirst(Box first) {
		this.first = first;
	}
	
	
	
	
}
