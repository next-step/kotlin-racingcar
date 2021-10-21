package racingcar.domain

import java.util.stream.Collectors

class Cars(val cars: List<Car> = mutableListOf()) {
    
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

    fun generateCar(count: Int): Cars {
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
