package model;

import java.util.Random;

import exceptions.MiddleBoxException;

//Adapted geek for geeks to create double linked list matrix
public class Game {

	private Box first;

	private int n;
	private int m;
	private int k;
	private String nickName;
	private int tempMirrors;

	public Game(int n, int m, int k, String nic) {
		first = null;
		this.n = n;
		this.m = m;
		this.k = k;
		nickName = nic;
		tempMirrors = 0;
	}

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

	public void generateMirrors() {

		if (k > tempMirrors) {
			Box current = searchBox(generateId());
			current.setMirror(selectMirror());
			setTempMirrors(++tempMirrors);
			generateMirrors();
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

	public void startShoot(String boxShooter) throws MiddleBoxException {
		if (boxShooter.length() == 2) {
			normalShoot(boxShooter);
		} else {
			sideShoot(boxShooter);
		}
	}

	private void normalShoot(String idShooter) throws MiddleBoxException {
		Box boxShooter = searchBox(idShooter);
		if (boxShooter.getUp() != null && boxShooter.getDown() != null && boxShooter.getNext() != null
				&& boxShooter.getPrev() != null) {
			throw new MiddleBoxException(idShooter);
		} else {

		}

	}

	public Box searchBox(String id) {
		Box searched = null;
		if (first != null) {
			if (first.getId().equals(id)) {
				searched = first;

			} else {
				searched = searchRow(id, first);
			}
		}
		return searched;
	}

	private Box searchRow(String id, Box current) {
		if (current != null && current.getId().equals(id)) {
			return current;
		}
		if (searchColumn(id, current) == null && current != null) {
			return searchRow(id, current.getDown());
		}
		return searchColumn(id, current);
	}

	private Box searchColumn(String id, Box current) {
		if (current == null) {
			return null;
		}
		if (current != null && current.getId().equals(id)) {
			return current;
		} else if (current.getNext() == null) {
			return null;
		}
		return searchColumn(id, current.getNext());
	}

	/**
	 * double random_double = Math.random() * (max - min + 1) + min;
	 * 
	 * int random_int = (int)(Math.random() * (max - min + 1) + min);
	 * 
	 * @return
	 */

	public String generateId() {
		int randomRow = (int) (Math.random() * (n - 1 + 1) + 1);
		int randomCol = (int) (Math.random() * (m - 1 + 1) + 0);

		char col = (char) ('A' + randomCol);
		String id = randomRow + "" + col;
		return id;

	}
}
