package study.step2

import java.lang.IllegalArgumentException
import java.util.Stack

class Calculator {
    fun calculate(input: String): Int {
        val operandStack = Stack<Int>()
        val operatorStack = Stack<Operator>()

        val inputSplit = input.split(" ")

        inputSplit.forEach { s: String ->
            when {
                s.toIntOrNull() != null && operandStack.isEmpty() -> operandStack.add(s.toInt())
                Operator.values().map { o -> o.operator }.contains(s) -> addOperatorStack(operatorStack, s)
                s.toIntOrNull() != null -> operandStack.add(process(operandStack, operatorStack, s.toInt()))
                else -> throw IllegalArgumentException()
            }
        }

        return operandStack.pop()
    }

    private fun addOperatorStack(operatorStack: Stack<Operator>, s: String) {
        if (!operatorStack.empty()) {
            throw IllegalArgumentException()
        }

        operatorStack.add(Operator.values().find { o -> o.operator == s })
    }

    private fun process(operandStack: Stack<Int>, operatorStack: Stack<Operator>, s: Int): Int {
        if (operatorStack.empty()) {
            throw IllegalArgumentException()
        }

        return operatorStack.pop()
            .operate(operandStack.pop(), s)
    }
}
