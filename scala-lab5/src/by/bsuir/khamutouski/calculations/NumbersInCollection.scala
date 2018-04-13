package by.bsuir.khamutouski.calculations

import scala.annotation.tailrec
import scala.collection.mutable

object SimplyCollections {

  def simplyNumRec(list: mutable.Buffer[Integer]): mutable.Buffer[Integer] = {
    def simplyNum(num: Int, div: Int): Boolean = {
      if (div != 1 & div != 0) {
        if (num % div == 0) false
        else simplyNum(num, div - 1)
      }
      else {
        if (num == 1) false
        else true
      }
    }
    list.filter((i: Integer) => simplyNum(i, i - 1))
  }

  def simplyNumTailRec(list: mutable.Buffer[Integer]): mutable.Buffer[Integer] = {
    def simplyChk(num: Int): Boolean = {
      @tailrec
      def check(div: Int, num: Int) : Boolean = {
          if (div == num) true
          else {
            if (num % div == 0) false
            else check(div + 1, num)
          }
        }
      check(2, num)
    }
    list.filter((i: Integer) => simplyChk(i))
  }
}