package step2

class ExceptionType {
    companion object {
        const val INPUT_MUST_NOT_NULL = "입력이 비어서는 안됩니다."
        const val INPUT_MUST_NOT_BLANK = "입력이 공백 이여서는 안됩니다."
        const val INPUT_MUST_START_WITH_NUMBER = "숫자 부터 입력 되어야합니다."
        const val INPUT_MUST_END_WITH_NUMBER = "식의 마지막에는 숫자가 입력되어야 합니다."
        const val OPERAND_IS_MUST_NUMBER = "피연산자 자리에는 숫자가 와야합니다."
        const val OPERATOR_IS_MUST_FIXED_SYMBOL = "연산자는 미리 정해진 기호만 사용 가능합니다."

        const val NOT_OPERATOR_SYMBOL = "잘못된 계산 연산자 입력입니다."
        const val CAN_NOT_DIVIDED_BY_ZERO = "0으로 나눌수 없습니다."
    }
}
