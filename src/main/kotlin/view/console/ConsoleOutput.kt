package view.console

class ConsoleOutput {
    fun printExpressionInputMessage() {
        println("계산식을 입력해주세요.")
    }

    fun printResultMessage(result: Double) {
        println("결과는 $result 입니다.")
    }

    fun printCarCountInputMessage() {
        println("자동차 대수는 몇 대인가요?")
    }

    fun printTryCountInputMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }
}
