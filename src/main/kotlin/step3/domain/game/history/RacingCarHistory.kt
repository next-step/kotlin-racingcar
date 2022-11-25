package step3.domain.game.history

import step3.domain.car.RacingCar
import step3.domain.car.distance.CarDistance
import step3.domain.car.name.CarName

class RacingCarHistory(racingCar: RacingCar) {

    var carName: CarName = racingCar.carName.copy()

    val carDistance: CarDistance = racingCar.carDistance.copy()
}
