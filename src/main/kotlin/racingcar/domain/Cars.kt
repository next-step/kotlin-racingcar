package racingcar.domain

import racingcar.dto.CarRecord
import racingcar.dto.Record
import racingcar.strategy.MoveStrategy

class Cars(
    carNames: List<String>,
    moveStrategy: MoveStrategy,
) {
    private val cars: List<Car> = carNames.map { carName ->
        Car(
            name = carName,
            moveStrategy = moveStrategy,
            position = START_POSITION
        )
    }

    fun move(): Record {
        return Record(cars.map { car -> CarRecord(car.name, car.move()) })
    }

    companion object {
        const val START_POSITION = 0
    }
}
