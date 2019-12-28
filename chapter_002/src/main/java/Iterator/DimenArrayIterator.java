package Iterator;

import java.util.Iterator;

public class DimenArrayIterator implements Iterator {
    private final int doublearray[][];
    private int i=0;
    private int l=0;

    public DimenArrayIterator(final int[][] doublearray) {
        this.doublearray = doublearray;
    }

    @Override
    public boolean hasNext() {
        if (i==doublearray.length) return false;
        return l<doublearray[i].length && doublearray.length>i;
    }

    @Override
    public Object next() {
        int s=doublearray[i][l];
        if (l!=doublearray[i].length-1) l++;
        else {
            l=0;
            i++;
        }
        return s;
    }
}
