package calculator

enum class Operator(
    val sign: Char,
    val operate: (first: Int, second: Int) -> Int
) {
    PLUS(sign = '+', operate = { first, second -> first + second }),
    MINUS(sign = '-', operate = { first, second -> first - second }),
    MULTIPLY(sign = '*', operate = { first, second -> first * second }),
    DIVIDE(sign = '/', operate = { first, second -> first / second })
    ;

    companion object {
        fun valueOf(sign: Char) = values().firstOrNull { it.sign == sign }
    }
}
