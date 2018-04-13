package by.bsuir.khamutouski.calculations

import scala.annotation.tailrec

object CountingSymbols {

  def simplyNumTailRec(list: List[Int]): List[Int] = {


    @tailrec
    def numIter(num: Int, div: Int): Boolean = {

      numIter(num, num - 1)
    }
  }

}