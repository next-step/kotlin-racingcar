package racingcar.domain.record

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.position.Positions

class Records(val record: List<Positions> = emptyList())

class RaceRecord(result: Records) {
    constructor() : this(Records())

    private val _record = result.record.toMutableList()

    val record: List<Positions>
        get() = _record.toList()

    fun record(cars: Cars) =
        _record.add(
            Positions(
                cars.cars.map(Car::position)
            )
        )
}
