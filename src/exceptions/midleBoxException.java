package exceptions;

public class midleBoxException extends Exception {

	private static final long serialVersionUID = 1L;
	private String box;

	public midleBoxException(String box) {

		super("The box can't be: " + box + ". Type a side box or a shore box");
	}

}
