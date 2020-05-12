package datastructures.fenwicktree;

public class FenwickTree {

    // The size of the array holding the Fenwick tree values
    private int size;

    // This array contains the Fenwick tree ranges
    private long[] tree;

    // Create an empty Fenwick Tree with 'sz' parameter zero based.
    public FenwickTree(int sz) {
        this.size = sz + 1;
        this.tree = new long[this.size];
    }

    // Construct a Fenwick tree with an initial set of values.
    // The 'values' array MUST BE ONE BASED meaning values[0]
    // does not get used, O(n) construction.
    public FenwickTree(long[] values) {

        if (values == null) throw new IllegalArgumentException("Values array cannot be null!");

        this.size = values.length;
        this.tree = new long[values.length + 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = values[i - 1];
            int lsb = lsb(i);
            if (i + lsb < size) {
                tree[i + lsb] += tree[i];
            }
        }
    }

    private int lsb(int i) {
        return i & -i;
    }

    // Computes the prefix sum from [1, i], O(log(n))
    private long prefixSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += tree[i];
            i -= lsb(i);
        }
        return sum;
    }

    // Returns the sum of the interval [left, right], O(log(n))
    public long sum(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }

    // Get the value at index i
    public long get(int i) {
        return sum(i, i);
    }

    // Add 'v' to index 'i', O(log(n))
    public void add(int i, long v) {
        while (i < size) {
            tree[i] += v;
            i += lsb(i);
        }
    }

    // Set index i to be equal to v, O(log(n))
    public void set(int i, long v) {
        add(i, v - get(i));
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(tree);
    }
}
