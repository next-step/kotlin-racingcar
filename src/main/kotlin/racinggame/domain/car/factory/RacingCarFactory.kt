package racinggame.domain.car.factory

import racinggame.domain.car.RacingCar

interface RacingCarFactory {

    fun create(): RacingCar
}
