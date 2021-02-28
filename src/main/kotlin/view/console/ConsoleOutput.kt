package calculator.view.console

class ConsoleOutput {
    fun printExpressionInputMessage() {
        println("계산식을 입력해주세요.")
    }

    fun printResultMessage(result: Double) {
        println("결과는 $result 입니다.")
    }
}
