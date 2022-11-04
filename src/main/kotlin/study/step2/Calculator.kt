package study.step2

import java.util.Stack

class Calculator {
    fun calc(str: String): Double {
        val numberStack = Stack<Double>()
        val operatorStack = Stack<(a: Double, b: Double) -> Double>()
        val splitStr = str.split(EMPTY_SPACE)

        validRule(splitStr)

        splitStr.forEach { s ->
            when {
                OperatorEnum.exist(s) -> operatorStack.push(OperatorEnum.findby(s).process())
                isDouble(s) -> processMidCalc(numberStack, operatorStack, s.toDouble())
                else -> throw IllegalArgumentException()
            }
        }
        return numberStack.pop()
    }

    private fun validRule(splitStr: List<String>) {
        splitStr.forEachIndexed { index, s ->
            val numberRule = index.mod(2) == 0 && isDouble(s)
            val operatorRule = index.mod(2) == 1 && OperatorEnum.exist(s)

            if (!numberRule && !operatorRule) {
                throw IllegalArgumentException("계산식의 순서가 맞지 않습니다")
            }
        }
    }

    private fun processMidCalc(
        numberStack: Stack<Double>,
        operatorStack: Stack<(a: Double, b: Double) -> Double>,
        s: Double
    ) {
        if (operatorStack.isNotEmpty()) {
            val targetOperator = operatorStack.pop()
            numberStack.push(targetOperator(numberStack.pop(), s))
        } else {
            numberStack.push(s)
        }
    }

    companion object {
        const val EMPTY_SPACE = " "
    }
}

fun isDouble(s: String): Boolean = s.toDoubleOrNull() != null
