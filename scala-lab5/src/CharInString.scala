import scala.annotation.tailrec

  object test extends App {

      //using tail-recursive
      def countSym(sym: Char, str: String, len: Int, count: Int): Int = {
        @tailrec
        def recIter(sym: Char, len: Int, count: Int): Int = {
          if (len == 0) {
            count
          } else {
            if (str.charAt(len - 1).equals(sym)) {
              recIter(sym, len - 1, count = count + 1)
            } else {
              recIter(sym, len - 1, count)
            }
          }
        }

        recIter(sym, len,  0)
      }

      //non tail-recursive
    def countSymRec(sym: Char, str: String, len: Int, count: Int) : Int = {
      def recIter(sym: Char, len: Int, count: Int) : Int = {
        if (len == 0) {
          count
        } else {
          if (str.charAt(len - 1).equals(sym)) {
            0 + recIter(sym, len - 1, count = count + 1)
          } else {
            0 + recIter(sym, len - 1, count)
          }
        }
      }
      0 + recIter(sym, len, 0)
    }

    def simplyNum(list: List[Int]) : List[Int] = {
      
    }




  }


