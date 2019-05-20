package exceptions;

/**
 * Exception related to an invalid blank Item's button
 * @author Alvaro de Francisco Sanchez
 */
public class InvalidItemNullButton extends Exception {
	/**
	 * InvalidItemNullButton's basic Constructor
	 * @param msg The message to be displayed when the exception is threw
	 */
	public InvalidItemNullButton(String msg) {
		super(msg);
	}
}
