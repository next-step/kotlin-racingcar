package calculator

class Calculator {

    companion object {
        const val IS_NOT_OR_BLANK: String = "입력값이 null 이거나 빈 공백 문자입니다."
        const val DELIMITER: String = " "
    }

    fun calculate(input: String?): Int {

        validateNullOrEmpty(input)

        val splitStrings = splitInputStr(input!!)
        var result: Int = splitStrings[0].toInt()

        splitStrings.forEachIndexed { i, _ ->
            if (i % 2 == 1) {
                val param = splitStrings[i + 1].toInt()
                val operator = Operator.operationEnum(splitStrings[i])
                result = operator.execute(result, param)
            }
        }
        return result
    }

    private fun validateNullOrEmpty(input: String?) {
        if (input?.trim().isNullOrEmpty()) {
            throw IllegalArgumentException(IS_NOT_OR_BLANK)
        }
    }

    private fun splitInputStr(input: String): List<String> = input.split(DELIMITER)
}
