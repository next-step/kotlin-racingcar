package step2

import step2.parser.ExpressionParser
import step2.strategy.CalculatorStrategy
import step2.tokenizer.ExpressionTokenizer

fun main() {
    val calculator = Calculator(
        expressionTokenizer = ExpressionTokenizer(),
        expressionParser = ExpressionParser(),
        calculatorStrategy = CalculatorStrategy()
    )
    val calculateResult = calculator.calculate(readLine())
    println(calculateResult)
}
