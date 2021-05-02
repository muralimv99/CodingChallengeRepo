package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The PowerSetIterable class is used to get all subsets(Power set) of the given Collection
 */
public class PowerSetIterable<T> implements Iterable<List<T>> {
    private final List<T> input;
    private final int numElements;
    public PowerSetIterable(List<T> input) {
        this.input = input;
        numElements = 1 << input.size();
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new Iterator<List<T>>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < numElements;
            }

            @Override
            public List<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                List<T> element = new ArrayList<T>();
                for (int i = 0; i < input.size(); i++) {
                    long b = 1 << i;
                    if ((current & b) != 0) {
                        element.add(input.get(i));
                    }
                }
                current++;
                return element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(
                        "May not remove elements from a power set");
            }
        };
    }
}