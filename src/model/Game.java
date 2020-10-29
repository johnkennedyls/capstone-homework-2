package model;

//Adapted geek for geeks to create double linked list matrix
public class Game {

	private Box first;

	private int n;
	private int m;
	private int k;
	private String nickName;

	public Game(int n, int m, int k, String nic) {
		first = null;
		this.n = n;
		this.m = m;
		this.k = k;
		nickName = nic;


	}

	

	public String display() {
         String message = "";		
         Box pointerDown = first;
		if (pointerDown == null) {
						
		}else {
			
			displayRow(pointerDown);
            message = "\n";		
			pointerDown = pointerDown.getDown();			
		}
		return message;
	}
	
	private String displayRow(Box pointerRight) {		
		String message = "";
		if (pointerRight == null) {
			
		}else {
			message = pointerRight + " ";
			displayRow(pointerRight.getNext());
		}
		return message;
	}
	
	
	

	
	public Box getFirst() {
		return first;
	}

	public void setFirst(Box first) {
		this.first = first;
	}

	//---------------------------------
	public void createMatrix() {
		createMatrix(0, 0, null);
	}

	private Box createMatrix(int i, int j, Box current) {
		if(i >= n || j >= m) {
			return null;
		}

		Box temp = new Box(i, j);
		if(first == null) {
			first = temp;
		}

		temp.setPrev(current);
		temp.setUp(current);
		temp.setNext(createMatrix(i, j + 1, temp));
		temp.setDown(createMatrix(i + 1, j , temp));
		return temp;
	}




}
