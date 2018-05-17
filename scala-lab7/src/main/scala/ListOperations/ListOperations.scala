package ListOperations

object ListOperations extends App {

  def simplyNum(n: Int): Boolean = {
    !((2 until n - 1) exists (n % _ == 0))
  }

  def divideByCondition(list: List[Int]): List[Double] = list match {
    case Nil => List[Double]()
    case _ => {
      list.foldRight (List[Double]()) ((num: Int, modifiedList: List[Double]) =>
        simplyNum (num) match {
        case true => num.toDouble./ (2) :: modifiedList
        case false => num.toDouble./ (3) :: modifiedList
      })
    }
  }
}
