package calculator.application

import calculator.application.Operator.ADD
import calculator.application.Operator.DIV
import calculator.application.Operator.MUL
import calculator.application.Operator.SUB
import java.util.Stack

class Engine(
    private val tokenizer: Tokenizer,
    private val converter: Converter,
) {
    fun compute(expr: String?): String {
        val infixTokens: List<String> = tokenizer.tokenize(expr!!)
        val postfixTokens = converter.covertToPostfix(infixTokens)

        val stack: Stack<String> = Stack<String>()
        for (token in postfixTokens) {
            if (isOperand(token)) {
                stack.add(token)
            } else {
                val rightOperand: String = stack.pop()
                val leftOperand: String = stack.pop()
                val operator: String = token

                val result: Int = calculate(leftOperand = leftOperand, rightOperand = rightOperand, operator = operator)
                stack.add(result.toString())
            }
        }
        return stack.pop()
    }

    private fun calculate(
        leftOperand: String,
        rightOperand: String,
        operator: String,
    ): Int {
        return when (operator) {
            ADD.operator -> leftOperand.toInt() + rightOperand.toInt()
            SUB.operator -> leftOperand.toInt() - rightOperand.toInt()
            MUL.operator -> leftOperand.toInt() * rightOperand.toInt()
            DIV.operator -> {
                if (rightOperand.toInt() == 0) {
                    throw ArithmeticException("나누기 연산의 오른쪽 피연산자가 0입니다.")
                }
                leftOperand.toInt() / rightOperand.toInt()
            }
            else -> throw IllegalArgumentException()
        }
    }

    private fun isOperand(token: String): Boolean {
        return token.matches(Regex("\\d+"))
    }
}
