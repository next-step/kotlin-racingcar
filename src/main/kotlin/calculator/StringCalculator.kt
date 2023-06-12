package calculator

import calculator.exception.DivideByZeroException
import calculator.exception.IllegalExpressionException
import calculator.exception.IllegalSymbolException

object StringCalculator {
    private val symbolToFunctionMap = mapOf(
        "+" to this::add,
        "-" to this::subtract,
        "*" to this::multiply,
        "/" to this::divide
    )
    private val blankRegex = Regex(" +")
    private val numberRegex = Regex("\\d+(\\.\\d+)?")
    private val allowedCharacter = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/")

    fun calculate(arithmeticExpression: String): Float {
        if (arithmeticExpression.isBlank()) {
            throw IllegalExpressionException("표현식이 비어있습니다.")
        }

        val splitedExpression = splitByBlank(arithmeticExpression)
        val numbers: List<Float> = splitedExpression.filter { isNumber(it) }.map { it.toFloat() }
        val arithmeticSymbols = splitedExpression.filter { isOperator(it) }

        validate(splitedExpression, numbers, arithmeticSymbols)

        val result = numbers.reduceIndexed { index, acc, s ->
            doCalculate(acc, s, arithmeticSymbols[index - 1])
        }

        println(result)
        return result
    }

    private fun validate(splitedExpression: List<String>, numbers: List<Float>, arithmeticSymbols: List<String>) {
        if (splitedExpression.any { it !in allowedCharacter }) {
            throw IllegalExpressionException("숫자와 기호외의 문자가 포함되었습니다.")
        }

        if (numbers.size != arithmeticSymbols.size + 1) {
            throw IllegalExpressionException("숫자는 기호보다 1개 많아야 합니다.")
        }
    }

    private fun splitByBlank(arithmeticExpression: String): List<String> {
        return arithmeticExpression.split(blankRegex)
    }

    private fun isNumber(input: String): Boolean {
        return numberRegex.matches(input)
    }

    private fun isOperator(input: String): Boolean {
        return input in symbolToFunctionMap
    }

    private fun doCalculate(num1: Float, num2: Float, operator: String): Float {
        val operatorFunction = symbolToFunctionMap[operator] ?: throw IllegalSymbolException()
        return operatorFunction.invoke(num1, num2)
    }

    fun add(num1: Float, num2: Float) = num1 + num2

    fun subtract(num1: Float, num2: Float) = num1 - num2

    fun multiply(num1: Float, num2: Float) = num1 * num2

    fun divide(num1: Float, num2: Float): Float {
        if (num2 == 0F) {
            throw DivideByZeroException()
        }

        return num1 / num2
    }
}
