import ChecksumAccumulator.calculate
import scala.collection.mutable.ArrayOps

object Summer {
  def main(args: Array[String]) = {
    for (arg <- args)
      println(arg + ": " + calculate(arg))
  }
}