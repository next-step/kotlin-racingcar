package calculator

object Const {
    object OutputMsg {
        const val INIT_MSG = "계산할 문자를 입력하세요."
        const val RESULT_MST = ""
    }

    object ErrorMsg {
        const val INPUT_IS_EMPTY_OR_BLANK_ERROR_MSG = "비어있는 값은 입력 할 수 없습니다."
        const val INPUT_SIZE_IS_WRONG_ERROR_MSG = "연산이 불가능한 식입니다."
        const val OPERATOR_IS_NOT_VALID_ERROR_MSG = "잘못된 연산자가 포함되어 있습니다."
        const val OPERAND_IS_NOT_NUMBER_ERROR_MSG = "잘못된 피연산자가 포함되어 있습니다."
        const val CANNOT_DIVIDE_TO_ZERO_ERROR_MSG = "0으로 나눌 수 없습니다."
    }
}
