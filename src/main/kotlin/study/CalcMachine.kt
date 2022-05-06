package study

import java.util.Deque
import java.util.LinkedList

class CalcMachine(private val stringOperators: List<StringOperator>, numbers: List<Operand>) {

    private val numberQueue: Deque<Operand> = LinkedList(numbers)

    init {
        require(stringOperators.size + 1 == this.numberQueue.size)
    }

    fun calculate(): Operand {
        stringOperators.forEach(::processingOperators)
        return numberQueue.poll()
    }

    private fun processingOperators(stringOperator: StringOperator) {
        val leftOperand = numberQueue.poll()
        val rightOperand = numberQueue.poll()
        this.numberQueue.addFirst(stringOperator.apply(leftOperand, rightOperand))
    }
}
