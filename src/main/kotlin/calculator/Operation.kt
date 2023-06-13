package calculator

internal enum class Operation(private val sign: String, private val calculator: (Int, Int) -> Int) {

    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    MULTIPLY("*", { first, second -> first * second }),
    DIVIDE("/", { first, second ->
        require(second != 0) { "divide number must not be zero" }
        first / second
    });

    fun calculate(first: Int, second: Int): Int = calculator(first, second)

    companion object {
        fun signOf(sign: String): Operation {
            return values().find { sign == it.sign }
                ?: throw IllegalArgumentException("not supported operation. (`$sign`)")
        }
    }
}
