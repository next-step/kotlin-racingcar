package racingcar.ui

import racingcar.application.GameInput

object InputView {

    private const val MIN_NUMBER_OF_CARS = 1
    private const val MAX_NUMBER_OF_CARS = 10
    private const val MIN_NUMBER_OF_RACES = 1
    private const val MAX_NUMBER_OF_RACES = 100

    fun read(): GameInput {
        val numberOfCars = readNumberOfCars()
        val numberOfPhase = readNumberOfRaces()

        return GameInput(numberOfCars, numberOfPhase)
    }

    private fun readNumberOfRaces(): Int {
        print("시도할 횟수는 몇 회인가요? ")
        val numberOfPhase = readln().toInt()
        require(numberOfPhase in MIN_NUMBER_OF_RACES..MAX_NUMBER_OF_RACES) { "시도 횟수는 최소 $MIN_NUMBER_OF_RACES, 최대 $MAX_NUMBER_OF_RACES 이어야 합니다." }
        return numberOfPhase
    }

    private fun readNumberOfCars(): Int {
        print("자동차 대수는 몇 대인가요? ")
        val numberOfCars = readln().toInt()
        require(numberOfCars in MIN_NUMBER_OF_CARS..MAX_NUMBER_OF_CARS) { "자동차 대수는 최소 $MIN_NUMBER_OF_CARS, 최대 $MAX_NUMBER_OF_CARS 이어야 합니다." }
        return numberOfCars
    }
}
