package ThisIsSpringStudy.product.management.presentation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 도메인 유효성 처리 핸들러
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(
            ConstraintViolationException ex
    ) {
        //예외에 대한 처리 
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<String> errors = constraintViolations.stream()
                .map(
                        constraintViolation ->
                                extractField(constraintViolation.getPropertyPath()) + ", " +
                                        constraintViolation.getMessage()
                ).toList();

        ErrorMessage errorMessage = new ErrorMessage(errors);
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

    }

    // 컨트롤러 유효성 처리 핸들러
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = fieldErrors.stream()
                .map(
                        fieldError -> fieldError.getField() + ", " + fieldError.getDefaultMessage()
                ).toList();

        ErrorMessage errorMessage = new ErrorMessage(errors);
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }

    private String extractField(Path path) {
        String[] splittedArray = path.toString().split("[.]");
        int lastIndex = splittedArray.length - 1;
        return splittedArray[lastIndex];
    }
}
