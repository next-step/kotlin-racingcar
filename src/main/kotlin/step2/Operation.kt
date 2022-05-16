package step2

enum class Operation(val exp: String) {
    PLUS("+") {
        override fun compute(v1: Int, v2: Int) = plus(v1, v2)
    },
    MINUS("-") {
        override fun compute(v1: Int, v2: Int) = minus(v1, v2)
    },
    MULTIPLY("*") {
        override fun compute(v1: Int, v2: Int) = multiply(v1, v2)
    },
    DIVIDE("/") {
        override fun compute(v1: Int, v2: Int) = divide(v1, v2)
    },
    ;

    abstract fun compute(v1: Int, v2: Int): Int

    companion object {
        fun of(exp: String) = runCatching {
            values().first { it.exp == exp }
        }.getOrElse { throw IllegalArgumentException() }

        fun contains(exp: String): Boolean = of(exp) in values()

        private fun divide(v1: Int, v2: Int): Int {
            if (v2 == 0) throw IllegalArgumentException()
            return v1 / v2
        }

        private fun multiply(v1: Int, v2: Int) = v1 * v2

        private fun minus(v1: Int, v2: Int) = v1 - v2

        private fun plus(v1: Int, v2: Int) = v1 + v2
    }
}
