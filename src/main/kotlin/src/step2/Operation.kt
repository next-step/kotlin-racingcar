package src.step2

import kotlin.IllegalArgumentException

interface Calculable {
    fun calculate(x: Int, y: Int): Int
}

enum class Operation(val symbol: Char) : Calculable {
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
    };
    companion object {
        fun findSymbol(symbol: Char?): Operation {
            checkNotNull(symbol) { "연산자가 없습니다" }
            return Operation.values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("연산자를 찾을 수 없습니다")
        }
    }
}

object StringCalculator {

    fun execute(value: String?): Int {
        validate(value)

        var result = 0
        var symbol: Char? = null
        value!!.forEachIndexed forEach@{ index, it ->
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
            result = Operation.findSymbol(symbol).calculate(result, Character.getNumericValue(it))
        }

        return result
    }

    private fun validate(value: String?) {
        if (value.isNullOrBlank()) throw IllegalArgumentException("값이 입력되지 않았습니다")
        val symbolCount = value.count { it -> it in Operation.values().map { it.symbol }.toList() }
        if (symbolCount == 0) throw IllegalArgumentException("연산자가 입력되지 않았습니다")
        val numberCount = value.count { it.isDigit() }
        if (numberCount == 0) throw IllegalArgumentException("숫자가 입력되지 않았습니다")
    }
}
