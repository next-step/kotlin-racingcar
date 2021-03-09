package calculator

enum class Operator(val sign: String, val operator: (Int, Int) -> Int) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    TIMES("*", { first, second -> first * second }),
    DIVIDE("/", { first, second -> first / second });

    companion object {
        fun contain(sign: String): Boolean {
            return values().any { it.sign == sign }
        }

        fun bySign(sign: String): Operator {
            return values().find { it.sign == sign } ?: throw IllegalArgumentException("$sign is not operator.")
        }
    }
}
