package step2

import step2.calculator.Calculator
import step2.calculator.CalculatorImpl
import step2.calculator.Node
import step2.parser.NodeParser
import step2.parser.NodeParserImpl

fun main(args: Array<String>) {
    CalculatorFacade().execute()
}

class CalculatorFacade {
    val parser: NodeParser = NodeParserImpl()
    val calculator: Calculator = CalculatorImpl()

    fun execute() {
        val text = readLine()
        println(
            try {
                calculator.calculate(parser.parse(text!!))
            } catch (e: NodeParser.Error.InvalidCharacter) {
                e.localizedMessage
            } catch (e: Calculator.Error.NumberIsMissing) {
                e.localizedMessage
            } catch (e: Calculator.Error.OperatorIsMissing) {
                e.localizedMessage
            } catch (e: Node.Operator.Divide.DivideByZeroException) {
                e.localizedMessage
            }
        )
    }
}
