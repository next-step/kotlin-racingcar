class CalculatorParser {

    fun parse(input: String): List<String> {
        validateBlank(input)

        val split = input.trim()
            .split(" ")
            .toList()

        validateOnlyArithmeticSymbol(split)

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

    private fun isNumeric(input: String): Boolean {
        return input.toIntOrNull() != null
    }
}