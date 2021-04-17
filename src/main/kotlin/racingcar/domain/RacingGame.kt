package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy

class RacingGame(
    private val round: Int,
    private var cars: Cars
) {

    init {
        require(round > 0) { "시도할 횟수는 0보다 커야한다. round: $round" }
    }

    fun race(moveStrategy: MoveStrategy): RacingResult {

        val resultElements = mutableListOf<Cars>()
        repeat(round) {
            cars = cars.move(moveStrategy)
            resultElements.add(cars)
        }

        return RacingResult(resultElements)
    }
}
