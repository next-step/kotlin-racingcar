package study.step2

import org.apache.commons.lang3.StringUtils

class Calculator {
    private var symbol = "+"
    private var result = 0

    companion object {
        private val operations: Map<String, (Int, Int) -> Int> = mapOf(
            "+" to { result, number -> result + number },
            "-" to { result, number -> result - number },
            "*" to { result, number -> result * number },
            "/" to { result, number ->
                if (number == 0) {
                    throw ArithmeticException("0으로 나눌 수 없습니다.")
                } else {
                    result / number
                }
            },
        )
    }

    fun calculate(targetStr: String?): Int {
        if (StringUtils.isBlank(targetStr)) throw IllegalArgumentException("문자열을 null 이거나 빈 문자열일 수 없습니다.")
        initCalculator()
        targetStr?.split(" ")?.map(this::dealEachSymbol)

        return result
    }

    private fun initCalculator() {
        symbol = "+"
        result = 0
    }

    private fun dealEachSymbol(value: String) {
        when (val number = value.toIntOrNull()) {
            null -> changeSymbol(value)
            else -> operations[symbol]?.let { result = it(result, number) }
        }
    }

    private fun changeSymbol(value: String) {
        if (value in operations.keys) {
            symbol = value
        } else {
            throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }
}
