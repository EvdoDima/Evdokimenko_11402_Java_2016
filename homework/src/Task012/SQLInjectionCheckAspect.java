package Task012;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by evdodima on 25/03/16.
 * 11-402
 */
@Aspect
public class SQLInjectionCheckAspect {


    @Around("execution(* SomeClass.executeQuery(String))")
    public Object injectionCheck(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        if (args.length == 1) {
            String toCheck = (String) args[0];
            Pattern p = Pattern.compile("(['\"()#%{}])|(INSERT|DROP|ALTER|SELECT|UPDATE|DELETE)", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(toCheck);

            return m.find() ? null : jp.proceed();
        }
        return jp.proceed();
    }
}
