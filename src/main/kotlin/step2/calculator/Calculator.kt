package step2.calculator

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

object Calculator {
    private const val DELIMITER = " "

    /**
     * 1. 중위표기법 -> 후위표기법 변환
     * 2. 후위표기법 계산
     * */
    fun calculate(expression: String): Int {
        val postfixExpression = makePostfixExpression(expression)

        return calculatePostfixExpression(postfixExpression)
    }

    private fun makePostfixExpression(expression: String): Queue<String> {
        val queue = LinkedList<String>()
        val stack = Stack<String>()

        val tokens = expression.split(DELIMITER)
        tokens.forEach { token ->
            if (token.isNumber()) {
                queue.add(token)

                return@forEach
            }

            if (token.isOperator()) {
                while (stack.isNotEmpty() &&
                    OperatorType.of(stack.peek()).priority >= OperatorType.of(token).priority
                ) {
                    queue.add(stack.pop())
                }
                stack.push(token)

                return@forEach
            }

            throw IllegalArgumentException("지원하지 않는 문자입니다.")
        }

        while (stack.isNotEmpty()) {
            queue.add(stack.pop())
        }

        return queue
    }

    private fun calculatePostfixExpression(postfixExpression: Queue<String>): Int {
        val stack = Stack<Int>()

        postfixExpression.forEach { token ->
            if (token.isNumber()) {
                stack.push(token.toNumber())
                return@forEach
            }

            val right = stack.safePop()
            val left = stack.safePop()
            val result = OperatorType.of(token).calculate(left, right)
            stack.push(result)
        }

        return stack.pop()
    }

    private fun String.toNumber(): Int = this.toInt()

    private fun String.isNumber(): Boolean = this.toIntOrNull() != null

    private fun String.isOperator(): Boolean = OperatorType.isOperator(this)

    private fun <E> Stack<E>.safePop(): E {
        require(this.isNotEmpty()) { "잘못된 수식입니다." }

        return this.pop()
    }
}

private enum class OperatorType(
    val symbol: String,
    val calculate: (left: Int, right: Int) -> Int,
    val priority: Int,
) {
    PLUS("+", { left, right -> left + right }, 1),
    MINUS("-", { left, right -> left - right }, 1),
    MULTIPLY("*", { left, right -> left * right }, 1),
    DIVIDE("/", { left, right -> left / right }, 1), ;

    companion object {
        private val map = values().associateBy { it.symbol }

        fun of(symbol: String): OperatorType {
            return map[symbol] ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }

        fun isOperator(symbol: String): Boolean {
            return map.containsKey(symbol)
        }
    }
}
