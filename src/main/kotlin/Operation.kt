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
    NONE("") {
        override fun compute(v1: Int, v2: Int) = throw IllegalArgumentException()
    }
    ;

    abstract fun compute(v1: Int, v2: Int): Int

    companion object {
        fun of(exp: String) = runCatching {
            values().first { it.exp == exp }
        }.getOrElse { NONE }

        private fun divide(v1: Int, v2: Int): Int {
            if (v2 == 0) throw IllegalArgumentException()
            return v1 / v2
        }

        private fun multiply(v1: Int, v2: Int) = v1 * v2

        private fun minus(v1: Int, v2: Int) = v1 - v2

        private fun plus(v1: Int, v2: Int) = v1 + v2
    }
}
