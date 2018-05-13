//for ((key, value) <- map) yield (value, key)

object MapOperations extends App {

  def reverse[T, U](map: Map[T, U]): Map[U, T] = {
    if (map.isEmpty) Map()
    Map() ++ map.map(_.swap)
  }

}
