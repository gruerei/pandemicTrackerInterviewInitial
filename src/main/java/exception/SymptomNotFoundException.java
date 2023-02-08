package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SymptomNotFoundException extends Exception{
    public SymptomNotFoundException(String s) {
        super(s);
    }
}
