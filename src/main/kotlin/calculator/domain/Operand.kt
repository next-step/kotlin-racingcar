package calculator.domain

data class Operand(
    val value: Double
) {
    constructor(value: Int) : this(value.toDouble())

    operator fun plus(another: Operand): Operand = Operand(value + another.value)
    operator fun minus(another: Operand): Operand = Operand(value - another.value)
    operator fun times(another: Operand): Operand = Operand(value * another.value)
    operator fun div(another: Operand): Operand {
        if (another.value == 0.0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다")
        }
        return Operand(value / another.value)
    }

    companion object {
        fun of(stringInput: String): Operand {
            try {
                return Operand(stringInput.toDouble())
            } catch (numberFormatException: NumberFormatException) {
                throw IllegalArgumentException("숫자로 변환할 수 없는 문자입니다")
            }
        }
    }
}
