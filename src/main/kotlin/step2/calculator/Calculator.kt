package step2.calculator

class Calculator {
    fun execute(input: String): Long {
        val splitter = Splitter(input)
        val operator = splitter.operator
        val result = operator.calculate(splitter.left, splitter.right)

        if (splitter.hasOther) {
            return execute("$result ${splitter.other}")
        }

        return result
    }
}
