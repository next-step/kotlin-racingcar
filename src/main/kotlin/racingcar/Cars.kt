package racingcar

data class Cars(var cars: List<Car>) {
    fun move(condition: () -> Int): List<Car> {
        val of = mutableListOf<Car>()

        cars.forEach {
            of.add(it.move(condition()))
        }
        return of
    }

    fun findMaxStatusValue(): Int = cars.maxOf { it.status }
}
