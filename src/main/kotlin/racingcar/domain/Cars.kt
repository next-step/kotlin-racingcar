package racingcar.domain

import java.util.stream.Collectors

class Cars(private val cars: List<Car> = mutableListOf()) {

    fun size(): Int {
        return cars.size
    }

    fun dashOver(): Cars {
        return Cars(
            cars.stream()
                .map { it.dashOver() }
                .collect(Collectors.toList())
        )
    }

    fun makeCars(inputCar: Int): Cars {
        return generateCar(inputCar)
    }

    private fun generateCar(count: Int): Cars {
        return Cars(
            (0 until count)
                .map { Car() }
                .stream()
                .collect(
                    Collectors.toList()
                )
        )
    }
}
