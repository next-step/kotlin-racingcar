package racingcar

import racingcar.condition.MoveCondition

class Cars(carNumber: Int, conditions: List<MoveCondition>) {
    private val cars: List<Car> =
        IntRange(0, carNumber - 1).map { num ->
            Car("${num}번 차", START_POSITION, conditions)
        }

    fun move(): Record {
        return Record(cars.map { car -> car.move() })
    }

    companion object {
        const val START_POSITION = 0
    }
}
