package Iterator;

import java.util.Iterator;

public class DimenArrayIterator implements Iterator {
    private final int doublearray[][];
    private int i=0;
    private int l=0;

    public DimenArrayIterator(final int[][] doublearray) {
        this.doublearray = doublearray;
    }

    public int[][] getDoublearray() {
        return doublearray;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
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

    public static void main(String[] args) {
        int[][] slovo=new int[200][200];
        for (int [] l:slovo) {
            for (int k:l) {
                k=4;
            }
        }
        DimenArrayIterator d=new DimenArrayIterator(slovo);
        while (d.hasNext()) {
            System.out.print(d.next());
        }
        System.gc();

    }
}
