package autos

class Torino(override val cantidadRuedas: Int) extends Auto(cantidadRuedas) {
  
  
  override def ruedas : Int = {
    10
  }
  
  override def andar() {
    println("Un torino andando en " + this.ruedas)
  }
}