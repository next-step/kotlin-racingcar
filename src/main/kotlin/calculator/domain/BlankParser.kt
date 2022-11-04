package calculator.domain

import java.util.*

class BlankParser {

    fun parseOperators(expression: String): Operators {
        validateExpression(expression)

        val operatorQueue: Queue<Operator> = LinkedList()
        val split = expression.split(DELIMITER)

        for (i in 1 until split.size step 2) {
            operatorQueue.offer(Operator(split[i]))
        }
        return Operators(operatorQueue)
    }

    fun parseOperands(expression: String): Operands {
        validateExpression(expression)

        val operandQueue: Queue<Operand> = LinkedList()
        val split = expression.split(DELIMITER)

        for (i in split.indices step 2) {
            operandQueue.offer(Operand(split[i]))
        }
        return Operands(operandQueue)
    }

    private fun validateExpression(expression: String) {
        if (expression.isBlank()) {
            throw IllegalArgumentException()
        }
    }

    private companion object {
        private const val DELIMITER = " "
    }
}
