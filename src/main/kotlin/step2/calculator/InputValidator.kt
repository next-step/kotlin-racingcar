package step2.calculator

object InputValidator {
    fun validate(input: String?) {
        validateInputIsNullOrBlank(input)
        validateIsArithmeticSymbol(input!!)
    }

    private fun validateInputIsNullOrBlank(input: String?) {
        require(!input.isNullOrBlank()) { "입력된 값이 Null 이거나 공백입니다." }
    }

    private fun validateIsArithmeticSymbol(input: String) {
        require(!filterDigit(input).any { !ARITHMETIC_SYMBOLS.contains(it) }) { "입력된 값에 사칙 연산 기호가 아닌 값이 존재합니다." }
    }

    private fun filterDigit(input: String): List<String> {
        return input.filterNot { it.isDigit() }.replace(" ", "").associateBy { it }.map { it.value.toString() }
    }

    private val ARITHMETIC_SYMBOLS = listOf("+", "-", "*", "/")
}
