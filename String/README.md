# class String

## Important Note: What class to use and when?

* ***StringBuffer*** is synchronized, hence, thread-safe. It should be used when a string is to be modified from multiple threads.

* ***StringBuilder*** should be preferred over *StringBuffer* when there is a single thread to mutate the string.

* ***String*** should be used when frequent modification to the string is not expected. Because everytime a change is made to its object, a new object gets created and referenced rather than modifying the original.

    | String       | StringBuilder   | StringBuffer |
    | :----------: | :-------------: | :----------: |
    | immutable    | mutable         | mutable      |
    | thread-safe  | not thread-safe | thread-safe  |

* The figure shows the StringBuilder (*fourth*) is mutable unlike String (*first*, *second*, *third*).
![String and StringBuilder](./outputs/String%20and%20String%20Builder.PNG)

> [!NOTE]
> *System.identityHashCode(Object)* does not return the actual memory address. Java does not provide any such direct mechanism.
