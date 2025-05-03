**Four Types of Thread Pools in Java**

1. Fixed Thread Pool
   • Description
      •Has a fixed number of threads.
      •Tasks are submitted to a blocking queue.
      •Threads fetch tasks from the queue and execute them one after another.

   • Use Case: Best for a predictable number of tasks.
 
   • Code Example:
   `ExecutorService service = Executors.newFixedThreadPool(10);
   for (int i = 0; i < 100; i++) {
        service.submit(() -> {
          // Task logic
       });
     }`

2. Cached Thread Pool
    • Description
        •Creates threads dynamically as needed.
        •Uses a synchronous queue (capacity = 1) to hold tasks temporarily.
        •Threads are kept alive for a specified time if no tasks are available.
        •If no idle threads are available, new threads are created.
        •Idle threads are terminated after 60 seconds.
    
    • Use Case: Best for a large number of short-lived tasks.
    
    • Code Example:
    `ExecutorService service = Executors.newCachedThreadPool();
      for (int i = 0; i < 100; i++) {
          service.submit(() -> {
             // Task logic
         });
       }`

3. Scheduled Thread Pool
    • Description
        •Designed for tasks that need to run after a delay or at fixed intervals.
        •Uses a delay queue to manage tasks based on their execution time.
        •Three scheduling options:
            • Run once after a delay.
            • Run repeatedly at a fixed rate (e.g., every 10 seconds).
            • Run repeatedly with a fixed delay (e.g., wait 10 seconds after the previous task finishes).
            • schedule(Runnable task, long delay, TimeUnit unit)
            • schedule(Callable task, long delay, TimeUnit unit)
            • scheduleAtFixedRate(Runnable task, long initialDelay, long period, TimeUnit unit)
    
    • Use Case: Suitable for periodic or delayed tasks like logging, monitoring, or scheduled events.
    
    • Code Example:
      `ScheduledExecutorService service = Executors.newScheduledThreadPool(10);`
      
      `// Run once after 10 seconds
      service.schedule(() -> {
      // Task logic
      }, 10, TimeUnit.SECONDS);`
      
      `// Run every 10 seconds
      service.scheduleAtFixedRate(() -> {
      // Task logic
      }, 15, 10, TimeUnit.SECONDS);`
      
      `// Run with a 10-second delay after the previous task completes
      service.scheduleWithFixedDelay(() -> {
      // Task logic
      }, 15, 10, TimeUnit.SECONDS);`

4. Single Threaded Executor
    • Description
        •Creates a single-threaded executor.
        •All tasks are executed sequentially in a single thread.
        •Ensures strict order of task execution (task 1 → task 2 → task 3).
        •If the thread is terminated, it is recreated automatically to continue processing.
    
    • Use Case: Best for sequential task execution or when task order is critical.
    
    • Code Example:
      `ExecutorService service = Executors.newSingleThreadExecutor();
       for (int i = 0; i < 10; i++) {
       service.submit(() -> {
       // Task logic
       });
       }`



    • Note: Useful for tasks that require a consistent order of execution or when you want to ensure that tasks don't run concurrently.


Comparison of Thread Pools
Thread Pool	           Threads	            Queue Type	         Use Case

Fixed Thread Pool	   Fixed number	        Blocking Queue	     Predictable workload
Cached Thread Pool	   Dynamic (up to max)	Synchronous Queue	 Large number of short-lived tasks
Scheduled Thread Pool  Fixed number	        Delay   Queue	     Periodic or delayed tasks
Single Thread Executor Single thread	    Blocking Queue	     Sequential task execution


Key Points
1. Fixed Thread Pool: Limited, reusable threads for tasks.
2. Cached Thread Pool: Dynamic thread creation and termination, best for bursts of tasks.
3. Scheduled Thread Pool: Ideal for tasks requiring scheduling or periodic execution.
4. Single Thread Executor: Guarantees sequential execution, maintaining task order.