package racinggame.domain.car

import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.factory.RacingCarUniqueKey
import racinggame.domain.car.engine.Engine
import racinggame.domain.car.system.RacingCarSystem

class RacingCar(
    val uniqueKey: RacingCarUniqueKey,
    engine: Engine,
) {

    var onWheelsSpinListener: ((DrivableDistance) -> Unit)? = null

    private val racingCarSystem = RacingCarSystem(
        engine = engine,
        moveAction = { drivableDistance -> onWheelsSpinListener?.invoke(drivableDistance) }
    )
}
