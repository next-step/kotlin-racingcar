package stringcaculator

class StringCalculator {

    private var result = 0
    private var operator = "+"

    fun calculate(input: String): Int {
        result = 0
        operator = "+"
        input.split(" ").forEach {
            operandCalculate(it)
        }
        return result
    }

    fun operandCalculate(input: String) {
        checkInputIsNullOrBlank(input)
        if (!checkIsNumber(input)) {
            operator = input
            return
        }

        result = when (operator) {
            "+" -> plus(result, input.toInt())
            "-" -> minus(result, input.toInt())
            "*" -> multiply(result, input.toInt())
            "/" -> divide(result, input.toInt())
            else -> throw IllegalArgumentException("Invalid Operator")
        }
    }

    fun checkIsNumber(input: String): Boolean {
        input.toCharArray().forEach {
            if (!it.isDigit()) return false
        }
        return true
    }

    fun checkInputIsNullOrBlank(input: String) {
        if (input.isNullOrBlank()) throw IllegalArgumentException("Invalid Input")
    }

    fun plus(operand1: Int, operand2: Int): Int {
        return operand1 + operand2
    }

    fun minus(operand1: Int, operand2: Int): Int {
        return operand1 - operand2
    }

    fun multiply(operand1: Int, operand2: Int): Int {
        return operand1 * operand2
    }

    fun divide(operand1: Int, operand2: Int): Int {
        if (operand2 == 0) throw ArithmeticException("/by Zero")
        return operand1 / operand2
    }
}
