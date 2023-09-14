package kr.or.ddit.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import lombok.extern.slf4j.Slf4j;

/**
 * 메소드 호출 joinpoint 지원 시스템에서 위빙의 종류.
 * 
 * before advice : 메소드 호출 전 위빙.
 * after advice : 메소드 호출 이후 위빙.
 *
 */
@Slf4j
public class LoggingAdvice {
	public void before(JoinPoint point) {
		long start = System.currentTimeMillis();
		Object target = point.getTarget();
		Signature signature = point.getSignature();
		String targetMethodName = signature.getName();
		Class<?> returnType = signature.getDeclaringType();
		Object[] args = point.getArgs();
		log.info("before weaving on : {}.{}({})", target.getClass().getSimpleName(), targetMethodName, args);
	}
	
	public void afterReturning(JoinPoint point, Object retValue) {
		long end = System.currentTimeMillis();
		Object target = point.getTarget();
		Signature signature = point.getSignature();
		String targetMethodName = signature.getName();
		Class<?> returnType = signature.getDeclaringType();
		Object[] args = point.getArgs();
		log.info("after weaving on : {}.{}({}) \n 실행 후 반환값 : {}", 
						target.getClass().getSimpleName(), targetMethodName, args, retValue);
	}
	
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object target = point.getTarget();
		Signature signature = point.getSignature();
		String targetMethodName = signature.getName();
		Class<?> returnType = signature.getDeclaringType();
		Object[] args = point.getArgs();
		log.info("before weaving on : {}.{}({})", target.getClass().getSimpleName(), targetMethodName, args);
		
		long start = System.currentTimeMillis();
		// target 직접 실행
		Object retValue = point.proceed(args);
		long end = System.currentTimeMillis();
		
		log.info("after weaving on : {}.{}({}) \n 실행 후 반환값 : {}, 소요시간 : {}ms", 
				target.getClass().getSimpleName(), targetMethodName, args, retValue, (end-start));
		return retValue;
	}
}


























