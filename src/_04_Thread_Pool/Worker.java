package _04_Thread_Pool;


import java.util.concurrent.ConcurrentLinkedDeque;

public class Worker implements Runnable {
	ConcurrentLinkedDeque<Task> taskQueue;
	public Worker(ConcurrentLinkedDeque<Task> T){
		this.taskQueue = T;
	}
	@Override
	public void run() {
		while (taskQueue.isEmpty() == false){
			Task task = taskQueue.remove();
			task.perform();
		}
	}
}
