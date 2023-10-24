package study

class Calculator(val input: String?) {
    fun calculate(): Double {
        val inputValues = input?.split(" ") ?: listOf()

        checkInputValid(inputValues)

        var current = inputValues[0].toDouble()
        var arithMeticSymbol = ""
        for (inputValue in inputValues.subList(1, inputValues.size)) {
            if (inputValue.isNumeric()) {
                current = when (arithMeticSymbol) {
                    "+" -> plus(current, inputValue.toDouble())
                    "-" -> minus(current, inputValue.toDouble())
                    "/" -> divide(current, inputValue.toDouble())
                    "*" -> multiply(current, inputValue.toDouble())
                    else -> throw IllegalArgumentException()
                }
            }
            arithMeticSymbol = inputValue
        }
        return current
    }

    private fun plus(value1: Double, value2: Double) = value1 + value2

    private fun minus(value1: Double, value2: Double) = value1 - value2

    private fun divide(value1: Double, value2: Double) = value1 / value2

    private fun multiply(value1: Double, value2: Double) = value1 * value2

    private fun checkInputValid(inputValues: List<String>) {
        if (inputValues.size < 3) {
            throw IllegalArgumentException()
        }
    }
}

private fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}
