package calculator

import java.util.function.IntBinaryOperator

enum class Operator(private val expression: String, private val operator: IntBinaryOperator) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        require(b != 0) { "0으로 나눌 수 없습니다." }
        a / b
    });

    fun getResult(leftOperand: Int, rightOperand: Int): Int = operator.applyAsInt(leftOperand, rightOperand)

    companion object {
        fun from(expression: String): Operator = values().find { o -> o.expression == expression }
            ?: throw IllegalArgumentException("$expression 사칙연산 기호가 올바르지 않습니다.")
    }
}
