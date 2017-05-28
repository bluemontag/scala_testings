package testsandasserts

//import org.scalatest.Assertions._
import org.scalatest.DiagrammedAssertions._
import org.scalactic._

class Testings {
	
}

object Testings {
  def method(i:Int):Int = {
  	
  	i ensuring (i>=2, i)
  }
  
  def main(args:Array[String]):Unit = {
  	method(4)//anda bien
//  	method(1)//da AssertionError

  	var x = 1
  	
  	assert(List(1,2,3).contains(x) && x > 1)
  	
  }
}