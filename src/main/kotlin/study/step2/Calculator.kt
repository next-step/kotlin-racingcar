package study.step2

import java.util.Stack

class Calculator {
    fun calc(expression: List<String>): Int {
        val numberStack = Stack<Int>()
        val operatorStack = Stack<(a: Int, b: Int) -> Int>()

        expression.forEach { s ->
            when {
                OperatorEnum.exist(s) ->
                    OperatorEnum.findByOrNull(s)?.let {
                        operatorStack.push(it.process())
                    }

                s.isInt() -> processMidCalc(numberStack, operatorStack, s.toInt())
            }
        }
        return numberStack.pop()
    }

    private fun processMidCalc(
        numberStack: Stack<Int>,
        operatorStack: Stack<(a: Int, b: Int) -> Int>,
        s: Int
    ) {
        if (operatorStack.isNotEmpty()) {
            val targetOperator = operatorStack.pop()
            numberStack.push(targetOperator(numberStack.pop(), s))
        } else {
            numberStack.push(s)
        }
    }
}

fun String.isInt(): Boolean = this.toIntOrNull() != null
