package ExceptionPackage;
/**
 * @author Nicky Randles
 *
 */
public class IncorrectEntryException extends Exception {
	
	private static final long serialVersionUID=123456;
	
	public IncorrectEntryException(String Incorrect) {
		super(Incorrect);
	}
	
}
