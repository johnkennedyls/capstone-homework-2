package model;

import java.util.Random;

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
		
	public  void display() {
        Box pointerRight;
        Box pointerDown = first;
        while (pointerDown != null) {

            pointerRight = pointerDown;
            while (pointerRight != null) {
                System.out.print(pointerRight + " ");
                pointerRight = pointerRight.getNext();
            }

            System.out.println();
            pointerDown = pointerDown.getDown();
        }
    }
		
	public Box getFirst() {
		return first;
	}

	public void setFirst(Box first) {
		this.first = first;
	}

	/*
	 * 
	 */
	public void createMatrix() {
		createMatrix(0, 0, null);
	}

	private Box createMatrix(int i, int j, Box current) {
		if(i >= n || j >= m) {
			return null;
		}
		

		Box temp = new Box(i+1, j);
		
		if(first == null) {
			first = temp;
		}

		temp.setPrev(current);
		temp.setUp(current);
		temp.setNext(createMatrix(i, j + 1, temp));
		temp.setDown(createMatrix(i + 1, j , temp));
		return temp;
	}
	
	public boolean getRamdom() {
		boolean has = false;
		Random r = new Random();
		has = r.nextBoolean();
		return has;
	}
	
	public char selectMirror(){
		
		if(getRamdom()) {
			return 'R';
		}
		return 'L';
		
	}
	
	public void generateMirror() {
		int counter = 0;
		
		if(first != null && counter == k ) {
			
		}
	}
	
	
    public String toString() {
    	String msg = "";
    	msg = toStringRow(first);   	
    	return msg;
    }





	private String toStringRow(Box firstRow) {
		String msg = "";
		if(firstRow != null) {
			msg = toStringCol(firstRow) +"\n";
			msg += toStringRow(firstRow.getDown());
		}
		
		return msg;
	}





	private String toStringCol(Box current) {
		String msg = "";
		if(current != null) {
			msg += current.toString();
			msg += toStringCol(current.getNext());
		}
		
		return msg;
	}



}
