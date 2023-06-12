package calculator

import java.util.LinkedList
import java.util.Queue

class StringCalculator {
    fun calculate(expression: String): Int {
        val expressionQueue = buildExpressionQueue(expression.replace(" ", ""))
        var result = 0
        var operator = "+"
        while (expressionQueue.isNotEmpty()) {
            val element = expressionQueue.poll()
            if (isNumeric(element)) {
                result = Calculator(result, operator, element.toInt()).calculate()
            } else {
                operator = element
            }
        }

        return result
    }

    fun isNumeric(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }

    fun buildExpressionQueue(sanitizedExpression: String): Queue<String> {
        val queue: Queue<String> = LinkedList()
        var currentNumber = ""
        for (char in sanitizedExpression) {
            currentNumber = if (char.isDigit()) {
                currentNumber + "" + char
            } else {
                queue.offer(currentNumber)
                queue.offer(char.toString())
                ""
            }
        }
        queue.offer(currentNumber)
        return queue
    }
}
