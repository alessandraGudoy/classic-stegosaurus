package edu.ics211.h10;

/**
 * This assignment is for you to learn about queues by implementing a
 * simple task scheduler, similar to what is found in an operating system.
 *
 * The scheduler represents a queue of tasks, implemented by an array.
 * Queues are FIFO, or First-In-First-Out
 * 
 * java.util.LinkedList is a queue by default, but for the purposes
 * of this assignment, we will be using an array with a fixed size given
 * to the constructor.
 * Adding to a full Queue should throw an exception.
 * You may not use any classes from java.util.
 * 
 * Once jobs are in the queue, they should NOT be moved in the physical
 * array.  Instead, you will need to use variables to keep track of
 * which job needs to be run next and which slot to add any new jobs to.
 * 
 * @author Benjamin Strauss and Alessandra Gudoy
 *
 */

public class Scheduler {
	
	public final Task[] array;
	public final int maxTasks;
	private int start;
	private int end;
	private int size;
	
	public Scheduler(int queueSize) {
		array = new Task[queueSize];
		maxTasks = queueSize;

		start = 0;
		end = 0;
		size = 0;
	}
	
	/**
	 * Adds a task to the queue
	 * @param task to be added to queue
	 * @throws NullPointerException if task is null
	 * @throws RuntimeException if queue is full
	 */
	public void add(Task task) {
		if(task == null){
			throw new NullPointerException("Task is null");
		} else if(size == maxTasks){
			throw new RuntimeException("Queue is full");
		} else{
			array[end] = task;
			end = (end + 1) % maxTasks;
			size = size + 1;
		}
	}
	
	/**
	 * Returns but does not remove the element at the head of the queue (next task to be called)
	 * 		Does NOT run the task it returns
	 * @return task at the head of queue (next task to be called)
	 * @throws RuntimeException if queue is empty
	 */
	public Task element() {		// TODO

		if(size == 0){
			throw new RuntimeException("Queue is empty -- no tasks to return");
		}
		return array[(start) % maxTasks];
	}
	
	/**
	 * Returns and removes the element at the head of the queue (next task to be called)
	 * 		Does NOT run the task it returns
	 * @return task at the head of the queue
	 * @throws RuntimeException if queue is empty
	 */
	public Task remove() {		// TODO

		if(size == 0){
			throw new RuntimeException("Queue is empty -- no tasks to remove");
		}
		
		size = size - 1;
		start = (start + 1) % maxTasks;

		return array[(start-1+maxTasks) % maxTasks];
	}
	
	/**
	 * Runs and removes the task at the head of the queue and returns the result of the task
	 * @return the result returned by the task
	 * @throws RuntimeException if queue "is empty" (no jobs to do in the queue)
	 */
	public Object runTask() {	// TODO

		if(size == 0){
			throw new RuntimeException("Queue is empty -- no tasks to be done");
		}

		size = size - 1;
		start = (start + 1) % maxTasks;

		return array[(start-1+maxTasks) % maxTasks].run();
	}
	
	/**
	 * Returns the number of jobs currently in the queue
	 * @return number of jobs in queue
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Returns if queue is empty
	 * @return true if queue is empty, false if there are jobs to do in the queue
	 */
	public boolean empty() {
		return size == 0;
	}
	
	private static void assertTrue(boolean b) {
		if(!b) {
			throw new AssertionError();
		}
	}
	
	public static void main(String[] args) {
		Scheduler scheduler = new Scheduler(16);
		
		assertTrue(scheduler.size() == 0);
		
		/* Adding brackets after "new Task("Task 1")" allows
		 * one to redefine methods of the object without making
		 * a new class.	To learn more about this, see:
		 * (1) https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
		 * (2) https://www.baeldung.com/java-anonymous-classes
		 */
		scheduler.add(new Task("Task #0") {
			@Override public Object run() {
				return "(Dummy) Task #0 Completed";
			}
		});
		
		assertTrue(scheduler.size() == 1);
		
		System.out.println(scheduler.runTask());
		
		assertTrue(scheduler.size() == 0);
		
		Long a = (long) 5, b = (long) 7, c = (long) 12;
		
		/* 
		 * More ideas for tasks
		 */
		scheduler.add(new Task("Add Task", a, b) {
			/*
			 * running this task takes 2 Strings as parameters,
			 * both representing a long
			 */
			@Override public Object run() {
				Long l1 = Long.parseLong(params[0].toString());
				Long l2 = Long.parseLong(params[1].toString());
				return l1+l2;
			}
		});
		
		scheduler.add(new Task("Hello Task", "Manoa") {
			@Override public Object run() {
				String your_name = (String) params[0];
				return "Hello, " + your_name + "!";
			}
		});
		
		scheduler.add(new Task("Generate Queue Task", 3) {
			@Override public Object run() {
				Integer i1 = Integer.parseInt(params[0].toString());
				return new Scheduler(i1);
			}
		});
		
		//Running the tasks
		assertTrue(scheduler.runTask() == c);
		assertTrue(scheduler.size() == 2);
		assertTrue(scheduler.runTask().equals("Hello, Manoa!"));
		assertTrue(scheduler.size() == 1);
		
		Scheduler sch2 = (Scheduler) scheduler.runTask();
		// since "dummy" doesn't override "run()",
		// dummy.runTask() will always return null
		Task dummy = new Task("Dummy");
		assertTrue(dummy.run() == null);

		// add the same task several times
		sch2.add(dummy);
		sch2.add(dummy);
		sch2.add(dummy);
		
		try {	// the queue should have size 3, so this should fail
			sch2.add(dummy);
			System.out.println("Exception not thrown when queue capacity exceeded!");
		} catch (RuntimeException re) {
			System.out.println("Exception thrown properly.");
		}
	}

	/* * * START OF TASK DEFINITION * * */

	/**
	 * Task class that the scheduler runs.
	 * @author Benjamin Strauss
	 *
	 */
	public static class Task {
		public final String name;
		public final Object[] params;
		
                // parameters is an array of 0 or more objects
		public Task(String name, Object... parameters) {
			assertTrue(name != null);
			this.name = name;
			this.params = parameters;
		}
		
		public Object run() {
			//does nothing, can be overridden when making objects, see the main() for an example
			return null;
		}
		
		public String toString() { return "Task: "+name; }
	}

	/* * * END OF TASK DEFINITION * * */
	
}
