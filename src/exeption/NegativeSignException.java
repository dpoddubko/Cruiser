package exeption;

public class NegativeSignException extends RuntimeException{
    public String toString() {
        return "NegativeSignException: количество патронов не может быть отрицательным!";
    }
}
