package calculator

enum class Operator(
    private val symbol: String
) {

    ADD("+") {
        override fun invoke(n1: Int, n2: Int): Int = n1 + n2
    },
    SUB("-") {
        override fun invoke(n1: Int, n2: Int): Int = n1 - n2
    },
    MULTI("*") {
        override fun invoke(n1: Int, n2: Int): Int = n1 * n2
    },
    DIV("/") {
        override fun invoke(n1: Int, n2: Int): Int? =
            if (n1 == 0 || n2 == 0) null else n1 / n2
    }
    ;

    abstract operator fun invoke(n1: Int, n2: Int): Int?

    companion object {
        fun of(char: String): Operator = values().find { it.symbol == char }
            ?: throw IllegalArgumentException("유효하지 않은 연산자 입니다.")
    }
}
