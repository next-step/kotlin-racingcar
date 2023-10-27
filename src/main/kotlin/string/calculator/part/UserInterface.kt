package string.calculator.part

class UserInterface(private val validator: Validator) {
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
        validator.validateContinue(input)
        return input == YES
    }

    fun occurError(e: String) {
        println(OCCURS_ERROR)
        println("오류 메시지: ${e}\n")
    }

    companion object {
        const val ENTER_CALCULATION_INPUT = "계산할 식을 입력해주세요."
        const val ENTER_CONTINUE_INPUT = "계속하시겠습니까? (Y/N)"
        const val YES = "Y"
        const val OCCURS_ERROR = "오류가 발생했습니다. 다시 안내에 따라 다시 시도해주세요."
    }
}
