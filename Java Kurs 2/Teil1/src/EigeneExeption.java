public class EigeneExeption extends Exception{
    EigeneExeption(String message, Throwable e){
        super(message, e);
    }
    EigeneExeption(String message){
        super(message);
    }
}
