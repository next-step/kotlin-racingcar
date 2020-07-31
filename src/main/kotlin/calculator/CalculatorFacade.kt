package calculator

import calculator.calculator.Calculator
import calculator.calculator.CalculatorImpl
import calculator.parser.NodeParser
import calculator.parser.NodeParserImpl

fun main() {
    val parser: NodeParser = NodeParserImpl()
    val calculator: Calculator = CalculatorImpl()

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
