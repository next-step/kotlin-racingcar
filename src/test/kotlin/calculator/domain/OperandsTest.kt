package calculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.util.LinkedList
import java.util.Queue

class OperandsTest :StringSpec() {
    init {
        "Operands 에 저장되어 있는 Operand 를 꺼낼 수 있다" {
            val operandQueue: Queue<Operand> = LinkedList()
            operandQueue.offer(Operand(0))
            operandQueue.offer(Operand(1))
            operandQueue.offer(Operand(2))

            val operands = Operands(operandQueue)

            operands.pull() shouldBe Operand(0)
            operands.pull() shouldBe Operand(1)
            operands.pull() shouldBe Operand(2)
        }
    }
}
