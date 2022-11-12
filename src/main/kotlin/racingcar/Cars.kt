package racingcar

import racingcar.condition.MoveCondition
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

    fun move(moveConditions: List<MoveCondition>): Record {
        return Record(cars.map { car -> car.move(moveConditions) })
    }

    companion object {
        const val START_POSITION = 0
    }
}
