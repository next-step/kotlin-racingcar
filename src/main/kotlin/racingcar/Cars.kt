package racingcar

class Cars(var cars: List<Car>) {
    fun move(): List<Car> {
        val of = mutableListOf<Car>()

        cars.forEach {
            of.add(it.move((RANDOM_NUMBER_RANGE).random()))
        }
        return of
    }

    fun findMaxStatusValue(): Int = cars.maxOf { it.status }

    companion object {
        private val RANDOM_NUMBER_RANGE = 0..9
    }
}
