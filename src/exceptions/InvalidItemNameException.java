package exceptions;

/**
 * Exception related to an invalid blank Item's name
 * @author Alvaro de Francisco Sanchez
 */
public final class InvalidItemNameException extends Exception {
	/**
	 * InvalidItemNameException's basic Constructor
	 * @param msg | The message to be displayed when the exception is threw
	 */
	public InvalidItemNameException(String msg) {
		super(msg);
	}
}
