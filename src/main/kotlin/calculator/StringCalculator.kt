package calculator

class StringCalculator {
    fun validateStringForCalculate(str: String?) {
        if (str == null) {
            throw IllegalArgumentException("null is not acceptable")
        }
        if (!str.contains(" ")) {
            throw IllegalArgumentException("$str is not acceptable")
        }
        if (!VALID_REGEX.matches(str)) {
            throw IllegalArgumentException("$str is not acceptable")
        }
    }

    fun splitForCalculate(str: String): List<String> {
        return str.split(DELIMITER)
    }

    fun calculate(list: List<String>): Int {
        val numList = list.filter { it !in Operator.symbolList() }
        val operatorList = list.filter { it in Operator.symbolList() }
        var numListIndex = 0
        var result = numList[numListIndex].toInt()
        numListIndex++
        for (operator in operatorList) {
            checkDivideZero(operator, numList, numListIndex)
            result = Operator.findSymbolOperator(operator).apply(result, numList[numListIndex].toInt())
            numListIndex++
        }
        return result
    }

    private fun checkDivideZero(operator: String, numList: List<String>, numListIndex: Int) {
        if (operator == Operator.DIVIDE.symbol && numList[numListIndex].toInt() == 0) {
            throw ArithmeticException("not divide by zero")
        }
    }

    companion object {
        val VALID_REGEX = Regex(pattern = "^[ 0-9+*\\-=\\/]+$")
        val DELIMITER = " "
    }
}
