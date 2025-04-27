import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMap {

  // Criação de uma Map normal (não sincronizada ainda)
  private static Map<Integer, String> Map = new ConcurrentHashMap<>();

  public static void main(String[] args) {
    // Criação de um único objeto Runnable que será usado por várias threads
    MyRunnable runnable = new MyRunnable();
    Thread t0 = new Thread(runnable);
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);

    // Início das três threads ao mesmo tempo.
    // Todas tentarão adicionar elementos à Map.
    t0.start();
    t1.start();
    t2.start();

    try {
      // Pequena pausa para garantir que todas as threads terminem
      // antes de imprimirmos a Map no console.
      Thread.sleep(500);
    } catch (Exception e) {
      // Captura de qualquer exceção durante o sleep
    }

    // Impressão do conteúdo da Map após as operações concorrentes.
    System.out.println(Map);
  }

  // Classe que define o que cada thread vai executar
  public static class MyRunnable implements Runnable {
    @Override
    public void run() {
      // Cada thread vai adicionar o texto "Coisa" à Map.
      // Como a Map é sincronizada, não há risco de problemas de concorrência aqui.
      Map.put(new Random().nextInt(), "Coisa");
    }
  }     
}