package org.bmsk.calculator.model

import org.bmsk.calculator.StringCalculator
import org.bmsk.calculator.mapper.toOperator
import org.bmsk.calculator.util.isNumeric
import org.bmsk.calculator.util.isOperator
import org.bmsk.calculator.validator.StringFormulaValidator
import java.util.Stack

data class StringFormula(val formula: String) {

    fun calculate(): Float {
        StringFormulaValidator.validate(this)

        val numStack = Stack<String>()
        val operatorStack = Stack<Operator>()
        formula.split(" ").forEach { token ->
            when {
                token.isOperator() -> {
                    applyPendingOperation(numStack, operatorStack)
                    operatorStack.push(token.toOperator())
                }

                token.isNumeric() -> {
                    numStack.push(token)
                }
            }
        }
        applyAllPendingOperations(numStack, operatorStack)
        return numStack.pop().toFloat()
    }

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
