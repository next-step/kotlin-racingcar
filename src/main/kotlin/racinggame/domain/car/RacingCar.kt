package racinggame.domain.car

import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.engine.Engine
import racinggame.domain.car.factory.RacingCarUniqueKey
import racinggame.domain.player.Racer

class RacingCar(
    val uniqueKey: RacingCarUniqueKey,
    private val engine: Engine,
) {

    var racer: Racer? = null
        private set

    fun getIn(racer: Racer) {
        getOffRacer()
        this.racer = racer
    }

    fun getOffRacer(): Racer? {
        return racer.also { racer = null }
    }

    fun tryRun(): DrivableDistance {
        return engine.execute()
    }
}

fun List<RacingCar>.getOffAllRacer() {
    forEach { racingCar ->
        racingCar.getOffRacer()
    }
}
