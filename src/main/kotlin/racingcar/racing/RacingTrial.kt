package racingcar.racing

import racingcar.racing.car.Car

class RacingTrial(
    val records: List<Record>
) {
    companion object {
        fun of(cars: Collection<Car>): RacingTrial = RacingTrial(cars.map { Record(it.name, it.location) })
    }
}
