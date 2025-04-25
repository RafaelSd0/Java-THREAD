public class Runnable_1 {
  static int i = -1;
  public static void main(String[] args) {
    MyRunnable runnable = new MyRunnable();
    Thread t0 = new Thread(runnable);
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    Thread t3 = new Thread(runnable);
    Thread t4 = new Thread(runnable);

    t0.start();
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
  public static class MyRunnable implements Runnable {
    // Esse método está sendo executado em paralelo por 5 threads diferentes
    @Override
    public  void run(){
      // o synchronized faz com que o recurso seja disputado por uma thread de cada vez
      synchronized(this){
        i++;
      }
      String name = Thread.currentThread().getName();
      System.out.println(name + ": " + i);
    }
  }     
}
