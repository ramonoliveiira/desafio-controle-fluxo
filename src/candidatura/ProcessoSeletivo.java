package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    // analisarCandidato(1900.0);
    // analisarCandidato(2200.0);
    // analisarCandidato(2000.0);

    // selecaoCandidatos();

    // imprimirSelecionados();

    String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
    for (String candidato : candidatos) {
      entrandoEmContato(candidato);
    }
  }

  static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTendando = true;
    boolean atendeu = false;

    do {
      atendeu = atender();
      continuarTendando = !atendeu;
      if (continuarTendando)
        tentativasRealizadas++;
      else
        System.out.println("CONTATO REALIZADO COM SUCESSO");

    } while (continuarTendando && tentativasRealizadas < 3);

    if (atendeu)
      System.out.println(
          "CONSEGUIMIS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
    else
      System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO TENTATIVAS "
          + tentativasRealizadas + " REALIZADA");
  }

  static boolean atender() {
    return new Random().nextInt(3) == 1;
  }

  static void imprimirSelecionados() {
    String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
    System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
    for (int idx = 0; idx < candidatos.length; idx++) {
      System.out.printf("O candidato de nº %d é " + candidatos[idx] + "\n", idx);
    }
    System.out.println("Forma abreviada de interação for each");

    for (String candidato : candidatos) {
      System.out.println("O candidato selecionado foi " + candidato);
    }
  }

  static void selecaoCandidatos() {
    String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO",
        "MIRELA", "DANIELA", "JOÃO"};

    int candidatosSelecionados = 0;
    int candidatoAtual = 0;
    double salarioBase = 2000.0;
    while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
      String candidato = candidatos[candidatoAtual];
      double salarioPretendido = valorPretendido();

      System.out.println(
          "O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
      if (salarioBase >= salarioPretendido) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
        candidatosSelecionados++;
      }
      candidatoAtual++;
    }
  }

  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.0;
    if (salarioBase > salarioPretendido) {
      System.out.println("LIGAR PARA O CANDIDATO");
    } else if (salarioBase == salarioPretendido) {
      System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
    } else {
      System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }
  }
}
