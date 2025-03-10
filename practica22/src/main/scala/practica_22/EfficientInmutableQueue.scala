/*package practica_22

import practica_22.extras.EfficientQueue

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

class EfficientQueue[T](front: List[T], rear: List[T]) extends ImmutableQueue[T] {
  ...
}

@main def testImmutableQueue(): Unit = {
  val squeue = new EfficientQueue[Int]()
  val q = squeue.enqueue(1).enqueue(2).enqueue(3).enqueue(4)
  assert(q.dequeue() == (1, EfficientQueue(List(2, 3, 4), List())), s"${q.dequeue()} should be equal to (1, SimpleQueue(List(2, 3, 4)))")
  assert(squeue.isEmpty, s"{q} should be empty")
  assert(!q.isEmpty, s"{q should not be empty")
  val q2 = EfficientQueue(List(1, 2, 3, 4), List())
  assert(q == q2, s"${q} and ${q2} should be equal")
  assert(q.hashCode() == q2.hashCode(), s"The hash codes of ${q} and ${q2} should be equal")
}
*/