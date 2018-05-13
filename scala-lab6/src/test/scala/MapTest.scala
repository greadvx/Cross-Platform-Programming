import org.scalatest.FunSuite

class MapTest extends FunSuite{
  test("one pair") {
    assert(MapOperations.reverse(Map(1 -> "one")) === Map("one" -> 1))
  }
  test("many pairs") {
    assert(MapOperations.reverse(Map(1->100, 2->200, 3->300)) === Map(100->1, 200->2, 300->3))
  }

}
