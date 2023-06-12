package racinggame.domain.car.factory

import racinggame.domain.car.RacingCar
import racinggame.domain.player.User

interface RacingCarFactory {

    fun create(user: User): RacingCar
}
