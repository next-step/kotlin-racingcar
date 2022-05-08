class StringCalculator(val input: String?) {
    var op: String = ""

    fun calculate() {
        validate()

        val inputArray: Array<String> = convertToArray(input!!)

        val result = inputArray.reduceIndexed() { index, prev, cur ->
            if (index % 2 == 1) {
                op = cur
                prev
            }

            calc(prev, op, cur)
        }
    }

    private fun convertToArray(input: String): Array<String> {
        return input
            .replace(" ", "")
            .toCharArray()
            .map { it.toString() }
            .toTypedArray()
    }

    fun calc(left: String, op: String, right: String): String {
        var result = 0;
        val leftValue = left.toInt();
        val rightValue = right.toInt();

        when (op) {
            "+" -> {
                result = sum(leftValue, rightValue)
            }
            "-" -> {
                result = minus(leftValue, rightValue)
            }
            "*" -> {
                result = multiple(leftValue, rightValue)
            }
            "/" -> {
                result = divide(leftValue, rightValue)
            }
        }

        return result.toString()
    }

    private fun validate() {
        if (input == null || input.isEmpty()) {
            throw IllegalArgumentException()
        }

        for((index, value) in input.withIndex()) {
            if (index % 2 == 0) {
                validateIsDigit(value)
            }

            if (index % 2 == 1) {
                validateOperator(value)
            }
        }
    }

    private fun validateIsDigit(value: Char) {
        if(!value.isDigit()) {
            throw IllegalArgumentException()
        }
    }

    private fun validateOperator(value: Char) {
        val validOperator = listOf<Char>('+', '-', '*', '/')
        if(!validOperator.contains(value)) {
            throw IllegalArgumentException()
        }
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun minus(a: Int, b: Int): Int {
        return a - b
    }

    fun multiple(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        return a / b
    }
}