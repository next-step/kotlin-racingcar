package calculator

class Calculator {

    private val DELIMITER: String = " "

    fun execute(expression: String): Int {
        val token = tokenize(expression)
        return calculate(token)
    }

    private fun tokenize(expression: String): Pair<List<Int>, List<Operation>> {
        val tokens: List<String> = expression.split(DELIMITER)

        val numbers: List<Int> = tokens.mapIndexedNotNull { index: Int, string: String ->
            if (index % 2 == 0) string.toInt() else null
        }

        val operations: List<Operation> = tokens.mapIndexedNotNull { index: Int, string: String ->
            if (index % 2 != 0) Operation.of(string) else null
        }

        return Pair(numbers, operations)
    }

    private fun calculate(token: Pair<List<Int>, List<Operation>>): Int {
        val numbers = token.first.toMutableList()
        val operations = token.second

        var result: Int = numbers.removeFirst()

        for (operation in operations) {
            result = operation.execute(result, numbers.removeFirst())
        }

        return result
    }
}
