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
            return findBySign(newSign) ?: throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }

        private fun findBySign(newSign: Char): Operator? {
            return Operator.values().find { it.sign == newSign }
        }
    }
}
