# Learn Java Data Structures

It contains the lessons I learn through the official Java documentation and practices.

<details>
<summary>Day 01</summary>

1. ***Object*** is the root in class hierarchy. Every object is an Object (extends from it or has its non-private properties and methods).

    * [*public **Object()***](./Object/README.md#constructors) constructor, which we will probably never use to initialize any object.

    * [*protected Object **clone()** throws CloneNotSupportedException*](./Object/README.md#methods) method, returns a **shallow copy** of an object, however, if *Cloneable* interface is not implemented by that object, *CloneNotSupportedException* will be thrown. *Object* class does not implement *Cloneable*. [Check this sample program.](./Object/CloneExample.java)
    ![Shallow Copy vs Deep Copy - Sample Output](./Object/outputs/Shallow%20Copy%20vs%20Deep%20Copy.PNG)

    > [!IMPORTANT]
    > *A shallow copy creates a new object that holds the **same top-level properties as the original, but any nested objects are still references to the original**. A deep copy, on the other hand, creates a **completely independent copy of the object and all its nested objects**, ensuring no shared references.*

</details>