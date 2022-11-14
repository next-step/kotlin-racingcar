package calculator.common

import calculator.enums.ExceptionCode

class InputValidation {
    private val utils = OperatorHelper()

    fun validate(input: String?): List<String> {
        require(!input.isNullOrBlank()) {
            ExceptionCode.NOT_ALLOWED_NULL_OR_BLANK.getMessage()
        }
        val inputParsingList = input.split(" ")
        inputParsingList.mapIndexed { index, string ->
            when {
                // 숫자일 때
                index % 2 == 0 ->
                    if (!utils.isNumeric(string)) throw IllegalArgumentException(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())
                // 연산자일 때
                else ->
                    if (!utils.isOperator(string)) throw IllegalArgumentException(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())
            }
        }
        return inputParsingList
    }
}
