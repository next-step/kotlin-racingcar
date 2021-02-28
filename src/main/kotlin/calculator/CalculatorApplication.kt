package calculator

import calculator.domain.BlankMathExpression
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

        try {
            val mathExpression = BlankMathExpression(input)
            val calculator = Calculator(mathExpression)
            val result = calculator.calculate()

            userInterface.showResult(result.value)
        } catch (e: Exception) {
            userInterface.showErrorMessage(e.localizedMessage)
            run()
        }
    }
}
