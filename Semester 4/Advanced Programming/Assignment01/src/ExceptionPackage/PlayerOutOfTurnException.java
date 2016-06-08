package ExceptionPackage;
/**
 * @author Nicky Randles
 *
 */
public class PlayerOutOfTurnException extends Exception {
	
	private static final long serialVersionUID=123456;

	public PlayerOutOfTurnException(String OutOfTurn) {
		super(OutOfTurn);
	}

}
