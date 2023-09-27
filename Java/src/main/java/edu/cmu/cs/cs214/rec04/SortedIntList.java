package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;

public class SortedIntList implements IntegerList {

    private final List<Integer> intList;

    public SortedIntList() {
        this.intList = new ArrayList<Integer>();
    }

    @Override
    public boolean add(int num) {
        int lo = 0;
        int hi = this.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (this.intList.get(mid) == num) {
                this.intList.add(mid, num);
                return true;
            } else if (this.intList.get(mid) > num) {
                hi = mid;
            } else if (this.intList.get(mid) < num) {
                lo = mid + 1;
            }
        }
        this.intList.add(lo, num);
        return true;
    }

    @Override
    public boolean addAll(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            this.intList.add(list.get(i));
        }
        return true;
    }

    @Override
    public int get(int index) {
        return this.intList.get(index);
    }

    @Override
    public boolean remove(int num) {
        int lo = 0;
        int hi = this.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (this.intList.get(mid) == num) {
                this.intList.remove(mid);
                return true;
            } else if (this.intList.get(mid) > num) {
                hi = mid;
            } else if (this.intList.get(mid) < num) {
                lo = mid + 1;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            this.intList.remove(list.get(i));
        }
        return true;
    }

    @Override
    public int size() {
        return this.intList.size();
    }

}
