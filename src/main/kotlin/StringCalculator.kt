class StringCalculator(val input: String?) {
    init {
        validate()
    }

    fun calculate(): Int {
        val inputArray: Array<String> = convertToArray(input!!)

        var op = ""
        var result: Int = inputArray[0].toInt()
        for (index in 1 until inputArray.size) {
            if (index % 2 == 1) {
                op = inputArray[index]
                continue
            }

            validateIsDigit(inputArray[index])
            result = calc(result, op, inputArray[index].toInt())
        }

        return result
    }

    private fun convertToArray(input: String): Array<String> {
        return input
            .replace(" ", "")
            .toCharArray()
            .map { it.toString() }
            .toTypedArray()
    }

    private fun calc(leftValue: Int, op: String, rightValue: Int): Int {
        return when (op) {
            "+" -> {
                sum(leftValue, rightValue)
            }
            "-" -> {
                minus(leftValue, rightValue)
            }
            "*" -> {
                multiple(leftValue, rightValue)
            }
            "/" -> {
                divide(leftValue, rightValue)
            }
            else -> throw IllegalArgumentException()
        }
    }

    private fun validate() {
        validateEmptyInput()
        validateInputLength()
    }
    private fun validateEmptyInput() {
        if (input == null || input.replace(" ", "").isEmpty()) {
            throw IllegalArgumentException()
        }
    }

    private fun validateInputLength() {
        if (input!!.length % 2 == 0) {
            throw IllegalArgumentException()
        }
    }

    private fun validateIsDigit(value: String) {
        if(value.toIntOrNull() == null) {
            throw IllegalArgumentException()
        }
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun minus(a: Int, b: Int): Int {
        return a - b
    }

    private fun multiple(a: Int, b: Int): Int {
        return a * b
    }

    private fun divide(a: Int, b: Int): Int {
        return a / b
    }
}