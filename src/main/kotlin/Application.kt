import domain.CalculationExpression
import domain.Calculator
import view.InputView

fun main() {
    val input = CalculationExpression(InputView().getUserInput())
    println(Calculator().calculate(input))
}
