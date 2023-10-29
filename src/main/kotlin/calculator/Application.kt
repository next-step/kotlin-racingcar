package calculator

import calculator.input.InputView

class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val expressions = InputView.read()
            Calculator.calculate(expressions).run { println(this) }
        }
    }
}
