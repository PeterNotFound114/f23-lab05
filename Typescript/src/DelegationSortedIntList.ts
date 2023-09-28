/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

import { IntegerList } from "./IntegerList";
import { SortedIntList } from "./hidden/SortedIntListLibrary";

class DelegationSortedIntList implements IntegerList {
  insertion: number
  intList: SortedIntList
  
  constructor(){
    this.intList = new SortedIntList()
    this.insertion = 0
  }

  add (num: number) : boolean {
    this.insertion ++
    return this.intList.add(num)
  }

  addAll (list: IntegerList) : boolean {
    this.insertion += list.size()
    return this.intList.addAll(list)
  }

  get (index: number) : number {
    return this.intList.get(index)
  }

  remove (num: number) : boolean {
    return this.intList.remove(num)
  }

  removeAll (list: IntegerList) : boolean {
    return this.intList.removeAll(list)
  }

  size () : number {
    return this.intList.size()
  }

  getTotalAdded(): number {
    return this.insertion
  }
}

export { DelegationSortedIntList }
