package calculator

enum class Operator(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS("+", ::add),
    MINUS("-", ::subtract),
    MULTIPLY("*", ::multiply),
    DIVIDE("/", ::divide),
    ;

    companion object {
        fun of(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("사칙연산은 '+', '-', '*', '/' 만 사용 가능합니다.")
        }
    }
}

fun add(a: Int, b: Int): Int = a + b
fun subtract(a: Int, b: Int): Int = a - b
fun multiply(a: Int, b: Int): Int = a * b
fun divide(a: Int, b: Int): Int = a / b
