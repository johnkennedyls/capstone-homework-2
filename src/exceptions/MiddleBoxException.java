package exceptions;

public class MiddleBoxException extends Exception {

	private static final long serialVersionUID = 1L;
	private String box;

	public MiddleBoxException(String box) {

		super("The box can't be: " + box + ". Type a side box or a shore box");
	}

	public String getBox() {
		return box;
	}

	
	

}
