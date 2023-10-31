package racingCar.helper

import racingCar.domain.Cars
import racingCar.domain.RaceResult

object RaceFixture {
    fun makeFakeRaceResult() = object : RaceResult {
        override fun save(cars: Cars) {
        }
    }
}
