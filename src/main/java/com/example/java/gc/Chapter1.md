1. Garbage Collection (GC) in Java – In-Depth Explanation
   Garbage Collection (GC) in Java is an automatic process that reclaims memory occupied by objects no longer in use. 
   This prevents memory leaks and optimizes performance.

2. Why Do We Need Garbage Collection?
   Java manages memory automatically using Heap Memory, but if objects are not explicitly deallocated, 
   they can cause OutOfMemoryError. Garbage Collection helps reclaim memory by identifying and removing
   objects that are no longer reachable.GC ensures that unused objects are removed so that memory can be reused.

3. Java Memory Areas (JVM Memory Model)
   Before diving into GC, let's understand JVM memory areas:
    • **Heap Memory**: Stores objects created by the application. Stores objects and is managed by the GC
                       Young Generation (Eden + Survivor Spaces)
                       Old (Tenured) Generation
                       Permanent Generation (Java 7 and earlier) or Metaspace (Java 8+) for class metadata.
    • **Stack Memory**: Stores local variables and method calls. Each thread has its own stack memory.(not managed by GC).
    • **PC Register**, Native Method Stack → Used for execution tracking.

4. How Does Garbage Collection Work?
   GC uses different algorithms to identify and remove unused objects:
    • **Mark and Sweep**: Identifies reachable objects and marks them. Unmarked objects are swept and removed.
    • **Copying**: Divides memory into two parts. Objects are copied between these parts, and unused memory is reclaimed.
    • **Generational**: Divides memory into Young and Old generations. Most objects die young, so they are collected in the Young generation.
    • **Reference Counting**: Counts references to objects. Objects with zero references are removed.

5. Generational Garbage Collection
   The Java Heap is divided into three regions:
     • **Young Generation**:
       Contains Eden and Two Survivor Spaces (S0 & S1).
       Most objects die young (short-lived objects).
       Uses Minor GC to remove unreferenced objects.
       Surviving objects are promoted to Old Generation.
     • **Old (Tenured) Generation (Long-Lived Objects)**:
         Stores objects that survived multiple GC cycles in Young Generation.
         Uses Major GC (Full GC) to remove unreferenced objects.
     • **Permanent Generation (Java 7 and earlier)**: Stores class metadata and interned strings.
     • **Metaspace (JDK 8+)**:
         Stores class metadata (replaces PermGen).
         Grows dynamically, no OutOfMemoryError unless limited by MaxMetaspaceSize.

6. Types of Garbage Collection in Java
   • **Minor GC**
     Cleans Young Generation (Eden & Survivor Spaces).
     Stops application briefly (Stop-the-World Pause).
     Objects that survive multiple minor GCs are promoted to Old Generation.
   • **Major GC (Full GC)**
     Cleans Old Generation (long-lived objects).
     Triggers Stop-the-World (STW), causing application delay.
     More expensive than Minor GC.
   • **Mixed GC**
     Used in G1 GC, it collects both Young and Old Generation.

7. Garbage Collection Algorithms
   Java provides multiple GC algorithms based on performance needs:
     **Serial GC (Single-threaded, STW)**
      - **Use case**: Single-threaded applications (e.g., embedded devices).
      - **Uses**: Stop-the-World (STW) during GC.
      - **JVM Option**: `-XX:+UseSerialGC`.
    
     **Parallel GC (Multiple Threads for GC)**
      - **Use case**: Multi-core CPUs for better throughput.
      - **Uses**: Multiple threads to clean heap.
      - **JVM Option**: `-XX:+UseParallelGC`.
    
     **G1 (Garbage First) GC (Balanced)**
      - **Use case**: Large heaps (>4GB) with low pause times.
      - **Uses**: Regions-based GC (instead of generations).
      - **JVM Option**: `-XX:+UseG1GC`.
    
     **ZGC (Low-Latency GC)**
      - **Use case**: Low-latency applications.
      - **Uses**: Works with heap sizes up to 16TB.
      - **JVM Option**: `-XX:+UseZGC`.
    
     **Shenandoah GC (Low Pause GC)**
      - **Use case**: Real-time, low-pause workloads.
      - **JVM Option**: `-XX:+UseShenandoahGC`.

8. How Garbage Collector Works? (GC Process)
   Step 1: Mark Phase
   Identifies objects that are still in use.
   Step 2: Sweep Phase
   Removes unreferenced objects.
   Step 3: Compact Phase
   Moves remaining objects together to avoid fragmentation.

9. GC Tuning and Monitoring
   GC tuning is essential to optimize performance and prevent memory leaks:
    • **Heap Size**: Adjust the heap size based on application requirements.
    • **GC Algorithms**: Choose the appropriate GC algorithm based on the application.
    • **GC Logging**: Monitor GC activity using flags like -XX:+PrintGCDetails.
    • **VisualVM**: Analyze GC activity using tools like VisualVM.

10. Conclusion
    Garbage Collection in Java is a critical process that ensures memory is managed efficiently. Understanding GC algorithms
    and tuning parameters can help optimize application performance and prevent memory-related issues.