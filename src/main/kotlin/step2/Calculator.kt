package step2

/**
 *
 * @author Leo
 */
class Calculator {

    fun calculate(expression: String): Long {
        val classifiedParams = classifyParams(expression = expression)
        val numbers = classifiedParams.first
        val operations = classifiedParams.second
        var result = 0L

        numbers.forEach { number ->
            result = operations.removeFirst().calculation(result, number)
        }

        return result
    }

    fun classifyParams(expression: String): Pair<MutableList<Long>, MutableList<Operation>> {
        val numbers = mutableListOf<Long>()
        val operations = mutableListOf(Operation.PLUS)

        expression.split(OperationConstant.SPACE)
            .forEach { param ->
                if (OperationConstant.SYMBOLS.contains(param)) {
                    operations.add(Operation.findCalculation(param))
                    return@forEach
                }

                numbers.add(param.toLong())
            }

        return Pair(numbers, operations)
    }
}
