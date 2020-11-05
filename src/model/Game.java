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
	public int Score;

	public Game(int n, int m, int k, String nic) {
		first = null;
		this.n = n;
		this.m = m;
		this.k = k;
		nickName = nic;
		tempMirrors = 0;
		createMatrix();
	}
	
	

	public int getScore() {
		return Score;
	}



	public void setScore(int score) {
		Score = score;
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

private void createMatrix() {
		first= new Box(0, 0);
		createRow(0,0,first);
	}

	

	private void createRow(int i, int j, Box firstRow) {
		
		createCol(i,j+1,firstRow,firstRow.getUp());
		if(i+1 < n) {
			Box downFirstRow = new Box(i +1, j);
			downFirstRow.setUp(firstRow);
			firstRow.setDown(downFirstRow);
			createRow(i + 1, j, downFirstRow);
		}
	}

	private void createCol(int i, int j, Box prev, Box rowPrev) {
		if(j < m) {
			Box current = new Box(i, j);
			current.setPrev(prev);
			prev.setNext(current);
			
			if(rowPrev != null) {
				rowPrev = rowPrev.getNext();
				current.setUp(rowPrev);
				rowPrev.setDown(current);
			}
			createCol(i, j + 1, current, rowPrev);
		}
		
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
			System.out.println(current.getId());
			if (current.getMirror() == 'R' || current.getMirror() == 'L') {
				generateMirrors();
			}else {
				current.setMirror(selectMirror());
				
				System.out.println("         el getMirror es: " + current.getMirror());
				
				
				setTempMirrors(++tempMirrors);
				generateMirrors();
			}

			
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

	private void sideShoot(String boxShooter) {
		// TODO Auto-generated method stub
		
	}

	private void normalShoot(String idShooter) throws MiddleBoxException {
		System.out.println("Entra en normal shoot");
		Box boxShooter = searchBox(idShooter);
		if (boxShooter.getUp() != null && boxShooter.getDown() != null && boxShooter.getNext() != null
				&& boxShooter.getPrev() != null) {
			
			throw new MiddleBoxException(idShooter);
		} else {
              Box current =  searchBox(idShooter);
               if(current.getUp() == null) {
            	   System.out.println("Entra en sendDown");
            	  // shootDown(current);
               }
               else if(current.getPrev() == null) {
            	   shootRight(current);
               }
               else if(current.getNext() == null) {
            	 //  shootLeft(current);
               }else {
            	  // shootUp(current);
               }
		}

	}
	
	
	public  Box shootRight(Box box) {
      char mirror = box.getMirror();
        if (mirror != 'x') {
            if (mirror =='L') {
                return shootDown(box);
            } else {
                return shootUp(box);
            }
        }
        if (box.getNext() == null) {
            return box;
        }
        return shootRight(box.getNext());
    }

    public  Box shootUp(Box box) {
        System.out.println(box);
        if (box.getUp() == null) {
            return box;
        }
        return shootUp(box.getUp());
    }

    public  Box shootDown(Box box) {
        if (box.getDown() == null) {
            return box;
        }
        return shootDown(box.getDown());
    }

    public  Box shootLeft(Box box) {
        if (box.getPrev() == null) {
            return box;
        }

        return shootLeft(box.getPrev());
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
		int randomRow = (int) (Math.random() * (n - 1 + 1) + 0);
		int randomCol = (int) (Math.random() * (m - 1 + 1) + 0);

		char col = (char) ('A' + randomCol);
		String id = randomRow + "" + col;
		return id;

	}
}
