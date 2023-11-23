package racingcar.domain

import racingcar.dto.RacingResult

class RacingGame {

    fun race(cars: List<Car>): List<RacingResult> {
        return cars.map {
            it.move()
            RacingResult(it.name, it.position)
        }
    }
}
