package calculator

class ExceptionCase {
    companion object {
        const val CASE_NULL_CAR_NAME = "차의 이름이 존재하지 않습니다."
        const val CASE_INT_FORMAT_OR_NULL = "숫자 포멧이 아니거나 null 값입니다."
        const val CASE_INPUT_NULL_OR_EMPTY = "입력값이 없습니다."
        const val CASE_INCORRECT_SYMBOL = "사측연산 기호가 아닙니다."
        const val CASE_INCORRECT_INPUT = "계산할 수 없는 식입니다."
        const val CASE_DIVISION_NUMBER_ZERO = "0으로 나눗셈 계산할 수 없습니다."
    }
}
