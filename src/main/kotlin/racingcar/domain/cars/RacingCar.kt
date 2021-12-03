package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.RacingDistance

data class RacingCar(
    val name: String = DEFAULT_RACING_CAR_NAME,
    private var racingDistance: RacingDistance = RacingDistance()
) {
    init {
        require(name.isNotBlank())
    }

    fun racingDistance(): Int = racingDistance.value

    fun race(engine: Engine) {
        racingDistance = racingDistance.race(engine = engine)
    }

    fun copyRacingCar(): RacingCar {
        return RacingCar(name = name, racingDistance = RacingDistance(racingDistance.value))
    }

    companion object {
        private const val DEFAULT_RACING_CAR_NAME = "Anonymous"
    }
}
