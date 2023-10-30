package string.calculator.domain

object UserInterface {
    private const val ENTER_CALCULATION_INPUT = "계산할 식을 입력해주세요."
    private const val ENTER_CONTINUE_INPUT = "계속하시겠습니까? (Y/N)"
    private const val YES = "Y"
    private const val OCCURS_ERROR = "오류가 발생했습니다. 다시 안내에 따라 다시 시도해주세요."
    private const val NUMBER_NOT_ENTERED = "숫자가 입력되지 않았습니다."
    private const val OPERATOR_NOT_ENTERED = "연산자가 입력되지 않았습니다."
    private const val OPERAND_COUNT_MISMATCH = "피연산자의 개수는 최소 2개입니다."
    private const val INPUT_IS_NOT_VALID = "입력값이 올바르지 않습니다."
    private const val CONTINUE_IS_NOT_VALID = "계속 여부는 Y 또는 N만 입력 가능합니다."
    private const val MIN_OPERAND_SIZE = 2

    fun introduce(): String {
        println(ENTER_CALCULATION_INPUT)
        return readlnOrNull().orEmpty()
    }

    fun showResult(result: Long) {
        println("계산 결과는 $result 입니다.")
    }

    fun isContinue(): Boolean {
        println(ENTER_CONTINUE_INPUT)
        val input = readlnOrNull().orEmpty()
        validateContinue(input)
        return input == YES
    }

    fun occurError(e: String) {
        println(OCCURS_ERROR)
        println("오류 메시지: ${e}\n")
    }

    // TODO refactor validateInput
    fun validateInput(numbers: MutableList<Long>, operators: MutableList<Operator>) {
        require(numbers.isNotEmpty()) { throw IllegalArgumentException(NUMBER_NOT_ENTERED) }
        require(operators.isNotEmpty()) { throw IllegalArgumentException(OPERATOR_NOT_ENTERED) }
        require(numbers.size >= MIN_OPERAND_SIZE) { throw IllegalArgumentException(OPERAND_COUNT_MISMATCH) }
        require(numbers.size == operators.size + 1) { throw IllegalArgumentException(INPUT_IS_NOT_VALID) }
    }

    fun validateContinue(input: String) {
        require(input == "Y" || input == "N") { throw IllegalArgumentException(CONTINUE_IS_NOT_VALID) }
    }
}
