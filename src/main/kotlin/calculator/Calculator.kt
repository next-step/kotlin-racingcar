package calculator

import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import kotlin.IllegalArgumentException

class Calculator {
    fun calculate(expression: String?): Int {
        val expressions = ExpressionParser().parse(expression)

        return when (val result = performCalculation(expressions)) {
            is ExpressionType.Term -> result.value
            is ExpressionType.Operator -> throw IllegalArgumentException("Last type must be number")
        }
    }

    private fun performCalculation(expressions: List<ExpressionType>): ExpressionType {
        val expressionQueue: Queue<ExpressionType> = LinkedList(expressions)

        val firstItem = expressionQueue.poll()
        if (firstItem !is ExpressionType.Term) {
            throw IllegalArgumentException("First type must be number")
        }

        val expressionStack = Stack<ExpressionType>()

        expressionStack.push(firstItem)

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

    private fun throwIfSameType(o1: ExpressionType, o2: ExpressionType) {
        if (o1.isSameType(o2)) {
            throw IllegalArgumentException("Not allow same type continuous")
        }
    }

    private fun operate(
        expressionStack: Stack<ExpressionType>,
        currentItem: ExpressionType,
    ): ExpressionType {
        val peek = expressionStack.peek()

        if (peek is ExpressionType.Term) {
            return currentItem
        }

        val operator = expressionStack.pop() as ExpressionType.Operator
        val firstTerm = expressionStack.pop() as ExpressionType.Term
        val secondTerm = currentItem as ExpressionType.Term

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
