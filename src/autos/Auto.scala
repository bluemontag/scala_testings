package autos

class Auto(val cantidadRuedas: Int) {
  var cantRuedas = cantidadRuedas
  
  def ruedas : Int = {
    cantRuedas
  }
  
  def andar() {
    println("Un auto andando... en " + cantRuedas)
  }
}

object Auto {
  def main(args: Array[String]) {
    
    val t = new Auto(4)
    println(t.andar)
    
    val b = new Torino(5)
    println(b.andar)
    
  }
}