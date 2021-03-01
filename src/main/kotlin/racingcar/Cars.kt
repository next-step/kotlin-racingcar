package racingcar

import java.util.stream.IntStream
import kotlin.streams.toList

class Cars(private var cars: List<Car>) {
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

    fun forwardAllByCondition(conditions: List<Int>): Cars {
        val forwardedCars = cars.mapIndexed { index, car ->
            forwardByCondition(car, conditions[index])
        }.toList()

        return Cars(forwardedCars)
    }

    fun forwardByCondition(car: Car, condition: Int): Car {
        if (canForward(condition)) {
            car.forward()
        }

        return car
    }

    private fun canForward(condition: Int) = condition >= MAX_FORWARD_CONDITION

    fun getSize(): Int {
        return cars.size
    }

    fun getPositionByIndex(index: Int): Int {
        return cars[index].retrievePosition()
    }

    fun retrieveCars(): List<Car> {
        return cars
    }
}
