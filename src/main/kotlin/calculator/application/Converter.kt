package calculator.application

import calculator.application.Operator.Companion.isOperator
import java.util.LinkedList

class Converter {
    fun covertToPostfix(infixTokens: List<String>): List<String> {
        val operands: MutableList<String> = LinkedList<String>()
        val operators: MutableList<String> = LinkedList<String>()

        for (infixToken: String in infixTokens) {
            if (isOperator(infixToken)) {
                operators.add(infixToken)
            } else {
                operands.add(infixToken)
            }
        }
        operators.reverse()
        return operands + operators
    }
}
