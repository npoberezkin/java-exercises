package datastructures.unionfind;

public class UnionFind {

    // The number of elements in this union find
    private int size;

    // Used to track the size of each of the component
    private int[] compSizes;

    // id[i] points to the parent of i, if id[i] = i then i is a root node
    private int[] ids;

    // Tracks the number of components in the union find
    private int compNum;

    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size should not be <= 0");
        }
        this.size = this.compNum = size;
        this.compSizes = new int[size];
        this.ids = new int[size];
        for (int i = 0; i < size; i++) {
            compSizes[i] = 1;
            ids[i] = i;
        }
    }

    // Find which component/set 'e' belongs to, takes amortized constant time.
    public int find(int e) {
        int root = e;

        // Find the root of the component/set
        while (ids[root] != root) {
            root = ids[root];
        }

        // Compress the path leading back to the root.
        // Doing this operation is called "path compression"
        // and is what gives us amortized time complexity.
        while (e != root) {
            int next = ids[e];
            ids[e] = root;
            e = next;
        }

        return root;
    }

    // Return whether or not the elements 'p' and
    // 'q' are in the same components/set.
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Return the size of the components/set 'p' belongs to
    public int componentSize(int p) {
        return compSizes[find(p)];
    }

    // Return the number of elements in this UnionFind/Disjoint set
    public int size() {
        return size;
    }

    // Returns the number of remaining components/sets
    public int components() {
        return compNum;
    }

    // Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {

        int root1 = find(p);
        int root2 = find(q);

        // These elements are already in the same group!
        if (root1 == root2) return;

        // Merge smaller component/set into the larger one.
        if (compSizes[root1] < compSizes[root2]) {
            compSizes[root2] += compSizes[root1];
            ids[root1] = root2;
        } else {
            compSizes[root1] += compSizes[root2];
            ids[root2] = root1;
        }

        // Since the roots found are different we know that the
        // number of components/sets has decreased by one
        compNum--;
    }
}
