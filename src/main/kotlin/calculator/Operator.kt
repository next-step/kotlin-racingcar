package calculator

enum class Operator(
    val operator: String,
    val calculate: (Double, Double) -> Double,
) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIV("/", { x, y -> x / y });

    companion object {
        fun operatorByValue(operator: String): Operator {
            return Operator.values().firstOrNull { it.operator == operator }
                ?: throw IllegalArgumentException("Invalid operator: $operator")
        }
    }
}
