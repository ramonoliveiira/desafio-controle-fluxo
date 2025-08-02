import java.util.Scanner;
import exceptions.InvalidParametersException;

public class Contador {
  public static void main(String[] args) {
    Scanner terminal = new Scanner(System.in);

    System.out.println("==========================");
    System.out.println("Insira o primeiro número:");
    int firstParam = terminal.nextInt();
    System.out.println("Insira o segundo número:");
    int secondParam = terminal.nextInt();

    try {
      count(firstParam, secondParam);
    } catch (InvalidParametersException e) {
      System.out.println(e.getMessage());
    } finally {
      terminal.close();
    }
  }

  public static void count(int firstNumber, int secondNumber) throws InvalidParametersException {
    if (secondNumber < firstNumber) {
      throw new InvalidParametersException("O segundo parâmetro deve ser maior que o primeiro");
    }

    int difference = secondNumber - firstNumber;

    for (int idx = 0; idx < difference; idx++) {
      int numberToPrint = idx + 1;
      System.out.printf("Imprimindo o número %d \n", numberToPrint);
    }

  }
}
