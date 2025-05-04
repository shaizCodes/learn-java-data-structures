# Learn Java Data Structures

It contains the lessons I learn through the official Java documentation and practices.

---
Before we begin, let's [proceed to *Object*](./Object/README.md) class as every object has its methods.

***Object*** is the root in class hierarchy. Every object is an Object (extends from it or has its non-private properties and methods).

* [*public **Object()***](./Object/README.md#constructors) constructor, which we will probably never use to initialize any object.
  
* [*protected Object **clone()** throws CloneNotSupportedException*](./Object/README.md#protected-object-clone-throws-clonenotsupportedexception) method, returns a **shallow copy** of an object, however, if *Cloneable* interface is not implemented by that object, *CloneNotSupportedException* will be thrown. *Object* class does not implement *Cloneable*. [Check this sample program.](./Object/CloneExample.java)
  ![Shallow Copy vs Deep Copy - Sample Output](./Object/outputs/Shallow%20Copy%20vs%20Deep%20Copy.PNG)

> [!CAUTION]
> *A shallow copy creates a new object that holds the **same top-level properties as the original, but any nested objects are still references to the original**. A deep copy, on the other hand, creates a **completely independent copy of the object and all its nested objects**, ensuring no shared references.*

* [*public String **toString()***](./Object/README.md#string-tostring) method returns the object information; complete class name, and object hashcode in hexadecimal. The hashcode is useful to verify whether an object is modified or not.

> [!NOTE]
> An object hashcode changes when the object is modified, and multiple objects can have same hashcode when they are equal but it is not necessary.

* [*public boolean **equals(Object obj)***](./Object/README.md#public-boolean-equalsobject-obj) method verifies whether two objects are equal by checking the following critera:

  **Reflexive:**$\quad x \neq \text{null}, \quad x.equals(x) \implies \text{true}$

  **Non-nullity:**$\quad x \neq \text{null}, \quad x.equals(\text{null}) \implies \text{false}$
  
  **Symmetric:**$\quad x, y \neq \text{null}, \quad x.equals(y) \iff y.equals(x)$

  **Transitive:**$\quad x, y, z \neq \text{null}, \quad x.equals(y) \land y.equals(z) \implies x.equals(z)$

  **Consistent:**$\quad x, y \neq \text{null}, \quad x.equals(y) \text{ returns the same result unless } x \text{ or } y \text{ is modified}$

> [!TIP]
> *Objects.hash(Object... values)* can be used to generate hashcode for objects that have multiple fields.

  [Check the example here.](./Object/OverridenEqualsExample.java)

> [!IMPORTANT]
> Whenever you override the *equals* method, do override the *hashcode* as well. It is because generally objects with same hashcode are considered equal.

* [*protected void **finalize()** throws Throwable*](./Object/README.md#protected-void-finalize-throws-throwable) method is to define the actions taken by finalization of an object. Such as closing database connection before discarding all the resources.

> [!CAUTION]
> ***finalize()*** is deprecated, avoid using it. Instead refer to *WeakReference* or *PhantomReference*.
