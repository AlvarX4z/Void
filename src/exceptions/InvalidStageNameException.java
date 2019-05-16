package exceptions;

/**
 * Exception related to an invalid blank Stage's name
 * @author Alvaro de Francisco Sanchez
 */
public final class InvalidStageNameException extends Exception {
	/**
	 * InvalidStageNameException's basic Constructor
	 * @param msg | The message to be displayed when the exception is threw
	 */
	public InvalidStageNameException(String msg) {
		super(msg);
	}
}
