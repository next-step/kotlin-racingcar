import java.util.Stack

class Calculator {
    fun calculate(strNum1: String?, strNum2: String?, operation: String): String {
        val i = requireNotNull(strNum1?.toBigDecimalOrNull())
        val j = requireNotNull(strNum2?.toBigDecimalOrNull())

        return Operator.symbolOf(operation).calculate(i, j).toString()
    }

    fun calculateWithNumberStack(strNum: String, operation: String, number: Stack<String>): String =
        if (number.isNotEmpty()) calculate(number.pop().toString(), strNum, operation)
        else throw IllegalArgumentException(ErrorMessage.InputError.message)

    fun calculateStringInput(input: String): String {
        val stack = Stack<String>()
        val number = Stack<String>()
        input.split(SEPARATOR).map { s ->
            if (Operator.isContains(s)) {
                stack.push(s)
            } else {
                val num = when {
                    stack.isNotEmpty() -> calculateWithNumberStack(s, stack.pop(), number)
                    else -> s
                }
                number.push(num)
            }
        }
        if (stack.isNotEmpty()) throw IllegalArgumentException(ErrorMessage.InputError.message)
        val result = number.pop()
        if (number.isNotEmpty()) throw IllegalArgumentException(ErrorMessage.InputError.message)
        return result
    }

    companion object {
        private const val SEPARATOR = " "
    }
}
