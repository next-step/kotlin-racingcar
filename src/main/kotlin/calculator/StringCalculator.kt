package calculator

import java.lang.IllegalArgumentException

class StringCalculator {
    companion object {
        fun calculate(value: String?): Int {
            if (isBlank(value)) {
                throw IllegalArgumentException("입력 값은 null이 될 수 없습니다.")
            }

            val values = value!!.split(" ")

            var result = toInt(values[0])
            for (x in 1 until values.size step 2) {
                result = calculate(result, values[x], toInt(values[x + 1]))
            }
            return result
        }

        private fun isBlank(value: String?) = value == null || value.isBlank()

        private fun toInt(value: String) = Integer.parseInt(value)

        private fun calculate(first: Int, operator: String, second: Int): Int {
            val operator = Operator.valueOfSign(operator)
            return operator.operation(first, second)
        }
    }
}

enum class Operator(val sign: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun valueOfSign(sign: String): Operator {
            return values().firstOrNull { it.sign == sign }
                ?: throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
        }
    }
}
