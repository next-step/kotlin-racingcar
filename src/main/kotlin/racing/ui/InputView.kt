package racing.ui

class InputView() {
    fun getInputView(): InputData {
        println("자동차 대수는 몇 대 인가요?")
        val carNumber = readln().toInt()
        println("시도할 횟수는 몇 회 인가요?")
        val tryNumber = readln().toInt()
        return InputData(carNumber, tryNumber)
    }
}
