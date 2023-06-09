package step2

import step2.parser.ExpressionParser
import step2.strategy.CalculatorStrategy
import step2.tokenizer.ExpressionTokenizer
import step2.validator.ExpressionValidator

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
