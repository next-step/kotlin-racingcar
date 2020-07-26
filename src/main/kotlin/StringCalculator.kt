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
        val numList = list.filter { it !in OperatorSymbol.symbolList() }
        val operatorList = list.filter { it in OperatorSymbol.symbolList() }
        var result = 0
        var numListIndex = 0
        result = numList[numListIndex].toInt()
        numListIndex++
        for (operator in operatorList) {
            if (operator.equals(OperatorSymbol.DIVIDE.symbol) && numList[numListIndex].toInt() == 0) {
                throw ArithmeticException("not divide by zero")
            }
            result = OperatorSymbol.findSymbolOperator(operator).apply(result, numList[numListIndex].toInt())
            numListIndex++
        }
        return result
    }

    companion object {
        val VALID_REGEX = Regex(pattern = "^[ 0-9+*\\-=\\/]+$")
        val DELIMITER = " "
    }
}
