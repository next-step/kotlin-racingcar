package racingcar.domain

data class Cars(private val cars: List<Car>) {
    fun move(condition: () -> Int): List<Car> {
        val of = mutableListOf<Car>()

        cars.forEach {
            of.add(it.move(condition()))
        }
        return of
    }

    fun findMaxStatusValue(): Int = cars.maxOf { it.status }

    fun statistic(max: Int): List<Car> {
        val result = mutableListOf<Car>()
        cars.forEach { car ->
            run {
                if (car.isWinner(max)) {
                    result += car
                }
            }
        }
        return result
    }
}
