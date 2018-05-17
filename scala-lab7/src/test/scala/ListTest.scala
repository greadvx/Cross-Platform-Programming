import org.scalatest.FunSuite

class ListTest extends FunSuite{

  test("empty list") {
    assert(ListOperations.ListOperations.divideByCondition(List[Int]()) === List[Double]())
  }
  test("group of numbers") {
    assert(ListOperations.ListOperations.divideByCondition(List(1,2,3,4,5,6))
      === List(0.5, 1.0, 1.5, 1.3333333333333333, 2.5, 2.0))
  }
}
