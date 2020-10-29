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

	public void createMatrix() {

		first = new Box(0, 0);
		createRow(0, 0, first);

	}

	private void createRow(int i, int j, Box current) {
		createColumn(i, j + 1, current);
		if (i + 1 < n) {

			Box temp = new Box(i+1, j);
            current.setDown(temp);
            temp.setUp(current);
			
		}

	}

	private void createColumn(int i, int j, Box prev) {
		//System.out.println(j + " "+ m);
		if (j < m) {
			Box current = new Box(i, j);
			current.setPrev(prev);
			prev.setNext(current);
			createColumn(i, ++j, current);
		}
	}

	public void display() {

		
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

	public String display1(Box head) {
		String message = "";

		if (head != null) {

			display2(head);

			message = "\n";

			display1(head.getDown());
		}
		return message;
	}

	public String display2(Box right) {
		String message = "";

		if (right != null) {
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
