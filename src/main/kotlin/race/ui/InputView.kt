package race.ui

class InputView() {
    var state: InputState

    init {
        val car = readCar()
        val round = readRound()

        state = InputState(car = car, round = round)
    }

    private fun readCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    private fun readRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
