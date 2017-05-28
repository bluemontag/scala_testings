import java.io.PrintWriter
import java.io.File


object ControlStructures {
	
	def twice (op:Double=>Double, x:Double):Double = {
		op(op(x))
	}
	
	def withPrinterWriter(file:File)(op: PrintWriter => Unit) = {
		val writer = new PrintWriter(file)
      try {
        op(writer)
      } finally {
        writer.close()
      }
	}
	
	def myWhile(condition: => Boolean)(f: => Unit):Unit = {
		if (condition) {
			f
			println("Se ejecuto f.")
			myWhile(condition)(f)
		}
	}
	
	def main(args: Array[String]) = {
		//twice
		print(twice(_ + 1, 5))
		
		val file = new File("fecha.txt")
		
		withPrinterWriter(file) {
			writer=>
				var i = 1
				myWhile(i<=50) {
					writer.println(i)
					i = i + 1
				}
		}
		
	}
}