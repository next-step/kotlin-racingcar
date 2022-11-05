package calculator

enum class Operator(val sign: Char) {
    PLUS('+') {
        override fun calculate(a: Int, b: Int): Int = a + b
    },
    MINUS('-') {
        override fun calculate(a: Int, b: Int): Int = a - b
    },
    MULTIPLY('*') {
        override fun calculate(a: Int, b: Int): Int = a * b
    },
    DIVIDE('/') {
        override fun calculate(a: Int, b: Int): Int = a / b
    };

    abstract fun calculate(a: Int, b: Int): Int

    fun equals(sign: Char): Boolean = this.sign == sign

    companion object {
        operator fun invoke(sign: Char): Operator {
            for (operator in Operator.values()) {
                if (operator.sign == sign) {
                    return operator
                }
            }
            throw IllegalArgumentException()
        }
    }
}
