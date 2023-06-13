package racinggame.domain.car.factory

import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.Engine
import racinggame.domain.player.User

class MockRacingCarFactory(
    private val getEngine: (User) -> Engine,
) : RacingCarFactory {

    constructor(engine: Engine) : this({ engine })

    override fun create(user: User): RacingCar {
        return RacingCar(
            user = user,
            engine = getEngine(user),
        )
    }
}
