package race.ui

class InputView() {
    fun getInputState(): InputState {
        return InputState(
            carNames = readCarNames().split(","),
            round = readRound()
        )
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
