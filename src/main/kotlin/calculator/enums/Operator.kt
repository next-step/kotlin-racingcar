package calculator.enums

enum class Operator(val operator: String, val sum: (num1: Int, num2: Int) -> Int) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    companion object {
        fun find(operator: String): Operator {
            return values().find { it.operator == operator }
                ?: throw IllegalArgumentException("+, -, *, / 외에는 사용할 수 없습니다.")
        }
    }
}