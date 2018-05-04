import org.scalatest.FunSuite

class ListTest extends FunSuite {

  ///mySwap testing
    test("mySwap odd") {
      assert(ListOperations.mySwap(List(2,1,4,3)) === List(1,2,3,4))
    }
    test("mySwap not odd") {
      assert(ListOperations.mySwap(List(2,1,6)) === List(1,2,6))
    }
    test("mySwap empty count") {
      assert(ListOperations.mySwap(List()) === List())
    }


  ///myLenR
    test("myLenR empty") {
      assert(ListOperations.myLenR(List()) === 0)
    }
    test("myLenR 1 element") {
      assert(ListOperations.myLenR(List(1)) === 1)
    }


  ///myLenL
    test("myLenL empty") {
      assert(ListOperations.myLenL(List()) === 0)
    }
    test("myLenL 1 element") {
      assert(ListOperations.myLenL(List(1)) === 1)
    }


}
