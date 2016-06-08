package ExceptionPackage;
/**
 * @author Nicky Randles
 *
 */
public class StalemateException extends Exception {
	
	private static final long serialVersionUID=123456;

	public StalemateException(String mate) {
		super(mate);
	}

}
