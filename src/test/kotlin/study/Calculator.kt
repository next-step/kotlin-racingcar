package study

import java.util.Stack

class Calculator {
    private val numberStack = Stack<Int>()
    private val operatorStack = Stack<(a: Int, b: Int) -> Int>()

    fun calc(str: String): Int {
        val splitStr = str.split(" ")

        splitStr.forEach { s ->
            when {
                s == "+" -> operatorStack.push(plusLambda)
                s == "-" -> operatorStack.push(minusLambda)
                s == "*" -> operatorStack.push(timesLambda)
                s == "/" -> operatorStack.push(divideLambda)
                isInt(s) -> processMidCalc(s.toInt())
                else -> throw IllegalArgumentException()
            }
        }
        return numberStack.pop()
    }

    private fun processMidCalc(s: Int) {
        if (operatorStack.isNotEmpty()) {
            val targetOperator = operatorStack.pop()
            numberStack.push(targetOperator(numberStack.pop(), s))
        } else {
            numberStack.add(s)
        }
    }
}

var plusLambda = { a: Int, b: Int -> a + b }
var minusLambda = { a: Int, b: Int -> a - b }
var timesLambda = { a: Int, b: Int -> a * b }
var divideLambda = { a: Int, b: Int -> if (b == 0) 0 else a / b }

fun isInt(s: String): Boolean = s.toIntOrNull() != null
