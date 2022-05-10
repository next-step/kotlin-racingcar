package stringcaculator

enum class Operator(val operator: String, val calculate: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        require(b != 0) { "Can't divide by zero" }
        a / b
    });

    companion object {
        fun of(operator: String): Operator {
            val validOperator = Operator.values().find { it.operator == operator }
            return requireNotNull(validOperator) { "Not a valid operator" }
        }
    }
}
