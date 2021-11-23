package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class Car(
    private val racing: Racing = Racing(engine = Engine::defaultCylinder),
    private var racingDistance: RacingDistance = RacingDistance()
) {
    fun race() {
        racingDistance = racing.race(racingDistance)
    }

    fun racingDistance(): Int = racingDistance.value
}
