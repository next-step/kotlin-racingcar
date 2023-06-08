object Calculator {

    private const val SPERATOR = " "
    private const val LAST_INDEX = 1
    private const val NEXT_PART_INDEX = 2
    private const val NUMBER_POSITION = 0
    private const val OPERATOR_POSITION = 1

    enum class Operator(val operator: String) {
        PLUS("+"),
        MINUS("-"),
        TIMES("*"),
        DIVIDE("/");

        companion object {
            fun findOperator(operator: String): Operator? = values().firstOrNull { it.operator == operator }
        }
    }

    fun calculate(str: String): String {
        if (str.isEmpty()) {
            throw IllegalArgumentException("Input value is empty")
        }
        val args = str.split(SPERATOR)
        val result = recursiveCalculator(args.reversed())
        println(result)
        return result
    }

    private fun recursiveCalculator(str: List<String>): String {
        if (str.size == LAST_INDEX) {
            return str[NUMBER_POSITION]
        }

        val operator = str[OPERATOR_POSITION]
        val num = str[NUMBER_POSITION]

        return when (Operator.findOperator(operator)) {
            Operator.PLUS -> {
                plus(recursiveCalculator(str.slice(NEXT_PART_INDEX until str.size)), num)
            }
            Operator.MINUS -> {
                minus(recursiveCalculator(str.slice(NEXT_PART_INDEX until str.size)), num)
            }
            Operator.TIMES -> {
                times(recursiveCalculator(str.slice(NEXT_PART_INDEX until str.size)), num)
            }
            Operator.DIVIDE -> {
                divide(recursiveCalculator(str.slice(NEXT_PART_INDEX until str.size)), num)
            }
            else -> {
                throw IllegalArgumentException("Cannot find operator")
            }
        }
    }
    fun plus(num1: String, num2: String): String {
        if (!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException("Value must be Number.")
        }
        return (num1.toInt() + num2.toInt()).toString()
    }

    fun minus(num1: String, num2: String): String {
        if (!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException()
        }
        return (num1.toInt() - num2.toInt()).toString()
    }

    fun times(num1: String, num2: String): String {
        if (!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException()
        }
        return (num1.toInt() * num2.toInt()).toString()
    }

    fun divide(num1: String, num2: String): String {
        if (!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException()
        }
        return (num1.toInt() / num2.toInt()).toString()
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
