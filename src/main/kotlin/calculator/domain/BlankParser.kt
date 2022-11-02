package calculator.domain

import java.util.*

class BlankParser {

    fun parseOperators(expression: String): Operators {
        val operatorQueue: Queue<Operator> = LinkedList()
        val split = expression.split(DELIMITER)

        var i = 1
        while (i < split.size) {
            operatorQueue.offer(Operator(split[i]))
            i += 2
        }
        return Operators(operatorQueue)
    }

    fun parseOperands(expression: String): Operands {
        val operandQueue: Queue<Operand> = LinkedList()
        val split = expression.split(DELIMITER)

        var i = 0
        while (i < split.size) {
            operandQueue.offer(Operand(split[i]))
            i += 2
        }
        return Operands(operandQueue)
    }

    private companion object {
        private const val DELIMITER = " "
    }
}
