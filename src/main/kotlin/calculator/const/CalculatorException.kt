package calculator.const

object CalculatorException {
    const val PARSING_ERROR = "입력 값은 널이나 빈 값이 들어올 수 없어요."
    const val ZERO_DIVIDE_ERROR = "나누기를 진행할 때, 피연산자는 0이 될 수 없어요."
    const val NOT_ENOUGH_SIZE = "계산할 수 있는 최소 입력 값을 입력해주세요."
    const val NOT_PROPER_SIZE = "홀수개의 연산자와 짝수개의 피연산자가 존재 해야 합니다."
    const val NOT_CORRECT_EXPRESSION = "수식이 올바르지 않습니다."
    const val NOT_PROPER_OPERATOR = "올바른 연산자를 입력해주세요."
}
