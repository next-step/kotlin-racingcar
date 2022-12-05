package racingcar.ui

import calculator.Parser

class InputView {

    var carNames: List<String> = emptyList()

    var numberOfGame: Int = 0
        private set

    fun show() {
        val carNamesString = inputCarNames()
        carNames = Parser().parse(input = carNamesString, delimiter = ",")

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
