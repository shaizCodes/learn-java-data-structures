# Class **Object**

* Every class extends the root **Object** class, hence, all objects including arrays implement its methods.

## Constructors

* ### Object()

    ```Java
    Object sampleObject = new Object();
    System.out.println("toString(): " + sampleObject);
    /*
    ** toString(): <complete class name>@<memory reference>
    ** e.g.,
    ** => toString(): java.lang.Object@37574691
    */
    ```

## Methods

* ### *protected Object* clone() *throws CloneNotSupportedException*

    Since it is a protected method, to use it an essential criteria is to implement the *Cloneable* interface which is done by most java.util classes.

    ```Java
    ArrayList firstObject = new ArrayList<Integer>();
    firstObject.add(1);
    firstObject.add(2);

    ArrayList secondObject = (ArrayList) firstObject.clone();
    // Note: it will be shallow, not a deep copy.

    System.out.println(
     "first: " + firstObject
     + "second: " + secondObject
     + "first == second: " + (firstObject == secondObject)
     + "first.equals(second): " + firstObject.equals(secondObject)
    );

    [Do check the source code for Shallow and Deep copy.](./CloneExample.java)

* ### *String* toString()

    It represents an object textually, and it should be overriden for every subclasses.

    For the root *Object* class, it returns the class name ( *getClass().getName()* ) followed by ampersand ( *@* ) before the integer hexadecimal representation of the object hashcode ( *Integer.toHexString(hashCode())* ).

    ```Java
    Object object = new Object();
    System.out.printf(
      "%-20s: %s\n"
      +"%-20s: %s\n"
      +"%-20s: %s\n"
      +"%-20s: %s\n"
      +"%-20s: %s\n",
      "object",
      object,
      "object.toString()",
      object.toString(),
      "object.getClass()",
      object.getClass(),
      "object.hashCode()",
      object.hashCode(),
      "Integer.toHexString(object.hashCode()): ",
      Integer.toHexString(object.hashCode())
    );
    ```

    ![toString composes of class name and object hexadecimal hashcode](./outputs/ToString%20composition.PNG)

> [!NOTE]
> [Read more about ***String*** here, especially this note](../String/README.md#important-note-what-class-to-use-and-when)

* ### *public boolean* equals(Object obj)

    It compares two objects to verify they are equal. This method can be overriden to define custom criteria for equality, however, hashcode() should be overriden too, because two objects with same hashcode are generally considered equal/same.

    ![Sample program overriding Equals](./outputs/With%20And%20Without%20Equals.PNG)

    [Check the source code here.](./OverridenEqualsExample.java)

* ### *protected void* finalize() *throws Throwable*

    It has been deprecated since v9+, though, its purpose was to do finalization, or to free resources before garbage collection starts.

    Due to the following major reasons, it is deprecated:

    * **Unpredictable latency** — An arbitrarily long time may pass between the moment an object becomes unreachable and the moment its finalizer is called. In fact, the GC provides no guarantee that any finalizer will ever be called.

    * **Unconstrained behavior** — Finalizer code can take any action. In particular, it can save a reference to the object being finalized, thereby resurrecting the object and making it reachable once again.

    * **Always enabled** — Finalization has no explicit registration mechanism. A class with a finalizer enables finalization for every instance of the class, whether needed or not. Finalization of an object cannot be cancelled, even if it is no longer necessary for that object.

    * **Unspecified threading** — Finalizers run on unspecified threads, in an arbitrary order. Neither threading nor ordering can be controlled.

    For detailed information, [read this webpage](https://openjdk.org/jeps/421).

    Below is a sample program output that shows the *finalize()* method never got called. [Check the source code here.](./OverridenFinalizeExample.java)

    ![Sample program overriding Finalize](./outputs/Finalization.PNG)
