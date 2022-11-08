package racingcar

import racingcar.condition.MoveCondition
import racingcar.strategy.MoveStrategy

class Cars(
    carNumber: Int,
    moveStrategy: MoveStrategy,
    moveConditions: List<MoveCondition>
) {
    private val cars: List<Car> = List(carNumber) { num ->
        Car(
            name = "${num}번 차",
            moveStrategy = moveStrategy,
            moveConditions = moveConditions,
            position = START_POSITION
        )
    }

    fun move(): Record {
        return Record(cars.map { car -> car.move() })
    }

    companion object {
        const val START_POSITION = 0
    }
}
