package exeption;

public class MinusException extends Exception {
    public String toString() {
        return "MinusException: количество патронов не может быть отрицательным!";
    }
}
