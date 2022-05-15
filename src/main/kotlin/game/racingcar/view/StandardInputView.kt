package game.racingcar.view

class StandardInputView : InputView {
    override var numberOfCar: Int = 0
    override var numberOfLap: Int = 0

    override fun init() {
        println("자동차 대수는 몇 대인가요?")
        numberOfCar = readln().toInt()
        println("시도할 횟수는 몇 회인가요?")
        numberOfLap = readln().toInt()
    }
}
