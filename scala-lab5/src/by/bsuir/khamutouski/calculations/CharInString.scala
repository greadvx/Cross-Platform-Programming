package by.bsuir.khamutouski.calculations

import scala.annotation.tailrec

  object CountingSymbols {

      //using tail-recursive
      def countSym(sym: Char, str: String, len: Int, count: Int): Int = {
        @tailrec
        def recIter(sym: Char, len: Int, count: Int): Int = {
          if (len == 0) count
          else {
            if (str.charAt(len - 1).equals(sym)) {
              recIter(sym, len - 1, count = count + 1)
            } else {
              recIter(sym, len - 1, count)
            }
          }
        }
        recIter(sym, len,  count)
      }

      //non tail-recursive
    def countSymRec(sym: Char, str: String, len: Int, count: Int) : Int = {
      def recIter(sym: Char, len: Int) : Int = {
        if (len == 0) count
        else {
          if (str.charAt(len - 1).equals(sym)) {
            count + 1 + recIter(sym, len - 1)
          } else {
            count + recIter(sym, len - 1)
          }
        }
      }
      count + recIter(sym, len)
    }
  }


