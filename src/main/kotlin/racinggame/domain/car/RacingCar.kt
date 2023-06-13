package racinggame.domain.car

import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.engine.Engine
import racinggame.domain.player.User

class RacingCar(
    val user: User,
    private val engine: Engine,
) {

    fun tryRun(): DrivableDistance {
        return engine.execute()
    }
}
