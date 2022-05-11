package calculator

class ErrorMessage {
    companion object {
        const val SPACE_INPUT_ERROR = "연산식에 공백은 올 수 없습니다"
        const val OTHER_STRING_INPUT_ERROR = "연산식에 숫자, 연산자를 제외한 다른 문자가 들어가 있습니다"
        const val NOT_MATCH_OPERAND_COUNT = "연산식이 피연산자 보다 많습니다."
        const val CALCULATION_VALUE_IS_INFINITY = "연산 결과 값이 무한대입니다."

        fun getParseIntErrorMessage(errorValue: String): String {
            return "피연산자('$errorValue')를 숫자로 변환하는 중에 에러가 발생하였습니다."
        }
    }
}
