package step3.domain.game.history

import step3.domain.car.RacingCar

class RacingCarHistory(racingCar: RacingCar) {
    val name: String = racingCar.name
    val distance = racingCar.distance
}
