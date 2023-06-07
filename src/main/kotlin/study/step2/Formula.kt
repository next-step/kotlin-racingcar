package study.step2

class Formula(
    input: String?
) {
    val expression: List<String>
    init {
        require(!input.isNullOrBlank()) { "잘못된 연산식입니다." }
        expression = input.split(" ")
        validateExpression()
    }
    private fun validateExpression() {
        expression.forEachIndexed { index, s ->
            if (index % 2 == 0 && s.toDoubleOrNull() == null) {
                throw NumberFormatException("유효한 숫자가 아닙니다.")
            }
        }
    }
}
