package exception;

public class IncorrectWeightException extends IllegalArgumentException {
  public IncorrectWeightException(int weight) {
    super("Вес не может быть отрицательным: " + weight);
  }
}
