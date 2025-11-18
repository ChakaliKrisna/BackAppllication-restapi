package restapi_java.demo_BankingApplication.Exception;


import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // handle specific exception account exception
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetails> HandleAccountException(AccountException accountException, WebRequest webRequest){

        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
                accountException.getMessage(),
                webRequest.getDescription(false),"Account not found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }

    // handle generic exception
@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception exception, WebRequest webRequest){



        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Internal Server Error"


        );
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
