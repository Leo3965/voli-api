package med.voli.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class VoliExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Error404Hanlder() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Error400Handler(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(Error400::new).toList());
    }

    private record Error400(String campo, String mensagem) {
        Error400(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
