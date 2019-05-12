package exceptions;

/**
 * Exception related to an invalid blank Item's description
 * @author Alvaro de Francisco Sanchez
 */
public final class InvalidItemDescriptionException extends Exception {
	/**
	 * InvalidItemDescriptionException's basic Constructor
	 * @param msg | The message to be displayed when the exception is threw
	 */
	public InvalidItemDescriptionException(String msg) {
		super(msg);
	}
}
