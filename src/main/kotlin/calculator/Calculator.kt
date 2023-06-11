package calculator

class Calculator {
    fun calculateExpression(expression: String?): Long {
        val splits = splitExpression(expression)
        var result = splits[0].toLong()
        val (operators, operands) = parseExpression(splits)

        for ((operator, operand) in operators.zip(operands)) {
            result = operator(result, operand)
        }

        return result
    }

    fun parseExpression(splits: List<String>): Pair<List<Operator>, List<Long>> {
        val operators = List(splits.size / EXPRESSION_GROUP_SIZE) { index ->
            Operator.getOperator(splits[index * EXPRESSION_GROUP_SIZE + EXPRESSION_START_PADDING])
        }
        val operands =
            List(splits.size / EXPRESSION_GROUP_SIZE) { index -> splits[(index + EXPRESSION_START_PADDING) * EXPRESSION_GROUP_SIZE].toLong() }

        return Pair(operators, operands)
    }

    fun splitExpression(expression: String?): List<String> {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("식이 비어있습니다.")
        }

        val splits = expression.split(" ").filter { it.isNotBlank() }
        if (splits.size % 2 == 0) {
            throw IllegalArgumentException("식이 올바르지 않습니다.")
        }
        return splits
    }

    companion object {
        const val EXPRESSION_GROUP_SIZE = 2
        const val EXPRESSION_START_PADDING = 1
    }
}
