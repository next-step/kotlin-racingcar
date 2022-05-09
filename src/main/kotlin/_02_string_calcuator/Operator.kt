package _02_string_calcuator

enum class Operator(private val symbol: String, private val expression: (left: Int, right: Int) -> Int) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right });

    fun calculate(num1: Int, num2: Int): Int {
        if (this == DIVIDE) {
            validateZero(num2)
        }
        return expression(num1, num2)
    }

    private fun validateZero(num: Int) = require(num != 0) { "나눗셈의 분모 값은 0이 될 수 없다." }

    companion object {
        fun find(operator: String) = Operator.values().find { it.symbol == operator } ?: throw IllegalArgumentException("사칙연산 기호가 아니다.")
    }
}
