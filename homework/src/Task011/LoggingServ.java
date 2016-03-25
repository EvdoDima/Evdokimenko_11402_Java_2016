package Task011;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import tasks001_005.Sem2testing.Server;

import java.net.Socket;


/**
 * Created by evdodima on 25/03/16.
 * 11-402
 */

@Aspect
public class LoggingServ {
    private int connections = 0;


    @Around("execution(* *.ServerSocket.accept())")
    public Object clientslog(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("waiting");
        Socket s = (Socket) jp.proceed();
        System.out.println("connected" + connections);
        connections++;
        return s;
    }


    @Before("execution(* tasks001_005.Sem2testing.Server.startNewGame())")
    public void gamestartlog() {
        System.out.println("starting game");
    }


}
