package racinggame.domain.car

import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.engine.Engine
import racinggame.domain.car.factory.RacingCarUniqueKey
import racinggame.domain.player.Racer

class RacingCar(
    val uniqueKey: RacingCarUniqueKey,
    val racer: Racer,
    private val engine: Engine,
) {

    fun tryRun(): DrivableDistance {
        return engine.execute()
    }
}
