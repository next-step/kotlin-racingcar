package step2

object Step2Exception {
    const val IS_NOT_NULL_OR_BLANK_EXCEPTION = "입력값이 null 혹은 공백일 수 없습니다."
    const val IS_NOT_ARITHMETIC_SYMBOL_EXCEPTION = "사칙연산 기호가 아닙니다."
    const val FIRST_VALUE_INVALID_EXCEPTION = "첫번째 입력값이 정수가 아니므로 변환할 수 없습니다."
    const val STRING_NEXT_NOT_NUM_EXCEPTION = "연산자 다음에는 정수가 입력 되어야 합니다."
    const val CANT_PLACE_NUMBER_EXCEPTION = "정수가 올 자리가 아닙니다."
    const val CANT_DIVIDE_ZERO_EXCEPTION = "0으로 나눌 수 없습니다"
}
