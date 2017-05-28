package traits

trait ConcatDog extends StringConcatenation {
  abstract override def addSomething():Unit = {
  	println("DOG")
  	super.addSomething()
  }
}