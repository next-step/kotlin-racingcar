import java.lang.IllegalArgumentException

object StringCalculator {
    fun evaluate(formula: String?): Int {
        if (formula.isNullOrBlank()) throw IllegalArgumentException("empty formula: `$formula`")

        val elements = formula.split(" ").toMutableList()

        var ans = elements.removeAt(0).toInt()

        for (i in 0 until elements.size / 2) {
            val operationString = elements[i * 2]
            val operand = elements[i * 2 + 1].toInt()

            ans = Operator.performOperation(ans, getOperation(operationString), operand)
        }

        return ans
    }

    private fun getOperation(operationString: String): ArithmeticOperation {
        return ArithmeticOperation.values().firstOrNull {
            it.operationString == operationString
        } ?: throw IllegalArgumentException("invalid operation: `$operationString`")
    }

    enum class ArithmeticOperation(val operationString: String, val run: (Int, Int) -> Int) {
        Plus("+", run = { currentValue, operand -> currentValue + operand }),
        Minus("-", run = { currentValue, operand -> currentValue - operand }),
        Multiply("*", run = { currentValue, operand -> currentValue * operand }),
        Divide("/", run = { currentValue, operand -> currentValue / operand }),
    }

    object Operator {
        fun plus(currentValue: Int, operand: Int) = ArithmeticOperation.Plus.run(currentValue, operand)
        fun minus(currentValue: Int, operand: Int) = ArithmeticOperation.Minus.run(currentValue, operand)
        fun multiply(currentValue: Int, operand: Int) = ArithmeticOperation.Multiply.run(currentValue, operand)
        fun divide(currentValue: Int, operand: Int) = ArithmeticOperation.Divide.run(currentValue, operand)
        fun performOperation(currentValue: Int, operation: ArithmeticOperation, operand: Int): Int =
            operation.run(currentValue, operand)
    }
}
