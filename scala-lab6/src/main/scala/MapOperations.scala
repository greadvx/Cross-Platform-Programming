

object MapOperations extends App {

  def reverse[T, U](map: Map[T,U]): Map[U, T] = {
    if (map.isEmpty) Map()
    for ((key, value) <- map) yield (value, key)
  }

}
