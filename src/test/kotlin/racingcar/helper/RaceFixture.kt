package racingcar.helper

import racingcar.domain.Cars
import racingcar.domain.RaceResult

object RaceFixture {
    fun makeFakeRaceResult() = object : RaceResult {
        override fun save(cars: Cars) {
        }
    }
}
