public class Test {

  public static void main(String[] args) {
    // Thread atual
    Thread t = Thread.currentThread();
    System.out.println(t.getName());

    Thread t1 = new Thread(new MyRunnable());

    //run não cria uma nova linha de execução, ele está executando na mesma thread
    t1.run();

    Thread t2 = new Thread( 
      () -> System.out.println(Thread.currentThread().getName())
    );
    // já com o start, de fato estou executando em outra thread
    t2.start();
    /*
    t2.start();
    
    java.lang.IllegalThreadStateException
        at java.lang.Thread.start(Thread.java:710)
        at Test.main(Test.java:17)
        
    Não pode usar a mesma tread mais de uma vez
    */
    t1.start();
    /*
      pq posso ter um start e um run na mesma instancia de uma tread no java


      O ChatGPT disse:
      Ótima pergunta, Rafael! Isso aí toca num ponto chave sobre como as threads funcionam em Java.

      🧠 Conceitos Básicos
      start() → é usado para iniciar uma nova thread. Quando você chama start(), a JVM cria um novo fluxo de execução e chama automaticamente o método run() da sua classe.

      run() → é o código que será executado pela thread quando ela começar. Você nunca chama run() diretamente se quiser executar em paralelo.

      🧵 Por que existem os dois (start() e run())?
      Porque eles fazem coisas diferentes:

      ✅ start():
      Cria uma nova thread.

      Aloca recursos no sistema operacional.

      Depois chama run() de forma assíncrona.

      Só pode ser chamado uma vez por instância de Thread. Chamar start() de novo gera um IllegalThreadStateException.

      📦 run():
      É apenas um método comum.

      Se você chamar diretamente (thread.run()), ele roda no mesmo fluxo de execução atual, sem criar uma nova thread.

      É como qualquer outro método — não tem paralelismo.


    */
    t1.run();
    /*
     eu posso ter mais de um run mas ele n fez a mesma coisa 2 vezes


      O ChatGPT disse:
      Boa, Rafael! Isso que você falou — "posso ter mais de um run() mas ele não fez a mesma coisa duas vezes" — é um ponto que vale muito a pena destrinchar.

      Vamos por partes:

      ✅ Sim, você pode ter múltiplas chamadas a run()... MAS
      Se você chamar run() mais de uma vez manualmente, você está apenas executando aquele método como se fosse qualquer outro — sem thread nova, sem paralelismo. Então ele só vai executar uma coisa de cada vez (como qualquer método comum em Java).

      Mas uma alternativa para usar o mesmo trecho de código seria utilizar o mesmo runnable
    */

  }
}