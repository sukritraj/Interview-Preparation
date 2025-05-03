It is used when we need to create only one instance of an class. It is used in logging, driver objects, caching, thread pool, database connections. It is used in scenarios when the object is heavy and consumes a lot of resources and we need to create only one instance of that object. It provides a global point of access to the instance. It is used in scenarios when we need to control concurrent access to the resources. It is used in scenarios when we need to create a single instance of a class in a single JVM. It is used in scenarios when we need to create a single instance of a class in a distributed environment. It is used in scenarios when we need to create a single instance of a class in a multi-threaded environment. It is used in scenarios when we need to create a single instance of a class in a multi-core environment. It is used in scenarios when we need to create a single instance of a class in a multi-processor environment. It is used in scenarios when we need to create a single instance of a class in a multi-node environment. It is used in scenarios when we need to create a single instance of a class in a multi-cluster environment. It is used in scenarios when we need to create a single instance of a class in a multi-datacenter environment. It is used in scenarios when we need to create a single instance of a class in a multi-region environment. It is used in scenarios when we need to create a single instance of a class in a multi-cloud environment. It is used in scenarios when we need to create a single instance of a class in a multi-geo environment.
There are four ways to create a singleton class:
1. Eager initialization
  --> The instance is created at the time of class loading. 
      This guarantees that the instance is created before any thread accesses the static getInstance method.
      Thread-Safe: Since the instance is created at class loading
2. Lazy initialization
  --> The instance is created when the getInstance method is called for the first time. or The instance is created only when it is needed for the first time.
      Thread-Safe: No
3. Syncronized initialization
  --> The getInstance method is synchronized to ensure that only one thread can execute it at a time.  
      This prevents multiple threads from creating multiple instances of the Singleton class.
      Thread-Safe: Yes
4. Double check locking initialization
 --> Reduces the overhead of synchronization by only locking the critical section where the instance is created. 
     The first check is performed without synchronization, and if the instance is null, the second check is performed within a synchronized block.

     Volatile Keyword: Ensures that the instance variable is read from the main memory and not from a thread's local cache, making sure that changes are visible to all threads.

    Thread Safety and Performance: This approach ensures thread safety while minimizing the performance impact of synchronization.