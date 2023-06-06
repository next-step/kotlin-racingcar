package next.step.calculator.domain

import next.step.calculator.domain.exception.IllegalInputNumberFormatException

data class InputNumber(private val n: Int) {
    companion object {
        fun from(str: String?): InputNumber {
            validate(str)
            return InputNumber(str!!.toInt())
        }

        private fun validate(str: String?) {
            if (str.isNullOrBlank() || str.isNotNumeric()) {
                throw IllegalInputNumberFormatException()
            }
        }
    }

    operator fun plus(other: InputNumber): InputNumber = InputNumber(n + other.n)
    operator fun minus(other: InputNumber): InputNumber = InputNumber(n - other.n)
    operator fun times(other: InputNumber): InputNumber = InputNumber(n * other.n)
    operator fun div(other: InputNumber): InputNumber = InputNumber(n / other.n)

    fun toInt(): Int = n
}

private fun String.isNotNumeric(): Boolean = this.any { char -> !char.isDigit() }
