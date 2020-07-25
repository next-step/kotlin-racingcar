class StringCalculator {
    val VALID_REGEX = Regex(pattern = "^[ 0-9+*\\-=\\/]+$")
    val DELIMITER = " "

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
        var iterator = list.listIterator()
        var result = 0
        var isFirst = true
        while (iterator.hasNext()) {
            var current = iterator.next()

            if (isFirst) {
                result = current.toInt()
                isFirst = false
            }

            when (current) {
                "+" -> {
                    result = Operator.PLUS.apply(result, iterator.next().toInt())
                }
                "-" -> {
                    result = Operator.MINUS.apply(result, iterator.next().toInt())
                }
                "*" -> {
                    result = Operator.MULTIPLY.apply(result, iterator.next().toInt())
                }
                "/" -> {
                    var number = iterator.next().toInt()
                    if (number == 0) {
                        throw ArithmeticException("not divide by zero")
                    }
                    result = Operator.DIVIDE.apply(result, number)
                }
            }
        }
        return result
    }
}
