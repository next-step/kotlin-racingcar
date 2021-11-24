package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.RacingDistance

data class RacingCar(
    val name: String = "Anonymous",
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
}
