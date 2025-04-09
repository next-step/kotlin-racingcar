import java.util.ArrayDeque
import java.util.Queue
import java.util.Stack

private const val DELIMITER = " "

fun String.containsInvalidSymbols(): Boolean {
    return this.any { !it.isDigit() && it !in Operator.getValidSymbols() }
}

class Calculator {

    fun compute(input: String): Int {
        validate(input)

        val tokens = input.split(DELIMITER)
        val queue: Queue<String> = ArrayDeque(tokens)

        val evalStack = Stack<Int>()
        while (queue.isNotEmpty()) {
            val token = queue.poll()
            evaluateToken(token, evalStack)
        }
        return evalStack.pop()
    }

    private fun validate(input: String) {
        require(input.isNotBlank()) { "Input should not be blank" }
        require(!input.containsInvalidSymbols()) { "Input contains invalid symbols" }
    }

    private fun evaluateToken(token: String, evalStack: Stack<Int>) {
        val operator = Operator.from(token)
        if (operator == null) {
            evalStack.push(token.toInt())
            return
        }

        val b = evalStack.pop()
        val a = evalStack.pop()
        evalStack.push(operator.apply(a, b))
    }

}