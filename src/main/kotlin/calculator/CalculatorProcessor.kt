package calculator

object CalculatorProcessor {
    fun calculate(operators: List<Operator>, operands: List<Double>): Double {
        var result = operands.first()

        println("\n========== 계산 시작 ==========")
        operands.drop(1).zip(operators) { operand, operator ->
            print("$result ${operator.symbol} $operand = ")
            result = operator.expression(result, operand)
            println(result)
        }
        println("========== 계산 완료 ==========\n")

        return result
    }
}
