package racing.ui

import racing.domain.MoveStrategy
import racing.domain.RacingCars

class RacingCarController(private val moveStrategy: MoveStrategy) {
    fun run(carCount: Int, tryCount: Int) {
        val racingCars = RacingCars.create(carCount)
        racingCars.race(tryCount, moveStrategy)
    }
}