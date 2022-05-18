package stringCalculator

class Message {
    companion object {
        const val INPUT_NULL_OR_BLANK = "입력 값이 null 이거나 빈 공백 문자일 수 없습니다."
        const val INVALID_OPERATOR = "사칙 연산 기호가 아닌 기호를 사용할 수 없습니다."
        const val INPUT_NOT_START_WITH_NUMBER = "입력값은 숫자 아닌 값으로 시작할 수 없습니다."
        const val INPUT_NOT_END_WITH_NUMBER = "입력값은 숫자 아닌 값으로 끝낼 수 없습니다."
        const val INPUT_CONTAINS_CHARACTER = "입력값에 문자가 들어갈 수 없습니다."
        const val INPUT_CONTAINS_OPERATOR_IN_A_ROW = "연산자가 연속으로 올 수 없습니다."
    }
}
