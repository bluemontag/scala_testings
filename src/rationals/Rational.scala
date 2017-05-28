package rationals

class Rational(n: Int, d: Int) {
	//println("Created " + n + "/" + d)
	require(d != 0)
	val g = gcd(n, d)
	val numer: Int = n / g
	val denom: Int = d / g
	def this(n: Int) = this(n, 1) // auxiliary constructor
	override def toString = numer + "/" + denom

	def +(that: Rational): Rational =
		new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

	def +(i: Int): Rational =
		new Rational(numer + i * denom, denom)

	def -(that: Rational): Rational =
		new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

	def -(i: Int): Rational =
		new Rational(numer - i * denom, denom)

	def *(that: Rational): Rational =
		new Rational(numer * that.numer, denom * that.denom)

	def *(i: Int): Rational =
		new Rational(numer * i, denom)

	def /(that: Rational): Rational =
		new Rational(numer * that.denom, denom * that.numer)

	def /(i: Int): Rational =
		new Rational(numer, denom * i)

	def lessThan(that: Rational) =
		this.numer * that.denom < that.numer * this.denom

	def max(that: Rational) =
		if (lessThan(that)) that else this

	private def gcd(a: Int, b: Int): Int = {
		//		println("gcd("+a+","+b+")")
		if (b == 0) a else gcd(b, a % b)
	}
}

object Rational {
	implicit def intToRational(x: Int) = new Rational(x) //esto tiene que estar en scope para que funcione 7 * r (donde r es Rational)

	def main(args: Array[String]): Unit = {
		/*print(new Rational(7,4))
		val oneHalf = new Rational(1, 2)
		val twoThirds = new Rational(2, 3)

		println(oneHalf + " * " + twoThirds + " = " + (oneHalf * twoThirds))

		println(oneHalf + " + " + twoThirds + " = " + (oneHalf + twoThirds))

		println(twoThirds * 7)
		
		println(7 * twoThirds)*/

		println("Resultado = "+(new Rational(1).gcd(9, 3)))

	}
}