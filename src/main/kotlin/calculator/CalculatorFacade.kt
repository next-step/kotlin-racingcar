package calculator

import calculator.calculator.Calculator
import calculator.calculator.TextCalculator
import calculator.parser.NodeParser

fun main() {
    val parser: NodeParser = NodeParser()
    val calculator: Calculator = TextCalculator()

    CalculatorFacade(parser, calculator).execute()
}

class CalculatorFacade(private val parser: NodeParser, private val calculator: Calculator) {

    fun execute() {
        val text = readLine()
        println(
            try {
                calculator.calculate(parser.parse(text!!))
            } catch (e: Exception) {
                e.localizedMessage
            }
        )
    }
}
