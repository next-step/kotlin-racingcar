package step2

enum class Operator(symbol: String) {
    PLUS("*"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
}

fun checkOperator(): Boolean {
    return true
}

fun plus(first: Int, second: Int): Int {
    return first + second
}

fun minus(first: Int, second: Int): Int {
    return first - second
}

fun divide(first: Int, second: Int): Int {
    return first / second
}

fun multiply(first: Int, second: Int): Int {
    return first * second
}
