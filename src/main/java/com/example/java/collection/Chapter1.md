### Java Collection Classes Cheat Sheet

---

## 1. Queue
**Interface**: `Queue<E>`  
**Common Implementations**: `LinkedList<E>`, `PriorityQueue<E>`

| Method               | Description                          | Time Complexity |
|----------------------|--------------------------------------|-----------------|
| `add(E e)`           | Adds an element to the queue         | O(1)            |
| `offer(E e)`         | Adds an element to the queue         | O(1)            |
| `remove()`           | Removes and returns the head         | O(1)            |
| `poll()`             | Removes and returns the head         | O(1)            |
| `element()`          | Returns the head (without removing)  | O(1)            |
| `peek()`             | Returns the head (without removing)  | O(1)            |

---

## 2. Stack
**Class**: `Stack<E>`  
**Note**: Prefer `Deque` implementations (e.g., `ArrayDeque`) for stack operations.

| Method               | Description                          | Time Complexity |
|----------------------|--------------------------------------|-----------------|
| `push(E e)`          | Pushes an element onto the stack     | O(1)            |
| `pop()`              | Pops the top element from the stack  | O(1)            |
| `peek()`             | Returns the top element              | O(1)            |
| `empty()`            | Checks if the stack is empty         | O(1)            |

---

## 3. PriorityQueue
**Class**: `PriorityQueue<E>`  
**Implementation**: Min-Heap by default (can be customized with a comparator).

| Method               | Description                          | Time Complexity |
|----------------------|--------------------------------------|-----------------|
| `add(E e)`           | Adds an element to the queue         | O(log n)        |
| `offer(E e)`         | Adds an element to the queue         | O(log n)        |
| `remove()`           | Removes and returns the head         | O(log n)        |
| `poll()`             | Removes and returns the head         | O(log n)        |
| `peek()`             | Returns the head (without removing)  | O(1)            |

---

## 4. Deque
**Interface**: `Deque<E>`  
**Common Implementations**: `ArrayDeque<E>`, `LinkedList<E>`

| Method               | Description                          | Time Complexity |
|----------------------|--------------------------------------|-----------------|
| `addFirst(E e)`      | Adds an element to the front         | O(1)            |
| `addLast(E e)`       | Adds an element to the end           | O(1)            |
| `removeFirst()`      | Removes and returns the first element| O(1)            |
| `removeLast()`       | Removes and returns the last element | O(1)            |
| `getFirst()`         | Returns the first element            | O(1)            |
| `getLast()`          | Returns the last element             | O(1)            |

---

## 5. List
**Interface**: `List<E>`  
**Common Implementations**: `ArrayList<E>`, `LinkedList<E>`

| Method               | Description                          | Time Complexity |
|----------------------|--------------------------------------|-----------------|
| `add(E e)`           | Adds an element to the end           | O(1) (Amortized)|
| `add(int index, E e)`| Inserts an element at a specific index | O(n)           |
| `remove(int index)`  | Removes an element at a specific index| O(n)           |
| `get(int index)`     | Returns the element at a specific index | O(1) (ArrayList), O(n) (LinkedList) |
| `set(int index, E e)`| Replaces the element at a specific index | O(1) (ArrayList), O(n) (LinkedList) |

---

## 6. Map
**Interface**: `Map<K, V>`  
**Common Implementations**: `HashMap<K, V>`, `TreeMap<K, V>`, `LinkedHashMap<K, V>`

| Method               | Description                          | Time Complexity |
|----------------------|--------------------------------------|-----------------|
| `put(K key, V value)`| Adds a key-value pair                | O(1) (HashMap), O(log n) (TreeMap) |
| `get(K key)`         | Returns the value for a key          | O(1) (HashMap), O(log n) (TreeMap) |
| `remove(K key)`      | Removes a key-value pair             | O(1) (HashMap), O(log n) (TreeMap) |
| `containsKey(K key)` | Checks if a key exists               | O(1) (HashMap), O(log n) (TreeMap) |
| `keySet()`           | Returns a set of keys                | O(1)            |

---

## 7. Set
**Interface**: `Set<E>`  
**Common Implementations**: `HashSet<E>`, `TreeSet<E>`, `LinkedHashSet<E>`

| Method               | Description                          | Time Complexity |
|----------------------|--------------------------------------|-----------------|
| `add(E e)`           | Adds an element to the set           | O(1) (HashSet), O(log n) (TreeSet) |
| `remove(Object o)`   | Removes an element from the set      | O(1) (HashSet), O(log n) (TreeSet) |
| `contains(Object o)` | Checks if an element exists          | O(1) (HashSet), O(log n) (TreeSet) |
| `size()`             | Returns the number of elements       | O(1)            |

---

### Summary of Implementations

| Collection Type | Implementations                     | Best Use Case                          |
|-----------------|-------------------------------------|----------------------------------------|
| Queue           | `LinkedList`, `PriorityQueue`       | FIFO operations, priority-based access |
| Stack           | `Stack`, `ArrayDeque`               | LIFO operations                        |
| PriorityQueue   | `PriorityQueue`                     | Priority-based access                  |
| Deque           | `ArrayDeque`, `LinkedList`          | Double-ended queue operations          |
| List            | `ArrayList`, `LinkedList`           | Random access, frequent insertions     |
| Map             | `HashMap`, `TreeMap`, `LinkedHashMap`| Key-value storage, sorted keys         |
| Set             | `HashSet`, `TreeSet`, `LinkedHashSet`| Unique elements, sorted elements       |

---

### Key Takeaways

- **ArrayList**: Fast random access, slower insertions/deletions in the middle.
- **LinkedList**: Fast insertions/deletions, slower random access.
- **HashMap**: Fast key-value lookups, no ordering.
- **TreeMap**: Sorted keys, slower lookups.
- **HashSet**: Fast unique element storage, no ordering.
- **TreeSet**: Sorted unique elements, slower operations.

---