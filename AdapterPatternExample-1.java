import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Adapter class that implements Iterator and uses an Enumeration internally
class EnumerationIteratorAdapter<E> implements Iterator<E> {
    private Enumeration<E> enumeration;

    public EnumerationIteratorAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Create an Enumeration from the Vector
        Enumeration<String> enumeration = vector.elements();

        // Create an Iterator using the EnumerationAdapter
        Iterator<String> iterator = new EnumerationIteratorAdapter<>(enumeration);

        // Use the Iterator to traverse the collection
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}