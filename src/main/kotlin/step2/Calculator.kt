package step2

class Calculator {
    fun calculate(inputText: String): Int {
        checkNullOrWhitespace(inputText)
        val splitedStringList = getListOfSplitedStringByBlank(inputText)

        val firstOperand = splitedStringList[0]

        val lastIndexOfOperand = splitedStringList.size - 3
        val offset = 2

        val operatorOffset = 1
        val yOperandOffset = 2

        checkNullOrWhitespace(firstOperand)
        var result = firstOperand.toInt()

        for (index: Int in 0..lastIndexOfOperand step (offset)) {
            val operator = splitedStringList[index + operatorOffset]
            val y = splitedStringList[index + yOperandOffset].toInt()

            result = calculateWithOperator(result, y, operator)
        }
        return result
    }

    private fun checkNullOrWhitespace(inputString: String) {
        require(inputString.isNotBlank()) { "입력값이 null이거나 빈 공백 문자임." }
    }

    private fun getListOfSplitedStringByBlank(inputString: String): List<String> {
        return inputString.split(' ') // ex) 2, +, 3, *, 4, /, 2
    }

    private fun calculateWithOperator(x: Int, y: Int, operator: String): Int {
        return Operator.pickOperation(operator).calculate(x, y)
    }
}
