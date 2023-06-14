package step2

enum class Operator(val sign: String, val operate: (Int, Int) -> (Int)) {

    PLUS("+", { first: Int, second: Int -> first + second }),
    MINUS("-", { first: Int, second: Int -> first - second }),
    MULTIPLY("*", { first: Int, second: Int -> first * second }),
    DIVIDE("/", { first: Int, second: Int -> first / second });

    companion object {
        fun getBySymbol(input: String): Operator =
            Operator.values().find { it.sign == input } ?: throw IllegalArgumentException()
    }
}
