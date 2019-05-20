package exceptions;

/**
 * Exception related to an invalid blank Stage's description
 * @author Alvaro de Francisco Sanchez
 */
public class InvalidStageDescriptionException extends Exception {
	/**
	 * InvalidStageDescriptionException's  basic Constructor
	 * @param msg The message to be displayed when the exception is threw
	 */
	public InvalidStageDescriptionException(String msg) {
		super(msg);
	}
}
