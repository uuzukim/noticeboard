package kr.or.ddit.exception;

/**
 * 식별자를 이용해 데이터를 검색했을때, 못찾은 경우, 발생시킬 예외.
 */
//public class PKNotFoundException extends Exception{ // checked exception
public class PKNotFoundException extends RuntimeException{

	public PKNotFoundException() {
		super();
		
	}

	public PKNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PKNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PKNotFoundException(String message) {
		super(message);
		
	}

	public PKNotFoundException(Throwable cause) {
		super(cause);
		
	} // unChecked exception

}
