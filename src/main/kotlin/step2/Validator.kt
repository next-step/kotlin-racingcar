package step2

class Validator {
    /**
     * 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     */
    fun validateInput(input: String?) {
        require(input == null || input.trim().isEmpty()) {"입력값이 null이거나 빈 공백 문자입니다."}
    }

    /**
     * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     */
    fun validateOperator(operator: String) {
        require(!operator.matches("[+\\-*/]".toRegex())) {"주어진 문자열은 사칙연산 기호가 아닙니다."}
    }
}