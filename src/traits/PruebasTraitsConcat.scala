package traits


class Prueba extends StringConcatenation {
	override def addSomething():Unit = {
		println("Final!!!!")
	}
}

object PruebasTraitsConcat {
  def main(args:Array[String]):Unit = {
  	
  	
  	var v = new Prueba with ConcatCat with ConcatDog 
  	v.addSomething()
  }
}