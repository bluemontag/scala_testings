package types

import types.Wild;

/*object covariant {
  def main(args : String[String]) : Unit {

  }
}*/

class CoQueue[+T]() {
  def enqueue[S >: T](x: S): Unit = {
    println("Enqueued in covariant position")
  }
}

object Main {
  def main(args: Array[String]) = {
    val q1 = new CoQueue[Integer];
    val q2 = new CoQueue[Number];

    println(q1.enqueue(new java.lang.Double(2.3)));
    println(q2.enqueue(new Integer(2)));
    println(4.getClass());
    
    val contents = (new Wild).contents;
  }
}

class EffQueue[+T] private (
  private[this] var leading: List[T],
  private[this] var trailing: List[T]) {

  private def mirror() =
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
  def head: T = {
    mirror()
    leading.head
  }
  def tail: EffQueue[T] = {
    mirror()
    new EffQueue(leading.tail, trailing)
  }
  def enqueue[U >: T](x: U) =
    new EffQueue[U](leading, x :: trailing)
}
