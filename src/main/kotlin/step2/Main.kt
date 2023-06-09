package step2

fun main() {
    val calculator = Calculator(
        expressionValidator = ExpressionValidator(),
        expressionTokenizer = ExpressionTokenizer(),
        expressionParser = ExpressionParser(),
        calculatorStrategy = CalculatorStrategy()
    )
    val calculateResult = calculator.calculate(readLine())
    println(calculateResult)
}
