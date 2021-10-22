package racingcar.domain

import java.util.stream.Collectors

class Cars(private val makeCount: Int, var cars: List<Car> = mutableListOf()) {

    init {
        cars = (0 until makeCount)
            .map { Car() }
            .stream()
            .collect(
                Collectors.toList()
            )
    }

    fun size(): Int {
        return cars.size
    }

    fun dashOver(): Cars {
        return Cars(
            makeCount,
            cars.stream()
                .map { it.dashOver() }
                .collect(Collectors.toList())
        )
    }
}
