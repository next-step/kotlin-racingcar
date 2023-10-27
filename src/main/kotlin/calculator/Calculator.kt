package calculator

object Calculator {
    fun calculate(input: String?): Double {
        val calculatorInput = CalculatorInputGenerator.generate(input)

        val operands = calculatorInput.operands
        val operators = calculatorInput.operators

        var index = 0

        return operands.reduce { accumulator, number ->
            operators[index++].operate(accumulator, number)
        }
    }
}
