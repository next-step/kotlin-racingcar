package step2

class InputValidator {
    companion object {
        fun validate(input: String?) {
            validateInputIsNullOrBlank(input)
            validateIsArithmeticSymbol(input!!)
        }

        private fun validateInputIsNullOrBlank(input: String?) {
            if (input.isNullOrBlank()) throw IllegalArgumentException()
        }

        private fun validateIsArithmeticSymbol(input: String) {
            if (filterDigit(input).any { !arithmeticSymbols.contains(it) }) {
                throw IllegalArgumentException()
            }
        }

        private fun filterDigit(input: String): List<String> {
            return input.filterNot { it.isDigit() }.replace(" ", "").associateBy { it }.map { it.value.toString() }
        }

        private val arithmeticSymbols = listOf("+", "-", "*", "/")
    }
}