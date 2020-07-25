package calculator

import java.lang.IllegalArgumentException

class StringCalculator {
    companion object {
        fun calculate(value: String): Int {
            val values = value.split(" ")

            var result = Integer.parseInt(values[0])
            for (x in 1 until values.size step 2) {
                val operator = values[x]
                val second = Integer.parseInt(values[x + 1])
                result = calculate(result, operator, second)
            }
            return result
        }

        private fun calculate(first: Int, operator: String, second: Int): Int {
            if (operator == "+")
                return first + second
            if (operator == "-")
                return first - second
            if (operator == "*")
                return first * second
            if (operator == "/")
                return first / second

            throw IllegalArgumentException("사칙 연산 기호만 입력할 수 있습니다.")
        }
    }
}
