package racingcar.domain

import racingcar.domain.strategy.MoveStrategy
import racingcar.dto.CarInfo

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

    fun move(): List<CarInfo> {
        return cars.map { car -> CarInfo(car.name, car.move()) }
    }

    companion object {
        const val START_POSITION = 0
    }
}
