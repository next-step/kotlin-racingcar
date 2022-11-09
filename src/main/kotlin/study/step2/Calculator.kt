package study.step2

import java.lang.IllegalArgumentException
import java.util.Stack

class Calculator {
    fun calculate(formula: String): Int {
        val operandStack = Stack<Int>()
        val operatorStack = Stack<Operator>()

        val formulaSplit = formula.split(" ")

        formulaSplit.forEach { formula: String ->
            when {
                formula.toIntOrNull() != null -> addOperandStack(operandStack, formula)
                Operator.contains(formula) -> addOperatorStack(operatorStack, formula)
                else -> throw IllegalArgumentException("연산자나 피연산자가 아닌 값이 입력되었습니다.")
            }

            if (canOperate(operandStack, operatorStack)) operandStack.add(process(operandStack, operatorStack))
        }

        return operandStack.pop()
    }

    private fun hasTwoOperands(operandStack: Stack<Int>): Boolean {
        return operandStack.size >= 2
    }

    private fun canOperate(operandStack: Stack<Int>, operatorStack: Stack<Operator>) =
        hasTwoOperands(operandStack) && operatorStack.isNotEmpty()

    private fun addOperandStack(operandStack: Stack<Int>, formula: String) {
        require(!hasTwoOperands(operandStack)) {
            "연산자 자리에 피연산자가 입력되었습니다."
        }

        operandStack.add(formula.toInt())
    }

    private fun addOperatorStack(operatorStack: Stack<Operator>, s: String) {
        require(operatorStack.isEmpty()) {
            "피연산자 자리에 연산자가 입력되었습니다."
        }

        operatorStack.add(Operator.find(s))
    }

    private fun process(operandStack: Stack<Int>, operatorStack: Stack<Operator>): Int {
        val secondOperand = operandStack.pop()
        val firstOperand = operandStack.pop()

        return operatorStack.pop()
            .operate(firstOperand, secondOperand)
    }
}
