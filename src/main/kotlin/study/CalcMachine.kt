package study

import java.util.*

class CalcMachine constructor(private val operators: List<Operator>, numbers: List<Operand>) {

    private val numberQueue: Deque<Operand> = LinkedList(numbers)

    init {
        if (operators.size + 1 != this.numberQueue.size) {
            throw IllegalArgumentException()
        }
    }

    fun calc(): Operand {
        operators.forEach(this::operatorCalc)
        return numberQueue.poll()
    }

    private fun operatorCalc(operator: Operator) {
        val lhs = numberQueue.poll()
        val rhs = numberQueue.poll()
        this.numberQueue.addFirst(operator.calc(lhs, rhs))
    }
}
