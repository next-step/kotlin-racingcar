package string.calculator

import string.calculator.domain.Calculator
import string.calculator.domain.Splitter
import string.calculator.domain.UserInterface

class CalculatorMachine(
    private val splitter: Splitter,
    private val userInterface: UserInterface
) {
    fun start() {
        try {
            run()
        } catch (e: IllegalArgumentException) {
            userInterface.occurError(e.message.orEmpty())
            start()
        }
    }

    private fun run() {
        var isRunning = true
        while (isRunning) {
            val input = userInterface.introduce()
            val splitInput = splitter.split(input)
            val calculator = Calculator(splitInput.first, splitInput.second)
            userInterface.showResult(calculator.calculate())
            isRunning = userInterface.isContinue()
        }
    }
}

fun main() {
    val calculatorMachine = CalculatorMachine(Splitter(), UserInterface)
    calculatorMachine.start()
}
