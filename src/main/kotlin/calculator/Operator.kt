package calculator

enum class Operator(val sign: String, val calculate: (Int, Int) -> Int) {
    PLUS(sign = "+", calculate = { a, b -> a + b }),
    MINUS(sign = "-", calculate = { a, b -> a - b }),
    MULTIPLY(sign = "*", calculate = { a, b -> a * b }),
    DIVIDE(sign = "/", calculate = { a, b -> a / b });

    companion object {
        fun of(sign: String): Operator =
            values().find { it.sign == sign } ?: throw IllegalArgumentException("invalid operator")
    }
}
