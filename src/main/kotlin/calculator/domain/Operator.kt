package calculator.domain

enum class Operator(
    private val value: String,
    val operation: (Operand, Operand) -> Operand
) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLE("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    companion object {
        fun of(operator: String): Operator {
            return values()
                .find { it.value == operator } ?: throw IllegalArgumentException("올바르지 않은 연산자 입니다")
        }
    }
}
