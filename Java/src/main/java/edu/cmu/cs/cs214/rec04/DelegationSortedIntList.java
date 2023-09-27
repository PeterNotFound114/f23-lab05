package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private int insertions;
    private final SortedIntList intList;

    public DelegationSortedIntList() {
        this.insertions = 0;
        this.intList = new SortedIntList();
    }

    public boolean add(int num) {
        this.insertions++;
        return this.intList.add(num);
    }

    public boolean addAll(IntegerList list) {
        this.insertions += list.size();
        return this.intList.addAll(list);
    }

    public int get(int index) {
        return this.intList.get(index);
    }

    public boolean remove(int num) {
        return this.remove(num);
    }

    public boolean removeAll(IntegerList list) {
        return this.removeAll(list);
    }

    public int size() {
        return this.intList.size();
    }

    public int getTotalAdded() {
        return this.insertions;
    }
}