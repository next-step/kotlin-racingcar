package study.step2

class ArithmeticCalculator {

    fun calculate(inputExpression: String?): Int {
        requireNotNull(inputExpression)
        require(inputExpression.isNotEmpty())

        var result = 0
        var inputOperator = ""

        inputExpression.split(" ").forEachIndexed { index, input ->
            when {
                index == 0 ->
                    result = input.toInt()
                index.isEven() ->
                    result = ArithmeticOperator.operate(inputOperator, result, input.toInt())
                else ->
                    inputOperator = ArithmeticOperator.getSymbol(input)
            }
        }

        return result
    }
}
