package racinggame.domain.car.factory

import racinggame.domain.car.RacingCar
import racinggame.domain.player.Racer

interface RacingCarFactory {

    fun create(racer: Racer): RacingCar
}
