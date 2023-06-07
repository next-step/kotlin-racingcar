package stringcalculator

@JvmInline
value class Number(val value: Double) {
    constructor(value: String) : this(
        value.toDoubleOrNull() ?: throw IllegalArgumentException("Invalid value: $value required number formattable value")
    )

    operator fun plus(target: Number): Number = Number(value + target.value)
    operator fun minus(target: Number): Number = Number(value - target.value)
    operator fun times(target: Number): Number = Number(value * target.value)
    operator fun div(target: Number): Number {
        if (target == ZERO) {
            throw ArithmeticException("0으로 나눌 수 없습니다.")
        }

        return Number(value / target.value)
    }

    companion object {
        private val ZERO: Number = Number(0.0)
    }
}
