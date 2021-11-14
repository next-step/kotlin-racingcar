package step2

/**
 *
 * @author Leo
 */
class Calculator {

    companion object {
        val PLUS = "+"
        val MINUS = "-"
        val MULTIPLE = "*"
        val DIVIDE = "/"
        val SPACE = " "
        val EMPTY = ""
    }

    fun calculate(expression: String): Long {
        val classifiedParams = classifyParams(expression = expression)
        val numbers = classifiedParams.first
        val operations = classifiedParams.second
        var result = 0L

        numbers
            .withIndex()
            .forEach { (index, number) ->
                if (index == 0) {
                    result = numbers[0]
                    return@forEach
                }

                result = operations[index - 1].calculation.apply(result, number)
            }

        return result
    }

    private fun classifyParams(expression: String): Pair<MutableList<Long>, MutableList<Operation>> {
        val numbers = mutableListOf<Long>()
        val operations = mutableListOf<Operation>()

        expression.split(SPACE)
            .withIndex()
            .forEach { (index, param) ->
                if (index % 2 == 0) {
                    numbers.add(param.toLong())
                    return@forEach
                }

                operations.add(Operation.findCalculation(param))
            }

        return Pair(numbers, operations)
    }
}
