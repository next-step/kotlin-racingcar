package step2

import step2.strategy.input.ConsoleInputStrategy
import step2.strategy.output.ConsoleOutputStrategy
import step2.ui.CalculatorInputView
import step2.ui.CalculatorOutputView

// 여기서 인풋뷰 받고 데이터 넘기는 형식으로 진행하자
// CalculatorView 에서 데이터 얻기
// Expression 도메인에 맞지 않을 경우 재호출하는 형식으로 진행하자.
// 메서드에서 호출하는 것은 결국 Expression 객체 만드는 것
// 서비스에 Expression 을 넘기는 방식으로 진행하자.
class CalculatorApplication(private val inputView: CalculatorInputView, private val outputView: CalculatorOutputView) {
    fun run() {
        val lawExpression = inputView.inputExpression()

    }
}

fun main() {
    val calculatorInputView = CalculatorInputView(ConsoleInputStrategy())
    val calculatorOutputView = CalculatorOutputView(ConsoleOutputStrategy())
    CalculatorApplication(calculatorInputView, calculatorOutputView).run()
}