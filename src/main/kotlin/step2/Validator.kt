package step2

object Validator {

    private val availableOperator: Regex by lazy { Regex("[+\\-*/]") }

    /**
     * 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     */
    fun validateInput(input: String?) {
        require(input != null && input.trim().isNotEmpty()) {"입력값이 null이거나 빈 공백 문자입니다."}
    }

    /**
     * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     */
    fun validateOperator(operator: String) {
        require(operator.matches(availableOperator)) {"주어진 문자열은 사칙연산 기호가 아닙니다."}
    }
}