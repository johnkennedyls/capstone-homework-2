package model;

import java.util.Random;
import exceptions.midleBoxException;

//Adapted geek for geeks to create double linked list matrix
public class Game {

	private Box first;

	private int n;
	private int m;
	private int k;
	private String nickName;
	private int tempMirrors;

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getN() {
		return n;
	}

	public String getNickName() {
		return nickName;
	}

	public void setTempMirrors(int tempMirrors) {
		this.tempMirrors = tempMirrors;
	}

	public Game(int n, int m, int k, String nic) {
		first = null;
		this.n = n;
		this.m = m;
		this.k = k;
		nickName = nic;
		tempMirrors = 0;
	}

	public int getTempMirrors() {
		return tempMirrors;
	}

	public Box getFirst() {
		return first;
	}

	public void setFirst(Box first) {
		this.first = first;
	}

	public void createMatrix() {
		createMatrix(0, 0, null);
	}

	private Box createMatrix(int i, int j, Box current) {
		if (i >= n || j >= m) {
			return null;
		}

		Box temp = new Box(i + 1, j);
		if (k > tempMirrors) {
			generateMirror(temp);

		}
		if (first == null) {
			first = temp;
		}

		temp.setPrev(current);
		temp.setUp(current);
		temp.setNext(createMatrix(i, j + 1, temp));
		temp.setDown(createMatrix(i + 1, j, temp));
		return temp;
	}

	public boolean getRamdom() {
		boolean has = false;
		Random r = new Random();
		has = r.nextBoolean();
		return has;
	}

	public char selectMirror() {

		if (getRamdom()) {
			return 'R';
		}
		return 'L';

	}

	public void generateMirror(Box temp) {
		if (getRamdom()) {
			temp.setMirror(selectMirror());
			tempMirrors++;
		}
	}

	public String toString() {
		String msg = "";
		msg = toStringRow(first);
		return msg;
	}

	private String toStringRow(Box firstRow) {
		String msg = "";
		if (firstRow != null) {
			msg = toStringCol(firstRow) + "\n";
			msg += toStringRow(firstRow.getDown());
		}

		return msg;
	}

	private String toStringCol(Box current) {
		String msg = "";
		if (current != null) {
			msg += current.toString();
			msg += toStringCol(current.getNext());
		}

		return msg;
	}

	public void startShoot(String boxShooter) {
		if (boxShooter.length() == 2) {
			normalShoot(boxShooter);
		} else {
			sideShoot(boxShooter);
		}
	}

	private void normalShoot(String boxShooter) {
		
   	 if(boxShooter.startsWith("1") ||
   			 boxShooter.startsWith(getN()+"") ||
   			 boxShooter.endsWith("A") ||
   			 boxShooter.endsWith(mParseString(boxShooter))
   		 ) {  
   		 throw new midleBoxException();
	}

}

	private String  mParseString(String boxShooter) {
   	 
   	 String m = boxShooter.substring(1, 1);
   		int mNumber = Integer.parseInt(m);
   		char mChar = (char) ('A' + mNumber);
   		String mString = Character.toString(mChar);
   		return mString;
    }
	
}
