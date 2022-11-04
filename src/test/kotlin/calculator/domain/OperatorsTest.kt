package calculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import java.util.LinkedList
import java.util.Queue

class OperatorsTest : StringSpec() {
    init {
        "Operators는 저장되어 있는 Operator를 꺼낼 수 있다" {
            val operatorQueue: Queue<Operator> = LinkedList()
            operatorQueue.offer(Operator.from("+"))
            operatorQueue.offer(Operator.from("-"))
            operatorQueue.offer(Operator.from("*"))
            operatorQueue.offer(Operator.from("/"))

            val operators = Operators(operatorQueue)

            operators.poll() shouldBe Operator.from("+")
            operators.poll() shouldBe Operator.from("-")
            operators.poll() shouldBe Operator.from("*")
            operators.poll() shouldBe Operator.from("/")
        }

        "Operator는 저장되어 있는 Operator가 있는지 확인할 수 있다" {
            val operatorQueue: Queue<Operator> = LinkedList()
            operatorQueue.offer(Operator.from("+"))

            val operators = Operators(operatorQueue)

            operators.hasNext().shouldBeTrue()

            operators.poll()

            operators.hasNext().shouldBeFalse()
        }
    }
}
