package exceptions;

/**
 * Exception threw when a Stage's minimum length is 0 or less
 * @author Alvaro de Francisco Sanchez
 */
public final class InvalidItemMinLengthException extends Exception {
	/**
	 * InvalidItemMinLengthException's basic Constructor
	 * @param msg | The message to be displayed when the exception is threw
	 */
	public InvalidItemMinLengthException(String msg) {
		super(msg);
	}
}
