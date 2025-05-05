The Decorator Design Pattern is a structural pattern used to dynamically add new behaviors or responsibilities to objects without modifying their existing code. 
It’s part of the GoF (Gang of Four) design patterns.

Key Concepts
- **Component**: An interface or abstract class defining the common interface for both concrete components and decorators.
- **Concrete Component**: A class that implements the component interface. It’s the object to which additional responsibilities can be added.
- **Decorator**: An abstract class that implements the component interface and contains a reference to a component object. It delegates the operations to the wrapped component.
- **Concrete Decorator**: A class that extends the decorator class and adds additional responsibilities or behaviors to the component.
- 
- **Client**: The class that uses the component interface to interact with both concrete components and decorators.
- **Dynamic Behavior**: The pattern allows for adding responsibilities at runtime, making it flexible and reusable.
- **Composition over Inheritance**: The decorator pattern promotes composition over inheritance, allowing for more flexible and reusable code.
- **Single Responsibility Principle**: Each decorator class has a single responsibility, making the code easier to maintain and understand.
- **Open/Closed Principle**: The pattern allows for extending the behavior of classes without modifying their existing code, adhering to the open/closed principle.
- **Example Use Cases**: The decorator pattern is commonly used in GUI frameworks, input/output streams, and other scenarios where behavior needs to be added dynamically.
- **Advantages**: The decorator pattern provides a flexible alternative to subclassing for extending functionality, promotes code reuse, and adheres to SOLID principles.
- **Disadvantages**: The pattern can lead to a large number of small classes, making the codebase more complex. It may also introduce additional overhead due to the delegation of calls to the wrapped component.
- **Real-World Examples**: The decorator pattern is used in Java I/O streams (e.g., BufferedReader, DataInputStream), GUI frameworks (e.g., Swing components), and other scenarios where behavior needs to be added dynamically.

- **When to Use**: Use the decorator pattern when you need to add responsibilities to individual objects dynamically and transparently, without affecting other objects of the same class. 
                   It’s also useful when you want to avoid creating a large number of subclasses for every possible combination of behaviors.
- **Implementation Steps**:
  1. Define the component interface.
  2. Create concrete components that implement the component interface.
  3. Create an abstract decorator class that implements the component interface and contains a reference to a component object.
  4. Create concrete decorators that extend the abstract decorator class and add additional responsibilities or behaviors.
  5. Use the decorators to wrap concrete components, adding functionality dynamically at runtime.