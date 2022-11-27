package racingcar.ui

class InputView {

    var numberOfCar: Int = 0
        private set
    var numberOfGame: Int = 0
        private set

    fun show() {
        println("자동차 대수는 몇 대인가요?")
        numberOfCar = readLine()?.toIntOrNull() ?: 0

        println("시도할 횟수는 몇 회인가요?")
        numberOfGame = readLine()?.toIntOrNull() ?: 0
    }
}
