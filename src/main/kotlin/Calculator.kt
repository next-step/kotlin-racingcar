import java.math.BigDecimal
import java.math.MathContext
import java.util.Stack

class Calculator {
    private fun add(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.add(j)

    private fun subtract(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.subtract(j)

    private fun multiply(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.multiply(j)

    private fun divide(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.divide(j, MathContext.DECIMAL64)

    fun calculate(strNum1: String?, strNum2: String?, operation: String): String {
        val i = strNum1?.toBigDecimalOrNull() ?: throw IllegalArgumentException()
        val j = strNum2?.toBigDecimalOrNull() ?: throw IllegalArgumentException()
        return when (operation) {
            Operator.ADD.symbol -> add(i, j)
            Operator.MINUS.symbol -> subtract(i, j)
            Operator.MULTIPLE.symbol -> multiply(i, j)
            Operator.DIVIDE.symbol -> divide(i, j)
            else -> throw IllegalArgumentException()
        }.toString()
    }

    fun calculateStringInput(input: String): String {
        val stack = Stack<String>()
        val number = Stack<String>()
        input.split(" ").map { s ->
            if (Operator.getOperators().contains(s)) {
                stack.push(s)
            } else {
                val num = if (stack.isNotEmpty()) {
                    if (number.isNotEmpty()) calculate(number.pop().toString(), s, stack.pop())
                    else throw RuntimeException(ErrorMessage.InputError.message)
                } else s
                number.push(num)
            }
        }
        val result = number.pop()
        if (number.isNotEmpty() || stack.isNotEmpty())throw RuntimeException(ErrorMessage.InputError.message)
        return result
    }
}
