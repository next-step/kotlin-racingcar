package step2.calculator

class Calculator {

    fun execute(input: String): Long {
        return this.execute(input.split(" "))
    }

    private fun execute(input: List<String>): Long {
        val splitter = Splitter(input)
        val operator = splitter.operator
        val result = operator.calculate(splitter.left, splitter.right)

        if (splitter.hasOther) {
            return execute(listOf(result.toString()) + input.drop(3))
        }

        return result
    }
}
