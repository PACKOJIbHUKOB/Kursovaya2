package pro.sky.Kursovaya2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExaminerServiceException extends RuntimeException{
    public ExaminerServiceException(String message) {
        super(message);
    }
}
