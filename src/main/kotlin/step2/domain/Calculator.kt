package step2.domain

object Calculator {

    fun calculate(calculatorInput: CalculatorInput): Long {
        val operators = calculatorInput.operators
        val numbers = calculatorInput.numbers

        var result = numbers.removeFirst()

        while (operators.isNotEmpty()) {
            val operator = operators.removeFirst()
            result = operator.calculate(firstNumber = result, secondNumber = numbers.removeFirst())
        }

        return result
    }
}
