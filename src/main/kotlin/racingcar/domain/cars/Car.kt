package racingcar.domain.cars

import racingcar.domain.engine.DefaultEngine
import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class Car(
    private val engine: Engine = DefaultEngine(),
    private var racingDistance: RacingDistance = RacingDistance()
) {
    private val racing = Racing(engine)

    fun race() {
        racingDistance = racing.race(racingDistance)
    }

    fun racingDistance(): Int = racingDistance.value
}
