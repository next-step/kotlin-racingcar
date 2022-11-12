import calculator.domain.CalculationExpression
import calculator.domain.Calculator
import calculator.view.InputView

fun main() {
    val input = CalculationExpression(InputView().getUserInput())
    println(Calculator().calculate(input))
}
