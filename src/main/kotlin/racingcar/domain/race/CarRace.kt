package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.moving.RandomBasedMoveStrategy
import racingcar.domain.record.RaceRecord

class CarRace {
    private val raceRecord = RaceRecord()

    fun start(carCount: CarCount, trialCount: TrialCount): RaceRecord =
        race(
            initCars(carCount), trialCount
        )

    private fun initCars(carCount: CarCount): Cars =
        Cars(
            (0 until carCount.value).map {
                Car(RandomBasedMoveStrategy())
            }
        )

    private fun race(cars: Cars, trialCount: TrialCount): RaceRecord {
        repeat(trialCount.value) {
            cars.move()
            raceRecord.record(
                cars
            )
        }
        return raceRecord
    }
}

@JvmInline value class CarCount(val value: Int) {
    init {
        require(value > 0) { "자동차 수는 1대 이상이어야 해요. given: $value" }
    }
}
@JvmInline value class TrialCount(val value: Int) {
    init {
        require(value > 0) { "경기 횟수는 1회 이상이어야 해요. given: $value" }
    }
}
