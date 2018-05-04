

object ListOperations extends App {

  def mySwap(list: List[Int]):List[Int] = {
    if (list.isEmpty) List()
    else {
      if (list.length == 1) List(list.head)
      else {
        List(list(1), list.head) ++ mySwap(list.drop(2))
      }
    }
  }

  def myLenR[T](list: List[T]): Int =
    (list foldRight 0)((_, acc) => acc + 1)

  def myLenL[T](list: List[T]): Int =
    (list foldLeft 0)((acc, _) => acc + 1)
}
