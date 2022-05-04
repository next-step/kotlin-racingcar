package step2

class StringCalculator {

    fun calculate(expression: String?): Number {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("입력값은 null 이거나 빈 공백 문자일수 없습니다.")
        }

        return expression
            .split(SPACE_DELIMITER)
            .let {
                calculateRecursive(it[0].toLongOnlyNumber(), it.drop(1))
            }
    }

    private fun calculateRecursive(currentNumber: Long, remainList: List<String>): Long {
        if (remainList.isEmpty()) {
            return currentNumber
        }
        val operator = Operator.of(remainList[0])
        val nextNumber = remainList[1].toLongOnlyNumber()

        return calculateRecursive(operator.operate(currentNumber, nextNumber), remainList.drop(2))
    }

    companion object {
        private const val SPACE_DELIMITER = " "
    }
}

