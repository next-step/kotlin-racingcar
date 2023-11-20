package racingcar.domain

import racingcar.dto.RacingResult

class RacingGame {

    fun race(car: Car, randomValue: Int): RacingResult {
        car.move(randomValue)
        return RacingResult(Car(car.name, car.position))
    }
}
