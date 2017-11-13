package futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Transformations {
  def main(args: Array[String]): Unit = {
    val fut = Future { Thread.sleep(10000); 21 + 21 }

    val result = fut.map(x => x + 1)

    println(result.value)

    Thread.sleep(10000)

    println(result.value)

    println(
    for {
      x <- Future { Thread.sleep(10000); 1 }
      y <- Future { Thread.sleep(10000); 2 }
    } yield x + y)
    
    
  }
}