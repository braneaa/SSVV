package src.ro.ubb.PisicutelePufoase.Exceptions;


public class ServiceException extends RuntimeException {
    String message;
    public ServiceException(String message){
        this.message=message;
    }
    public String getMessage(){
        return this.message;
    }
}