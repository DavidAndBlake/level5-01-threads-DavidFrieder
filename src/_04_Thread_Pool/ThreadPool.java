package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadPool
{
    Thread[] threads;
    ConcurrentLinkedDeque<Task> taskQueue;

    ThreadPool(int totalThreads)
    {
        threads = new Thread[totalThreads];
        taskQueue = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new Thread(new Worker(taskQueue));
        }

    }

    void addTask(Task task)
    {
        taskQueue.add(task);
    }

    void start() throws InterruptedException
    {
        for (int i = 0; i < threads.length; i++)
        {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++)
        {
            threads[i].join();
        }

    }
}
