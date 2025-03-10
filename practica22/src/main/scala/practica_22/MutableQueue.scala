package practica_22

import scala.collection.mutable.ArrayBuffer

trait MutableQueue[T] {
  def enqueue(elem: T): Unit
  def dequeue(): Option[T]
  def isEmpty: Boolean
}

class ArrayQueue[T](elems: T*) extends MutableQueue[T] {
  private val buffer = ArrayBuffer[T](elems: _*) //El ArrayBuffer es como el ArrayList de java

  override def enqueue(elem: T): Unit = buffer+=elem

  override def dequeue(): Option[T] =
    if(buffer.isEmpty) None
    else Some(buffer.remove(0))

  override def isEmpty: Boolean = buffer.isEmpty

  override def hashCode(): Int = buffer.hashCode()

  override def toString: String = buffer.mkString("Cola(", ", ", ")")

  //Se puede hacer tambien con isIntanceOf, como en java
  override def equals(obj: Any): Boolean = obj match
    case that: ArrayQueue[T] => this.buffer.equals(that.buffer)
    case _ => false
}

@main def testMutableQueue(): Unit = {
  val queue = new ArrayQueue[Int](1, 2, 3)
  queue.enqueue(4)
  assert(queue.dequeue().contains(1))
  assert(!queue.isEmpty)
  assert(queue == new ArrayQueue(2, 3, 4))
}
