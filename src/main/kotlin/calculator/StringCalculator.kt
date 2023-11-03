package calculator

import java.lang.IllegalArgumentException

object StringCalculator {
    fun evaluate(formula: String?): Int {
        if (formula.isNullOrBlank()) throw IllegalArgumentException("empty formula: `$formula`")

        val elements = formula.split(" ").toMutableList()

        var ans = elements.removeAt(0).toInt()

        for (i in 0 until elements.size / 2) {
            val operationString = elements[i * 2]
            val operand = elements[i * 2 + 1].toInt()

            ans = performOperation(ans, ArithmeticOperation.getOperation(operationString), operand)
        }

        return ans
    }

    private fun performOperation(currentValue: Int, operation: ArithmeticOperation, operand: Int): Int =
        operation.run(currentValue, operand)
}
