package racingcar.ui

class InputView {

    var numberOfGame: Int = 0
        private set
    var carNamesString: String = ""
        private set

    fun show() {
        carNamesString = inputCarNames()
        numberOfGame = inputNumberOfGame()
    }

    private fun inputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val result = readLine() ?: ""
        return result.ifBlank { inputCarNames() }
    }

    private fun inputNumberOfGame(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val result = readLine() ?: ""
        return if (result.isBlank()) {
            inputNumberOfGame()
        } else {
            result.toIntOrNull() ?: 0
        }
    }
}
