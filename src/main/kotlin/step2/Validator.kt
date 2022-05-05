package step2

class Validator {

    fun validate(input: String?) {
        validateNullOrBlank(input)
        validateOperator(input!!)
    }

    private fun validateNullOrBlank(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력 값이 null(널)이거나 빈 공백 문자입니다.")
        }
    }

    private fun validateOperator(input: String) {
        val requestOperator = input.filterNot { it.isDigit() }.replace(" ", "").associateBy { it }

        requestOperator.map {
            if (!DECLARED_OPERATOR.contains(it.key)) {
                throw IllegalArgumentException("허용하지 않는 operator 혹은 문자입니다. '${it.key}'")
            }
        }
    }

    companion object {
        private val DECLARED_OPERATOR = Operator.values().map { operator -> operator.symbol }
    }
}
