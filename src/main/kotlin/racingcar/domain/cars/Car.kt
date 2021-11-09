package racingcar.domain.cars

import racingcar.domain.engine.Engine

data class Car(
    private var racingLab: RacingLab,
    private val engine: Engine
) {
    private val racing = Racing(engine)

    fun race() {
        racingLab = racing.race(racingLab)
    }

    fun race(numberOfRace: Int): Unit = repeat(numberOfRace) {
        race()
    }

    fun racingLab(): Int = racingLab.value
}
