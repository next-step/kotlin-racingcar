package racingcar.ui

import racingcar.application.GameInput

object InputView {

    private const val DELIMITER = ","
    private const val MIN_NUMBER_OF_RACES = 1
    private const val MAX_NUMBER_OF_RACES = 100

    fun read(): GameInput {
        val names = readNameOfCars()
        val numberOfPhase = readNumberOfRaces()
        return GameInput(names, numberOfPhase)
    }

    private fun readNumberOfRaces(): Int {
        print("시도할 횟수는 몇 회인가요? ")
        val numberOfPhase = readln().toInt()
        require(numberOfPhase in MIN_NUMBER_OF_RACES..MAX_NUMBER_OF_RACES) { "시도 횟수는 최소 $MIN_NUMBER_OF_RACES, 최대 $MAX_NUMBER_OF_RACES 이어야 합니다." }
        return numberOfPhase
    }

    private fun readNameOfCars(): List<String> {
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). ")
        return readln().split(DELIMITER)
    }
}
