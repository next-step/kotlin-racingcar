package study.step2

import java.util.Stack

class Calculator {
    fun calc(str: String): Int {
        val numberStack = Stack<Int>()
        val operatorStack = Stack<(a: Int, b: Int) -> Int>()
        val splitStr = str.split(" ")

        validRule(splitStr)

        splitStr.forEachIndexed { index, s ->
            println("index $index")
            when {
                s == "+" -> operatorStack.push(plusLambda)
                s == "-" -> operatorStack.push(minusLambda)
                s == "*" -> operatorStack.push(timesLambda)
                s == "/" -> operatorStack.push(divideLambda)
                isInt(s) -> processMidCalc(numberStack, operatorStack, s.toInt())
                else -> throw IllegalArgumentException()
            }
        }
        return numberStack.pop()
    }

    private fun validRule(splitStr: List<String>) {
        splitStr.forEachIndexed { index, s ->
            val numberRule = index.mod(2) == 0 && isInt(s)
            val operatorRule = index.mod(2) == 1 && OperatorEnum.exist(s)

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
}

var plusLambda = { a: Int, b: Int -> a + b }
var minusLambda = { a: Int, b: Int -> a - b }
var timesLambda = { a: Int, b: Int -> a * b }
var divideLambda = { a: Int, b: Int -> if (b == 0) 0 else a / b }

fun isInt(s: String): Boolean = s.toIntOrNull() != null
