package study.calculator

class Calculator {
    fun evaluate(expression: String?): Double {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException(
                "Expression cannot be null or blank"
            )
        }

        val tokens = expression.split(" ")
        var result = tokens[0].toDouble()

        var index = 1
        while (index < tokens.size) {
            val operator = tokens[index]
            val operand = tokens[index + 1].toDouble()

            result = when (operator) {
                "+" -> add(result, operand)
                "-" -> subtract(result, operand)
                "*" -> multiply(result, operand)
                "/" -> divide(result, operand)
                else -> throw IllegalArgumentException("Invalid operator: $operator")
            }

            index += 2
        }

        return result
    }

    fun add(a: Double, b: Double): Double = a + b

    fun subtract(a: Double, b: Double): Double = a - b

    fun multiply(a: Double, b: Double): Double = a * b

    fun divide(a: Double, b: Double): Double = a / b
}
