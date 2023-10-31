package racing.ui

class InputView() {
    fun getInputView(): InputData {
        println("자동차 대수는 몇 대 인가요?")
        val carNumber = readln().toInt()
        println("시도할 횟수는 몇 회 인가요?")
        val tryNumber = readln().toInt()
        return InputData(carNumber, tryNumber)
    }

    fun getInputViewWithName(): InputDataWithName {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.")
        val carNames = readln().toString()
        println("시도할 횟수는 몇 회인가요?")
        val tryNumber = readln().toInt()
        return InputDataWithName(carNames, tryNumber)
    }
}
