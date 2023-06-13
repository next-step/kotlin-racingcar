package racinggame.domain.car.factory

import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.RandomEnergyEngine
import racinggame.domain.car.engine.RealRandomNumberGenerator
import racinggame.domain.player.User

class RealRacingCarFactory : RacingCarFactory {

    override fun create(user: User): RacingCar {
        return RacingCar(
            user = user,
            engine = RandomEnergyEngine(RealRandomNumberGenerator())
        )
    }
}
