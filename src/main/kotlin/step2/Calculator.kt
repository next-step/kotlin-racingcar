package step2

/**
 *
 * @author Leo
 */
class Calculator {

    fun classifyParams(expression: String): Pair<MutableList<Long>, MutableList<Operation>> {
        val numbers = mutableListOf<Long>()
        val operations = mutableListOf<Operation>()

        fun collectParam(index: Int, param: String) {
            if (index % 2 == 0) {
                numbers.add(param.toLong())
                return
            }

            operations.add(Operation.findCalculation(param))
        }

        expression.split(Constant.SPACE)
            .withIndex()
            .forEach { (index, param) ->
                collectParam(index = index, param = param)
            }

        return Pair(numbers, operations)
    }

    fun calculate(classifiedParams: Pair<MutableList<Long>, MutableList<Operation>>): Long {
        var result = 0L
        val numbers = classifiedParams.first
        val operations = classifiedParams.second

        fun updateResult(index: Int, number: Long) {
            if (index == 0) {
                result = numbers[0]
                return
            }

            result = operations[index - 1].calculation.apply(result, number)
        }

        numbers
            .withIndex()
            .forEach { (index, number) ->
                updateResult(index = index, number = number)
            }

        return result
    }
}
