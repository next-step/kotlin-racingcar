package calculator

enum class Operator(private val sign: Char) {
    PLUS('+') {
        override fun calculate(a: Num, b: Num): Num = a.add(b)
    },
    MINUS('-') {
        override fun calculate(a: Num, b: Num): Num = a.sub(b)
    },
    MULTIPLY('*') {
        override fun calculate(a: Num, b: Num): Num = a.multiply(b)
    },
    DIVIDE('/') {
        override fun calculate(a: Num, b: Num): Num = a.divide(b)
    };

    abstract fun calculate(a: Num, b: Num): Num

    fun isSame(sign: Char): Boolean = this.sign == sign

    companion object {
        operator fun invoke(sign: Char): Operator {
            return values().first { o -> o.isSame(sign) }
        }
    }
}
