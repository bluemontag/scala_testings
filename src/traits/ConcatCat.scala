package traits

trait ConcatCat extends StringConcatenation {
  abstract override def addSomething():Unit = {
  	println("CAT!")
  	super.addSomething()
  }
}