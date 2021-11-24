package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class RacingCar(
    val name: String = "No Name",
    private val racing: Racing = Racing(),
    private var racingDistance: RacingDistance = RacingDistance()
) {
    init {
        require(name.isNotBlank())
    }

    fun race(engine: Engine) {
        racingDistance = racing.race(
            engine = engine,
            racingDistance = racingDistance
        )
    }

    fun racingDistance(): Int = racingDistance.value
}
