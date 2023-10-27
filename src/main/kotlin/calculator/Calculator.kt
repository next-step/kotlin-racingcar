package calculator

import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import kotlin.IllegalArgumentException

class Calculator {
    fun calculate(expression: String): Int {
        val expressionParser = ExpressionParser()

        val expressions = expressionParser.parse(expression)

        val queue: Queue<ExpressionType> = LinkedList(expressions)

        val firstItem = queue.poll()

        val stack = Stack<ExpressionType>()

        if (firstItem !is ExpressionType.Term) {
            throw IllegalArgumentException("First type must be number")
        }

        stack.push(firstItem)

        while (queue.isNotEmpty()) {
            val item = queue.poll()

            if (item.isSameType(stack.peek())) {
                throw IllegalArgumentException("Same type cannot appear twice")
            }

            if (stack.peek() is ExpressionType.Operator) {
                val operator = stack.pop() as ExpressionType.Operator
                val firstTerm = stack.pop() as ExpressionType.Term
                val secondTerm = item as ExpressionType.Term

                val result = operate(operator, firstTerm, secondTerm)

                stack.push(result)
                continue
            }

            stack.push(item)
        }

        return when (val result = stack.pop()) {
            is ExpressionType.Term -> result.value
            is ExpressionType.Operator -> throw IllegalArgumentException("Last type must be number")
        }
    }

    private fun operate(
        operator: ExpressionType.Operator,
        firstTerm: ExpressionType.Term,
        secondTerm: ExpressionType.Term,
    ): ExpressionType.Term {
        return when (operator) {
            ExpressionType.Operator.Add -> add(firstTerm, secondTerm)
            ExpressionType.Operator.Sub -> sub(firstTerm, secondTerm)
            ExpressionType.Operator.Multi -> multi(firstTerm, secondTerm)
            ExpressionType.Operator.Div -> div(firstTerm, secondTerm)
        }
    }

    private fun add(firstTerm: ExpressionType.Term, secondTerm: ExpressionType.Term): ExpressionType.Term {
        return firstTerm + secondTerm
    }

    private fun sub(firstTerm: ExpressionType.Term, secondTerm: ExpressionType.Term): ExpressionType.Term {
        return firstTerm - secondTerm
    }

    private fun multi(firstTerm: ExpressionType.Term, secondTerm: ExpressionType.Term): ExpressionType.Term {
        return firstTerm * secondTerm
    }

    private fun div(firstTerm: ExpressionType.Term, secondTerm: ExpressionType.Term): ExpressionType.Term {
        return firstTerm / secondTerm
    }
}
