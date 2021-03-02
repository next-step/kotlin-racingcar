package calculator.domain

import java.lang.IllegalArgumentException

data class Operand(val number: Double) {
    companion object {
        fun of(input: String): Operand = Operand(getValidatedValue(input))

        private fun getValidatedValue(number: String): Double {
            try {
                return number.toDouble()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("올바르지 않은 피연산자 타입입니다")
            }
        }
    }
}
