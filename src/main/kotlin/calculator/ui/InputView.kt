package calculator.ui

class InputView(
    private val handler: CalculateHandler = CalculateHandler()
) {
    fun readInput() {
        print("계산할 문자열을 입력: ")
        println("결과: ${handler.handle(readLine())}")
    }
}
