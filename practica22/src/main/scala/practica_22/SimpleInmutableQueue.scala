package practica_22

trait ImmutableQueue[T] {
  def enqueue(elem: T): ImmutableQueue[T]
  def dequeue(): (T, ImmutableQueue[T])
  def isEmpty: Boolean
}

case class SimpleQueue[T](elems: List[T]) extends ImmutableQueue[T] {
  def this() = this(List())

  override def enqueue(elem: T): ImmutableQueue[T] = SimpleQueue(elems.appended(elem))

  override def dequeue(): (T, ImmutableQueue[T]) =
    if(elems.isEmpty) throw new UnsupportedOperationException("La cola esta vacia")//Excepcion si cola vacia
    else (elems.head, SimpleQueue(elems.tail)) //Borra el primer elemento y hace una cola nueva sin el

  override def isEmpty: Boolean = elems.isEmpty

  override def toString: String = elems.mkString("Lista(", ", ", ")")

  override def equals(obj: Any): Boolean = obj match
    case that: SimpleQueue[T] => this.elems.equals(that.elems)
    case _ => false

  override def hashCode(): Int = elems.hashCode()
}

@main def testImmutableQueue(): Unit = {
  val squeue = new SimpleQueue[Int]()
  val q = squeue.enqueue(1).enqueue(2).enqueue(3).enqueue(4)
  assert(q.dequeue() == (1, SimpleQueue(List(2, 3, 4))), s"${q.dequeue()} should be equal to (1, SimpleQueue(List(2, 3, 4)))")
  assert(squeue.isEmpty, s"{q} should be empty")
  assert(!q.isEmpty, s"{q should not be empty")
  val q2 = SimpleQueue(List(1, 2, 3, 4))
  assert(q == q2, s"${q} and ${q2} should be equal")
  assert(q.hashCode() == q2.hashCode(), s"The hash codes of ${q} and ${q2} should be equal")
}