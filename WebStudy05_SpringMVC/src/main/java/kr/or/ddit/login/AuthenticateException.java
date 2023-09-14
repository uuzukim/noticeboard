package kr.or.ddit.login;

/**
 * 인증 시스템에서 인증 실패를 표현하기 위한 예외.
 *
 */
public class AuthenticateException extends RuntimeException{

	public AuthenticateException() {
		super();
		
	}

	public AuthenticateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AuthenticateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AuthenticateException(String message) {
		super(message);
		
	}

	public AuthenticateException(Throwable cause) {
		super(cause);
		
	}

}
