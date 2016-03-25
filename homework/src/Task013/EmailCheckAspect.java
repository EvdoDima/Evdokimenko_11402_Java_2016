package Task013;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by evdodima on 25/03/16.
 * 11-402
 */
@Aspect
public class EmailCheckAspect {


    @Around("execution(* Task012.SomeClass.emailString(String))")
    public Object emailCheck(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        if(args.length==1){
            String toCheck = (String) args[0];
            Pattern p = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(toCheck);

            return m.find()?jp.proceed():null;
        }
        return jp.proceed();
    }
}
