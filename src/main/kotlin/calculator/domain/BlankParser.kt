package calculator.domain

import java.util.*

class BlankParser : Parser {

    override fun parseOperators(expression: String): Operators {
        validateExpression(expression)

        val operatorQueue: Queue<Operator> = LinkedList()
        val split = expression.split(DELIMITER)

        for (i in 1 until split.size step 2) {
            operatorQueue.offer(Operator.from(split[i]))
        }
        return Operators(operatorQueue)
    }

    override fun parseOperands(expression: String): Operands {
        validateExpression(expression)

        val operandQueue: Queue<Operand> = LinkedList()
        val split = expression.split(DELIMITER)

        for (i in split.indices step 2) {
            operandQueue.offer(Operand(split[i]))
        }
        return Operands(operandQueue)
    }

    private fun validateExpression(expression: String) {
        require(expression.isNotBlank())
    }

    private companion object {
        private const val DELIMITER = " "
    }
}
