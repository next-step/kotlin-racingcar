package step2

import step2.Calculator.isNumber

object InputStringValidator {
    /**
     * 문자열이 유효한지 한번에 체크
     */
    fun validateString(string: String) {
        string.validateFirstAndLast()
        string.validateDuplicatedOperation()
    }

    /**
     * 문자열의 처음과 끝이 * / 연산이면 IllegalArgumentException
     */
    private fun String.validateFirstAndLast() {
        require(
            first().isMultiplyOrDivide().not() &&
                last().isMultiplyOrDivide().not()
        ) { START_STRING_CAN_NOT_BE_OPERATION }
    }

    /**
     * 연산자가 두개 이상 동시에 들어오는 경우
     */
    private fun String.validateDuplicatedOperation() {
        forEachIndexed { index, char ->
            println("char is $char and isNumber? = ${char.isNumber()}")
            if (index != 0) { // 1~마지막
                validateDuplicate(char, index)
            }
        }
    }

    private fun String.validateDuplicate(char: Char, index: Int) {
        check((char.isFourArithmeticCalculation() && this[index - 1].isFourArithmeticCalculation()).not()) { DUPLICATED_OPERATION }
    }

    private fun Char.isMultiplyOrDivide() =
        this.toString() == FourArithmeticOperation.MULTIPLY.operation || this.toString() == FourArithmeticOperation.DIVIDE.operation

    private fun Char.isFourArithmeticCalculation(): Boolean {
        return if (this == '.') {
            true
        } else if (isNumber().not()) {
            FourArithmeticOperation.getArithmeticOperationFromString(this)
            true
        } else {
            false
        }
    }

    private const val START_STRING_CAN_NOT_BE_OPERATION = "문자열의 시작, 끝은 \"*, /\" 일 수 없어요"
    private const val DUPLICATED_OPERATION = "연산자가 2개 이상 연속으로 사용됐어요"
}
