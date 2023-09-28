import { IntegerList } from './IntegerList.js'
import { SortedIntList } from './hidden/SortedIntListLibrary.js'

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

class InheritanceSortedIntList extends SortedIntList {
  // Write your implementation below with API documentation
  insertions: number

  constructor(){
    super()
    this.insertions = 0
  }

  add(num:number): boolean {
    this.insertions += 1
    return super.add(num)
  }

  addAll(list: IntegerList): boolean {
    this.insertions += list.size()
    return super.addAll(list)
  }

  getTotalAdded(): number {
    return this.insertions
  }

}

export { InheritanceSortedIntList }
