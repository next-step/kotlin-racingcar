package calculator

private const val DELIMITER = " "
private const val BLANK_EXCEPTION = "입력이 올바르지 않습니다."
private const val SIZE_EXCEPTION = "계산을 위한 입력이 충분하지 않습니다."

object Calculator {
    fun getInput(input: String?): Int {
        require(!input.isNullOrBlank()) { BLANK_EXCEPTION }
        val inputArray = input.split(DELIMITER)
        require(inputArray.size > 2) { SIZE_EXCEPTION }

        var result = inputArray[0].toInt()
        for (i in 1 until inputArray.size step (2)) {
            result = calculate(inputArray[i], result, inputArray[i + 1].toInt())
        }
        return result
    }

    private fun calculate(operator: String, left: Int, right: Int): Int {
        return Operator.from(operator).operate(left, right)
    }
}
