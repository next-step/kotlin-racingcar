package string.calculator

import string.calculator.part.Calculator
import string.calculator.part.Splitter
import string.calculator.part.UserInterface
import string.calculator.part.Validator

class CalculatorMachine(private val calculator: Calculator, private val validator: Validator, private val splitter: Splitter, private val userInterface: UserInterface) {
    fun start() {
        try {
            run()
        } catch (e: IllegalArgumentException) {
            println(OCCURS_ERROR)
            println("오류 메시지: ${e.message}\n")
            start()
        }
    }

    private fun run() {
        var isRunning = true
        while (isRunning) {
            val input = userInterface.introduce()
            val splitInput = splitter.split(input)
            validator.validateInput(splitInput.numbers, splitInput.operators)
            val result = calculator.calculate(splitInput.numbers, splitInput.operators)
            userInterface.showResult(result)
            isRunning = userInterface.isContinue()
        }
    }

    companion object {
        const val OCCURS_ERROR = "오류가 발생했습니다. 다시 안내에 따라 다시 시도해주세요."
    }
}

fun main() {
    val calculatorMachine = CalculatorMachine(Calculator(), Validator(), Splitter(), UserInterface(Validator()))
    calculatorMachine.start()
}
