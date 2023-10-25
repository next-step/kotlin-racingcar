package calculator

data class UserInput(val input: String?) {

    fun validate() {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("계산식이 비어있습니다")
        }

        if (input.matches(regexForNumberAndOperator).not()) {
            throw IllegalArgumentException("계산식에 숫자와 사칙연산 기호 이외의 값이 포함되어 있습니다")
        }
    }
}
