package testsandasserts

import org.scalatest.Matchers
import org.scalatest.FlatSpec
//import org.scalatest.DiagrammedAssertions._

class MyTests extends FlatSpec with Matchers {
  
	"operator +" should "be commutative" in {
		(1+2) should be (2+1)
	}
	
	it should "be associative" in {
		((1+2)+3) should be (1+(2+3))
	}
	
	"operator contains" should "return true if the element is in the list" in {
		var x = 1
  	
  	assert(List(1,2,3).contains(x))
	}
}