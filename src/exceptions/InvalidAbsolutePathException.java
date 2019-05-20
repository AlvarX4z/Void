package exceptions;

/**
 * Exception related to the use of an absolute path for files
 * @author Alvaro de Francisco Sanchez
 */
public final class InvalidAbsolutePathException extends Exception {
	/**
	 * InvalidAbsolutePathException's basic Constructor
	 * @param msg The message to be displayed when the exception is threw
	 */
	public InvalidAbsolutePathException(String msg) {
		super(msg);
	}
}