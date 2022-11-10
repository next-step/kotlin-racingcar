package racingcar

import racingcar.condition.MoveCondition
import racingcar.strategy.MoveStrategy

class Cars(
    carNumber: Int,
    moveStrategy: MoveStrategy,
) {
    private val cars: List<Car> = List(carNumber) { num ->
        Car(
            name = "${num}번 차",
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
