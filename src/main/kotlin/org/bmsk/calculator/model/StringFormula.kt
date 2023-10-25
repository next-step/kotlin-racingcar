package org.bmsk.calculator.model

import org.bmsk.calculator.StringCalculator
import org.bmsk.calculator.mapper.toOperator
import java.util.Stack

data class StringFormula(val str: String) {

    fun calculate(): Float {
        val numStack = Stack<String>()
        val operatorStack = Stack<Operator>()

        str.split(" ").forEach { token ->
            if (token.isOperator()) {
                applyPendingOperation(numStack, operatorStack)
                operatorStack.push(token.toOperator())
            } else {
                numStack.push(token)
            }
        }

        applyAllPendingOperations(numStack, operatorStack)
        return numStack.pop().toFloat()
    }

    private fun String.isOperator() = this in listOf(
        Operator.Plus.symbol,
        Operator.Minus.symbol,
        Operator.Times.symbol,
        Operator.Division.symbol,
    )

    private fun applyPendingOperation(numStack: Stack<String>, operatorStack: Stack<Operator>) {
        if (operatorStack.isNotEmpty()) {
            val poppedOperator = operatorStack.pop()
            val secondNumber = numStack.pop()
            val firstNumber = numStack.pop()
            numStack.push(poppedOperator.applyOperation(firstNumber, secondNumber))
        }
    }

    private fun applyAllPendingOperations(numStack: Stack<String>, operatorStack: Stack<Operator>) {
        while (operatorStack.isNotEmpty()) {
            applyPendingOperation(numStack, operatorStack)
        }
    }

    private fun Operator.applyOperation(first: String, second: String): String = when (this) {
        Operator.Plus -> StringCalculator.plus(first, second)
        Operator.Minus -> StringCalculator.minus(first, second)
        Operator.Times -> StringCalculator.multiply(first, second)
        Operator.Division -> StringCalculator.divide(first, second)
    }
}
