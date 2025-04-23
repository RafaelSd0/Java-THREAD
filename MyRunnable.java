public class MyRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("olá mundo \nnome:" + Thread.currentThread().getName());
  }
}
