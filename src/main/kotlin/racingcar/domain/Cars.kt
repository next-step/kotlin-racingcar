package racingcar.domain

import java.util.stream.Collectors

/**
 * 자동차 목록.
 */
class Cars(val cars: List<Car>) {
    constructor() : this(mutableListOf<Car>())

    /**
     * 자동차를 이동하고 변경된 자동차 목록을 리턴한다.
     */
    fun move(): Cars {
        val carsRecords: MutableList<Car> = ArrayList()
        for (car in cars) {
            val movedCar: Car = car.moveForward()
            carsRecords.add(movedCar)
        }
        return Cars(carsRecords)
    }

    /**
     * 입력받은 대수만큼 자동차 목록을 생성하여 리턴한다.
     */
    fun createCars(count: Int): Cars {
        return Cars(
            (0 until count)
                .map { Car() }
                .stream()
                .collect(
                    Collectors.toList()
                )
        )
    }

    fun size(): Int {
        return cars.size
    }
}
