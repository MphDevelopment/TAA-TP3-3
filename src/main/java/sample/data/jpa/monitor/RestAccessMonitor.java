package sample.data.jpa.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestAccessMonitor {

	@Before("execution(* sample.data.jpa.web.EmployeeController.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.err.print(joinPoint.getTarget().getClass().getName());
		
		System.err.print("#" + joinPoint.getSignature().getName());
				
		String argsString = " With args: ";
		for(Object a : joinPoint.getArgs())
		{
			argsString += a.toString() + " ";
		}
		System.err.println(argsString);
	}
}
