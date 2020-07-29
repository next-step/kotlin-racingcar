package calculator

class Calculator {
    private val NUMBER_REGEX = Regex("\\d*\\.?\\d+")

    fun calculate(value: String): Int {
        try {
            validateBlank(value)
            val str = value.split(" ")
            val numberList = str.filter {
                it.matches(NUMBER_REGEX)
            }.map(String::toInt)
            val operatorList = str.filter {
                !it.matches(NUMBER_REGEX)
            }
            return operate(numberList, operatorList)
        } catch (e: NumberFormatException) {
            throw NotSupportedTypeException("정수만 입력할 수 있습니다.")
        }
    }

    private fun operate(
        numberList: List<Int>,
        operatorList: List<String>
    ): Int {
        var result = numberList[0]
        var number = 1

        for (operator in operatorList) {
            result = Operator.selectOperator(operator).calculation(result, numberList[number++])
        }
        return result
    }

    private fun validateBlank(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("공백 문자는 입력할 수 없습니다.")
        }
    }
}
