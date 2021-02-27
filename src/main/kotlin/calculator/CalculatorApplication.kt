package calculator

import calculator.domain.Calculator
import calculator.userinterface.Console
import calculator.userinterface.UserInterface

fun main() {
    val ui: UserInterface = Console()
    val app = CalculatorApplication(ui)
    app.run()
}

class CalculatorApplication(private val userInterface: UserInterface) {

    fun run() {
        userInterface.showInput()
        val input = userInterface.inputMathExpression()
        val operands = input.split(" ").filterIndexed { idx, _ -> idx % 2 == 0 }.toList()
        val operators = input.split(" ").filterIndexed { idx, _ -> idx % 2 == 1 }.toList()

        val calculator = Calculator(operands, operators)
        val result = calculator.calculate()

        userInterface.showResult(result)
    }
}
