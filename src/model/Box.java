package model;

//Adapted of geeks for geeks and example of classroom
public class Box {

	private Box next;
	private Box prev;
	private Box up;
	private Box down;

	private int row;
	private int  colum;
	private char mirror;
	private String id;
	private boolean isStart;
	private boolean isEnd;
	

	public Box(int r, int c) {
		row = r;
		colum = c;

		next = null;
		prev = null;
		up = null;
		down = null;
		mirror = 'x';
		id = getRow() + "" + getColum();
		isStart = false;
		isEnd = false;
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
		return (char) ('A' + colum);
	}

	public void setColum(int colum) {
		this.colum = colum;
	}

	@Override
	public String toString() {
		String message;
		message = "[ " + getMirror() + " ]";
		
		if(isStart) {
			message = "[S]";
		}
		if(isEnd) {
			message = "[E]";
		}
       return message;
	}

	public char getMirror() {
		return mirror;
	}

	public void setMirror(char mirror) {
		this.mirror = mirror;
	}
	
	public  String getId() {
		return id;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	
}
