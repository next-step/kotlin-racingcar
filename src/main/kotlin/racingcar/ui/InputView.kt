package racingcar.ui

import calculator.Parser

class InputView {

    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNamesString = readlnOrNull() ?: ""
        val carNames = Parser().parse(text = carNamesString, delimiter = ",")
        return carNames.ifEmpty {
            inputCarNames()
        }
    }

    fun inputNumberOfGame(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val numberOfGame = readlnOrNull() ?: ""
        return if (numberOfGame.isBlank()) {
            inputNumberOfGame()
        } else {
            numberOfGame.toIntOrNull() ?: 0
        }
    }
}
