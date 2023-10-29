package race.ui

class InputView {
    var state: InputState = InputState()
        private set

    init {
        readCar()
        readRound()
    }

    private fun readCar() {
        println("자동차 대수는 몇 대인가요?")
        state = state.copy(car = readln().toInt())
    }

    private fun readRound() {
        println("시도할 횟수는 몇 회인가요?")
        state = state.copy(round = readln().toInt())
    }
}
