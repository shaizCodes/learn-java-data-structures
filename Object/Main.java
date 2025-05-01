import java.util.ArrayList;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        ArrayList firstObject = new ArrayList<Integer>();
        firstObject.add(2);
        firstObject.add(3);
        firstObject.add(4);
        firstObject.add(1);
        
        ArrayList secondObject = (ArrayList) firstObject.clone();
        
        System.out.println(
            "first: " + firstObject
            + "\nsecond: " + secondObject
            + "\nfirst == second: " + (firstObject == secondObject)
            + "\nfirst.equals(second): " + firstObject.equals(secondObject)
        );
    }
}