package src.step2

import kotlin.IllegalArgumentException

interface Calculable {
    fun calculate(x: Int, y: Int): Int
}

enum class Calculator(val symbol: Char): Calculable {
    PLUS('+') {
        override fun calculate(x: Int, y: Int): Int {
            return x + y
        }
    },
    MINUS('-') {
        override fun calculate(x: Int, y: Int): Int {
            return x - y
        }
    },
    MULTIPLY('*') {
        override fun calculate(x: Int, y: Int): Int {
            return x * y
        }
    },
    DIVIDE('/') {
        override fun calculate(x: Int, y: Int): Int {
            return x / y
        }
    }
}

object StringCalculator {

    private val symbols = listOf('+', '-', '*', '/')

    fun execute(value: String?): Int {
        validate(value)

        var result = 0
        var symbol: Char? = null
        value!!.forEachIndexed forEach@{ index, it  ->
            // 연산자를 저장
            if (!it.isDigit()) {
                symbol = it
                return@forEach
            }

            // 첫번째 숫자값을 저장
            if (index == 0) {
                result = Character.getNumericValue(it)
            }

            // 계산
            val calculator = Calculator.values().find { it.symbol == symbol }
            result =  calculator?.calculate(result, Character.getNumericValue(it))
                ?: return@forEach
        }

        return result
    }

    private fun validate(value: String?) {
        if (value.isNullOrBlank()) throw IllegalArgumentException("값이 입력되지 않았습니다")
        val isContainsSymbol = value.any { it in symbols }

        if (!isContainsSymbol) {
            throw IllegalArgumentException("연산자가 포함되지 않았습니다")
        }
    }
}