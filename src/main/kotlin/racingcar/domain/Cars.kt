package racingcar.domain

data class Cars(private val cars: List<Car>) {
    fun move(condition: () -> Int): List<Car> {
        return cars.map {
            it.move(condition())
        }
    }

    fun findMaxStatusValue(): Int = cars.maxOf { it.status }

    fun statistic(max: Int): List<Car> {
        return cars.filter {
            it.isWinner(max)
        }
    }
}
