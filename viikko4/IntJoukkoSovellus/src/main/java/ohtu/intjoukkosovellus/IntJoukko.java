
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int DEFAULT_CAPACITY = 5,
                            DEFAULT_INCREMENT = 5;

    private int increment;
    private int[] buffer;
    private int size;

    public IntJoukko() {
        construct(DEFAULT_CAPACITY, DEFAULT_INCREMENT);
    }

    public IntJoukko(int capacity) {
        construct(capacity, DEFAULT_INCREMENT);
    }
    
    public IntJoukko(int capacity, int increment) {
        construct(capacity, increment);
    }

    public IntJoukko(int[] from) {
        construct(from.length, DEFAULT_INCREMENT);
        this.buffer = from;
    }

    private void construct(int capacity, int increment) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        if (increment <= 0) {
            throw new IllegalArgumentException("Increment must be greater than 0");
        }
        buffer = new int[capacity];
        size = 0;
        this.increment = increment;
    }

    public boolean lisaa(int value) {
        if (size == 0 || !kuuluu(value)) {
            pushValue(value);
            return true;
        }
        return false;
    }

    public boolean kuuluu(int value) {
        if (findValue(value) >= 0) return true;
        return false;
    }

    public boolean poista(int value) {
        int location = findValue(value);
        if (location >= 0) {
            shiftLeft(location);
            return true;
        }
        return false;
    }

    public int mahtavuus() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            sb.append(buffer[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[size];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = buffer[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko union = new IntJoukko(a.mahtavuus() + b.mahtavuus());
        for (int i = 0; i < a.mahtavuus(); i++) {
            union.lisaa(a.get(i));
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            union.lisaa(b.get(i));
        }
        return union;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko section = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            int test = a.get(i);
            if (b.kuuluu(test)) section.lisaa(test);
        }
        return section;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of range.");
        return buffer[index];
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko difference = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            int test = a.get(i);
            if (!b.kuuluu(test)) difference.lisaa(test);
        }
        return difference;
    }

    private void incrementCapacity() {
        int[] newBuffer = new int[buffer.length + increment];
        copyBufferToTarget(newBuffer);
        buffer = newBuffer;
    }

    private void copyBufferToTarget(int[] target) {
        for (int i = 0; i < buffer.length; i++) {
            target[i] = buffer[i];
        }
    }

    private void incrementSize() {
        if(++size == buffer.length) {
            incrementCapacity();
        }
    }

    private void pushValue(int value) {
        buffer[size] = value;
        incrementSize();
    }

    private int findValue(int value) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == value) return i;
        }
        return -1;
    }

    private void shiftLeft(int from) {
        size--;
        for (int j = from; j < size; j++) {
            buffer[j] = buffer[j + 1];
        }
    }
}