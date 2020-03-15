package pl.sarchael.zenerius.security.exceptions;

public class BadTokenException extends Exception {

    public BadTokenException(){
        super("Nieprawidłowy token!");
    }

    public String getMessage(){
        return super.getMessage();
    }
}