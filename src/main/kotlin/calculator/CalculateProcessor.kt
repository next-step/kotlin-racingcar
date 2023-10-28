package calculator

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class CalculateProcessor {
    fun performCalculate(expressionElements: List<ExpressionElement>): ExpressionElement {
        val remainedElements: Queue<ExpressionElement> = LinkedList(expressionElements)

        val firstElement = remainedElements.poll()
        if (firstElement !is ExpressionElement.Term) {
            throw IllegalArgumentException("First type must be number")
        }

        val calculateStack = Stack<ExpressionElement>().apply {
            push(firstElement)
        }

        while (remainedElements.isNotEmpty()) {
            throwIfSameType(
                remainedElements.peek(),
                calculateStack.peek(),
            )

            val result = operate(calculateStack, remainedElements.poll())

            calculateStack.push(result)
        }

        return calculateStack.pop()
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

    private fun throwIfSameType(o1: ExpressionElement, o2: ExpressionElement) {
        if (o1.isSameType(o2)) {
            throw IllegalArgumentException("Not allow same type continuous")
        }
    }
}
