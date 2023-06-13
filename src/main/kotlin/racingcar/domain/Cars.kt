package racingcar.domain

data class Cars(
    private val cars: Array<Car>
) : Iterable<Car> {

    fun moveAll() {
        cars.forEach { it.move() }
    }

    override fun iterator(): Iterator<Car> =
        cars.iterator()
}
