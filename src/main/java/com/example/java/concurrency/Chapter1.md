**Volatile**
   • The volatile keyword in Java ensures visibility of updates to a variable across threads.
   • Without volatile, threads may read stale values due to local caching.
   • When a variable is declared as volatile:
   • Updates to it are immediately visible to all threads.
   • Reads always fetch the latest value from the main memory, bypassing thread-local caches.
   • Use Case:
     Volatile is typically used for flags (like boolean variables) where one thread updates the flag and another thread reads it.
   
       Example :
       volatile boolean flag = true;
       
       Thread 1:
       flag = false; // Write to the flag
       
       Thread 2:
       while (flag) { 
           // Process until flag changes
       }
    
    
Why Volatile Doesn't Solve Synchronization Problems
   • volatile only ensures visibility but doesn't guarantee atomicity.
   • A compound operation like value++ (read-modify-write) is not atomic :
   • Thread 1 and Thread 2 may both read the same value and overwrite each other's changes, resulting in incorrect behavior.
   
   `Example :
          volatile int value = 1;`
   
   `Thread 1: value++; // Reads, increments, writes
         Thread 2: value++; // Same as above`
   
   • Final value might be 2 instead of 3.
   
   
**Atomic Variables**
   • Atomic classes (like AtomicInteger) provide thread-safe operations without requiring explicit synchronization.
   • Methods like incrementAndGet() or compareAndSet() ensure atomicity of compound operations.
   
       Example : 
       AtomicInteger value = new AtomicInteger(1);
       
       Thread 1: value.incrementAndGet(); // Atomically increments to 2
       Thread 2: value.incrementAndGet(); // Atomically increments to 3
       
   • The compareAndSet(expectedValue, newValue) method allows atomic conditional updates:
     If the current value matches the expectedValue, it's updated to newValue.
   

**Synchronized**
   • The synchronized keyword provides thread-safe access by mutual exclusion.
   • It allows only one thread to execute the critical section at a time, ensuring atomicity for compound operations.
   
       Example : 
       int value = 1;
       
       synchronized (this) {
           value++;
       }
       
   • The synchronized block ensures only one thread can increment value at a time, avoiding race conditions.

Core Differences
     Feature         Volatile           Synchronized                                      Atomic Variables

     Use Case        Solve visibility   issues Solve atomicity & visibility issues        Solve atomicity for specific operations
     Performance     Lightweight        Can be slower due to thread locking               Faster for specific atomic operations
     Compound Ops    Not supported      Supported                                         Supported (e.g., incrementAndGet())
     Common Usage    Boolean flags      Critical sections                                 Counters, references


When to Use
   `• Volatile:
      • When you only need visibility (e.g., boolean flags).`

    • Synchronized:
      • For critical sections or compound operations with complex logic.
    
    • Atomic Variables:
      • For counters or when you need lightweight thread-safe operations.   