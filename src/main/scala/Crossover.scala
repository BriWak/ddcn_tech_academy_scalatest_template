object Crossover extends App {

  def apply(string1: String, string2: String, index: Int) : (String, String) = {
    val start1 = string1.drop(string1.length-index)
    val start2 = string2.drop(string2.length-index)
    val end1 = string1.takeRight(string1.length-index)
    val end2 = string2.takeRight(string2.length-index)
    (start1 + end2, start2 + end1)
  }

}
