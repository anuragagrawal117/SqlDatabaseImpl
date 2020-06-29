package exceptions;

public class RequiredFieldException extends RuntimeException {
    public RequiredFieldException(String error){
        super(error);
    }
}
