package exeption;

public class IllegalValueException extends RuntimeException{
    public String toString() {
        return "IllegalValueException: значение находится вне заданного диапазона значений!";
    }
}
