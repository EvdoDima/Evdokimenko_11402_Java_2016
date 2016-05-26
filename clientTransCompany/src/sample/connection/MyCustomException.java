package sample.connection;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */

import org.springframework.http.HttpStatus;

public class MyCustomException extends RuntimeException {

    private HttpStatus statusCode;

    public MyCustomException(HttpStatus status) {
        statusCode = status;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
