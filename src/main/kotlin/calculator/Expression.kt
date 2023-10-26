package calculator

class Expression(val number: Number, private val arithmetic: Arithmetic? = null) {

    fun put(string: String): Expression {
        if (Number.isNumber(string)) {
            return createFormularyArithmetic(string)
        }

        if (Arithmetic.isArithmetic(string)) {
            return Expression(number, Arithmetic.of(string))
        }

        throw IllegalArgumentException("수식은 숫자 혹은 사칙연산 기호만 입력 가능합니다.")
    }

    private fun createFormularyArithmetic(string: String): Expression {
        if (arithmetic == null) {
            return Expression(Number(string))
        }
        return Expression(arithmetic.operation(number, Number(string)))
    }
}
