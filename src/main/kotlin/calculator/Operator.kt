package calculator

enum class Operator(
    val operator: String,
    val operation: (Number, Number) -> Number
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    fun operate(a: Number, b: Number): Number {
        return operation(a, b)
    }

    companion object {
        fun of(operator: String): Operator {
            return values().find { it.operator == operator } ?: throw IllegalArgumentException("연산자가 아닙니다.")
        }
    }
}
