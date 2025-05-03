Concurrency vs. Parallelism: A Concise Explanation

Parallelism:
    • Definition: Doing multiple tasks simultaneously to speed up a program.
    • Example:
        • A program that processes multiple images concurrently to reduce the total processing time.
        • Three tasks: ProcessTax(User1), ProcessTax(User2), and HeavyCalculations().
        • Using threads or a thread pool, these tasks can run in parallel on separate CPU cores if the CPU has multiple 
          cores (e.g., a quad-core CPU).
    • Execution: Each thread runs independently, scheduled on different cores.
    • Goal: Speed up the program by running multiple tasks simultaneously.
    • Tools in Java: Raw Threads, Thread pools(ExecutorService, ForkJoinPool), CompletableFuture.
    • Requires multiple CPU cores for true parallelism.

Concurrency:
    • Definition: Managing multiple tasks that can interact, particularly when sharing resources.
    • Example:
      • Two threads book tickets by checking and updating a shared variable availableTickets.
      • Without proper synchronization, both threads might book the same ticket, causing incorrect results due to race conditions.
    • Challenges:
      • Threads may interleave (time-sliced on a single core) or run in parallel (on multiple cores), leading to non-deterministic behavior.
      • Access to shared resources must be synchronized to avoid inconsistencies.
    • Tools in Java:
      • Locks (e.g., ReentrantLock), synchronized blocks.
      • Atomic classes (e.g., AtomicInteger).
      • Concurrent data structures (ConcurrentHashMap, BlockingQueue).
      • High-level utilities (CountDownLatch, CyclicBarrier, CompletableFuture).
    • Goal: Ensure correct and safe execution of multiple tasks.


Key Difference:
    • Parallelism: Doing many tasks at the same time (focused on performance).
    • Concurrency: Managing multiple tasks, often sharing resources, safely and correctly (focused on correctness).