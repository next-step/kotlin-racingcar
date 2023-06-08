package next.step.calculator.domain

data class InputNumber(private val n: Int) {
    companion object {
        fun from(str: String): InputNumber {
            require(str.isNotBlank() && str.isNumeric()) { "잘못된 형식의 숫자입니다." }
            return InputNumber(str.toInt())
        }
    }

    operator fun plus(other: InputNumber): InputNumber = InputNumber(n + other.n)
    operator fun minus(other: InputNumber): InputNumber = InputNumber(n - other.n)
    operator fun times(other: InputNumber): InputNumber = InputNumber(n * other.n)
    operator fun div(other: InputNumber): InputNumber = InputNumber(n / other.n)

    fun toInt(): Int = n
}

private fun String.isNumeric(): Boolean = this.all { char -> char.isDigit() }
