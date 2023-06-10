package racinggame.domain.car.system

import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.engine.Engine

class RacingCarSystem(
    private val engine: Engine,
    private val moveAction: (DrivableDistance) -> Unit
) : Accelerator {

    override fun pressAccelerator() {
        val drivableDistance = engine.execute()
        moveAction(drivableDistance)
    }
}
