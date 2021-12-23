package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable
{
    int threadNumber;
    ThreadedGreeter(int threadNumber){
       this.threadNumber = threadNumber;
    }
    @Override
    public void run()
    {
        System.out.println("Hello from thread number " + threadNumber);
        if(threadNumber < 50){
          Thread thread = new Thread (new ThreadedGreeter(threadNumber+1));
          thread.start();
            try
            {
                thread.join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args){
        Thread t = new Thread(new ThreadedGreeter(1));
        t.start();
        try{
            t.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
