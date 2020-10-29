package model;

//Adapted of gee
public class Box {
	
	private Box next;
	private Box prev;
	private Box up;
	private Box down;
	
	private int row;
	private char colum;
	
	public Box(int r, int c) {
		row = r;
		colum = (char) ('A' + c);
		
		next = null;
		prev = null;
		up = null;
		down = null;
	}

	public Box getNext() {
		return next;
	}

	public void setNext(Box next) {
		this.next = next;
	}

	public Box getPrev() {
		return prev;
	}

	public void setPrev(Box prev) {
		this.prev = prev;
	}

	public Box getUp() {
		return up;
	}

	public void setUp(Box up) {
		this.up = up;
	}

	public Box getDown() {
		return down;
	}

	public void setDown(Box down) {
		this.down = down;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public char getColum() {
		return colum;
	}

	public void setColum(char colum) {
		this.colum = colum;
	}
	
	@Override
	public String toString() {
		return "[ ]";
		
	}
	
	
	
	
	
	
}
