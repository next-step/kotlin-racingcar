package study.step2

import java.util.Stack

class Calculator {
    fun calc(str: String): Int {
        val numberStack = Stack<Int>()
        val operatorStack = Stack<(a: Int, b: Int) -> Int>()
        val splitStr = str.split(EMPTY_SPACE)

        validEmpty(str)
        validRule(splitStr)

        splitStr.forEach { s ->
            when {
                OperatorEnum.exist(s) -> operatorStack.push(OperatorEnum.findby(s).process())
                s.isInt() -> processMidCalc(numberStack, operatorStack, s.toInt())
            }
        }
        return numberStack.pop()
    }

    private fun validEmpty(str: String) {
        if (str.trim().isEmpty()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자가 될 수 없습니다")
        }
    }

    private fun validRule(splitStr: List<String>) {
        splitStr.forEachIndexed { index, s ->
            val isInt = s.isInt()
            val existOperator = OperatorEnum.exist(s)
            if (!isInt && !existOperator) {
                throw IllegalArgumentException("올바르지 않은 사칙연산 기호입니다")
            }

            val numberRule = index.mod(2) == 0 && isInt
            val operatorRule = index.mod(2) == 1 && existOperator
            if (!numberRule && !operatorRule) {
                throw IllegalArgumentException("계산식의 순서가 맞지 않습니다")
            }
        }
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

    companion object {
        const val EMPTY_SPACE = " "
    }
}

fun String.isInt(): Boolean = this.toIntOrNull() != null
