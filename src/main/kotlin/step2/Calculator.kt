package step2

object Calculator {

    fun calculate(value: String?): Int {
        require(!value.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다." }
        val valueSplitList = value.trim().split(" ")

        var result = valueSplitList[0].toIntOrNull() ?: throw NumberFormatException("첫번째 입력값이 정수가 아니므로 변환할 수 없습니다.")
        for (i in 1 until valueSplitList.size - 1) {
            if (checkStringNextNum(valueSplitList[i], valueSplitList[i + 1])) {
                result = calculate(result, valueSplitList[i], valueSplitList[i + 1].toInt())
            }
        }
        return result
    }

    private fun checkStringNextNum(maybeOperator: String, maybeIntValue: String): Boolean {
        return if (maybeOperator.toIntOrNull() == null && maybeIntValue.toIntOrNull() != null) {
            true
        } else if (maybeOperator.toIntOrNull() == null && maybeIntValue.toIntOrNull() == null) {
            throw IllegalArgumentException("연산자 다음에는 정수가 입력 되어야 합니다.")
        } else if (maybeOperator.toIntOrNull() != null && maybeIntValue.toIntOrNull() != null) {
            throw IllegalArgumentException("정수가 올 자리가 아닙니다.")
        } else {
            return false
        }
    }

    private fun calculate(num1: Int, op: String, num2: Int): Int {
        val operator = Operator.convertToOperator(op)
        return operator.calculate(num1, num2)
    }
}
