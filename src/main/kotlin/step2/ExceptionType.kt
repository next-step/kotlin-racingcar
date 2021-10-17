package step2

class ExceptionType {
    companion object {
        const val INPUT_MUST_NOT_NULL = "입력이 비어서는 안됩니다."
        const val INPUT_MUST_NOT_BLANK = "입력이 공백 이여서는 안됩니다."
        const val INPUT_MUST_START_WITH_NUMBER = "숫자 부터 입력 되어야합니다."
        const val INPUT_MUST_END_WITH_NUMBER = "식의 마지막에는 숫자가 입력되어야 합니다."
        const val OPERATOR_NEXT_IS_MUST_NUMBER = "연산자 다음은 숫자가 와야합니다."
        const val NUMBER_NEXT_IS_MUST_OPERATOR = "숫자 다음은 연산자가 와야합니다."

        const val NOT_OPERATOR_SYMBOL = "잘못된 계산 연산자 입력입니다."
        const val CAN_NOT_DIVIDED_BY_ZERO = "0으로 나눌수 없습니다."
    }
}
