package racing.ui

import racing.domain.RacingCars

class RacingCarController {
    fun run(carCount: Int, tryCount: Int) {
        val racingCars = RacingCars.create(carCount)
    }
}
