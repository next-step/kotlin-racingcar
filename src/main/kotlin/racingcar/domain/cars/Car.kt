package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class Car(
    private val racing: Racing = Racing(),
    private var racingDistance: RacingDistance = RacingDistance()
) {
    fun race(engine: Engine) {
        racingDistance = racing.race(
            engine = engine,
            racingDistance = racingDistance
        )
    }

    fun racingDistance(): Int = racingDistance.value
}
