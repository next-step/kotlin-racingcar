package calculator

class Calculator {
    private val numberRex = Regex("\\d*\\.?\\d+")

    fun calculate(value: String): Int {
        try {
            blankValidator(value)
            val str = value.split(" ")
            val numberList = str.filter {
                it.matches(numberRex)
            }.map(String::toInt)
            val operatorList = str.filter {
                !it.matches(numberRex)
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
            result = selectOperator(operator, result, numberList[number++])
        }
        return result
    }

    private fun blankValidator(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("공백 문자는 입력할 수 없습니다.")
        }
    }

    private fun selectOperator(operator: String, number1: Int, number2: Int): Int {
        return when (operator) {
            Operator.ADD.operator -> Operator.ADD.applyAsInt(number1, number2)
            Operator.MINUS.operator -> Operator.MINUS.applyAsInt(number1, number2)
            Operator.DIVIDE.operator -> Operator.DIVIDE.applyAsInt(number1, number2)
            Operator.TIMES.operator -> Operator.TIMES.applyAsInt(number1, number2)
            else -> throw IllegalArgumentException("사칙연산 부호가 아닙니다.")
        }
    }
}
