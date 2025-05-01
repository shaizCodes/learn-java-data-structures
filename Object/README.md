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
    ```
