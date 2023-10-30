package study.calculator

class Calculator {
    fun evaluate(expression: String?): Double {
        require(!expression.isNullOrBlank()) { "Expression cannot be null or blank" }

        var index = 0
        val tokens = expression.split(" ")
        var result = parseOperand(tokens[index++])

        while (index < tokens.size) {
            result = calculateNextOperation(result, tokens[index++], tokens[index++])
        }

        return result
    }

    private fun calculateNextOperation(result: Double, operator: String, operand: String): Double {
        val nextOperand = parseOperand(operand)
        return when (operator) {
            "+" -> Operations.add(result, nextOperand)
            "-" -> Operations.subtract(result, nextOperand)
            "*" -> Operations.multiply(result, nextOperand)
            "/" -> Operations.divide(result, nextOperand)
            else -> throw IllegalArgumentException("Invalid operator: $operator")
        }
    }

    private fun parseOperand(operand: String): Double {
        return operand.toDoubleOrNull()
            ?: throw IllegalArgumentException("Invalid operand: $operand")
    }
}
