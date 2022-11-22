package stringcalculator

import stringcalculator.domain.Calculator
import stringcalculator.ui.InputView

fun main() {
    Application().run()
}

class Application {

    fun run() {
        val formula = InputView.inputFormula()
        val result = Calculator.calculate(formula)
        print(result)
    }
}
