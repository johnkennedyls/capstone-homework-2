package model;

public class ManageScore {
          
	private ScoreGame root;
	
	public ManageScore() {
		root = null;
	}
	
	
	public void addScoreGame() {
		ScoreGame newScore = new ScoreGame();
		if(root==null) {
			root = newScore;
		}else {
			addScoreGame(root, newScore);
		}
		
		
		
	}


	private void addScoreGame(ScoreGame currentScore, ScoreGame newScore) {
		if(currentScore.getScore() > newScore.getScore()) {
			if(currentScore.getLeft()==null) {
				currentScore.setLeft(newScore);
				newScore.setParent(currentScore);
			}else {
				addScoreGame(currentScore.getLeft(), newScore);
			}
		}else {
			if(currentScore.getRight()==null) {
				currentScore.setRight(newScore);
				newScore.setParent(currentScore);
			}else {
				addScoreGame(currentScore.getRight(), newScore);
			}
		}
		
	}
	
	
	
}
