import java.util.Stack

class Calculator {

    fun calculate(strNum1: String?, strNum2: String?, operation: String): String {
        val i = strNum1?.toBigDecimalOrNull() ?: throw IllegalArgumentException()
        val j = strNum2?.toBigDecimalOrNull() ?: throw IllegalArgumentException()

        return Operator.symbolOf(operation).calculate(i, j).toString()
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
