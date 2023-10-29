package calculator

import calculator.input.InputView

class Application {

    // main 함수인데 왜 실행이 안 될까요...?!
    fun main() {
        val expressions = InputView.read()
        Calculator.calculate(expressions).run { println(this) }
    }
}
