package step2

import step2.calculator.Calculator
import step2.calculator.CalculatorImpl
import step2.parser.NodeParser
import step2.parser.NodeParserImpl

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
