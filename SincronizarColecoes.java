import java.util.*;

public class SincronizarColecoes {

  // Criação de uma lista normal (não sincronizada ainda)
  private static List<String> Lista = new ArrayList<>();

  public static void main(String[] args) {
    // Aqui a lista é "transformada" em uma versão sincronizada,
    // ou seja, segura para acesso por múltiplas threads.
    Lista = Collections.synchronizedList(Lista);

    // Criação de um único objeto Runnable que será usado por várias threads
    MyRunnable runnable = new MyRunnable();
    Thread t0 = new Thread(runnable);
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);

    // Início das três threads ao mesmo tempo.
    // Todas tentarão adicionar elementos à lista.
    t0.start();
    t1.start();
    t2.start();

    try {
      // Pequena pausa para garantir que todas as threads terminem
      // antes de imprimirmos a lista no console.
      Thread.sleep(500);
    } catch (Exception e) {
      // Captura de qualquer exceção durante o sleep
    }

    // Impressão do conteúdo da lista após as operações concorrentes.
    System.out.println(Lista);
  }

  // Classe que define o que cada thread vai executar
  public static class MyRunnable implements Runnable {
    @Override
    public void run() {
      // Cada thread vai adicionar o texto "Coisa" à lista.
      // Como a lista é sincronizada, não há risco de problemas de concorrência aqui.
      Lista.add("Coisa");
    }
  }     
}
