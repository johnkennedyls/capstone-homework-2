package model;

public class ScoreGame {
      private int score;
      private String nickName;
      Game g;
      
      private ScoreGame left;
      private ScoreGame right;
      private ScoreGame parent;
      
      public ScoreGame() {
    	  score = g.getScore();
    	  nickName = g.getNickName();
    	  
    	  left = null;
    	  right = null;
    	  parent = null;
      }

	public int getScore() {
		return score;
	}

	public String getNickName() {
		return nickName;
	}

	public ScoreGame getLeft() {
		return left;
	}

	public void setLeft(ScoreGame left) {
		this.left = left;
	}

	public ScoreGame getRight() {
		return right;
	}

	public void setRight(ScoreGame right) {
		this.right = right;
	}

	public ScoreGame getParent() {
		return parent;
	}

	public void setParent(ScoreGame parent) {
		this.parent = parent;
	}
    
	
      
      
}
