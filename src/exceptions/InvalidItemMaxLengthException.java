package exceptions;

/**
 * Exception threw when surpassing a Stage's maximum length of 5
 * @author Alvaro de Francisco Sanchez
 */
public final class InvalidItemMaxLengthException extends Exception {
	/**
	 * InvalidItemMaxLengthException's basic Constructor
	 * @param msg | The message to be displayed when the exception is threw
	 */
	public InvalidItemMaxLengthException(String msg) {
		super(msg);
	}
}
