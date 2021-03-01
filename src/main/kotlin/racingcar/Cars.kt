package racingcar

import java.util.stream.IntStream
import kotlin.streams.toList

class Cars(private val cars: List<Car>) {
    fun forwardAllByCondition(conditions: List<Int>) {
        cars.mapIndexed { index, car ->
            forwardByCondition(car, conditions[index])
        }
    }

    fun forwardByCondition(car: Car, condition: Int) {
        if (canForward(condition)) {
            car.forward()
        }
    }

    private fun canForward(condition: Int) = condition >= MAX_FORWARD_CONDITION

    fun getSize(): Int {
        return cars.size
    }

    fun getPositionByIndex(index: Int): Int {
        return cars[index].position
    }

    fun getPositions(): List<Int> {
        return cars.map { car -> car.position }
            .toList()
    }

    companion object {
        private const val MAX_FORWARD_CONDITION = 4
        private const val MIN_CAN_CREATE_CARS = 0

        fun createCars(numberOfCar: Int): Cars {
            require(numberOfCar > MIN_CAN_CREATE_CARS) { "0미만의 개수는 생성할 수 없습니다." }

            val newCars = IntStream.range(MIN_CAN_CREATE_CARS, numberOfCar)
                .mapToObj { Car() }
                .toList()

            return Cars(newCars)
        }
    }
}
