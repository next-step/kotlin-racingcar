package race.ui

class InputView() {
    var state: InputState

    init {
        val carNames = readCarNames()
        val round = readRound()

        state = InputState(carNames = carNames.split(','), round = round)
    }

    private fun readCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln()
    }

    private fun readRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
