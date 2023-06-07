package calculator

private const val DELIMITER = " "
private const val BLANK_EXCEPTION = "입력이 올바르지 않습니다."
private const val OPERATOR_EXCEPTION = "잘못된 연산자입니다."
private const val SIZE_EXCEPTION = "계산을 위한 입력이 충분하지 않습니다."

class Calculator {
    companion object {
        fun inputString(input: String?): Int {
            if (input.isNullOrBlank()) throw IllegalArgumentException(BLANK_EXCEPTION)
            val inputArray = input.split(DELIMITER)
            if (inputArray.size < 3) throw IllegalArgumentException(SIZE_EXCEPTION)

            var result = inputArray[0].toInt()
            for (i in 1 until inputArray.size step (2)) {
                result = calculate(inputArray[i], result, inputArray[i + 1].toInt())
            }
            return result
        }

        private fun calculate(operator: String, left: Int, right: Int): Int {
            return when (operator) {
                "+" -> Operator.PLUS.applyAsInt(left, right)
                "-" -> Operator.MINUS.applyAsInt(left, right)
                "*" -> Operator.MUL.applyAsInt(left, right)
                "/" -> Operator.DIV.applyAsInt(left, right)
                else -> throw IllegalArgumentException(OPERATOR_EXCEPTION)
            }
        }
    }
}
