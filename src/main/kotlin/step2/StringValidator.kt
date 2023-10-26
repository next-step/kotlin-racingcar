package step2

object StringValidator {
    /**
     * 문자열이 유효한지 한번에 체크
     */
    fun validateString(string: String) {
        validateFirstAndLast(string)
        validateDuplicatedOperation(string)
    }

    /**
     * 문자열의 처음과 끝이 * / 연산이면 IllegalArgumentException
     */
    private fun validateFirstAndLast(string: String) {
        require(
            string.first().isMultiplyOrDivide().not() &&
                string.last().isMultiplyOrDivide().not()
        ) { START_STRING_CAN_NOT_BE_OPERATION }
    }

    /**
     * 연산자가 두개 이상 동시에 들어오는 경우
     */
    private fun validateDuplicatedOperation(string: String) {
        string.mapIndexed { index, char ->
            if (index != 0) { // 1~마지막
                if (char.isFourArithmeticCalculation() && string[index - 1].isFourArithmeticCalculation()) {
                    error(DUPLICATED_OPERATION)
                }
            }
        }
    }

    private fun Char.isMultiplyOrDivide() =
        this.toString() == FourArithmeticOperation.getArithmeticOperation(FourArithmeticOperation.MULTIPLY) || this.toString() == FourArithmeticOperation.getArithmeticOperation(
            FourArithmeticOperation.DIVIDE
        )

    private fun Char.isFourArithmeticCalculation(): Boolean {
        return when (this@isFourArithmeticCalculation.toString()) {
            FourArithmeticOperation.getArithmeticOperation(FourArithmeticOperation.PLUS),
            FourArithmeticOperation.getArithmeticOperation(FourArithmeticOperation.MINUS),
            FourArithmeticOperation.getArithmeticOperation(FourArithmeticOperation.MULTIPLY),
            FourArithmeticOperation.getArithmeticOperation(FourArithmeticOperation.DIVIDE) -> true

            else -> false
        }
    }

    private const val START_STRING_CAN_NOT_BE_OPERATION = "문자열의 시작, 끝은 \"*, /\" 일 수 없어요"
    private const val DUPLICATED_OPERATION = "연산자가 2개 이상 연속으로 사용됐어요"
}
