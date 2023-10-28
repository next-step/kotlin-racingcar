package util

enum class CalculatorException(val message: String) {
    INVALID_INPUT("입력값이 올바르지 않습니다."),
    INVALID_OPERATOR("사칙연산 기호가 아닙니다."),
}
