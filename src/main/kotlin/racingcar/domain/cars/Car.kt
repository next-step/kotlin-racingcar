package racingcar.domain.cars

import racingcar.domain.engine.DefaultEngine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class Car(
    private val racing: Racing = Racing(DefaultEngine()),
    private var racingDistance: RacingDistance = RacingDistance()
) {
    fun race() {
        racingDistance = racing.race(racingDistance)
    }

    fun racingDistance(): Int = racingDistance.value
}
