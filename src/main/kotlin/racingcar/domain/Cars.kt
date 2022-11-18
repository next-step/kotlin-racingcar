package racingcar.domain

import racingcar.domain.strategy.MoveStrategy
import racingcar.dto.CarInfo
import racingcar.dto.Record

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

    fun move() {
        cars.map { car -> car.move() }
    }

    fun getRecord(): Record {
        return Record(cars.map { car -> CarInfo(car.name, car.position) })
    }

    companion object {
        const val START_POSITION = 0
    }
}
