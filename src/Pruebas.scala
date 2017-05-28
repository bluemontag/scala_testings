import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

object Pruebas {

	val filesHere = (new java.io.File("./src/")).listFiles

	def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

	def grep(pattern: String) =
		for (
			file <- filesHere if file.getName.endsWith(".scala");
			line <- fileLines(file) if line.trim.matches(pattern)
		) println(file + ": " + line.trim)

	def main(args: Array[String]): Unit = {
//		for (file <- filesHere if file.isFile() if file.getName().endsWith(".scala"))
//			println(file)

		//		grep(".*Unit.*")

		//		val forLineLengths =
		//			for {
		//				file <- filesHere if file.getName.endsWith(".scala")
		//				line <- fileLines(file)
		//				trimmed = line.trim
		//				if trimmed.matches(".*for.*")
		//			} yield {
		//				println(trimmed);
		//				trimmed.length;
		//			}
		//    
		//    for (leng <- forLineLengths)
		//    	println(leng)

		try {
			val name = filesHere.filter(x => x.getName.endsWith(".scala")).head.getName
			println("NAME:"+name)
			val f = new FileReader("./src/"+name)
			// Use and close file
		} catch {
			case ex: FileNotFoundException => // Handle missing file
				println("File not found")
			case ex: IOException => // Handle other I/O error
		}

	}
}