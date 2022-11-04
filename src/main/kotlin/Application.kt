import java.lang.IllegalArgumentException

class Application {
    fun calculate(args: String): Calculator {
        if (args.isNullOrBlank()) {
            throw IllegalArgumentException("")
        }

        var result = Calculator("0")
        var beforeCalculator: Calculator = Calculator("0")
        var beforeOperator: Operator = Operator.ADD
        args.split(" ")
            .forEachIndexed { index, s ->
                if (index % 2 == 0) {
                    result = beforeCalculator.operate(beforeOperator, Calculator(s))
                    beforeCalculator = result
                } else if (index % 2 == 1) {
                    beforeOperator = Operator.of(s)
                }
            }
        return result
    }
}
