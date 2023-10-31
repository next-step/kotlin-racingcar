package calculator

data class Expression(val number: Number, private val arithmetic: Arithmetic? = null) {

    fun put(string: String): Expression {
        return when {
            Number.isNumber(string) -> createFormularyArithmetic(string)
            Arithmetic.isArithmetic(string) -> Expression(number, Arithmetic.of(string))
            else -> throw IllegalArgumentException("수식은 숫자 혹은 사칙연산 기호만 입력 가능합니다.")
        }
    }

    private fun createFormularyArithmetic(string: String): Expression {
        if (arithmetic == null) {
            return Expression(Number(string))
        }
        return Expression(arithmetic.operation(number, Number(string)))
    }
}
