class CalculatorParser {
    fun parse(input: String): List<String> {
        validateBlank(input)

        val split =
            input.trim()
                .split(" ")
                .toList()

        validateOnlyArithmeticSymbol(split)
        validateStartWithOperand(split)
        validateEndWithOperand(split)
        validateDiscontinuousOperator(split)
        validateDiscontinuousOperand(split)

        return split
    }

    private fun validateBlank(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("Input is blank")
        }
    }

    private fun validateOnlyArithmeticSymbol(input: List<String>) {
        for (elem in input) {
            if (isNumeric(elem)) {
                continue
            }

            if (Operator.isOperator(elem)) {
                continue
            }

            throw IllegalArgumentException("$elem isn't a arithmetic operator")
        }
    }

    private fun validateStartWithOperand(input: List<String>) {
        if (Operator.isOperator(input.first())) {
            throw IllegalArgumentException("first symbol must to numeric")
        }
    }

    private fun validateEndWithOperand(input: List<String>) {
        if (Operator.isOperator(input.last())) {
            throw IllegalArgumentException("last symbol must to numeric")
        }
    }

    private fun validateDiscontinuousOperator(input: List<String>) {
        for (index in 0 until input.lastIndex) {
            if (Operator.isOperator(input[index]) && Operator.isOperator(input[index + 1])) {
                throw IllegalArgumentException("continuous operator must not allow operators")
            }
        }
    }

    private fun validateDiscontinuousOperand(input: List<String>) {
        for (index in 0 until input.lastIndex) {
            if (isNumeric(input[index]) && isNumeric(input[index + 1])) {
                throw IllegalArgumentException("continuous operand must not allow operators")
            }
        }
    }

    private fun isNumeric(input: String): Boolean {
        return input.toIntOrNull() != null
    }
}
