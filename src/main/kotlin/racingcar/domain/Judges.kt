package racingcar.domain

class Judges(
    private val cars: List<Car>
) {
    private val max = cars.maxOf { car ->
        car.distance
    }

    fun pickWinner(): List<Car> = cars.filter { car ->
        car.distance == max
    }
}
