package exceptions;

public class InvalidFieldException extends RuntimeException {

    public InvalidFieldException(String error){
        super(error);
    }
}
