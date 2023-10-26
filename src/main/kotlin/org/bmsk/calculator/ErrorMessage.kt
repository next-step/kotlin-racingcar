package org.bmsk.calculator

internal object ErrorMessage {
    const val DIVISION_BY_ZERO = "0으로 나눌 수 없습니다."
    const val BLANK_FORMULA = "공백은 계산할 수 없습니다."
    const val NOT_A_NUMBER = "수가 아닙니다."
    const val NOT_AN_OPERATOR = "연산자가 아닙니다."
    const val FORMULA_MUST_START_WITH_NUMBER = "수식은 수로 시작해야 합니다."
    const val FORMULA_MUST_END_WITH_NUMBER = "수식은 수로 끝나야 합니다."
    const val EVEN_POSITION_MUST_BE_NUMBER = "짝수 위치에는 숫자가 와야 합니다."
    const val ODD_POSITION_MUST_BE_OPERATOR = "홀수 위치에는 연산자가 와야 합니다."
}
