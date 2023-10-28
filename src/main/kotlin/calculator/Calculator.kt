package calculator

import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import kotlin.IllegalArgumentException

class Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            throw java.lang.IllegalArgumentException("Expression cannot be null or blank")
        }

        val expressions = ExpressionParser().parse(expression)

        return when (val result = performCalculation(expressions)) {
            is ExpressionElement.Term -> result.value
            is ExpressionElement.Operator -> throw IllegalArgumentException("Last type must be number")
        }
    }

    private fun performCalculation(expressionElements: List<ExpressionElement>): ExpressionElement {
        val expressionQueue: Queue<ExpressionElement> = LinkedList(expressionElements)

        val firstItem = expressionQueue.poll()
        if (firstItem !is ExpressionElement.Term) {
            throw IllegalArgumentException("First type must be number")
        }

        val expressionStack = Stack<ExpressionElement>().apply {
            push(firstItem)
        }

        while (expressionQueue.isNotEmpty()) {
            throwIfSameType(
                expressionQueue.peek(),
                expressionStack.peek(),
            )

            val result = operate(expressionStack, expressionQueue.poll())

            expressionStack.push(result)
        }

        return expressionStack.pop()
    }

    private fun throwIfSameType(o1: ExpressionElement, o2: ExpressionElement) {
        if (o1.isSameType(o2)) {
            throw IllegalArgumentException("Not allow same type continuous")
        }
    }

    private fun operate(
        expressionStack: Stack<ExpressionElement>,
        element: ExpressionElement,
    ): ExpressionElement {
        val peek = expressionStack.peek()

        if (peek is ExpressionElement.Term) {
            return element
        }

        val operator = expressionStack.pop() as ExpressionElement.Operator
        val firstTerm = expressionStack.pop() as ExpressionElement.Term
        val secondTerm = element as ExpressionElement.Term

        return operator.operate(firstTerm, secondTerm)
    }
}
