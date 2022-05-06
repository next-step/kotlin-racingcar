package study

import java.util.Deque
import java.util.LinkedList

class CalcMachine(private val operators: List<Operator>, numbers: List<Operand>) {

    private val numberQueue: Deque<Operand> = LinkedList(numbers)

    init {
        require(operators.size + 1 != this.numberQueue.size)
    }

    fun calculate(): Operand {
        operators.forEach(::processingOperators)
        return numberQueue.poll()
    }

    private fun processingOperators(operator: Operator) {
        val leftOperand = numberQueue.poll()
        val rightOperand = numberQueue.poll()
        this.numberQueue.addFirst(operator.apply(leftOperand, rightOperand))
    }
}
