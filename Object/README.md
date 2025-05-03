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

> [!NOTE]
> [Read more about ***String*** here, especially this note](../String/README.md#important-note-what-class-to-use-and-when)
