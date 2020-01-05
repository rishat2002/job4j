package Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iter = it.next();

            @Override
            public boolean hasNext() {
                while (!iter.hasNext() && it.hasNext()) {
                    iter = it.next();
                }
                return iter.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (!iter.hasNext()) {
                    iter = it.next();
                }
                Integer n = iter.next();
                return n;
            }
        };
    }
}
