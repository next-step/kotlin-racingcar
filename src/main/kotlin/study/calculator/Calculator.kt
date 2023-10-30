package study.calculator

class Calculator {
    fun evaluate(expression: String?): Double {
        require(!expression.isNullOrBlank()) { "Expression cannot be null or blank" }

        val tokens = expression.split(" ")
        var result = tokens[0].toDoubleOrNull()
            ?: throw IllegalArgumentException("Invalid operand: ${tokens[0]}")

        var index = 1
        while (index < tokens.size) {
            val operator = tokens[index]
            val operand = tokens[index + 1].toDoubleOrNull()
                ?: throw IllegalArgumentException("Invalid operand: ${tokens[index + 1]}")

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
