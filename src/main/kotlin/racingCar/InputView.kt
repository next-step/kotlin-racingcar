package racingCar

class InputView(private val input: IInput) {
    fun askCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return input.receiveCarCount()
    }

    fun askTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return input.receiveTryCount()
    }
}