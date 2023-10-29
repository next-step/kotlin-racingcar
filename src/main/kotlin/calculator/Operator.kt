package calculator

enum class Operator(
    val operator: String,
    val operation: (Number, Number) -> Number
) {
    PLUS("+", { a, b -> Number((a.getNumber() + b.getNumber()).toString()) }),
    MINUS("-", { a, b -> Number((a.getNumber() - b.getNumber()).toString()) }),
    MULTIPLY("*", { a, b -> Number((a.getNumber() * b.getNumber()).toString()) }),
    DIVIDE("/", { a, b -> Number((a.getNumber() / b.getNumber()).toString()) }),
    ;

    companion object {
        fun of(operator: String): Operator {
            return values().find { it.operator == operator } ?: throw IllegalArgumentException("연산자가 아닙니다.")
        }
    }

    fun operate(a: Number, b: Number): Number {
        return operation(a, b)
    }
}
