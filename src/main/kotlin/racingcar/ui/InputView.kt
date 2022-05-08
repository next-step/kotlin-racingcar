package racingcar.ui

import racingcar.application.GameInput

object InputView {

    private const val MIN_NUMBER_OF_CARS = 1
    private const val MAX_NUMBER_OF_CARS = 10
    private const val MIN_NUMBER_OF_PHASE = 1
    private const val MAX_NUMBER_OF_PHASE = 100

    fun read(): GameInput {
        print("자동차 대수는 몇 대인가요? ")
        val numberOfCars = readln().toInt()
        require(numberOfCars in MIN_NUMBER_OF_CARS..MAX_NUMBER_OF_CARS) { "자동차 대수는 최소 $MIN_NUMBER_OF_CARS, 최대 $MAX_NUMBER_OF_CARS 이어야 합니다." }

        print("시도할 횟수는 몇 회인가요? ")
        val numberOfPhase = readln().toInt()
        require(numberOfPhase in MIN_NUMBER_OF_PHASE..MAX_NUMBER_OF_PHASE) { "시도 횟수는 최소 $MIN_NUMBER_OF_PHASE, 최대 $MAX_NUMBER_OF_PHASE 이어야 합니다." }

        return GameInput(numberOfCars, numberOfPhase)
    }
}
