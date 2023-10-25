package calculator

data class IntExpression(
    val initialNumber: Int,
    val operations: List<Operation>
) {
    companion object {
        private const val DELIMITER = " "

        fun of(input: String): IntExpression {
            val validatedInput = validateInput(input)
            val splitInput = splitByDelimiter(validatedInput)
            val validatedSplitInput = validateSplitInput(splitInput)
            return toExpression(validatedSplitInput)
        }

        private fun validateInput(input: String): String = input.apply {
            if (input.isBlank()) throw IllegalArgumentException("빈 문자열은 식이 될 수 없습니다")
        }

        private fun splitByDelimiter(validatedInput: String): List<String> =
            validatedInput.split(DELIMITER).filter { it.isNotBlank() }

        private fun validateSplitInput(splitInput: List<String>): List<String> =
            splitInput.apply {
                if (this.size % 2 == 0) throw IllegalArgumentException("식을 구성할 수 없는 문자열 입니다")
            }

        private fun toExpression(validatedSplitInput: List<String>): IntExpression {
            val initialNumber = extractInitialNumber(validatedSplitInput)
            val operations = extractOperations(validatedSplitInput)
            return IntExpression(initialNumber, operations)
        }

        private fun extractInitialNumber(validatedSplitInput: List<String>): Int =
            toIntOperand(validatedSplitInput[0])

        private fun extractOperations(validatedSplitInput: List<String>): List<Operation> =
            validatedSplitInput.drop(1).chunked(2) { (stringOperator, stringOperand) ->
                Operation(toOperator(stringOperator), toIntOperand(stringOperand))
            }

        private fun toOperator(stringOperator: String): Operator =
            Operator.entries.firstOrNull { it.symbol == stringOperator }
                ?: throw IllegalArgumentException("식을 구성할 수 없는 문자열 입니다")

        private fun toIntOperand(stringOperand: String): Int =
            stringOperand.toIntOrNull()?.takeIf { it >= 0 } ?: throw IllegalArgumentException("식을 구성할 수 없는 문자열 입니다")
    }

    data class Operation(
        val operator: Operator,
        val operand: Int,
    )
}
