package racingcar.domain

import java.util.stream.Collectors

class Cars(val cars: List<Car>) {
    constructor() : this(mutableListOf<Car>())

    fun move(): Cars {
        val carsRecords: MutableList<Car> = ArrayList()
        for (car in cars) {
            val movedCar: Car = car.moveForward()
            carsRecords.add(movedCar)
        }
        return Cars(carsRecords)
    }

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
