object Calculator {

    private const val SPERATOR = " "
    private const val LAST_INDEX = 1
    private const val NEXT_PART_INDEX = 2
    private const val NUMBER_POSITION = 0
    private const val OPERATOR_POSITION = 1

    fun calculate(formulaString: String): String {
        if (formulaString.isEmpty()) {
            throw IllegalArgumentException("Input value is empty")
        }
        val formulaList = formulaString.split(SPERATOR)
        val resultValue = recursiveCalculator(formulaList.reversed())
        println(resultValue)
        return resultValue
    }

    private fun recursiveCalculator(formulaList: List<String>): String {
        if (formulaList.size == LAST_INDEX) {
            return formulaList[NUMBER_POSITION]
        }

        val operator = formulaList[OPERATOR_POSITION]
        val number = formulaList[NUMBER_POSITION]

        return when (Operator.findOperator(operator)) {
            Operator.PLUS -> {
                plus(recursiveCalculator(formulaList.slice(NEXT_PART_INDEX until formulaList.size)), number)
            }
            Operator.MINUS -> {
                minus(recursiveCalculator(formulaList.slice(NEXT_PART_INDEX until formulaList.size)), number)
            }
            Operator.TIMES -> {
                times(recursiveCalculator(formulaList.slice(NEXT_PART_INDEX until formulaList.size)), number)
            }
            Operator.DIVIDE -> {
                divide(recursiveCalculator(formulaList.slice(NEXT_PART_INDEX until formulaList.size)), number)
            }
            else -> {
                throw IllegalArgumentException("Cannot find operator")
            }
        }
    }
    fun plus(preNumber: String, postNumber: String): String {
        if (!isNum(preNumber) || !isNum(postNumber)) {
            throw IllegalArgumentException("Value must be Number.")
        }
        return (preNumber.toInt() + postNumber.toInt()).toString()
    }

    fun minus(preNumber: String, postNumber: String): String {
        if (!isNum(preNumber) || !isNum(postNumber)) {
            throw IllegalArgumentException()
        }
        return (preNumber.toInt() - postNumber.toInt()).toString()
    }

    fun times(preNumber: String, postNumber: String): String {
        if (!isNum(preNumber) || !isNum(postNumber)) {
            throw IllegalArgumentException()
        }
        return (preNumber.toInt() * postNumber.toInt()).toString()
    }

    fun divide(preNumber: String, postNumber: String): String {
        if (!isNum(preNumber) || !isNum(postNumber)) {
            throw IllegalArgumentException()
        }
        return (preNumber.toInt() / postNumber.toInt()).toString()
    }

    private fun isNum(numberString: String): Boolean {
        numberString.forEach {
            char ->

            val charConvertedToCode = char.code

            if (charConvertedToCode > 57 || charConvertedToCode < 48) {
                return false
            }
        }
        return true
    }
}
