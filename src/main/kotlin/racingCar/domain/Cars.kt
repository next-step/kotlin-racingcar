package racingCar.domain

import java.util.stream.Collectors
import java.util.stream.IntStream

class Cars(carNumber: Int, private val strategy: MoveStrategy) {

    val cars: List<Car> =
        IntStream.range(0, carNumber)
            .mapToObj { Car() }
            .collect(Collectors.toList())

    fun moveByStrategy() {
        cars.forEach {
            if (strategy.move()) {
                it.move()
            }
        }
    }
}
