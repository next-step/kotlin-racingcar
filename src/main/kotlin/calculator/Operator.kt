package calculator

enum class Operator(
    val sign: Char
) {
    PLUS('+') {
        override fun calculate(first: Double, second: Double): Double = first + second
    },
    SUBTRACT('-') {
        override fun calculate(first: Double, second: Double): Double = first - second
    },
    MULTIPLY('*') {
        override fun calculate(first: Double, second: Double): Double = first * second
    },
    DIVIDE('/') {
        override fun calculate(first: Double, second: Double): Double = first / second
    };

    abstract fun calculate(first: Double, second: Double): Double

    companion object {
        fun of(newSign: Char): Operator {
            return when (newSign) {
                PLUS.sign -> PLUS
                SUBTRACT.sign -> SUBTRACT
                MULTIPLY.sign -> MULTIPLY
                DIVIDE.sign -> DIVIDE
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }
    }
}
