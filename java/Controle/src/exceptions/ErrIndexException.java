package exceptions;

public class ErrIndexException extends Exception{
    
    public ErrIndexException(int index){
        System.out.println("L'index: " + index + " n'est pas valide");
    }
}
