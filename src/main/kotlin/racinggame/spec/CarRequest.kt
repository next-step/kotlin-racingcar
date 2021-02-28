package racinggame.spec

import racinggame.car.Engine
import racinggame.car.RacingCar

data class CarRequest(val carAmount: Int) {
    fun toRacingCar(engine: Engine): List<RacingCar> {
        return (1..carAmount).map { RacingCar(engine) }
    }
}
