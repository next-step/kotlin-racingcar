package calculator.domain

import java.lang.IllegalArgumentException

enum class Operator(
    private val value: String,
    val operation: (Operand, Operand) -> Operand
) {
    PLUS("+", { num1, num2 -> Operand(num1.number + num2.number) }),
    MINUS("-", { num1, num2 -> Operand(num1.number - num2.number) }),
    MULTIPLE("*", { num1, num2 -> Operand(num1.number * num2.number) }),
    DIVIDE(
        "/",
        { num1, num2 ->
            if (num2.number == 0.0)
                throw IllegalArgumentException("0으로는 나눌 수 없습니다")
            Operand(num1.number * num2.number)
        }
    );

    companion object {
        fun of(operator: String): Operator {
            try {
                return values()
                    .first { o -> o.value == operator }
            } catch (e: NoSuchElementException) {
                throw IllegalArgumentException("올바르지 않은 연산자 입니다")
            }
        }
    }
}
