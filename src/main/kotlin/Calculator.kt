import java.util.Stack

class Calculator {
    companion object {
        private const val STRING_SPACING = " "
    }

    fun calculate(strNum1: String?, strNum2: String?, operation: String): String {
        val i = requireNotNull(strNum1?.toBigDecimalOrNull())
        val j = requireNotNull(strNum2?.toBigDecimalOrNull())

        return Operator.symbolOf(operation).calculate(i, j).toString()
    }

    fun calculateStringInput(input: String): String {
        val stack = Stack<String>()
        val number = Stack<String>()
        input.split(STRING_SPACING).map { s ->
            if (Operator.getOperators().contains(s)) {
                stack.push(s)
            } else {
                val num = if (stack.isNotEmpty()) {
                    if (number.isNotEmpty()) calculate(number.pop().toString(), s, stack.pop())
                    else throw IllegalArgumentException(ErrorMessage.InputError.message)
                } else s
                number.push(num)
            }
        }
        val result = number.pop()
        if (number.isNotEmpty() || stack.isNotEmpty())throw IllegalArgumentException(ErrorMessage.InputError.message)
        return result
    }
}
