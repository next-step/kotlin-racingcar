import java.lang.IllegalArgumentException

object StringCalculator {
    fun evaluate(formula: String?): Int {
        if (formula.isNullOrBlank()) throw IllegalArgumentException("empty formula: `$formula`")

        val elements = formula.split(" ").toMutableList()

        var ans = elements.removeAt(0).toInt()

        for (i in 0 until elements.size / 2) {
            val operation = elements[i * 2]
            val operand = elements[i * 2 + 1].toInt()

            ans = performOperation(ans, operation, operand)
        }

        return ans
    }

    private fun performOperation(currentValue: Int, operationString: String, operand: Int): Int =
        when (operationString) {
            "+" -> plus(currentValue, operand)
            "-" -> minus(currentValue, operand)
            "*" -> multiply(currentValue, operand)
            "/" -> divide(currentValue, operand)
            else -> throw IllegalArgumentException("invalid operation: `$operationString`")
        }

    fun plus(currentValue: Int, operand: Int) = currentValue + operand

    fun minus(currentValue: Int, operand: Int) = currentValue - operand

    fun multiply(currentValue: Int, operand: Int) = currentValue * operand

    fun divide(currentValue: Int, operand: Int) = currentValue / operand
}
