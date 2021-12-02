package laborator4.exceptions;

public class ExceptionLimitReached extends RuntimeException{
    public ExceptionLimitReached(String message){
        super(message);
    }
}
