package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private final int newarr[];
    private int i=0;

    public EvenIterator(final int[] newarr) {
        this.newarr = newarr;
    }

    @Override
    public boolean hasNext() {
        boolean s=false;
        for (int l=i;l<newarr.length;l++) {
            if (newarr[l]%2==0) {
                s=true;
            }
        }
        return s;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!this.hasNext())
        {throw new NoSuchElementException();}
        for (int n=i;n<newarr.length;n++) {
            if (newarr[n]%2==0) {
                i=n;
                break;
            }
        }
        int l=i;
        if (i<newarr.length-1) i++;
        return newarr[l];
    }
}
